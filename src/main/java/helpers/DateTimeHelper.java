package helpers;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DateTimeHelper {

    String pattern = "yyyy-MM-dd'T'kk:mm:ss.SS";
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
    Calendar calendar;

    public String getDateTime(String day, int hour, int minute) {
        int intDay = getIntDay(day);
        calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        calendar.add(Calendar.HOUR, hour);
        calendar.add(Calendar.MINUTE, minute);
        calendar.add(Calendar.DATE, intDay);
        return simpleDateFormat.format(calendar.getTime());
    }

    public int getIntDay(String day) {
        switch (day) {
            case "yesterday":
                return -1;
            case "today":
                return 0;
            case "tomorrow":
                return 1;
            default:
                throw new IllegalStateException("Unexpected value: " + day);
        }
    }
}
