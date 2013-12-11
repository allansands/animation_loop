package uk.me.westmacott;

import java.awt.*;

import uk.me.westmacott.lorenz.LorenzWheel;

public class Main {

    public static void main(String[] args) {

        World myWorld = new LorenzWheel("Test World", 300, 500);

        new AnimationLoop(myWorld, 30).start();
    }
}