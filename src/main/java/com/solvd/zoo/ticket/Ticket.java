package com.solvd.zoo.ticket;

import com.solvd.zoo.exceptions.ExpiredTicketException;

import java.util.Date;
import java.util.Objects;
import com.solvd.zoo.utils.DateHandler;

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
        Date ticketDate = dateHandler.convertDate(dateString);
        this.date = ticketDate;
        dateHandler.checkDate(dateString);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Ticket other = (Ticket) obj;
        return this.ticketID == other.ticketID;
    }

    @Override
    public int hashCode() {
        return Objects.hash(ticketID);
    }
}
