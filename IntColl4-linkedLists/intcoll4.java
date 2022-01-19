import java.util.*;

public class intcoll4
{
    private int howmany;
    private ListNode c; //makes c of type listnode
                        //contains pointer to either next item in list or null pointer
                        //c is name of linkedlist that we are going to use

    //default constructor
    //makes new link list that is empty and starts the counter at 0 since the collection is empty
    public intcoll4() {
        c=null; howmany = 0;
    }

    //alternate custructor
    //same as method above since we're not worried about capacity
    //makes new link list that is empty and starts the counter at 0 since the collection is empty
    public intcoll4(int i) {
        c=null; howmany = 0;
    }

    //makes a copy of the list in the object of the method into the list that is calling the method
    public void copy(intcoll4 obj) {
        if (this != obj){ //makes sure object being copied isnt alrady equal to the object copying it
            howmany = obj.howmany;
            if (obj.c == null){  //if array being copied is null
                c = null;        //make copy of null array
            }
            else{
                c = new ListNode(obj.c.info, null); /* new listnode c with info member same as
                head of the object list node and link being null */
                ListNode p=c; //copies whats in c into p, p now points to first item in linked list
                ListNode q = obj.c; //copies whats in the list being copied into into q, q now points to first item in object's linked list
                while(q.link != null){ //while the array being copied still has next item in linked list
                    q = q.link; //info member of array being copied is copied to the link member so it can point to next listnode in list
                    p.link = new ListNode(q.info, null); //makes next listnode in list with info member q and link member null
                    p = p.link; //then reassignes p to pointer to next listnode in linked list
                }
            }
        }
    }


    //inserts i into the head of the collection if it that integer isnt already there
    public void insert(int i) {
        ListNode p=c; ////copies whats in c into p, p now points to first item in linked list
        while ((p!=null)&&(p.info!=i)) { //traverse through list until either pointer is null or info is i
            p=p.link;
        } //if p.info = i, do nothing
        if (p==null) {   //if i not there, create new listnode with infomember i and pointer to c
            p=new ListNode(i, c);
            c=p; //copies everything in p back into c
            howmany++;
        }
    }

    //removes integer i from whichever collection calls the method
    public void omit(int i)
    {
        ListNode p=c; ListNode pred=null;
        while ((p!=null)&&(p.info!=i)) {pred=p; p=p.link;}
        if (p!=null) {
            if (pred!=null) pred.link=p.link;
            else c=p.link;
            howmany--;
        }
    }

    //returns true or false if integer i is an info member of collection c
    public boolean belongs(int i) {
        ListNode p=c; //copies whats in c into p, p now points to first item in linked list
        while ((p!=null)&&(p.info!= i)) { //traverses through linkedlist until either link points to null or the info member = i
            p=p.link;
        }
        return (p!=null);
    }

    //returns the amount of integers in the collection
    public int get_howmany() {
        return howmany;
        //since howmany is being updated in insert method, simply return howmany
    }

    //iterates through the linked list & prints every integer in the collection
    public void print() {//traversing a linked list and printing the link
        ListNode p=c; //copies whats in c into p, p now points to first item in linked list
        System.out.println();
        while (p!=null) {
            System.out.println(p.info); //prints info member
            p=p.link; //changes p to point to next listnode in list
        }
    }

    //checks if two lists contain the same integers
    public boolean equals(intcoll4 obj) {
        ListNode p = c; //copies whats in c into p, p now points to first item in linked list
        boolean truthval = true;
        while (truthval && p != null){ //while true and the pointer isnt pointing to a null listnode, do:
         truthval = obj.belongs(p.info); /*iterates through list checking if each info member in the list that is calling the method
                                         is also in the list that is in the object of the method */
         p = p.link;
        }
        return truthval; //if breaks because a certain infomember wasnt in the other list's colletion, then returns false
                         // if breaks becuase pointer points to a null then every int belongs in other collection thus returns true
    }

    // The inner class for ListNode
    private class ListNode {
        private int info;      //interger stored in whatever list node in the list
        private ListNode link; //link cotains whole next listnode in the list
        public ListNode() {
            info=0;
            link=null;
        }

        public ListNode(int i, ListNode p) {
            info=i; link=p;
        }
    }
}
