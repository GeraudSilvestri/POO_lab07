package hanoi;

import util.Stack;

/**
 * gère le display d'hanoi (GUI ou console)
 *
 * @author Géraud Silvestri
 * @author Loïc Rosset
 */
public class HanoiDisplayer {

    /**
     * constructeur par défaut
     */
    public HanoiDisplayer(){}

    /**
     * gère l'affichage des tours
     * @param h hanoi faisant la résolution
     */
    public void display(Hanoi h){
        System.out.println(h);
    }
}
