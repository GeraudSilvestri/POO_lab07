package hanoi;

import util.Stack;

public class Hanoi {
    private static final int NB_STAKE = 3;
    int nbDisks;
    Stack[] stakes;
    int counter;
    HanoiDisplayer display;
    Boolean finished;

    public Hanoi(int nbDisks){
        this(nbDisks, new HanoiDisplayer(0));
    }

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

    public void solve(){
        finished = false;
        display.display(this);
        solve(nbDisks, stakes[0], stakes[1], stakes[2]);
        finished = true;
    }

    private void solve(int n, Stack from, Stack middle, Stack dest){
        if(n > 0) {
            solve(n - 1, from, dest, middle);
            dest.push(from.pop());
            counter++;
            display.display(this);
            solve(n-1, middle, from, dest);
        }
    }

    public Stack[] getStakes(){return stakes;}

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

    public boolean finished(){
        return finished;
    }

    public int turn(){return counter;}
}
