package Grilles.util;
/**
 * Classe enum Direction
 * On va retrouver une direction nord sud est ouest 
 */
public enum Direction {
    NORTH("Nord",0,-1), SOUTH("Sud",0,1), EAST("Est",1,0), WEST("Ouest",-1,0);
// Attribut---------------------
    private String nom;
    private int x;
    private int y;
//Constructeur---
    private Direction(String nomString,int Dx, int Dy) {
        this.nom = nomString;
        this.x = Dx;
        this.y = Dy;
    }
//Méthodes---------------------
    /**
     * @return the x
     */
    public int getX() {
        return this.x;
    }

    /**
     * @return the y
     */
    public int getY() {
        return this.y;
    }

    /**
     * Retourne l'opposé d'une direction
     * @return Direction
     */
    public Direction getOpposite() {
        switch (this.name()) {
            case "NORTH":
                return Direction.SOUTH;
            case "SOUTH":
                return Direction.NORTH;
            case "EAST":
                return Direction.WEST;
            case "WEST":
                return Direction.EAST;
            default:
                return null;
        }
    }

    public Direction getOtherSolution() {
        switch (this.name()){
            case "SOUTH":
                return Direction.EAST;
            case "EAST":
                return Direction.SOUTH;
            default:
                return null;
        }
    }

    /**
     * @return the nom
     */
    public String getNom() {
        return nom;
    }

}