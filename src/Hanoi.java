import hanoi.gui.JHanoi;

/**
 * Gère le programme Hanoi
 * Lance le programme en mode GUI s'il n'y a pas de paramètres, en mode console sinon
 *
 *  @author Géraud Silvestri
 *  @author Loïc Rosset
 */
public class Hanoi {
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




}
