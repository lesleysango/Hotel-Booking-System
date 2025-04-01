import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BookingManager implements IHotelService {
    private static BookingManager instance;

    private BookingManager() {
    }

    public static synchronized BookingManager getInstance() {
        if (instance == null) {
            instance = new BookingManager();
        }
        return instance;
    }

    @Override
    public void addBooking(Booking booking) {
        String sql = "INSERT INTO Bookings (CustomerID, RoomNumber, BookingDate, Nights) VALUES (?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, booking.getCustomer().getCustomerId());
            pstmt.setInt(2, booking.getRoom().getRoomNumber());
            pstmt.setDate(3, new java.sql.Date(booking.getDate().getTime()));
            pstmt.setInt(4, booking.getNights());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Booking getBooking(int bookingId) {
        String sql = "SELECT *, b.BookingID as BookingID FROM Bookings b " +
                "JOIN Customers c ON b.CustomerID = c.CustomerID " +
                "JOIN Rooms r ON b.RoomNumber = r.RoomNumber WHERE b.BookingID = ?";
        try (Connection conn = DatabaseConnection.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, bookingId);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                Customer customer = new Customer(rs.getString("Name"), rs.getString("Email"), rs.getInt("CustomerID"));
                Room room = new Room(rs.getInt("RoomNumber"), rs.getString("Type"), rs.getDouble("Price"));
                Booking booking = new Booking(rs.getInt("BookingID"), customer, room, rs.getDate("BookingDate"),
                        rs.getInt("Nights"));
                return booking;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Room createRoom(String type) {

        return RoomFactory.createRoom(type);
    }

}
