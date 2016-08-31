package com.company;

/**
 * Created by Administrator on 2016-08-31.
 */
public class Enemy {

    private Coordinate position;
    private double modifyX ;

    public Enemy(Coordinate position) {
        this.position = position;
    }

    public Coordinate getPosition() {
        return position;
    }

    public void updateEnemy(){
        modifyX += 0.01;
        position.setX(position.getX()+ (int)modifyX * -1); //går vänster

        if(modifyX >= 1.01){
            modifyX = 0;
        }

    }
}
