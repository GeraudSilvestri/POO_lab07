package hanoi;

import util.Stack;

/**
 * Mets à disposition la logique derrière la résolution des tours de Hanoi
 *
 * @author Géraud Silvestri
 * @author Loïc Rosset
 */
public class Hanoi {
    private static final int NB_STAKE = 3;
    int nbDisks;
    Stack[] stakes;
    int counter;
    HanoiDisplayer display;
    Boolean finished;
    String[] numbers = {"one", "two", "three"};

    /**
     * Constructeur utilisé pour le mode console
     * @param nbDisks nombre de disques
     */
    public Hanoi(int nbDisks){
        this(nbDisks, new HanoiDisplayer());
    }

    /**
     * Constructeur utilisé pour le mode GUI
     * @param nbDisks nombre de disques
     * @param display méthode de display des tours
     */
    public Hanoi(int nbDisks, HanoiDisplayer display){
        this.nbDisks = nbDisks;
        this.display = display;
        stakes = new Stack[NB_STAKE];

        for(int i = 0; i < NB_STAKE; ++i){
            stakes[i] = new Stack();
        }

        for(int i = nbDisks; i > 0; --i){
            stakes[0].push(i);
        }
    }

    /**
     * lance la résolution des tours
     */
    public void solve(){
        finished = false;
        display.display(this);
        solve(nbDisks, stakes[0], stakes[1], stakes[2]);
        finished = true;
    }

    /**
     * résout la tour
     * @param n numéro du disque a traiter
     * @param from tour de départ
     * @param middle tour intermédiaire
     * @param dest tour finale
     */
    private void solve(int n, Stack from, Stack middle, Stack dest){
        if(n > 0) {
            solve(n - 1, from, dest, middle);
            dest.push(from.pop());
            counter++;
            display.display(this);
            solve(n-1, middle, from, dest);
        }
    }

    /**
     * permet de récupérer l'état des tours sous le format suivant
     * -- Tour n:
     * one: [valeurs]
     * two: [valeurs]
     * three: [valeurs]
     * @return string contenant les valeurs des 3 tours
     */
    public String toString(){
        StringBuilder toReturn = new StringBuilder();
        toReturn.append("\n-- Turn ").append(turn()).append("\n");

        for(int i = 0; i < NB_STAKE; ++i){
            toReturn.append(numbers[i]).append(": ").append(stakes[i]).append("\n");
        }

        return toReturn.toString();
    }

    /**
     * permet de récupérer le contenu des tours en int
     * @return tableau du contenu
     */
    public int[][] status(){
        int[][] toReturn = new int[NB_STAKE][];

        for(int i = 0; i < NB_STAKE; ++i){
            Object[] values = stakes[i].state();
            toReturn[i] = new int[stakes[i].size()];
            for(int j = 0; j < values.length; j++){
                toReturn[i][j] = (int) values[j];
            }
        }
        return toReturn;
    }

    /**
     * permet de récupérer l'état de la résolution
     * @return état de résolution
     */
    public boolean finished(){
        return finished;
    }

    /**
     * permet de récupérer le nombre de déplacements effectués au moment de l'appel
     * @return nombre de déplacements
     */
    public int turn(){return counter;}
}
