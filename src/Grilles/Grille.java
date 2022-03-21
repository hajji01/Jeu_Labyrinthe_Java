package Grilles;

import java.util.Random;

import Grilles.util.*;

public class Grille {
    private AleaGen generator; 
    private int nx;
    private int ny;
    private Cell[][] quadrillage;

    // ---------------------------------CONSTRUCTEURS--------------------------------

    public Grille(int x, int y) {
        this.nx = x;
        this.ny = y;
        this.quadrillage = new Cell[x][y];
        for (int i = 0; i < this.quadrillage.length; i++) {
            for (int j = 0; j < this.quadrillage[0].length; j++) {
                this.quadrillage[i][j] = new Cell(i, j);
            }
        }
    }

     /**
     * @return the nx
     */
    public int getNx() {
        return nx;
    }

    /**
     * @return the ny
     */
    public int getNy() {
        return ny;
    }
    

    // ---------------------------------gestion ddes voisins des
    // cellules--------------------------------

    public Cell getNeighbour(int x, int y, Direction cardinal) {
        switch (cardinal) {
            case NORTH:
                return getCell(x, y - 1);
            case SOUTH:
                return getCell(x, y + 1);
            case EAST:
                return getCell(x + 1, y);
            case WEST:
                return getCell(x - 1, y);
            default:
                return null;
        }
    }

    public boolean hasANeighbour(int x, int y, Direction cardinal) {
        return (getNeighbour(x, y, cardinal) != null);
    }

    public boolean hasANeighbourRIGHT(int x, int y) {
        return (getNeighbour(x, y, Direction.EAST) != null);
    }

    public boolean hasANeighbourTOP(int x, int y) {
        return (getNeighbour(x, y, Direction.NORTH) != null);
    }

    public boolean hasANeighbourBOTTOM(int x, int y) {
        return (getNeighbour(x, y, Direction.SOUTH) != null);
    }

    public boolean hasANeighbourLEFT(int x, int y) {
        return (getNeighbour(x, y, Direction.WEST) != null);
    }

    public Cell getCell(int x, int y) {
        return this.quadrillage[x][y];
    }

    private boolean pileOUface() {
        return this.generator.genBoolean();
    }

    // ---------------------------------InitLabyrinthe--------------------------------
    public void makeMazeStupidMethod() {
        for (int i = 0; i < this.quadrillage.length; i++) {
            for (int j = 0; j < this.quadrillage[0].length; j++) {
                Cell currentCell = this.quadrillage[i][j];
                Cell neighbour;
                Direction choiceDirection;
                if (pileOUface()){
                    choiceDirection = Direction.EAST;
                }else{
                    choiceDirection = Direction.SOUTH;
                }
                if (this.hasANeighbour(currentCell.getX(), currentCell.getY(), choiceDirection)) {
                    if(currentCell.destroyWall(choiceDirection)){
                        neighbour = this.getNeighbour(currentCell.getX(), currentCell.getY(), choiceDirection);
                        neighbour.destroyWall(choiceDirection.getOpposite());
                    }
                }else{
                    if (this.hasANeighbour(currentCell.getX(), currentCell.getY(), choiceDirection.getOtherSolution())) {
                        if(currentCell.destroyWall(choiceDirection.getOtherSolution())){
                            if(currentCell.destroyWall(choiceDirection.getOtherSolution())){
                                neighbour = this.getNeighbour(currentCell.getX(), currentCell.getY(), choiceDirection.getOtherSolution());
                                neighbour.destroyWall(choiceDirection.getOtherSolution().getOpposite());
                            }                                    
                        }               
                    }
                }

            }
        }
    }
}
