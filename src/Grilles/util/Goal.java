package Grilles.util;

import Grilles.Grille;

public class Goal {
    private int posX;
    private int posY;
    private Grille maze;
    private AleaGen randomGen;

    public Goal(Grille maze){
        this.posX = 0;
        this.posY = 0;
        this.maze = maze;
        this.randomGen = new AleaGen();
    }

    public void setGoalRandomPosition(){
        this.posX = this.randomGen.genValueBound(this.maze.getNx());
        this.posY = this.randomGen.genValueBound(this.maze.getNy());        
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
