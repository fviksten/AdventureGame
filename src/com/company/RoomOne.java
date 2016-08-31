package com.company;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016-08-30.
 */
public class RoomOne implements Room {

    private List<Wall> walls = new ArrayList();
    private List<Door> doors = new ArrayList();
    private List<Enemy> enemies = new ArrayList();

    public RoomOne() {
        createWalls();
        createDoors();
    }

    @Override
    public void createDoors() {
        Door door1 = new Door(new Coordinate(MAX_WIDTH, MAX_HEIGHT/4), new Coordinate(MAX_WIDTH, MAX_HEIGHT/2), false, Color.BLACK, 1);
        doors.add(door1);
    }

    @Override
    public void createWalls(){
        Wall horizontalWalls = new FrameWall(new Coordinate(MIN_WIDTH,MIN_HEIGHT), new Coordinate(MAX_WIDTH,MAX_HEIGHT), true, Color.green);
        walls.add(horizontalWalls);
        Wall verticalWalls = new FrameWall(new Coordinate(MIN_WIDTH,MIN_HEIGHT), new Coordinate(MAX_WIDTH,MAX_HEIGHT), false, Color.green);
        walls.add(verticalWalls);
    }//End createFrameWall

    @Override
    public void revealSecret() {

    }

    @Override
    public boolean isSecretRevealed() {
        return false;
    }

    @Override
    public List<Wall> getFrameWalls() {
        return walls;
    }

    @Override
    public List<Door> getDoors() {
        return doors;
    }

    @Override
    public List<Enemy> getEnemies() {
        return enemies;
    }
}
