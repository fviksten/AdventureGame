package com.company;

import com.googlecode.lanterna.terminal.Terminal;

/**
 * Created by Administrator on 2016-08-30.
 */
public class GameGraphics {

    public void drawGame(Terminal terminal, Room room, Player player){
        terminal.clearScreen();
        for (Wall wall : room.getFrameWalls()) {
            for (Coordinate coord : wall.getCoordinates()) {
                terminal.moveCursor(coord.getX(),coord.getY());
                terminal.applyForegroundColor(wall.getColor().getRed(),wall.getColor().getGreen(),wall.getColor().getBlue()); //red, green, blue(Python green)
                terminal.putCharacter('\u2588'); //full block
            }
        }//End draw walls

        for (Door door : room.getDoors()) {
            for (Coordinate coord : door.getCoordinates()) {
                terminal.moveCursor(coord.getX(),coord.getY());
                terminal.applyForegroundColor(door.getColor().getRed(), door.getColor().getGreen(), door.getColor().getBlue()); //
                terminal.putCharacter('\u2588'); //full block
            }
        }//End draw doors

        //draw player
        terminal.moveCursor(player.getPosition().getX(),player.getPosition().getY());
        terminal.applyForegroundColor(255, 255, 255); //red, green, blue(Python green)
        terminal.putCharacter('\u263A'); //Smile =)

        for (Enemy enemy : room.getEnemies()) {
            terminal.moveCursor(enemy.getPosition().getX(), enemy.getPosition().getY());
            terminal.applyForegroundColor(0,0,255);
            terminal.putCharacter('\u2588'); //Big Yus
        }//End draw enemy
    }//End drawGame


    public void drawEnemy(Enemy enemy, Terminal terminal) {
        terminal.moveCursor(enemy.getPosition().getX(), enemy.getPosition().getY());
        terminal.applyForegroundColor(0,0,255);
        terminal.putCharacter('\u2588'); //Big Yus
        terminal.moveCursor(enemy.getPosition().getX() +1, enemy.getPosition().getY());
        //terminal.applyForegroundColor(0,0,0);
        terminal.putCharacter(' '); //full block

    }//End drawEnemy

    public void drawBullet(Bullet bullet, Terminal terminal) {
        terminal.moveCursor(bullet.getPosition().getX(), bullet.getPosition().getY());
        terminal.applyForegroundColor(255,255,255);
        terminal.putCharacter('-'); //ett skott
        terminal.moveCursor(bullet.getPosition().getX() -1, bullet.getPosition().getY());
        terminal.putCharacter(' '); //full block ful-lösning dölja skottets bana
    }

    public void printGameOver(Terminal terminal) {
        terminal.moveCursor(Room.MAX_WIDTH/2 , Room.MAX_HEIGHT+5);
        terminal.applyForegroundColor(255,0,0);

        //Slutmeddelande
        String end = "GAME OVER";
        for (int i = 0; i < end.length(); i++) {
            terminal.putCharacter(end.charAt(i));
        }//End for-loop slutmeddelande
    }

    public void printTitleScreen(Terminal terminal) {
        terminal.moveCursor(Room.MAX_WIDTH/2 , Room.MAX_HEIGHT/2);
        terminal.applyForegroundColor(255,255,255);

        //Slutmeddelande
        String end = "PRESS ANY BUTTON TO START...";
        for (int i = 0; i < end.length(); i++) {
            terminal.putCharacter(end.charAt(i));
        }//End for-loop slutmeddelande
    }
}
