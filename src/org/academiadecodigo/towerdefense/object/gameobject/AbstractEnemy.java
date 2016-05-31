package org.academiadecodigo.towerdefense.object.gameobject;

import org.academiadecodigo.simplegraphics.mouse.MouseEvent;
import org.academiadecodigo.towerdefense.object.interfaces.MovableRepresentable;
import org.academiadecodigo.towerdefense.object.interfaces.Shootable;
import org.academiadecodigo.towerdefense.object.simplegfx.SimpleGfxRepresentation;

/**
 * Created by codecadet on 23/05/16.
 */
public abstract class AbstractEnemy extends AbstractMovableObject implements Shootable {
    private Direction dir;
    private int hitPoints;
    private boolean isAlive = true;


    public AbstractEnemy(MovableRepresentable representation, GameObjectType type, int xPos, int yPos, int hp) {
        super(representation, type, xPos, yPos);
        this.hitPoints = hp;
        dir = Direction.STOPPED;
    }


    @Override
    public void animate(int animCounter) {
        super.animate(animCounter);

        switch (dir) {

            case NORTH:
                moveRepresentable(0, -1);
                break;

            case SOUTH:
                moveRepresentable(0, 1);
                break;

            case WEST:
                moveRepresentable(-1, 0);
                break;

            case EAST:
                moveRepresentable(1, 0);
                break;

            default:
                break;
        }
    }


    public void move() {
        switch (dir) {

            case NORTH:
                super.move(0, -1);
                break;

            case SOUTH:
                super.move(0, 1);
                break;

            case WEST:
                super.move(-1, 0);
                break;

            case EAST:
                super.move(1, 0);
                break;

            default:
                break;
        }
    }


    public void initialDirection(boolean northCheck, boolean southCheck, boolean westCheck, boolean eastCheck) {
        if (northCheck) dir = Direction.NORTH;
        if (southCheck) dir = Direction.SOUTH;
        if (westCheck) dir = Direction.WEST;
        if (eastCheck) dir = Direction.EAST;
    }


    public void verifyDirection(boolean northCheck, boolean southCheck, boolean westCheck, boolean eastCheck) {
        switch (dir) {

            case NORTH:
                changeDirection(northCheck, westCheck, eastCheck);
                break;

            case SOUTH:
                changeDirection(southCheck, eastCheck, westCheck);
                break;

            case WEST:
                changeDirection(westCheck, southCheck, northCheck);
                break;

            case EAST:
                changeDirection(eastCheck, northCheck, southCheck);
                break;

            default:
                break;
        }
    }


    private void changeDirection(boolean isFrontPath, boolean isLeftPath, boolean isRightPath) {
        switch (dir) {

            case NORTH:
                if (isFrontPath) {
                    return;
                }

                if (isLeftPath) {
                    dir = Direction.WEST;
                    return;
                }

                if (isRightPath) {
                    dir = Direction.EAST;
                    return;
                }
                break;

            case SOUTH:
                if (isFrontPath) {
                    return;
                }

                if (isLeftPath) {
                    dir = Direction.EAST;
                    return;
                }

                if (isRightPath) {
                    dir = Direction.WEST;
                    return;
                }
                break;

            case EAST:
                if (isFrontPath) {
                    return;
                }

                if (isLeftPath) {
                    dir = Direction.NORTH;
                    return;
                }

                if (isRightPath) {
                    dir = Direction.SOUTH;
                    return;
                }
                break;

            case WEST:
                if (isFrontPath) {
                    return;
                }

                if (isLeftPath) {
                    dir = Direction.SOUTH;
                    return;
                }

                if (isRightPath) {
                    dir = Direction.NORTH;
                    return;
                }
                break;
        }

        dir = Direction.STOPPED;
    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {

        if ((mouseEvent.getX() > this.getxPos() && mouseEvent.getX() < this.getxPos() + SimpleGfxRepresentation.getCellSize()) && ((mouseEvent.getY()+23) < this.getyPos() + SimpleGfxRepresentation.getCellSize() && (mouseEvent.getY()+23) > this.getyPos())) {

            if (!isAlive) {
                System.out.println("Enemy is already dead!");
            } else {
                loseHP();
            }
        }
    }



    @Override
    public int getHP() {
        return hitPoints;
    }

    @Override
    public void loseHP() {
        hitPoints -= 10;
        if (hitPoints <= 0) {
            setDead();
            dir = Direction.STOPPED;
            //set representation red rectangle
        }
    }

    @Override
    public boolean isAlive() {
        return this.isAlive;
    }

    @Override
    public boolean setDead() {
        return isAlive = false;
    }

    @Override
    public void setHP(int hp) {
        this.hitPoints = hp;
    }
}
