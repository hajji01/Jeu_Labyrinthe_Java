package Personnages;

import java.util.ArrayList;
import Objets.*;
import Grilles.*;

/**
 * Classe Hero héritant de Personnage, c'est le personnage que le joueur incarnera.
 * Il possède un inventaire d'objets.
 * Il peut afficher son iventaire, ajouter un objet, vendre un objet, utiliser un objet, prendre un objet sur une cellule.
 */
public class Hero extends Personnage{
// Attribut GLobal ------------------------------------------//
	// inventory : est null à sa création.
	private ArrayList<Items> inventory;

	/** 
	 * Constructeur ---
	 * @param name nom de type Sting, ne peut pas être null
	 * @param or or de type integer, ne peut pas être < 0
	 * Le constructeur hérite de Personnage.
	 * Inventory, à sa création la liste est vide.
	 */
	public Hero(String name, int or) {
		super(name,or);
		inventory = new ArrayList<Items>();
	}

	/**
	 * Affiche l'inventaire du Hero
	 */
	public void afficherInventaire() {
		for (int i = 1; i < inventory.size() + 1; i++) {
			System.out.println(i + "." + inventory.get(i - 1).getNomItems());
		}
	}

	/**
	 * La méthode permet de recupérer un objet présent sur une cellule.
	 */
	public void pickUpObject(){
		if(this.currentCell.isAnItemsThere() == true){			
			addItems(this.currentCell.getItems());		
		}
	}

	/**
	 * @param o de type Items
	 * ajoute le paramètre o à la liste.
	 */
	public void addItems(Items o) {
		inventory.add(o);
	}

	/**
	 * @param o de type Items
	 * Utilise le Paramètre o
	 */
	public void use(Items o) {
		if (inventory.contains(o)) {

			// effet de l'item

			inventory.remove(o);
		}
	}

	/**
	 * @param o de type Items
	 * Vend un paramètre o
	 */
	public void sell(Items o) {

		if (inventory.contains(o)) {
			inventory.remove(o);
			super.or += o.getPrix();
		} else {
			System.out.println("error");
			// donne une exception
		}
	}


}
