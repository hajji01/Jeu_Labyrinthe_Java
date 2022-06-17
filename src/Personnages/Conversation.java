package Personnages;

import java.util.Scanner;

import Objets.Enigme;

/**
 * Classe Conversation pour lancer différentes discussion entre le hero et un
 * pnj.
 */
public class Conversation {
    // Attribut Global ---------------------------------------//
    private Personnage hero;
    private Personnage pnj;
    private Boolean convEnded;
    private String convEnonc;
    private String[] convReponse;
    private Enigme e;
    private int numero;
    private Scanner sc;

    /**
     * Constructeur ---
     * 
     * @param p1 est le hero.
     * @param p2 est le PNJ
     * 
     */
    public Conversation(Personnage p1, Personnage p2) {
        this.hero = p1;
        this.pnj = p2;
        this.convEnded = false;
        this.sc = new Scanner(System.in);
    }

    public void derouleConv() {

        while (!this.convEnded) {
            // si joueur choisi parler
            // this.hero.parle(this.pnj);
            // si joueur choisi quitter
            // this.hero.QuitterConversation();

            this.convEnonc = this.e.Enigme1.getEnonce();
            System.out.println(this.convEnonc);
            this.convReponse = this.e.Enigme1.getReponses();
            this.e.printMenu(this.convReponse);
            this.numero = this.sc.nextInt(); // Trés important de vider le scanner pour prendre d'autres valeurs.
          

            switch (this.numero) {
                case 1:
                    System.out.println(this.convReponse[0]);
                    System.out.println('\n');
                    break;
                case 2:
                    System.out.println(this.convReponse[1]);
                    System.out.println('\n');
                    break;
                case 3:
                    System.out.println(this.convReponse[2]);
                    System.out.println('\n');
                    break;
                default:
                    System.out.println('\n');
                    break;
            }
            this.convEnded = true;
            this.sc.nextLine();
        }

    }



}