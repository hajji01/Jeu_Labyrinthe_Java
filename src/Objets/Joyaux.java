package Objets;

import Personnages.Personnage;

/**
 * Classe Parchemin qui hérite de la classe abstraite de Items.
 * Le Joyaux est trouvé sur une cellule et peut-être vendu à un marchand.
 */
public class Joyaux extends Items{

	/**
	 * Constructeur ---
	 * @param name nom du joyaux
	 * @param prix prix du joyaux
	 * Constructeur hériant de Items
	 */
	public Joyaux(String name, int prix) {
		super(name, prix);

	}

	/**
	 * @param p est Personnage sur lequel l'effet sera appliqué
	 */
	public void Effets(Personnage p) {
		p.setOr(p.getOr() + this.getPrix());
	}
}
