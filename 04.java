class Ticket {
    private int ticketNumber;
    private String customerName;
    private int seatNumber;

    public Ticket(int ticketNumber, String customerName, int seatNumber) {
        this.ticketNumber = ticketNumber;
        this.customerName = customerName;
        this.seatNumber = seatNumber;
    }

    public int getTicketNumber() { return ticketNumber; }
    public int getSeatNumber() { return seatNumber; }

    public String toString() {
        return "Ticket#: " + ticketNumber + ", Customer: " + customerName + ", Seat: " + seatNumber;
    }
}

class BookingSystem {
    private Ticket[] tickets = new Ticket[10];
    private int count = 0;

    public void bookTicket(int ticketNumber, String customerName, int seatNumber) {
        if (count >= tickets.length) {
            System.out.println("All seats are booked.");
            return;
        }
        for (int i = 0; i < count; i++) {
            if (tickets[i].getSeatNumber() == seatNumber) {
                System.out.println("Seat " + seatNumber + " is already booked.");
                return;
            }
        }
        tickets[count++] = new Ticket(ticketNumber, customerName, seatNumber);
    }

    public void cancelTicket(int ticketNumber) {
        for (int i = 0; i < count; i++) {
            if (tickets[i].getTicketNumber() == ticketNumber) {
                for (int j = i; j < count - 1; j++) {
                    tickets[j] = tickets[j + 1];
                }
                tickets[--count] = null;
                return;
            }
        }
        System.out.println("Ticket number " + ticketNumber + " not found.");
    }

    public void displayBookings() {
        for (int i = 0; i < count; i++) {
            System.out.println(tickets[i]);
        }
    }
}

public class MovieBookingSystem {
    public static void main(String[] args) {
        BookingSystem system = new BookingSystem();
        system.bookTicket(1, "Alice", 1);
        system.bookTicket(2, "Bob", 2);
        system.bookTicket(3, "Charlie", 3);

        system.cancelTicket(2);
        system.bookTicket(4, "David", 2);
        system.displayBookings();
    }
}
