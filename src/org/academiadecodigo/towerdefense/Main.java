package org.academiadecodigo.towerdefense;

import org.academiadecodigo.towerdefense.object.gameobject.ObjectFactory;
import org.academiadecodigo.towerdefense.object.representable.RepresentableFactory;
import org.academiadecodigo.towerdefense.object.simplegfx.SimpleGfxRepresentableFactory;

/**
 * Created by codecadet on 23/05/16.
 */
public class Main {

    public static void main(String[] args) {
        RepresentableFactory factory = new SimpleGfxRepresentableFactory();

        Game p = new Game(new ObjectFactory(factory), Level.LEVEL1);
        p.start();
    }
}
