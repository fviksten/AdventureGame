package com.company;

import java.util.List;

/**
 * Created by Administrator on 2016-08-30.
 */
public interface Room {
    int MAX_WIDTH = 98;
    int MAX_HEIGHT = 20;
    int MIN_WIDTH = 1;
    int MIN_HEIGHT = 1;

    void createWalls();
    void createDoors();

    List<Wall> getFrameWalls();

    List<Door> getDoors();

    List<Enemy> getEnemies();

    void revealSecret();
    boolean isSecretRevealed();
}
