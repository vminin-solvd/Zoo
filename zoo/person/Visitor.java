package zoo.person;

import zoo.exceptions.SpeakingException;
import zoo.ticket.Ticket;

public final class Visitor extends Person implements IShout, IComplain{

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
        System.out.println(shoutString);
    }

    @Override
    public void complain(String complainString) throws SpeakingException {
        System.out.println(complainString);
    }


}
