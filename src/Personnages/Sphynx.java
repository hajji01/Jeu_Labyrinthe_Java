package Personnages;

import Objets.Enigme;
import Objets.Parchemins;
import Grilles.Grille;
import Grilles.util.Direction;

    /**
    * Classe Sphynx héritant de la classe abstraite Personnage
    * Un Sphynx échangent un indice contre une bonne réponse
    à une énigme.
    */
public class Sphynx extends Personnage{
    private Enigme SphynxEnigma;
    
    /**
     * Constructeur ---
     * @param enigme , de type Enigme.
     * Héritant du constructeur Personnage.
     */

    public Sphynx(String name, int or, Grille maze, Enigme enigme){
        super(name, or, maze);
        this.SphynxEnigma = enigme;
        this.inventory.add(new Parchemins("Indice", 0));    
    }
    
     // Méthodes ------------------------------------------//
    public String giveEnigme(){
        return this.SphynxEnigma.getEnonce();
    }
    /**
     * @param hero est le hero qui aura le parchemin
     */
    public void giveParchemin(Hero hero){
        if (this.SphynxEnigma.checkReponse(this.SphynxEnigma.getReponse())) {
            hero.addItems(this.inventory.get(0));
            this.inventory.remove(0);
        }
    }

    /**
     * On redefinit le comportement de Move car le sphynx ne bougent pas
     * Les parametres sont donc inutile ici 
     */
    @Override
    public void Move(Grille prmGrille, Direction prmDirection) {
        this.x = this.x + 0;
        this.y = this.y + 0;
    }
}
