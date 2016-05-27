package org.academiadecodigo.towerdefense;

import org.academiadecodigo.towerdefense.object.gameobject.AbstractObject;
import org.academiadecodigo.towerdefense.object.gameobject.Field;
import org.academiadecodigo.towerdefense.object.gameobject.GameObjectType;
import org.academiadecodigo.towerdefense.object.gameobject.ObjectFactory;

/**
 * Created by codecadet on 23/05/16.
 */
public class Game {
    private static final int DELAY = 20;
    private ObjectFactory factory;
    private Level currentLevel;
    private Field field;


    public Game(ObjectFactory factory, Level currentLevel) {

        this.currentLevel = currentLevel;
        this.factory = factory;
        field = (Field) factory.createObject(GameObjectType.FIELD, 0, 0);

        field.init(factory, currentLevel);
    }

    /**@throws InterruptedException*/
    public void start() throws InterruptedException {
        while (true) {
            Thread.sleep(DELAY);


        }
    }
}
