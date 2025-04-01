import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class HotelBookingSystem extends JFrame {
    private JTextField txtCustomerName, txtCustomerEmail, txtRoomType, txtNights, txtBookingId;
    private JButton btnBook, btnFind;
    private JTextArea txtAreaOutput;

    public HotelBookingSystem() {
        super("Hotel Booking System");

        // Create components
        txtCustomerName = new JTextField(15);
        txtCustomerEmail = new JTextField(15);
        txtRoomType = new JTextField(12);
        txtNights = new JTextField(5);
        txtBookingId = new JTextField(7);
        btnBook = new JButton("Book Room");
        btnFind = new JButton("Find Booking");
        txtAreaOutput = new JTextArea(19, 30);
        txtAreaOutput.setEditable(false);

        // Layout
        setLayout(new FlowLayout());
        add(new JLabel("Customer Name:"));
        add(txtCustomerName);
        add(new JLabel("Customer Email:"));
        add(txtCustomerEmail);
        add(new JLabel("Room Type (single/double/suite):"));
        add(txtRoomType);
        add(new JLabel("Number of Nights:"));
        add(txtNights);
        add(btnBook);
        add(new JLabel("Booking ID:"));
        add(txtBookingId);
        add(btnFind);
        add(new JScrollPane(txtAreaOutput));

        // Add button listeners
        btnBook.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                makeBooking();
            }
        });

        btnFind.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                findBooking();
            }
        });

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 500);
        setVisible(true);
    }

    private void makeBooking() {
        String name = txtCustomerName.getText();
        String email = txtCustomerEmail.getText();
        String roomType = txtRoomType.getText();
        int nights = Integer.parseInt(txtNights.getText());  // Convert the number of nights from text to integer
        try {
            Room room = BookingManager.getInstance().createRoom(roomType);
            Customer customer = new Customer(name, email, (int) (Math.random() * 1000));
            Booking booking = new Booking((int) (Math.random() * 1000), customer, room, new Date(), nights);
            BookingManager.getInstance().addBooking(booking);
            txtAreaOutput.setText("Booking successful:\n" + booking);
        } catch (Exception e) {
            txtAreaOutput.setText("Failed to book: " + e.getMessage());
        }
    }

    private void findBooking() {
        int bookingId = Integer.parseInt(txtBookingId.getText());
        Booking details = BookingManager.getInstance().getBooking(bookingId);
        txtAreaOutput.setText(String.valueOf(details));
    }

    public static void main(String[] args) {
        new HotelBookingSystem();
    }
}
