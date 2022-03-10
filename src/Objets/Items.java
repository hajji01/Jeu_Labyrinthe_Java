package Objets;

import Personnages.Personnage;

/**
 * Classe Abstraite Items, définit plusieurs getter et setter, sur les noms d'objet et le prix.
 * 
*/
public abstract class Items {
	private String nomItems;
	private int prix;

	/**
	 * 
	 */
	public Items(String name, int prix) {
		this.prix = prix;
		this.nomItems = name;
	}

	public String getNomItems() {
		return nomItems;
	}

	public void setNomItems(String nomItems) {
		this.nomItems = nomItems;
	}

	public int getPrix() {
		return prix;
	}

	public void setPrix(int prix) {
		this.prix = prix;
	}

	// Effet d'un Items
	public abstract void Effets(Personnage p);
}
