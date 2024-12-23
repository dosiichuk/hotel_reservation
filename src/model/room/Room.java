package model.room;

public class Room implements IRoom {
    private final String roomNumber;
    private Double price;
    private final RoomType roomType;
    private boolean isFree;

    public Room(String roomNumber, Double price, Integer roomType) {
        this.roomType = RoomType.getRoomType(roomType);
        if (this.roomType == null) {
            throw new IllegalArgumentException("Invalid room type");
        }
        try {
            Integer.parseInt(roomNumber);
        } catch (Exception e) {
            throw new IllegalArgumentException("Invalid room number");
        }
        if (price < 0) {
            throw new IllegalArgumentException("Price cannot be negative");
        }
        this.roomNumber = roomNumber;
        this.price = price;
        this.isFree = price == 0.0;
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

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Room)) {
            return false;
        }
        Room room = (Room) obj;
        return roomNumber.equals(room.roomNumber);
    }

    @Override
    public int hashCode() {
        return roomNumber.hashCode();
    }
}