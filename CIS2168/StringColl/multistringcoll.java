import java.util.LinkedList;

//fix copy method
public class multistringcoll {
    private btNode c;
    private int howmany; //keeps track of distinct strings
    private int total; //keeps track of total strings

    //returns how many times i occurs in the collection
    public int get_count(String i){
        btNode pred = null;
        btNode p = c;
        while(p != null && !p.info.equals(i)){ //finds where i is in tree
            pred=p;
            if (p.info.compareTo(String.valueOf(i)) > 0) {
                p = p.left;
            }
            else{
                p=p.right;
            }
            //finds location of either string i or null node if i isnt in tree
        }
        return p.count; //then returns the count of that string
    }

    //returns total number of distinct strings in the collection
    public int get_howmany(){
        return howmany;
    }

    //returns total number of strings in the collection
    public int get_total(){
        return total;
    }

    /*outputs the distinct integers in the collection (with number of
    times it appears in parentheses if it appears more than once) */
    public void print() {
        printtree(c);
    }

    private static void printtree(btNode t) {
        //prints strings in tree in alphabetical (inorder) order
        if (t!=null) {
            printtree(t.left); //inorder traverse t's left subtree
            if (t.info != null) { //becuase of my omit making the info member null, need to ignore nulls for print
                System.out.println(t.info + " (" + t.count + ")");  //visit the root
            }
            printtree(t.right); //inorder traverse t's right subtree
        }
    }

    //creates a new stringcoll object that represents an empty collection
    public multistringcoll() {
        c = null; //null pointer
        howmany = 0;
    }

    //same as above, do nothing i with since we're not worried about capicity
    public multistringcoll(int i) {
        c = null;
        howmany = 0;
    }

    /*traverses through the tree thats calling the method copying all of
    the information from the object tree into it */
    private static btNode copytree(btNode t) {
        btNode root=null;
        if (t!=null) { //still copies if null tree
            root=new btNode(); //object that root is pointing to has info member "" "" and null left and right pointers
            root.info=t.info; //sets roots infomember to t's infomember
            root.left=copytree(t.left); //sets roots left pointer to t's left pointer
            root.right=copytree(t.right); //sets roots right pointer to t's left pointer
            root.count = t.count; //sets roots count to t's count
        }
        return root;
    }

    //insert i into the collection if its not there and do nothing if it is there
    public void insert(String i) {
        if (i != null) {
            btNode pred=null;
            btNode p=c;
            while ((p!=null)&&(!p.info.equals(i))) {
                //while loop checks if i is in the tree
                pred=p;
                if (p.info.compareTo(i) > 0) {
                    p=p.left;
                }
                else {
                    p = p.right;
                }
            }
            if (p != null){ //if i is already in collection
                p.count++; //iterate that p's count
                total++; //and iterate the total
            }
            else if (p==null) { //if i isn't in the tree, insert it
                p=new btNode(i, null, null, 1);
                if (pred!=null) { //traverse through tree
                    if (pred.info.compareTo(i) > 0) { //if predecesor's infomember is greater than i (alphabetically),
                        pred.left=p;  //assign p to the predecessors left pointer
                        howmany++;
                        total++;
                    }
                    else pred.right=p; //if greater than i than assign p to predesessors right pointer
                    howmany++;
                    total++;

                }
                else c=p;
            }
        }
    }

    //remove int from tree if it is there
    public void omit(String i) {
        btNode p = c; //p points to root of c
        btNode pred = null; //predecessor set to null
        while(p != null && !p.info.equals(i)){ //finds where i is in tree
            pred=p;
            if (p.info.compareTo(String.valueOf(i)) > 0) {
                p = p.left;
            }
            else {
                p = p.right; //after this while loop p points to the node that contains i as infomember
            }
        }
        if (p.count == 1){ //if the string is in the array once,
            p.info = null; //set its info member to 0
            p.count = 0;  //set its count to 0
            total--; //decrease the total by one
        }
        else if (p.count > 1){ //if there is more than one of this string in the tree,
            p.count--; //decreate p's count
            total--; //decrease total
        }
    }

    //returns true if i in collection, false if not
    public boolean belongs(String i) {
        btNode p=c; //p pointing to root of tree
        while ((p!=null)&&(!p.info.equals(i))) { //if p doesnt contain a null pointer, and if p's info memeber isnt i
            if (p.info.compareTo(String.valueOf(i)) > 0) {
                p=p.left; //check left tree
            }
            else {
                p=p.right; //check right tree
            }
        }
        return (p!=null); //if in tree returns true, false if otherwise
    }


    //checks if all the intgers in the objects collection are exactly the same as the integers in the collection calling the method
    public boolean equals(multistringcoll obj) {
        int i = 0;
        boolean result = (howmany==obj.howmany);
        if (result)
        {
            String[] a = new String[howmany];
            String[] b = new String[howmany];
            toarray(c, a, i); //c references the root of the tree calling the method, a is the array we're putting it in to, and 0 is where we're starting at
            toarray(obj.c, b, i); //obj.c refrences the root of the tree in the object, b is the array we're putting it into, and 0 is where the array starts

            while (result && (i < howmany)){
            //  result = (a[i].equalsIgnoreCase(b[i]));
                result = java.util.Objects.equals(a[i],b[i]);
                //used built in method to compare so it wouldnt throw exception for comparing two nulls
                i++;
            }
        }
        return result;
    }


    //makes a copy of the tree being called in the object
    public void copy(multistringcoll obj) {
        //makes object tree have same capaicty and objects in collection as the tree calling the method
        if (this!=obj) { //if a tree isnt already b
            howmany=obj.howmany; //copy b's howmany into a's
            total = obj.total;
            c = copytree(obj.c);
        }
    }



    //puts all the integers in the tree into an array starting at slot i of the array in
    //inorder order, also returns the amount of things in the tree
    private static int toarray(btNode t, String[] a, int i) { //giving this method the binary tree we want to work on, the array that we want to use for the integers, and i is where we want the integers in btnode to start at in the array
        int num_nodes=0; //keeps tracks of howmany things in tree

        if (t!=null) { //if null returns 0
            i =toarray(t.left, a, i); //inorder t's left subtree and put it in a starting at slot i of a
            a[i++] = t.info; //take whats in the root of the tree and put it in the array after the ints in the left inorder of the tree
            i = toarray(t.right, a, i); //inorder traverses the right subtree and adds those ints to the array
        }
        return num_nodes;
    }


    private static class btNode {
        //The inner class for binary tree nodes
        //used to contain the information of each node, and its left and right pointers
        String info;
        btNode left;
        btNode right;
        int count;

        //default constructor
        private btNode() {
            info="";
            left=null;
            right=null;
            count = 0;
        }

        //alternate constuctor
        private btNode(String s, btNode lt, btNode rt, int ct) {
            info=s;
            left=lt;
            right=rt;
            count = ct;
        }
    }
}

