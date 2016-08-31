package com.company;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016-08-30.
 */
public class Door extends FrameWall{

    int roomNumber;

    public Door(Coordinate start, Coordinate end, boolean horizontal, Color color, int roomNumber) {
        super(start, end, horizontal, color);
        this.roomNumber = roomNumber;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int index) {
        this.roomNumber = roomNumber;
    }


}
