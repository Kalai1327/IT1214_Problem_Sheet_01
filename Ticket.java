class Ticket{
    private int ticketNumber;
    private String customerName;
    private int seatNumber;

    Ticket(int ticketNumber, String customerName, int seatNumber){
        this.ticketNumber = ticketNumber;
        this.customerName = customerName;
        this.seatNumber = seatNumber;
    }

    int getTicketNumber(){
        return ticketNumber;
    }

    int getSeatNumber(){
        return seatNumber;
    }

    void display(){
        System.out.println("Ticket #" + ticketNumber + " | Customer: " + customerName + " | Seat: " + seatNumber);
    }
}

class BookingSystem{
    private Ticket[] tickets = new Ticket[10]; // max 10 seats

    boolean bookTicket(int ticketNumber, String name, int seat){
        if (seat < 1 || seat > 10){
            System.out.println("Invalid seat number.");
            return false;
        }
        if (tickets[seat - 1] != null){
            System.out.println("Seat " + seat + " is already booked.");
            return false;
        }
		
		tickets[seat - 1] = new Ticket(ticketNumber, name, seat);
        System.out.println("Ticket booked for " + name + " at seat " + seat);
        return true;
    }

    void cancelTicket(int ticketNumber){
        for (int i = 0; i < 10; i++){
            if (tickets[i] != null && tickets[i].getTicketNumber() == ticketNumber){
                System.out.println("Ticket #" + ticketNumber + " cancelled");
                tickets[i] = null;
                return;
            }
        }
        System.out.println("Ticket #" + ticketNumber + " not found.");
    }

    void displayBookings(){
        for (Ticket t : tickets){
            if (t != null) t.display();
        }
    }
}

class MovieBookingApp{
    public static void main(String[] args){
        BookingSystem system = new BookingSystem();

        system.bookTicket(1, "Alice", 1);
        system.bookTicket(2, "Bob", 2);
        system.bookTicket(3, "Charlie", 3);
        system.cancelTicket(2);
        system.bookTicket(4, "David", 2);
        system.displayBookings();
    }
}