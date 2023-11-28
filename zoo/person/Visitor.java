package zoo.person;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import zoo.exceptions.SpeakingException;
import zoo.ticket.Ticket;

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
    public String toString() {
        return "Visitor name=" + this.getName() + ", location=" + this.getLocation() + ", ticketID=" + ticket.getTicketID();
    }

    @Override
    public void shout(String shoutString) throws SpeakingException {

        if (shoutString == null) {
            throw new SpeakingException("String cannot be null");
        }
        LOGGER.info(shoutString);
    }

    @Override
    public void complain(String complainString) throws SpeakingException {

        if (complainString == null) {
            throw new SpeakingException("String cannot be null");
        }
        LOGGER.info(complainString);
    }


}
