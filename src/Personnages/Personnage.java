package Personnages;

import Grilles.*;
import Grilles.util.Direction;

/**
 * @author hugo wiernicki , victor truyen
 * Classe Abstraite 'Personnage', dans cette classe on va y retrouver un constructeur ainsi que des fonction de getter et setter.
 * La classe contient plusieurs attribut : un nom, une quantité d'or et une position sur une cellule (x,y).
 */
public abstract class Personnage {
// Attribut Global ---------------------------------------------------------------//
	// name : doit être différent de null
	protected String name;
	// or : doit être >= 0
	protected int or;
	// x et y : position du Personnage
	protected int x;
	protected int y;

	/**
	 * Constructeur Personnage ---
	 * @param name Nom de type String, en paramètre du constructeur 'Personnage', il ne peut pas être null.
	 * @param or Or de type integer, en paramètre du constructeur 'Personnage', il ne peut pas être négatif.
	 * La création d'un Personnage ce fait par son nom et la quantité d'or avec laquelle il va commencer.
	 */
	public Personnage(String name, int or ) {
		this.name = name;
		this.or = or;
	}

	
// Méthodes ---------------------------------------------------------------------//
	/**
	 * @return this.name, la fonction retourne le nom du Personnage de type String.
	 */
	public String getName() {
		return this.name;
	}
	/**
	 * @param name ne peut pas être null.
	 * La fonction ne renvois rien.
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return this.or, de type integer, la fonction retourne l'or du Personnage.
	 */
	public int getOr() {
		return this.or;
	}
	/**
	 * @param or ne peut être négatif
	 * La fonction ne renvois rien.
	 */
	public void setOr(int or) {
		this.or = or;
	}
	/**
	 * @param prmGrille paramètre de type Grille, qui sert à récuperer une fonction getCell()
	 * @param prmDirection paramètre de type Direction
	 * La méthode Move, fait deplacer le personnage à la prochaine case où si il n'y a pas de mur.
	 */
	public void Move(Grille prmGrille ,Direction prmDirection){
		if (!(prmGrille.getCell(this.x, this.y).isWallExist(prmDirection))) {
			this.x += prmDirection.getX();
			this.y += prmDirection.getY();
		}
	}

	/**
	 * @param pnj
	 * Pour engager une conversation quand le Personnage croisera un pnj.
	 */
	public void engagerConv(Personnage pnj){
		//Conversation convo = new Conversation(pnj);
	}
	/**
	 * @param pnj
	 * Si une conversation est engager, on utilisera cette methode.
	 */
	public void parle(Personnage pnj){
		
	}
	/**
	 * Quitte une conversation si elle a été engager.
	 */
	public void QuitterConversation(){
    	
	}
}
