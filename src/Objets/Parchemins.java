package Objets;

import Grilles.util.AleaGen;
import Grilles.util.Goal;
import Personnages.Personnage;

/**
 * Classe Parchemin qui hérite de la classe abstraite de Items.
 * Le Parchemin est vendu par un marchand contre de l'or ou peut-être trouvé sur une cellule.
 */
public class Parchemins extends Items{
// Attribut Global -----------------------------------------------//
	//private Cell objectif;
	private AleaGen generator; 
	/**
	 * Constructeur ---
	 * @param name nom du parchemin
	 * @param prix prix non négatif
	 * Constructeur hériant de Items
	 */
	public Parchemins(String name, int prix) {
		super(name, prix);
	}
	/**
	 * @param p est Personnage sur lequel l'effet sera appliqué
	 */
	public void Effets(Personnage p,Goal goal) {
		
		// Sur la grille dans la creation il faut definir une case au hasard et elle sera la case à atteindre.
		// recup les coordonnées de cette case 
		// un switch entre une direction à donner ou la case en elle même (à voir plus tard )

		String clue = "";
		int diffX ;
		int diffY ;

		diffX = goal.getPosX() - p.getX();
		diffY = goal.getPosY() - p.getY();

		if (diffX > 0) {
			clue = clue + "Votre Objectif est à l'Est de votre position";
		}else{
			clue = clue + "Votre Objectif est à l'Ouest de votre position";
		}

		if (diffY > 0){
			clue = clue + "Ainsi que plus au sud";
		}else{
			clue = clue + "Ainsi que plus nord";
		}

}
}
