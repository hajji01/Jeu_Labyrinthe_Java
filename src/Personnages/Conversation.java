package Personnages;

/**
 * Classe Conversation pour lancer différentes discussion entre le hero et un pnj.
 */
public class Conversation{
// Attribut Global ---------------------------------------//
    private Personnage hero;
    private Personnage pnj;
    private Boolean convEnded;
    private String conv;

    /**
     * Constructeur ---
     * @param p1 est le hero.
     * @param p2 est le PNJ
     * 
     */
public Conversation(Personnage p1, Personnage p2){
    this.hero = p1;
    this.pnj = p2;
    this.convEnded = false;
}

public void derouleConv(){
 while(!this.convEnded){
 //si joueur choisi parler    
     //this.hero.parle(this.pnj);
 //si joueur choisi quitter    
     //this.hero.QuitterConversation();
 }

}

// public String Convo1(){
//     conv = "..."

// }

// public String Convo2(){
//     conv = "xxx"
// }


}