public interface IHotelService {
    void addBooking(Booking booking);
    Booking getBooking(int bookingId);
    Room createRoom(String type);
}
