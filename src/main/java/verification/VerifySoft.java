package verification;

import org.testng.asserts.SoftAssert;

public class VerifySoft {

    private static SoftAssert softAssert = new SoftAssert();

    public static void verifyEqualsSoft(boolean actual, boolean expected, String message) {
        softAssert.assertEquals(actual, expected, message);
    }

    public static void verifyEqualsSoft(String actual, String expected, String message) {
        softAssert.assertEquals(actual, expected, message);
    }

    public static void verifyEqualsSoft(int actual, int expected, String message) {
        softAssert.assertEquals(actual, expected, message);
    }

    public static void showAllChecking() {
        try {
            softAssert.assertAll();
        } finally {
            resetSoftAssert();
        }
    }

    public static void resetSoftAssert() {
        softAssert = new SoftAssert();
    }
}
