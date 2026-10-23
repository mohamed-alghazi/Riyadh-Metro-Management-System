
package riyadhmetroproject;

/**
 *
 * @author amany
 */
public class Passenger {
      private int ticketID;
    private String passengerName;
    private String destination;

    public Passenger(int id, String name, String dest) {
        this.ticketID = id;
        this.passengerName = name;
        this.destination = dest;
    }

    public int getTicketID() {
        return ticketID;
    }

    public void setTicketID(int ticketID) {
        this.ticketID = ticketID;
    }

    public String getPassengerName() {
        return passengerName;
    }

    public void setPassengerName(String passengerName) {
        this.passengerName = passengerName;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    @Override
    public String toString() {
        return "Ticket{" + "ticketID=" + ticketID + ", passengerName=" + passengerName + ", destination=" + destination + '}';
    }

   
}
