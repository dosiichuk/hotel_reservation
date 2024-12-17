package model.room;

public class Room  implements IRoom{
    private final String roomNumber;
    private Double price;
    private final RoomType roomType;
    private boolean isFree;

    public Room(String roomNumber, Double price, RoomType roomType, boolean isFree) {
        this.roomNumber = roomNumber;
        this.price = price;
        this.roomType = roomType;
        this.isFree = isFree;
    }

    @Override
    public String toString() {
        return "Room{" +
                "roomNumber='" + roomNumber + '\'' + ", roomType=" +
                roomType.getDescription() +
                ", price=" + price +
                '}';
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public Double getRoomPrice() {
        return price;
    }

    public RoomType getRoomType() {
        return roomType;
    }

    public boolean isFree() {
        return isFree;
    }


}
