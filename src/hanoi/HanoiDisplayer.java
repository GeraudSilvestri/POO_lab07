package hanoi;

import util.Stack;

public class HanoiDisplayer {

    public HanoiDisplayer(){    }

    public void display(Hanoi h){
        System.out.println("\nTurn " + h.turn());
        for(Stack s : h.getStakes()){
            System.out.println(s);
        }
    }
}
