package Personnages;
import Grilles.Grille;
import Objets.*;
/**
 * Classe Marchands héritant de la classe abstraite Personnage
 * Un Marchands vend un parchemin qui contient l'objectif à atteindre.
 */
public class Marchands extends Personnage{
// Attribut GLobal ---------------------------------//
    /**
     * Constructeur ---
     * @param name nom du marchands, de type String.
     * Héritant du constructeur Personnage.
     */
    public Marchands(String name,int or, Grille maze){
        super(name,or,maze);
    }
// Méthodes ------------------------------------------//
    /**
     * @param p engager la conversation par un personnage P
     * la méthodes ne renvois rien ou pas .
     */
    public void sell(Items obj, Personnage P){
        if(this.inventory.contains(obj)){
            P.inventory.add(obj);
            this.inventory.remove(obj);
            this.or += obj.getPrix();
        }
    }


}
