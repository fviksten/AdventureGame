package com.company;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016-08-30.
 */
public class World {

    private List<Room> rooms = new ArrayList();
    private Room currentRoom;
    private Player player;

    public World() {
        player = new Player(new Coordinate(Room.MAX_WIDTH/2, Room.MAX_HEIGHT -2),3);
        createRooms();
        currentRoom = rooms.get(0);
    }

    private void createRooms() {
        Room room1 = new RoomOne();
        rooms.add(room1);
        Room room2 = new RoomTwo();
        rooms.add(room2);
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public Player getPlayer() {
        return player;
    }

    public void setCurrentRoom(int roomNumber) {
        currentRoom = rooms.get(roomNumber);
    }
}
