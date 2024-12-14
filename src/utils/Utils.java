package utils;

import java.util.Calendar;
import java.util.Date;

public class Utils {

    public static Date createDate(int year, int month, int day) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month, day, 0, 0, 0); // Set year, month, day, and reset time to 00:00:00
        calendar.set(Calendar.MILLISECOND, 0); // Reset milliseconds
        return calendar.getTime(); // Convert Calendar to Date
    }
}
