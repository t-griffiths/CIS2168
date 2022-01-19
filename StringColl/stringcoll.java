
public class stringcoll {
    private int howmany; //keeps track of how many ints in collection
    private btNode c;

    //creates a new stringcoll object that represents an empty collection
    public stringcoll() {
        c = null; //null pointer
        howmany = 0;
    }

    //same as above, do nothing i with since we're not worried about capicity
    public stringcoll(int i) {
        c = null;
        howmany = 0;
    }

    //traverses through the tree that called the method copying all of the information from the object tree into it
    private static btNode copytree(btNode t) {
        btNode root=null;
        if (t!=null) { //still copies if null tree
            root=new btNode(); //object that root is pointing to has info member "" "" and null left and right pointers
            root.info=t.info; //sets roots infomember to t's infomember
            root.left=copytree(t.left); //sets roots left pointer to t's left pointer
            root.right=copytree(t.right); //sets roots right pointer to t's left pointer
        }
        return root;
    }

    //makes object tree have same capaicty and objects in collection as the tree calling the method
    public void copy(stringcoll obj) {
        if (this!=obj) { //if a tree isnt already b
            howmany=obj.howmany; //copy b's howmany into a's
            c=copytree(obj.c); //have c point to root to obj's tree.
        }
    }

    //removes i from tree if it is there
    public void omit(String i) {
        btNode p = c; //p points to root of c
        btNode pred = null; //predecessor set to null
        howmany--; //updates howmany
        while(p != null && !p.info.equals(i)){ //finds where i is in tree (took these first few lines from insert method)
            pred=p;
            if (p.info.compareTo(String.valueOf(i)) > 0) {
                p = p.left;
            }
            else{
                p=p.right; //after this while loop p points to the node that contains i as infomember
            }
            //pred points to i's predicessor
        }
        if (p != null){ //if i is in collection
            if ((p.left == null) && (p.right == null)) { //if no successor
                if (pred != null){
                    if (0 < pred.info.compareTo(String.valueOf(i))) {
                        pred.left = null; //if i is less than its predecessors info member (meaning i is in preds left tree), make preds left tree null
                    }
                    else if (0 > pred.info.compareTo(String.valueOf(i))){
                        pred.right = null; //if i is greater than its pred (meaning i is in preds right tree), make preds right tree null
                    }
                }
                else c = null; //if c does not have a predesessor, make c null (case if binary tree with only int in collection being i)
            }

            else if ((p.left != null) && (p.right ==null)){ //if only left successor
                if (pred != null){
                    pred.left = p.left; //make predecessor point to i's left successor
                }
                else c = p.left; //if the predecessor of i is null, make i's successor the root of tree

            }
            else if ((p.left == null) && (p.right !=null)){ //if only right successor
                if (pred != null){
                    pred.right = p.right; //make predecessor point to i's right successor
                }
                else c = p.right; //if the predecessor of i is null, make i's successor the root of tree
            }
            else if ((p.left != null) && (p.right !=null)){ //if left and right successor

                btNode largestleftint = p.left; //this line and while loop iterates through p's left tree finding largest val
                while (largestleftint.right != null){
                    largestleftint = largestleftint.right;
                }
                p.info = largestleftint.info; //sets p's info member to the largest int in p's left subtree
                if ((largestleftint.left != null) && (largestleftint.right == null)){
                    largestleftint = null; //after moving this val to where t was, remove this val (make null)
                }
            }
        }
    }


    //insert i into the collection if its not there and do nothing if it is there
    public void insert(String i) {
        if (i != null) {
            stringcoll.btNode pred=null;
            stringcoll.btNode p=c;
            while ((p!=null)&&(!p.info.equals(i))) { //might have to do !p.info.equals(i)
                //while loop checks if i is in the tree
                pred=p;
                if (p.info.compareTo(i) > 0) {
                    p=p.left;
                }
                else {
                    p = p.right;
                }
            }
            if (p==null) { //if predecessor is null then it is empty tree and sets i to the first spot in the tree
                p=new stringcoll.btNode(i, null, null);
                if (pred!=null) { //traverse through tree
                    if (pred.info.compareTo(i) > 0) { //if predecesor's infomember is greater than i,
                        pred.left=p;  //assign p to the predecessors left pointer
                    }
                    else pred.right=p; //if greater than i then assign p to predesessors right pointer
                }
                else c=p;
            }
            howmany++;
        }
    }

    //returns true if i in collection, false if not
    public boolean belongs(String i) {
        btNode p=c; //p pointing to root of tree
        while ((p!=null)&&(!p.info.equals(i))) { //if p doesnt contain a null pointer, and if p's info memeber isnt i
            if (p.info.compareTo(String.valueOf(i)) > 0) {
                p=p.left; //check if i is less than the node we're at, so we look in left subtree
            }
            else {
                p=p.right; //if i is larger than the node we're at, search in the right tree
            }
        }
        return (p!=null);
    }


    //returns how many strings are in the tree
    public int get_howmany() {
        return howmany;
    }


    //prints tree in inorder order
    public void print() {
        //calls the printtree method
        printtree(c);
    }


    //checks if all the intgers in the objects collection are exactly the same as the integers in the collection calling the method
    public boolean equals(stringcoll obj) {
        int i = 0;
        boolean result = (howmany==obj.howmany);
        if (result)
        {
            String[] a = new String[howmany];
            String[] b = new String[howmany];
            toarray(c, a, 0); //c references the root of the tree calling the method, a is the array we're putting it in to, and 0 is where we're starting at
            toarray(obj.c, b, 0); //obj.c refrences the root of the tree in the object, b is the array we're putting it into, and 0 is where the array starts

            while (result && (i < howmany)){
                result = (a[i].equalsIgnoreCase(b[i]));
                i++;
            }
        }
        return result;
    }

    //prints integers in tree in inorder order
    private static void printtree(btNode t) {
        if (t!=null) {  //if t is not null
            printtree(t.left); //inorder traverse t's left subtree
            System.out.println(t.info);  //visit the root
            printtree(t.right); //inorder traverse t's right subtree
        }
    }

    //puts all the integers in the tree into an array starting at slot i of the array in
    //inorder order, also returns the amount of things in the tree
    private static int toarray(btNode t, String[] a, int i) { //giving this method the binary tree we want to work on, the array that we want to use for the integers, and i is where we want the integers in btnode to start at in the array
      //  int num_nodes=0; //keeps tracks of howmany things in tree

        if (t!=null) { //if null returns 0
            i =toarray(t.left, a, i); //inorder t's left subtree and put it in a starting at slot i of a
            a[i++] = t.info; //take whats in the root of the tree and put it in the array after the ints in the left inorder of the tree
            i =toarray(t.right, a, i); //inorder traverses the right subtree and adds those ints to the array
            //third paramter tells it where to start in array hence ^ because it starts at the slot after the root
        }
        return i;
    }


    private static class btNode {
        //The inner class for binary tree nodes
        //used to contain the information of each node, and its left and right pointers
        String info;
        btNode left;
        btNode right;

        //default constructor
        private btNode() {
            info="";
            left=null;
            right=null;
        }

        //alternate constuctor
        private btNode(String s, btNode lt, btNode rt) {
            info=s;
            left=lt;
            right=rt;
        }

    }
}

