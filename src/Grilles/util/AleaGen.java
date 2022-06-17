package Grilles.util;

import java.util.Random;

/**
 * Classe de génération aléatoire
 */
public class AleaGen {
    private Random genRandom;

    public  AleaGen() {
        this.genRandom = new Random();
    }

    public boolean genBoolean() {
       return this.genRandom.nextBoolean();
    }

    /**
     * La méthode renvoie la limite x ou y de la grille
     * @param bound
     * @return this.genRandom.nextInt(bound)
     */
    public int genValueBound(int bound){
        return this.genRandom.nextInt(bound);
    }

    public int genValueBound2(int bound, int min){
        return this.genRandom.nextInt(bound) + min;
    }

}
