package zoo.utils;

import zoo.exceptions.ExpiredTicketException;

import java.util.Calendar;
import java.util.Date;
import java.util.Objects;

public class DateHandler {

    public void checkDate(String dateString) throws ExpiredTicketException {
        String[] dateParts = dateString.split("/");
        int month = Integer.parseInt(dateParts[0]);
        int day = Integer.parseInt(dateParts[1]);
        int year = Integer.parseInt(dateParts[2]);

        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month - 1); // Subtract 1 because months are 0-indexed
        calendar.set(Calendar.DAY_OF_MONTH, day);
        Date date = calendar.getTime();

        Calendar todayCalendar = Calendar.getInstance();
        todayCalendar.set(Calendar.HOUR_OF_DAY, 0);
        todayCalendar.set(Calendar.MINUTE, 0);
        todayCalendar.set(Calendar.SECOND, 0);
        todayCalendar.set(Calendar.MILLISECOND, 0);
        Date today = todayCalendar.getTime();

        if (!Objects.equals(date, today)) {
            throw new ExpiredTicketException("Ticket is not valid for entry today");
        }

    }
}
