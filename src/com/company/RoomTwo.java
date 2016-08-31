package com.company;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Administrator on 2016-08-30.
 */
public class RoomTwo implements Room {

    private List<Wall> walls = new ArrayList();
    private List<Door> doors = new ArrayList();
    private List<Enemy> enemies = new ArrayList();


    public RoomTwo() {
        createWalls();
        createDoors();
        createEnemies();
    }


    private void createEnemies() {
        Random rand = new Random();
        int x, y;
        for(int i = 0; i < 5; i++){
            x = rand.nextInt((MAX_WIDTH-1) - MAX_WIDTH/2) + MAX_WIDTH/2; // ((max - min) + 1) + min
            y = rand.nextInt((MAX_HEIGHT-2) - MIN_HEIGHT+1) + MIN_HEIGHT +1;
            enemies.add(new Enemy(new Coordinate(x,y)));
        }
    }

    @Override
    public void createWalls() {
        Wall horizontalWalls = new FrameWall(new Coordinate(MIN_WIDTH,MIN_HEIGHT), new Coordinate(MAX_WIDTH,MAX_HEIGHT), true, Color.red);
        walls.add(horizontalWalls);
        Wall verticalWalls = new FrameWall(new Coordinate(MIN_WIDTH,MIN_HEIGHT), new Coordinate(MAX_WIDTH,MAX_HEIGHT), false, Color.red);
        walls.add(verticalWalls);
    }

    @Override
    public void createDoors() {
        Door door1 = new Door(new Coordinate(MIN_WIDTH, MAX_HEIGHT/4), new Coordinate(MIN_WIDTH, MAX_HEIGHT/2), false, Color.BLACK, 0);
        doors.add(door1);
        Door door = new Door(new Coordinate(MAX_WIDTH, MAX_HEIGHT/4), new Coordinate(MAX_WIDTH, MAX_HEIGHT/2), false, Color.RED, 0);
        doors.add(door);
    }

    @Override
    public boolean isSecretRevealed(){
        if (enemies.size() == 0){
            return true;
        }
        return false;
    }

    @Override
    public void revealSecret(){
        doors.get(1).setColor(Color.BLACK);
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
