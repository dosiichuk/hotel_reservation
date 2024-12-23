package model.room;

public class FreeRoom extends Room {
    public FreeRoom(String roomNumber, Integer roomType) {
        super(roomNumber, 0.0, roomType);
    }

    @Override
    public String toString() {
        return "FreeRoom{" +
                "roomNumber='" + getRoomNumber() + '\'' +
                ", price=" + getRoomPrice() +
                ", roomType=" + getRoomType() +
                '}';
    }
}
