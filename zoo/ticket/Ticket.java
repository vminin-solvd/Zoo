package zoo.ticket;

public class Ticket {

    private int ticketID;
    private float discount;
    private float cost;

    public int getTicketID() {
        return this.ticketID;
    }

    public float getDiscount() {
        return this.discount;
    }

    public float getCost() {
        return this.cost;
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
}
