package Grilles.util;

import java.util.Random;

import Grilles.Cell;

public class AleaGen {
    private Random genRandom;

    public  AleaGen() {
        this.genRandom = new Random();
    }

    public boolean genBoolean() {
       return this.genRandom.nextBoolean();
    }

    public int genValueBound(int bound){
        return this.genRandom.nextInt(bound);
    }

}
