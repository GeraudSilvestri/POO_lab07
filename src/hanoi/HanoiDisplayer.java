package hanoi;

import util.Stack;

public class HanoiDisplayer {
    int mode; // 0 = console, 1 = GUI

    public HanoiDisplayer(int mode){
        this.mode = mode;
    }

    public HanoiDisplayer(){
        this.mode = 0;
    }

    public void display(Hanoi h){
        System.out.println("\nTurn " + h.turn());
        for(Stack s : h.getStakes()){
            System.out.println(s);
        }
    }
}
