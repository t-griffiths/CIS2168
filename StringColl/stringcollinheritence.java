
public class stringcollinheritence extends multistringcoll {


    private int howmany; //keeps track of how many ints in collection
    private stringcollinheritence.btNode c;

    //default constuctor
    public stringcollinheritence(){
        super();
    }

    //alternate constructor
    public stringcollinheritence(int i){
        super(i);
    }


    public void insert(String i) {
        //insert i into the collection if its not there and do nothing if it is there
        if (i != null) {
            stringcollinheritence.btNode pred=null;
            stringcollinheritence.btNode p=c;
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
                p=new stringcollinheritence.btNode(i, null, null);
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

    private static class btNode {
        //The inner class for binary tree nodes
        //used to contain the information of each node, and its left and right pointers
        String info;
        stringcollinheritence.btNode left;
        stringcollinheritence.btNode right;

        //default constructor
        private btNode() {
            info="";
            left=null;
            right=null;
        }

        //alternate constuctor
        private btNode(String s, stringcollinheritence.btNode lt, stringcollinheritence.btNode rt) {
            info=s;
            left=lt;
            right=rt;
        }

    }

    public void omit(String i) {
        //remove int from tree if it is there
        //first checks if i is in the tree, if so, it deletes it considering if i has a left pointer,
        //a right pointer, no points, or both pointers

        stringcollinheritence.btNode p = c; //p points to root of c
        stringcollinheritence.btNode pred = null; //predecessor set to null
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

                stringcollinheritence.btNode largestleftint = p.left; //this line and while loop iterates through p's left tree finding largest val
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

}
