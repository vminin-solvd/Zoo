package zoo.person;

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
    public void shout() {
        System.out.println("WOOOO I AM HAVING SO MUCH FUN");
    }

    @Override
    public void complain() {
        System.out.println("UGH LIFE IS SO HARD AND THIS ZOO SUCKS");
    }
}
