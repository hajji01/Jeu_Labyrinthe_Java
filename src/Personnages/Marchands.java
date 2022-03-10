package Personnages;
import objets.Parchemins;

/**
 * Classe Marchands héritant de la classe abstraite Personnage
 * Un Marchands vend un parchemin qui contient l'objectif à atteindre.
 */
public class Marchands extends Personnage{
// Attribut GLobal ---------------------------------//
    // or : ne peut être null
    private int or = 0;
    /**
     * Constructeur ---
     * @param name nom du marchands, de type String.
     * Héritant du constructeur Personnage.
     */
    public Marchands(String name){
        super(name);
    }
// Méthodes ------------------------------------------//
    /**
     * @param p engager la conversation par un personnage P
     * la méthodes ne renvois rien ou pas .
     */
    public void Conversation(Personnage p){
        String a = "je te vend ce parchemins pour : " + this.or ;
        Parchemins D = new Parchemins();

    }
}
