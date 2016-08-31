package com.company;

import java.awt.*;
import java.util.List;

/**
 * Created by Administrator on 2016-08-30.
 */
public interface Wall {

    void create(boolean horizontal);
    List<Coordinate> getCoordinates();
    Color getColor();
}
