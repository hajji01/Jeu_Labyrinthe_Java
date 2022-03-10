package Grilles;

import java.util.HashMap;
import java.util.Map;
import Objets.Items;
import Grilles.util.Direction;
import Grilles.util.Wall;


/**
 * La classe Cell est une cellule de coordonées (x,y) du labyrinthe.
 * elle possède des getters et des setters, un constructeur, Différentes méthodes pour savoir si il y a un objet
 * ou savoir si une cellule à déjà était visité.
 */
public class Cell {
// Attribut Global --------------------------------------------
    // coordonée x.
    private int x;
    // coordonée y.
    private int y;
    // Attribut déja visité .
    private Boolean alreadyVisited;
    // Attribut pour savoir si un item est présent sur la celulle.
    private Boolean ItemIsTrue = false;
    private Items obj;

    // Map sur les murs de direction : NORD , SUD , EST , OUEST
    private Map<Direction,Wall> murs;

    /**
     * Constructeur ---
     * @param x
     * @param y
     * Initialise une cellule et place les murs dans toutes les directions.
     * une cellule , n'est pas visité à sa création et il n'y a pas d'objet non plus.
     */
    public Cell(int x, int y) {
        this.x = x;
        this.y = y;
        this.murs = new HashMap<Direction,Wall>();
        this.murs.put(Direction.NORTH, new Wall());
        this.murs.put(Direction.SOUTH, new Wall());
        this.murs.put(Direction.EAST, new Wall());
        this.murs.put(Direction.WEST, new Wall());
        this.alreadyVisited = false;
        this.obj = null;
    }

    public void setObj(Items o){
        this.obj = o;
    }
    /**
     * la méthodes Boolean nous informe sur la préscence ou non d'un objet sur la cellule actuelle 
     * @return this.ItemIsTrue (vrai ou faux)
     */
    public Boolean isAnItemsThere(){
         if(this.obj != null){
             this.ItemIsTrue = true;
         }
         return this.ItemIsTrue;
    }

    public void getItems(){
        if(ItemIsTrue == true){
            setObj(this.obj);
        }
    }
    /**
     * @return x de type integer
     */
    public int getX() {
        return this.x;
    }

    /**
     * @return y de type integer
     */
    public int getY() {
        return this.y;
    }

    /**
     * 
     * @return les coordonees formaté dans un tableau.
     */
    public int[] coordinates() {
        int[] coordonees = new int[2];
        coordonees[0] = this.getX();
        coordonees[1] = this.getY();
        return coordonees;
    }

    /**
     * La méthode indique si la cellule a déjà était visité
     * @return this.alreadyVisited (vrai ou faux)
     */
    public Boolean isAlreadyVisited(){
        return this.alreadyVisited;
    }
    /**
     * 
     * @param cardinal
     * @return this.murs.get(cardinal)
     * @throws UnknownWallException
     * Récupere le cardinal d'un mur si le cardinal du mur n'existe pas donne une exception UnknownWallException
     */
    public Wall getWall(Direction cardinal) throws UnknownWallException{
        if (isWallExist(cardinal)) {
            return this.murs.get(cardinal);            
        }else{
            throw new UnknownWallException("This Wall doesn't exists");
        }
    }

    /**
     * Détruit un mur dans une direction donnée.
     * @param cardinal
     * @return true ou false
     */
    public boolean destroyWall(Direction cardinal) {
        if (isWallExist(cardinal)) {
            this.murs.remove(cardinal);
            return true;
        }else{
            return false;
        }
    }

    public Boolean isWallExist( Direction cardinal){
        return this.murs.containsKey(cardinal);
    }   

    /**
     * Méthode equals
     */
    public boolean equals(Object obj) {
        boolean reponse = false;
        if(obj instanceof Cell){
            Cell other = (Cell) obj;
            reponse = ((this.x == other.x)&&(this.y == other.y)&&(this.murs.equals(other.murs)));
        }
        return reponse;
    }
}