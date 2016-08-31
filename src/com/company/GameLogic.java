package com.company;

import com.googlecode.lanterna.input.Key;

import java.util.List;

/**
 * Created by Administrator on 2016-08-30.
 */
public class GameLogic {

    /**
     * Moves the player
     * @param player
     * @param key
     * @param room
     */
    public void movePlayer(World world, Player player, Key key, Room room){

        switch (key.getKind()) {
            case ArrowUp:
                if(checkForDoor(world, player, room, key)){
                    System.out.println("It's a TRAP!");
                    player.getPosition().setX(Room.MAX_HEIGHT-2);
                }
                if (!isWallHit(player, key)){
                    player.getPosition().setY(player.getPosition().getY()-1);
                }
                break;
            case ArrowRight:
                if(checkForDoor(world, player, room, key)){
                    System.out.println("It's a TRAP!");
                    player.getPosition().setX(Room.MIN_WIDTH+2);
                }
                if (!isWallHit(player, key)) {
                    player.getPosition().setX(player.getPosition().getX() + 1);
                }
                break;
            case ArrowDown:
                if(checkForDoor(world, player, room, key)){
                    System.out.println("It's a TRAP!");
                    player.getPosition().setX(Room.MIN_HEIGHT+2);
                }
                if (!isWallHit(player, key)) {
                    player.getPosition().setY(player.getPosition().getY() + 1);
                }
                break;
            case ArrowLeft:
                if(checkForDoor(world, player, room, key)){
                    System.out.println("It's a TRAP!");
                    player.getPosition().setX(Room.MAX_WIDTH-2);
                }
                if (!isWallHit(player, key)) {
                    player.getPosition().setX(player.getPosition().getX() - 1);
                }
                break;
            case Tab:
                System.out.println("Shoot!");
                player.shoot();
                break;
            default:
        }//End switch

    }//End movePlayer

    private boolean checkForDoor(World world, Player player, Room room, Key key) {

        for (Door door : room.getDoors() ) {
            if(door.isHorizontal()){
                switch (key.getKind()) {
                    case ArrowUp:
                        if (player.getPosition().getX() >= door.getStart().getX() &&
                                player.getPosition().getX() <= door.getEnd().getX() &&
                                player.getPosition().getY() == door.getStart().getY()+1){
                            world.setCurrentRoom(door.getRoomNumber());
                            return true;
                        }
                        break;
                    case ArrowDown:
                        if (player.getPosition().getX() >= door.getStart().getX() &&
                                player.getPosition().getX() <= door.getEnd().getX() &&
                                player.getPosition().getY() == door.getStart().getY()-1){
                            world.setCurrentRoom(door.getRoomNumber());
                            return true;
                        }
                        break;
                    default:
                }//End switch
            }//End if door.isHorizontal
            else{
                switch (key.getKind()) {
                    case ArrowLeft:
                        if (player.getPosition().getY() >= door.getStart().getY() &&
                                player.getPosition().getY() <= door.getEnd().getY() &&
                                player.getPosition().getX() == door.getStart().getX()+1){
                            world.setCurrentRoom(door.getRoomNumber());
                            System.out.println("Found door");
                            return true;
                        }
                        break;
                    case ArrowRight:
                        if (player.getPosition().getY() >= door.getStart().getY() &&
                                player.getPosition().getY() <= door.getEnd().getY() &&
                                player.getPosition().getX() == door.getStart().getX()-1){
                            world.setCurrentRoom(door.getRoomNumber());
                            return true;
                        }
                        break;
                    default:
                }//End switch

            }//end if/else

        }//End for doors



        return false;

    }//End checkForDoor

    private boolean isWallHit(Player player, Key key) {

        switch (key.getKind()) {
            case ArrowUp:
                if (player.getPosition().getY() == Room.MIN_HEIGHT +1){
                    return true;
                }
                break;
            case ArrowRight:
                if (player.getPosition().getX() == Room.MAX_WIDTH -1){
                    return true;
                }
                break;
            case ArrowDown:
                if (player.getPosition().getY() == Room.MAX_HEIGHT -1){
                    return true;
                }
                break;
            case ArrowLeft:
                if (player.getPosition().getX() == Room.MIN_WIDTH +1){
                    return true;
                }
                break;
            default:
        }//End switch

        return false;
    }//End isWallHit

    public boolean collisionDetection(World world, Player player) {

        for (int i = 0; i < player.getBullets().size(); i++) {
            for (int j = 0; j < world.getCurrentRoom().getEnemies().size(); j++) {
                if(player.getBullets().get(i).getPosition().getX() == world.getCurrentRoom().getEnemies().get(j).getPosition().getX() &&
                        player.getBullets().get(i).getPosition().getY() == world.getCurrentRoom().getEnemies().get(j).getPosition().getY()){
                    System.out.println("HIT ENEMY!");
                    player.getBullets().remove(i);
                    world.getCurrentRoom().getEnemies().remove(j);
                    break;
                }//End if
            }//End J
        }//End I

        for (Enemy enemy : world.getCurrentRoom().getEnemies()) {
            if(player.getPosition().getX() == enemy.getPosition().getX() &&
                    player.getPosition().getY() == enemy.getPosition().getY() ){
                System.out.println("DEAD");
                return false;
            }//End if
        }


        return true;
    }
}
