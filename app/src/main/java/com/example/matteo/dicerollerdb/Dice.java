package com.example.matteo.dicerollerdb;

import java.util.Random;

public class Dice implements IRollable{
    Integer faces;

    public Integer getFaces() {
        return faces;
    }

    public void setFaces(Integer faces) {
        this.faces = faces;
    }

    @Override
    public int roll() {
        int diceResult = 0;

        if (faces != null){
            Random random = new Random();
            diceResult = random.nextInt(faces) + 1;
        }

        return diceResult;
    }
}
