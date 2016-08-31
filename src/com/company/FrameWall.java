package com.company;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016-08-30.
 */
public class FrameWall implements Wall {

    private List<Coordinate> coordinates = new ArrayList();
    private Coordinate start;
    private Coordinate end;
    private boolean horizontal;
    private Color color;

    public FrameWall(Coordinate start, Coordinate end, boolean horizontal, Color color) {
        this.start = start;
        this.end = end;
        this.horizontal = horizontal;
        create(this.horizontal);
        this.color = color;
    }//constructor

    @Override
    public void create(boolean horizontal){
        if (horizontal){
            for (int i = start.getX(); i <= end.getX() ; i++) {
                coordinates.add(new Coordinate(i,start.getY()));
                coordinates.add(new Coordinate(i,end.getY()));
            }
        }else{
            for (int i = start.getY(); i <= end.getY(); i++ ){
                coordinates.add(new Coordinate(start.getX(),i));
                coordinates.add(new Coordinate(end.getX(),i));
            }
        }
    }//end createFrameWall

    @Override
    public List<Coordinate> getCoordinates() {
        return coordinates;
    }

    public Color getColor() {
        return color;
    }
    public void setColor(Color color) {
        this.color = color;
    }

    public Coordinate getStart() {
        return start;
    }

    public Coordinate getEnd() {
        return end;
    }

    public boolean isHorizontal() {
        return horizontal;
    }
}//End class wall
