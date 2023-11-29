package com.solvd.zoo.person;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.solvd.zoo.exceptions.SpeakingException;
import com.solvd.zoo.interfaces.IComplain;
import com.solvd.zoo.interfaces.IShout;
import com.solvd.zoo.ticket.Ticket;
import com.solvd.zoo.Zoo;

public final class Visitor extends Person implements IShout, IComplain {

    private static final Logger LOGGER = LogManager.getLogger(Visitor.class);
    private Ticket ticket;

    public Ticket getTicket() {
        return this.ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    @Override
    public void shout(String shoutString) throws SpeakingException {
        if (shoutString == null) {
            throw new SpeakingException("String cannot be null");
        }
        LOGGER.info(shoutString);
    }

    @Override
    public void complain(String complainString, Zoo zoo) throws SpeakingException {
        if (zoo != null) {
            zoo.handleComplaint(this, complainString);
        } else {
            LOGGER.warn("Zoo reference is not set for this visitor");
        }
    }

    @Override
    public String toString() {
        return "Visitor name=" + this.getName() + ", location=" + this.getLocation() + ", ticketID=" + ticket.getTicketID();
    }
}
