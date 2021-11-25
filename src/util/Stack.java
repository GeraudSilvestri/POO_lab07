package util;

/**
 * Mets à disposition une structure de type pile
 *
 * @author Géraud Silvestri
 * @author Loïc Rosset
 */
public class Stack {
    Element start;
    int size;

    /**
     * constructeur par défaut
     */
    public Stack(){
        size=0;
    }

    /**
     * ajout d'un élément dans la pile
     * @param o valeur de l'élément
     */
    public void push(Object o){
        size++;
        start = new Element(o, start);
    }

    /**
     * enlève l'élément au sommet de la pile
     * @return valeur de l'élément au sommet
     */
    public Object pop(){
        if(start == null)
            throw new RuntimeException("Erreur pop");
        Element temp = start;
        start = start.getNext();
        size--;
        return temp.value();
    }

    /**
     * récupère l'itérateur pointant sur le sommet de la pile
     * @return itérateur pointant sur le sommet
     */
    public Examinator getIterator(){
        return new Examinator(start);
    }

    /**
     * permet de récupérer la valeur de tous les éléments de la pile en string
     * @return valeur de tous les éléments en string
     */
    public String toString(){
        StringBuilder string = new StringBuilder();

        Examinator ite = getIterator();

        string.append("[");
        while(ite.hasNext()){
            string.append("<").append(ite.next()).append("> ");
        }
        string.append("]");

        return string.toString();
    }

    /**
     * permet de récupérer un tableau de tous les éléments de la pile dans un tableau
     * @return tableau contenant les valeurs de tous les éléments de la pile
     */
    public Object[] state(){
        Object[] array = new Object[size];
        Examinator ite = getIterator();
        int i = 0;

        while(ite.hasNext()){
            array[i++] = ite.next();
        }

        return array;
    }

    /**
     * permet de récupérer la taille de la pile
     * @return taille de la pile
     */
    public int size(){
        return size;
    }
}
