package Objets;


public enum Enigme {
    Enigme1("Qui marche sur 4 pattes le matin, 2 le midi et 3 le soir ?","l'homme"),
    Enigme2("Combien vaut 5 * 5 * 5 ?", "125"),
    Enigme3("Les riches en manquent, les pauvres en ont et pire que le diable ?", "rien");

    private String enonce;
    private String reponse;
    private String[] reponses = { "1- l homme ", "2- 125","3- rien" };

    private Enigme(String enonce, String reponse){
        this.enonce = enonce;
        this.reponse = reponse;
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

    /**
     * @return the enonce sous forme de String
     */
    public String getEnonce() {
        return this.enonce;
    }

    /**
     * @return the reponse sous forme de String
     */
    public String getReponse() {
        return this.reponse;
    }

    /**
     * @return the reponse sous forme de String
     */
    public String [] getReponses() {
        return this.reponses;
    }


    /**
     * 
     * @param s la reponse donné par le joueur
     * @return true si la reponse sous forme de minuscule est la bonne
     */
    public boolean checkReponse(String s){
        return s.toLowerCase().equals(this.reponse);
    }
}
