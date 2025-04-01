import java.util.Date;

public class Booking {
    private int bookingId;
    private Customer customer;
    private Room room;
    private Date date;
    private int nights;  // Number of nights for the booking

    public Booking(int bookingId, Customer customer, Room room, Date date, int nights) {
        this.bookingId = bookingId;
        this.customer = customer;
        this.room = room;
        this.date = date;
        this.nights = nights;
    }

    public int getBookingId() {
        return bookingId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Room getRoom() {
        return room;
    }

    public Date getDate() {
        return date;
    }

    public int getNights() {
        return nights;
    }

    // Calculate the total cost based on the number of nights and room price
    public double getTotalCost() {
        return nights * room.getPrice();
    }

    @Override
    public String toString() {
        return "Booking Details" +  "\nBooking Number: " + bookingId + "\nCustomer: " + customer.name +
                "\nRoom: " + room.getRoomNumber() + "\nDate: " + date + "\nNights: " + nights +
                "\nTotal cost: $" + getTotalCost() ;
    }
}
