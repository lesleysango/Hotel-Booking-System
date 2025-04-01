public class RoomFactory {
    public static Room createRoom(String type) {
        switch (type) {
            case "single":
                return new Room(101, "single", 100.0);
            case "double":
                return new Room(102, "double", 200.0);
            case "suite":
                return new Room(201, "suite", 300.0);
            default:
                return null; // or throw an IllegalArgumentException
        }
    }
}
