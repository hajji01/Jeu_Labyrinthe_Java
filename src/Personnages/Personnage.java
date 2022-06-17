package Personnages;

import Grilles.*;
import java.util.ArrayList;

import Grilles.util.AleaGen;
import Grilles.util.Direction;
import Objets.Items;
//import actions.action;

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
	protected ArrayList<Items> inventory;
	protected Cell currentCell;
	protected AleaGen randomGen;
	/**
	 * Constructeur Personnage ---
	 * @param name Nom de type String, en paramètre du constructeur 'Personnage', il ne peut pas être null.
	 * @param or Or de type integer, en paramètre du constructeur 'Personnage', il ne peut pas être négatif.
	 * La création d'un Personnage ce fait par son nom et la quantité d'or avec laquelle il va commencer.
	 */
	public Personnage(String name, int or, Grille maze) {
		this.name = name;
		this.or = or;
		this.x = 0;
		this.y = 0;
		this.inventory = new ArrayList<Items>();
		this.currentCell = maze.getCell(0, 0);
		this.randomGen = new AleaGen();
	}

	/**
	 * Constructeur Personnage ---
	 * @param name Nom de type String, en paramètre du constructeur 'Personnage', il ne peut pas être null.
	 * @param or Or de type integer, en paramètre du constructeur 'Personnage', il ne peut pas être négatif.
	 * La création d'un Personnage ce fait par son nom et la quantité d'or avec laquelle il va commencer.
	 */
	public void Personnages(String name, int or, Grille maze, int x, int y) {
		this.name = name;
		this.or = or;
		this.x = x;
		this.y = y;
		this.inventory = new ArrayList<Items>();
		this.currentCell = maze.getCell(x, y);
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
	 * @param x the x to set
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * @param y the y to set
	 */
	public void setY(int y) {
		this.y = y;
	}


	/**
	 * @return the x
	 */
	public int getX() {
		return x;
	}

	/**
	 * @return the y
	 */
	public int getY() {
		return y;
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
     * la méthode prend une position aléatoire dans la grille 
     */
    public void setPersonnage(Grille prmGrille){
		this.x = 0;
		this.y =0;
        //this.x = this.randomGen.genValueBound(prmGrille.getNx()) ;
        //this.y = this.randomGen.genValueBound(prmGrille.getNy()) ;   

    }

	/**
     * la méthode prend une position X aléatoire dans la grille 
     */
    public void setPersonnageX(Grille prmGrille){
        this.x = this.randomGen.genValueBound(prmGrille.getNx());  

    }

	/**
     * la méthode prend une position Y aléatoire dans la grille 
     */
    public void setPersonnageY(Grille prmGrille){
        this.y = this.randomGen.genValueBound(prmGrille.getNy());   

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
