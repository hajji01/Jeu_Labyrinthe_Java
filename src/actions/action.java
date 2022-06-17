package actions;

import java.util.InputMismatchException; //exception scanner 
import java.util.Scanner; // Import the Scanner class
import java.util.concurrent.TimeUnit; // pour le sleep
import java.util.regex.Pattern; // pour les expression regulieres

import Grilles.*;
import Grilles.util.AleaGen;
import Grilles.util.Direction;
import Grilles.util.Goal;
import Personnages.Conversation;
import Personnages.Hero;
import Personnages.Marchands;

/**
 * classe action qui contient les diverses option de choix du jeu
 */
public class action {
    // Attributs-------------------------------------------------------------------------------
    private int or, ChoixNumero, Cardinalite; // xCoordonéeHero, yCoordonéeHero;
    private String nom;
    private Boolean name_IS_StringChar;
    private Grille grille;
    private Hero hero;
    private Marchands marchand;
    private Scanner sc;
    private AleaGen generator;
    private Goal goal;
    private Conversation conv;
    // Options-----
    private String[] optEtape0 = { "1- 10*10", "2- autre grille" };
    private String[] optEtape1 = { "1- creation hero" };
    private String[] optEtape2 = { "1- nord", "2- sud", "3- est", "4- ouest", };

    // Constructeur -----
    public action() {
        this.name_IS_StringChar = false;
        this.generator = new AleaGen();
    }
    // ------------------------------------------------------------------------------------------------
    // Méthodes ----------------------------------------------------------------

    /**
     * C'est l'option qui commence par creer une grille
     * Option 0
     * exemple : this.g = new Grille(3,4);
     * lancement du jeu
     */
    public void OptionStart() {
        Boolean notInt = false;
        this.DisplayOption0();
        while (notInt == false) {
            try {
                switch (this.ChoixNumero) {
                    case 1:
                        notInt = true;
                        this.grille = new Grille(10,10);       // Faire un test avec cette grille . 
                        this.goal = new Goal(this.grille);
                        this.goal.setGoalFixed();
                        this.grille.makeMazeStupidMethod();
                        System.out.println("( " + this.grille.getNx() + "," + this.grille.getNy() + " )");
                        // System.out.println("( " + this.goal.getPosX()+ "," + this.goal.getPosY()+ "  )");    //**Débug**
                        marchand = new Marchands("name", 10, this.grille);
                        this.marchand.setPersonnage(this.grille);
                        System.out.println('\n');
                        break;
                    case 2:
                        notInt = true;
                        this.grille = new Grille(this.generator.genValueBound(20), this.generator.genValueBound(20));      
                        this.goal = new Goal(this.grille);
                        this.goal.setGoalRandomPosition();
                        this.grille.makeMazeStupidMethod();
                        System.out.println('\n');
                        break;
                    default:
                        notInt = false;
                        System.out.println("Erreur la partie recommence");
                        this.DisplayOption0();
                        break;
                }

            } catch (InputMismatchException e) {
                System.out.println("Erreur c'est une chaine de caractère !  Recommence ");
                notInt = false;
                this.sc.nextLine();
            }
        }
    }

    /**
     * Option 1
     * creation perso etape 1
     */
    public void OptionCreationHero() {
        Boolean notInteger = false;
        while ((this.name_IS_StringChar == false) || (notInteger == false)) {
            printMenu(this.optEtape1);
            try {
                // Trés important de vider le scanner pour prendre d'autres valeurs.
                this.ChoixNumero = this.sc.nextInt();
                switch (this.ChoixNumero) {
                    case 1:
                        notInteger = true;
                        this.Display_AndSet_Name();
                        this.testName();
                        break;
                    default:
                        System.out.println("Choisis la bonne option avec un chiffre.");
                        notInteger = false;
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Erreur c'est une chaine de caractère !  Recommence ");
                notInteger = false;
                this.sc.nextLine();
            }

        }
    }

    /**
     * direction MOVE
     */
    public void OptionCreationDirection() {
        // tant que me goal n'a pas été trouvé.
        while ((this.goal.getPosX() != this.hero.getX()) || (this.goal.getPosY() != this.hero.getY())) {
            printMenu(this.optEtape2);
            this.ChoixNumero = this.sc.nextInt(); // Trés important de vider le scanner pour prendre d'autres valeurs.

            switch (this.ChoixNumero) {
                case 1:
                    this.Cardinalite = 1;
                    this.Display_Direction_North_South();
                    this.ifMarchandIsHere();
                    break;
                case 2:
                    this.Cardinalite = 2;
                    this.Display_Direction_North_South();
                    this.ifMarchandIsHere();
                    break;
                case 3:
                    this.Cardinalite = 3;
                    this.Display_Direction_East_West();
                    this.ifMarchandIsHere();
                    break;
                case 4:
                    this.Cardinalite = 4;
                    this.Display_Direction_East_West();
                    this.ifMarchandIsHere();
                    break;
                default:
                    System.out.println("Il y à un mur présent : ");
                    break;
            }
        }

    }

    /**
    * 
    * @return iHere type boolean , true si il rencontre le perso false sinon
    */
    public Boolean ifMarchandIsHere(){
        Boolean isHere = false;
        if((this.hero.getX()) == (this.marchand.getX())){
            if((this.hero.getY()) == (this.marchand.getY())){
                 isHere = true;
                 this.conv = new Conversation(this.hero, this.marchand);
                 this.conv.derouleConv();
            }
        }
        return isHere;
    }

    // FIN Méthodes
    // -------------------------------------------------------------------------------------------------------------------------------------
    // Fonction Display Etape 0 -----------

    public void DisplayOption0() {
        System.out.println("Lancement ...");
        try {
            TimeUnit.SECONDS.sleep(1);
            System.out.println("Choix de la grille : ");
            printMenu(this.optEtape0);
            this.ChoixNumero = this.sc.nextInt();// Trés important de vider le scanner pour prendre d'autres valeurs.

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }


    // Fonction Display Etape 1 HERO -----------

    /**
     * Display Hero Crée le hero à partir des donnée du scanner des fct Display et
     * execute un affichage
     */
    public void DisplayHero() {
        this.hero = new Hero(this.nom, this.or, this.grille);
        this.hero.setX(0);
        this.hero.setY(0);
        System.out.println("Ton nom est : " + this.hero.getName() + ".");
        System.out.println("Tu possèdes : " + this.hero.getOr() + " or." + '\n');
    }

    /**
     * Display_AndSet_Name demande de taper le nom et execute un affichage
     */
    public void Display_AndSet_Name() {
        this.sc.nextLine();
        System.out.println("Quel est ton nom ?");
        this.nom = this.sc.nextLine();
    }

    /**
     * cette methode permet de verifié si le nom est constitué d'une chaine de
     * caractère
     * 
     * @return this.name_IS_StringChar
     */
    public Boolean testName() {
        this.name_IS_StringChar = Pattern.matches("[a-zA-Z]*", this.nom);
        if (this.name_IS_StringChar == true) {
            System.out.println("Bienvenue " + this.nom);
            this.DisplayHero();
        } else {
            System.out.println("Réssaye en utilisant uniquement des lettres. ");
        }
        return this.name_IS_StringChar;
    }

    /**
     * Display_AndSet_OR demande de taper l'or et execute un affichage
     */
    public void Display_AndSet_OR() {
        System.out.println("tu as combiens d'or ? ");
        this.or = this.sc.nextInt();
    }

    /*
     * 
     * 
     * public void recupCoord() {
     * this.xCoordonéeHero = this.hero.getX();
     * this.yCoordonéeHero = this.hero.getY();
     * }
     */

    // Display Direction Etape 2------------------

    /**
     * Cardinalite 1 -> north , 2 -> south
     */
    public void Display_Direction_North_South() {
        if (this.Cardinalite == 1) {
            System.out.println("North");
            this.hero.Move(this.grille, Direction.NORTH);
            // this.recupCoord();
            System.out.println(
                    this.hero.getName() + " se trouve : en (" + this.hero.getX() + "," + this.hero.getY() + ")");
        } else {
            if (this.Cardinalite == 2) {
                System.out.println("South");
                this.hero.Move(this.grille, Direction.SOUTH);
                // this.recupCoord();
                System.out.println(
                        this.hero.getName() + " se trouve : en (" + this.hero.getX() + "," + this.hero.getY() + ")");
            }
        }
    }

    /**
     * Cardinalite 3 -> EAST , 4 -> WEST
     */
    public void Display_Direction_East_West() {
        if (this.Cardinalite == 3) {
            System.out.println("East");
            this.hero.Move(this.grille, Direction.EAST);
            System.out.println(
                    this.hero.getName() + " se trouve : en (" + this.hero.getX() + "," + this.hero.getY() + ")");
            // this.recupCoord();
        } else {
            if (this.Cardinalite == 4) {
                System.out.println("West");
                this.hero.Move(this.grille, Direction.WEST);
                System.out.println(
                        this.hero.getName() + " se trouve : en (" + this.hero.getX() + "," + this.hero.getY() + ")");
                // this.recupCoord();
            }
        }
    }
    // Fin méthode display
    // --------------------------------------------------------------------------------------

    /**
     * CloseSC, la méthode ne renvoie rien elle nous sert à fermer le scanner pour
     * éviter les fuites ressources.
     */
    public void CloseSC() {
        this.sc.close();
    }

    /**
     * OpenSC, la méthode ne renvoie rien elle nous sert à ouvrir le scanner en
     * system.in
     */
    public void OpenSC() {
        this.sc = new Scanner(System.in);
    }

    /**
     * PrintMenu, affiche les différentes options de choix.
     * 
     * @param options
     */
    public static void printMenu(String[] options) {
        for (String option : options) {
            System.out.println(option);
        }
        System.out.println("Choisis ton action : ");
    }
}
