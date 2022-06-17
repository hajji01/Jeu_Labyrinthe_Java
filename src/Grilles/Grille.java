package Grilles;

//import java.util.Random;

import Grilles.util.*;

public class Grille {
    private int nx;
    private int ny;
    private Cell[][] quadrillage;
    private AleaGen generator;
    // ---------------------------------CONSTRUCTEURS--------------------------------

    public Grille(int x, int y) {
        this.nx = x;
        this.ny = y;
        this.quadrillage = new Cell[this.nx][this.ny];
        for (int i = 0; i < this.quadrillage.length; i++) {
            for (int j = 0; j < this.quadrillage[0].length; j++) {
                this.quadrillage[i][j] = new Cell(i, j);
            }
        }
        this.generator = new AleaGen();
    }

    /**
     * @return the nx abcisse
     */
    public int getNx() {
        return this.nx;
    }

    /**
     * @return the ny ordonée
     */
    public int getNy() {
        return this.ny;
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

    // Méthodes pour savoir si il y a un voisin dans une direction ---
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

    // ---

    // ---------------------------------InitLabyrinthe--------------------------------
    public void makeMazeStupidMethod() {
        String DrawGrille = "";
        Cell currentCell = null;
        Cell neighbour = null;
        Direction choiceDirection = null;
        for (int i = 0; i < this.quadrillage.length -1; i++) {
            for (int j = 0; j < this.quadrillage[0].length -1; j++) {
                DrawGrille += "+-----";
                System.out.print(DrawGrille);
                //System.out.print("+-----");
               // System.out.print("|");
                currentCell = this.quadrillage[i][j];
                if (this.pileOUface()) {
                    choiceDirection = Direction.EAST;
                } else {
                    choiceDirection = Direction.SOUTH;
                }
                // on casse la cellule dans la direction tiré et dans la cellule voisine également mais du coté opposé.
                if (this.hasANeighbour(currentCell.getX(), currentCell.getY(), choiceDirection)) {
                    if (currentCell.destroyWall(choiceDirection)) {
                        neighbour = this.getNeighbour(currentCell.getX(), currentCell.getY(), choiceDirection);
                        neighbour.destroyWall(choiceDirection.getOpposite());
                       // neighbour.destroyWall(choiceDirection.getOtherSolution());
                    }
                } else {
                    if (this.hasANeighbour(currentCell.getX(), currentCell.getY(),
                            choiceDirection.getOtherSolution())) {
                        if (currentCell.destroyWall(choiceDirection.getOtherSolution())) {
                            neighbour = this.getNeighbour(currentCell.getX(), currentCell.getY(),choiceDirection.getOtherSolution());
                            neighbour.destroyWall(choiceDirection.getOtherSolution().getOpposite());
                        }
                    }
                }

            }
        }
    }
}
