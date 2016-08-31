package com.company;

import com.googlecode.lanterna.*;
import com.googlecode.lanterna.input.Key;
import com.googlecode.lanterna.terminal.Terminal;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;


public class Main {


    public static void main(String[] args) throws InterruptedException {
	// write your code here
        System.out.println("Let's start!");

        //Setup Terminal
        Terminal terminal = TerminalFacade.createTerminal(System.in, System.out, Charset.forName("UTF8"));
        terminal.enterPrivateMode();
        terminal.setCursorVisible(false);

        GameGraphics gameGraphics = new GameGraphics();
        GameLogic gameLogic = new GameLogic();
        World world = new World();
        Key key;

        gameGraphics.printTitleScreen(terminal);
        boolean gameIsRunning = true;
        while (gameIsRunning){
            do{
                Thread.sleep(5);
                key = terminal.readInput();
                for (Enemy enemy : world.getCurrentRoom().getEnemies()) {
                    enemy.updateEnemy();
                    gameGraphics.drawEnemy(enemy, terminal);
                }
                world.getPlayer().handleBullets();
                for (Bullet bullet : world.getPlayer().getBullets()) {
                    bullet.updateBullet();
                    gameGraphics.drawBullet(bullet, terminal);
                }
                gameIsRunning = gameLogic.collisionDetection(world, world.getPlayer());
                if (world.getCurrentRoom().isSecretRevealed()){
                    world.getCurrentRoom().revealSecret();
                }
            }while(key == null && gameIsRunning);

            if(gameIsRunning) {
                gameLogic.movePlayer(world, world.getPlayer(), key, world.getCurrentRoom());
                gameGraphics.drawGame(terminal, world.getCurrentRoom(), world.getPlayer());
            }
        }//End main game-loop
        gameGraphics.printGameOver(terminal);
    }//End Main method

}//End main Class
