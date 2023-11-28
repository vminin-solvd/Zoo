package zoo.ticket;

import zoo.exceptions.ExpiredTicketException;

import java.util.Date;
import java.util.Calendar;
import zoo.utils.DateHandler;

public class Ticket {

    private float cost;
    private float discount;
    private Date date;
    private int ticketID;


    public int getTicketID() {
        return this.ticketID;
    }

    public float getDiscount() {
        return this.discount;
    }

    public float getCost() {
        return this.cost;
    }

    public Date getDate() {
        return this.date;
    }
    public void setTicketID(int ticketID) {
        this.ticketID = ticketID;
    }

    public void setDiscount(float discount) {
        this.discount = discount;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    public void setDate(String dateString) throws ExpiredTicketException {
        DateHandler dateHandler = new DateHandler();
        dateHandler.checkDate(dateString);

        String[] dateParts = dateString.split("/");
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, Integer.parseInt(dateParts[2]));
        calendar.set(Calendar.MONTH, Integer.parseInt(dateParts[0]) - 1); // Months are 0-indexed
        calendar.set(Calendar.DAY_OF_MONTH, Integer.parseInt(dateParts[1]));
        this.date = calendar.getTime();
    }
}
