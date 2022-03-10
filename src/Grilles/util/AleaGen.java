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
// genere une case objectif compris dans la grille
    public Grille genObjectifCell() {
        Cell caseAleatoireX = 0;
        Cell caseAleatoireY = 0;
// VICTOR ALED !!!!
        caseAleatoireX =  caseAleatoireX.getX();
        caseAleatoireY = caseAleatoireY.getY();
        if ((caseAleatoireX < "Xmax du maze")&&(caseAleatoireY < "Ymax du maze")){ 
            return caseAleatoire;
        }
        
     }

}
