package Grilles.util;

import Grilles.Grille;
/**
 * classe Goal, classe qui donne le but final du jeu
 */
public class Goal {
    // Attribut--------------------------
    private int posX;
    private int posY;
    private Grille maze;
    private AleaGen randomGen;
    //Constructeur---
    public Goal(Grille maze){
        this.posX = 0;
        this.posY = 0;
        this.maze = maze;
        this.randomGen = new AleaGen();
    }
    //Méthodes-------------------------------

    /**
     * la méthode prend une position aléatoire dans la grille 
     */
    public void setGoalRandomPosition(){
        this.posX = this.randomGen.genValueBound(this.maze.getNx());
        this.posY = this.randomGen.genValueBound(this.maze.getNy());        
    }

    public void setGoalFixed(){
        this.posX = 8;
        this.posY = 3;      
    }

    /**
     * @return the posX
     */
    public int getPosX() {
        return posX;
    }

    /**
     * @return the posY
     */
    public int getPosY() {
        return posY;
    }
    
}
