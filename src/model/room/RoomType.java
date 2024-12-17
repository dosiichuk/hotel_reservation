package model.room;

public enum RoomType {
    SINGLE(1, "Single bed room"),
    DOUBLE(2, "Double bed room");

    private final int capacity;
    private final String description;

    RoomType(int capacity, String description) {
        this.capacity = capacity;
        this.description = description;
    }

    public int getCapacity() {
        return capacity;
    }

    public String getDescription() {
        return description;
    }

    public static RoomType getRoomType(int capacity) {
        for (RoomType roomType : RoomType.values()) {
            if (roomType.getCapacity() == capacity) {
                return roomType;
            }
        }
        return null;
    }
}
