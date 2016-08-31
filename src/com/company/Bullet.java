package com.company;

/**
 * Created by Administrator on 2016-08-31.
 */
public class Bullet {

    private Coordinate position;
    private double modifyX ;

    public Bullet(Coordinate position) {
        this.position = position;
    }

    public Coordinate getPosition() {
        return position;
    }

    public void updateBullet(){

        modifyX += 0.1;
        position.setX(position.getX()+ (int)modifyX); //går höger

        if(modifyX >= 1.1){
            modifyX = 0;
        }

    }
}
