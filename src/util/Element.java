package util;

public class Element {
    private final Object value;
    private final Element next;

    @Override
    public String toString() {
        return value.toString();
    }

    public Element getNext() {
        return next;
    }

    public Element(Object o, Element next){
        this.value = o;
        this.next = next;
    }

    public Object value(){return value;}
}
