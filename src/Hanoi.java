import hanoi.gui.JHanoi;

public class Hanoi {
    public static void main(String[] args){

        if(args.length > 1){
            System.out.println("Error :  passage de paramètres");
        }
        else if(args.length == 1){
            int temp = 0;
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
