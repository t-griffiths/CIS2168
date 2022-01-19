import java.util.*;

public class QuickSortTest {
    static int numcalls = 0;
    static int qcount = 0;
    static int m = 0;


    public static void main(String[] args) {
        Random gen = new Random();
        int[] a = new int[32]; //dealing with array a of length 32
        //uses random class to fill array a with 32 random ints between 1-5000
        int i;
        for (i = 0; i < a.length; i++) a[i] = gen.nextInt(5000) + 1;
        System.out.println("Initial array:");
        for (i = 0; i < a.length; i++) System.out.println(a[i] + " ");
        System.out.println();
        quicksort(a, 0, a.length - 1); //calls quicksort to sort the array
        System.out.println("Sorted array:");
        for (i = 0; i < a.length; i++) System.out.println(a[i] + " ");
        System.out.println("Done!");
        System.out.println(" numcalls " + numcalls);
        System.out.println(" count " + qcount + " m " + m); //m tells us how many comparisons

        int[] b = {5,8,1,5,7,3,9,1};
        partition(b,0,b.length -1);
    }

    // Rearranges the entries in the array between positions indexed by i and j and returns
    // an array index which guarantees that all entries above it are larger than the entry
    // it indexes, and all entries below it are smaller.

    //uses the last element in array as pivot. checks each element and swaps it before
    //the pivot if the val is < pivot, or swaps it after pivot if val > pivot
    public static int partition(int a[], int i, int j){
        int pivot = a[j];
        int lower = i - 1; //contains the slot of the predecessor of i

        for (int k = i; k < j; k++){
            if (a[k] <= pivot ){ //if spot before i is less than pivot val switch i and lower
                qcount++; //^ comparison
                lower++; //make lower one bigger
                //switch spot of new lower and k
                int temp = a[lower];
                a[lower] = a[k];
                a[k] = temp;
            }
        }
        //switches spots of i and j and returns i + 1 (the pivot point)
        int temp = a[lower + 1];
        a[lower + 1] = a[j];
        a[j] = temp;
        return lower + 1;
    }

    //taken from quicksort.doc on canvas
    //Sorts the array data between positions indexed by i and j in descending order.
    public static void quicksort(int[] a, int i, int j) { //takes parameters of which array your working on, the slot that you start at i, and slot where it ends j
        int p;
        if (i < j) { //if i isnt less than j that means i is the only int in the array
            qcount++; //if statement is comparison
            p = partition(a, i, j); //everything above slot p is greater than or equal to what's in slot p, and everything under slot p is less than or equal to what's in slot p
            quicksort(a, i, p - 1); //sorts everything above slot p
            quicksort(a, p + 1, j); //sorts everything below slot p
        }
    }

}
