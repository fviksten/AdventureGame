package com.company;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016-08-30.
 */
public class Player {

    private Coordinate position;
    private int health;
    private List<Bullet> bullets = new ArrayList();

    public Player(Coordinate position, int health) {
        this.position = position;
        this.health = health;
    }//End constructor

    public Coordinate getPosition() {
        return position;
    }

    public int getHealth() {
        return health;
    }

    public void shoot() {
        Bullet bullet = new Bullet(new Coordinate(position.getX()+2, position.getY()));
        bullets.add(bullet);
    }//End shoot

    public List<Bullet> getBullets() {

        return bullets;
    }

    public void handleBullets() {

        for (int i = 0; i < bullets.size(); i++) {
            if(bullets.get(i).getPosition().getX() >= Room.MAX_WIDTH - 1){
                bullets.remove(i);
            }
        }
    }
}
