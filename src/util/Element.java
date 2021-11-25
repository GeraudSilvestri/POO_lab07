package util;

/**
 * Représente l'élément d'une pile
 * Chaque élément pointe sur l'élément suivant
 *
 * @author Géraud Silvestri
 * @author Loïc Rosset
 */
public class Element {
    private final Object value;
    private final Element next;

    /**
     * permet de récupérer la valeur de l'élément en string
     * @return valeur en string
     */
    @Override
    public String toString() {
        return value.toString();
    }

    /**
     * permet de récupérer l'élément pointé par notre objet
     * @return élément suivant
     */
    public Element getNext() {
        return next;
    }

    /**
     * constructeur
     * @param o valeur de l'élément
     * @param next élément suivant (pointé)
     */
    public Element(Object o, Element next){
        this.value = o;
        this.next = next;
    }

    public Object value(){return value;}
}
