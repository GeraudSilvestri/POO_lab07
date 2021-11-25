package util;

/**
 * Itérateur pour la pile mettant à disposition des méthodes sur ladite pile
 *
 * @author Géraud Silvestri
 * @author Loïc Rosset
 */
public class Examinator {
    Element current;

    /**
     * constructeur contenant un élément
     * @param e élément
     */
    public Examinator(Element e){
       current = e;
    }

    /**
     * retourne vrai si l'élément contenu n'est pas nul
     * @return vrai si l'élément n'est pas nul
     */
    public boolean hasNext(){
        return current != null;
    }

    /**
     * renvoi l'élément courant et l'examinateur pointe sur l'élément suivant
     * @return élément courant
     */
    public Object next(){
        if(!hasNext()){
            throw new RuntimeException();
        }

        Object temp = current.value();
        this.current = current.getNext();
        return temp;
    }
}
