package zoo.ticket;

import zoo.exceptions.ExpiredTicketException;

import java.util.Date;
import java.util.Calendar;
import java.util.Objects;

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

    public  void setDate(int month, int day, int year) throws ExpiredTicketException {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month - 1); // Subtract 1 because months are 0-indexed
        calendar.set(Calendar.DAY_OF_MONTH, day);
        this.date = calendar.getTime();
        Date today = Calendar.getInstance().getTime();
        if(!Objects.equals(date, today)) {
            throw new ExpiredTicketException("Ticket is not valid for entry today");
        }
    }
}
