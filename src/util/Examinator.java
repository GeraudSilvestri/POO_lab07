package util;

public class Examinator {
    Element current;

    public Examinator(Element e){
       current = e;
    }

    public boolean hasNext(){
        return current != null;
    }

    public Object next(){
        if(!hasNext()){
            throw new RuntimeException();
        }

        Object temp = current.value();
        this.current = current.getNext();
        return temp;
    }
}
