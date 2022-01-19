import java.util.*;

public class intcoll5 {
    private LinkedList<Integer> c = new LinkedList<Integer>();

    public intcoll5(){
        c = new LinkedList<Integer>();
    }

    public intcoll5(int i){
        c = new LinkedList<Integer>();
    }

    public void copy(intcoll5 obj){
        ListIterator<Integer> I = obj.c.listIterator();
        while(I.hasNext()){
            Integer n = I.next();
            c.add(n);
        }
    }

    public boolean belongs(int i){
        boolean truthval = c.contains(i);
        return truthval;
    }

    public void insert(int i){
        if (i>0){
            Integer I = new Integer(i);
            if ((!c.contains(I))){
                c.addFirst(I);
            }
        }
    }

    public void omit(int i){
        if(c.contains(i)){
            c.remove(new Integer(i));
        }
    }

    public int get_howmany(){
        return c.size();
    }

    public void print(){
        ListIterator<Integer> I = c.listIterator();
        while(I.hasNext()){
            Integer n = I.next();
            System.out.println(n.intValue());
        }
    }

    public boolean equals(intcoll5 object){
        ListIterator<Integer> I = c.listIterator();
        boolean truthval = true;
        while (I.hasNext() && truthval){
            Integer m = I.next();
            truthval = object.c.contains(m);
        }
        return truthval;
    }

}
