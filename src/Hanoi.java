import hanoi.gui.JHanoi;
import util.Stack;

/**
 * Gère le programme Hanoi
 *
 * @author Géraud Silvestri
 * @author Loïc Rosset
 */
public class Hanoi {
    /**
     * Lance le programme en mode GUI s'il n'y a pas de paramètres, en mode console sinon
     * @param args si pas null, lance le programme en mode console, sinon en mode GUI
     */
    public static void main(String[] args){
        if(args.length > 1){
            System.out.println("Error :  passage de paramètres");
        }
        else if(args.length == 1){
            int temp;
            try {
                temp = Integer.parseInt(args[0]);
                hanoi.Hanoi hanoi = new hanoi.Hanoi(temp);
                hanoi.solve();
            }catch(NumberFormatException e){
                System.out.println("Error : " + e.getMessage());
            }
        }
        else{
            JHanoi jHanoi = new JHanoi();
        }
    }

    /**
     * batterie de test sur les différentes fonctionalitées de la stack
     */
    private static void test(){
        try {
            Stack stack = new Stack();

            System.out.println("test push");
            System.out.println("Avant\n" + stack);
            stack.push(1);
            stack.push(2);
            stack.push(3);
            System.out.println("Push 1");
            System.out.println("Push 2");
            System.out.println("Push 3");
            System.out.println("Apres\n" + stack);
            System.out.println("\n");

            System.out.println("test pop");
            System.out.println("Avant\n" + stack);
            Object temp = stack.pop();
            System.out.println("Element retourné: " + temp);
            System.out.println("Apres\n" + stack);
            System.out.println("\n");

            System.out.println("test pop d'une pile vide");
            Stack vide = new Stack();
            try {
                Object t = vide.pop();
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
            System.out.println("\n");

            System.out.println("test state");
            stack.push(3);
            System.out.println("Stack\n" + stack);
            System.out.println("Attendu: 3 2 1");
            System.out.println("Recu: ");
            for (Object o : stack.state()) {
                System.out.print(o);
            }
            System.out.println("\n");

            System.out.println("test size");
            System.out.println("Stack\n" + stack);
            System.out.println("Attendu: 3");
            System.out.println("Recu: " + stack.size() + "\n");

            System.out.println("test getIterator");
            System.out.println("Stack\n" + stack);
            System.out.println("Attendu (hasNext): True");
            System.out.println("Recu: " + stack.getIterator().hasNext() + "\n");
            System.out.println("Attendu (next): 3");
            System.out.println("Recu: " + stack.getIterator().next() + "\n");

            System.out.println("test getIterator sur pile vide");
            System.out.println("Attendu (hasNext): false");
            System.out.println("Recu: " + vide.getIterator().hasNext() + "\n");
            try {
                System.out.println("Recu: " + vide.getIterator().next() + "\n");
            }catch(Exception e){
                System.out.println(e.getMessage());
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
