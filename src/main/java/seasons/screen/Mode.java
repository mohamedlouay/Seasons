package seasons.screen;



public enum Mode {
    /**
     * permet d'afficher ou non le log du jeu selon le situation :
     * RECAP : affiche le resumé du log
     * EXTEND : affiche le log en details
     * NONE   : n'affiche pas les log -> cas de test
     */
    RECAP,
    EXTEND,
    NONE
}