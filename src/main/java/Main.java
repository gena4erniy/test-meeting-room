import org.apache.commons.lang3.tuple.Pair;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    static List<Pair<Integer, Integer>> steps = new ArrayList<>() {{
        add(Pair.of(-1, -1));
        add(Pair.of(-1, 0));
        add(Pair.of(-1, 1));
        add(Pair.of(1, -1));
        add(Pair.of(1, 0));
        add(Pair.of(1, 1));
        add(Pair.of(0, -1));
        add(Pair.of(0, 1));
    }};

    public static void show(int n, int m, int[][] myArray) {
        for (int row = 0; row < m; row++) {
            for (int column = 0; column < n; column++) {
                System.out.print(myArray[row][column] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n, m;
        n = scan.nextInt();
        m = scan.nextInt();
        int[][] myArray = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int k = 0; k < n; k++) {
                myArray[i][k] = scan.nextInt();
            }
        }

        List<Area> areas = new ArrayList<>();
        while (true) {
            Pair<Integer, Integer> yx = findOne(myArray, n, m);
            if (yx == null) break;
            List<Pair<Integer, Integer>> chain = findChain(n, m, myArray, List.of(yx));
            if (chain.size() >= 2) {
                areas.add(new Area(chain, myArray));
            }
            myArray = taggedMatrix(myArray, chain);
        }

        try {
            double maxHelpfulless = areas.stream().map(area -> area.helpfulness).max(Double::compare).get();
            var listMaxHelp = areas.stream().filter(area -> area.helpfulness == maxHelpfulless)
                    .collect(Collectors.toList());
            int maxS = listMaxHelp.stream().map(area -> area.s).max(Integer::compare).get();
            System.out.println(maxS);
        } catch (NoSuchElementException e) {
            System.out.println(0);
        }
    }

    public static List<Pair<Integer, Integer>> findChain(int n, int m, int[][] myArray, List<Pair<Integer, Integer>> way) {
        Pair<Integer, Integer> current = way.get(way.size() - 1);
        if (steps.stream()
                .filter(step -> {
                    return canStep(current, step, n, m, myArray, way);
                })
                .count() == 0) return way;
        return steps.stream()
                .filter(step -> {
                    return canStep(current, step, n, m, myArray, way);
                })
                .map(step -> {
                    List<Pair<Integer, Integer>> newWay = new ArrayList<>(way);
                    newWay.add(Pair.of(step.getLeft() + current.getLeft(), step.getRight() + current.getRight()));
                    return findChain(n, m, myArray, newWay);
                })
                .flatMap(List::stream)
                .distinct()
                .collect(Collectors.toList());
    }

    public static Pair<Integer, Integer> findOne(int[][] myArray, int n, int m) {
        for (int row = 0; row < m; row++) {
            for (int column = 0; column < n; column++) {
                if (myArray[row][column] == 1) return Pair.of(row, column);
            }
        }
        return null;
    }

    public static boolean canStep(Pair<Integer, Integer> current, Pair<Integer, Integer> step, int n, int m,
                                  int[][] myArray, List<Pair<Integer, Integer>> way) {
        int newY = current.getLeft() + step.getLeft();
        int newX = current.getRight() + step.getRight();
        if (newX >= n || newX < 0) return false;
        if (newY >= m || newY < 0) return false;
        if (myArray[newY][newX] != 1) return false;
        if (way.indexOf(Pair.of(newY, newX)) != -1) return false;
        return true;
    }

    public static int[][] taggedMatrix(int[][] myArray, List<Pair<Integer, Integer>> way) {
        way.stream().forEach(pair -> {
            myArray[pair.getLeft()][pair.getRight()] = 2;
        });
        return myArray;
    }

    static class Area {
        int s;
        int countFertile;
        double helpfulness;

        public Area(List<Pair<Integer, Integer>> way, int[][] myArray) {
            int xMin = way.stream().map(pair -> pair.getRight()).min(Integer::compare).get();
            int xMax = way.stream().map(pair -> pair.getRight()).max(Integer::compare).get();
            int yMin = way.stream().map(pair -> pair.getLeft()).min(Integer::compare).get();
            int yMax = way.stream().map(pair -> pair.getLeft()).max(Integer::compare).get();
            int x = xMax - xMin + 1;
            int y = yMax - yMin + 1;
            s = x * y;
            countFertile = 0;
            for (int raw = yMin; raw <= yMax; raw++) {
                for (int column = xMin; column <= xMax; column++) {
                    if (myArray[raw][column] == 1) countFertile++;
                }
            }
            helpfulness = (double) countFertile / s;
        }
    }
}