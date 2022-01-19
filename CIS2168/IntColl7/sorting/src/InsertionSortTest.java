import java.util.*;

public class InsertionSortTest {
    static int numcalls=0;
    static int icount=0;
    static int m=0;

    public static void main(String[] args)
    {
        Random gen=new Random(); int[] a=new int[32]; //dealing with array a of length 32
        //uses random class to fill array a with 32 random ints between 1-5000
        int i; for (i=0; i<a.length; i++) a[i]=gen.nextInt(5000)+1;
        System.out.println("Initial array:");
        for (i=0; i<a.length; i++) System.out.println(a[i] + " ");
        System.out.println();
        insertionsort(a); //calls mergesort to sort the array
        System.out.println("Sorted array:");
        for (i=0; i<a.length; i++) System.out.println(a[i] + " ");
        System.out.println("Done!");
        System.out.println(" numcalls "+numcalls);
        System.out.println(" count "+icount+" m "+m); //m tells us how many comparisons
    }

    //https://www.geeksforgeeks.org/insertion-sort/
    //Sorts the array data between positions indexed by i and j in descending order.
    public static void insertionsort(int[] a){
        for(int i = 1; i < a.length; i++){
            int current = a[i];
            int j = i - 1;

            //while the spot before i isnt negative and the value
            //of the spot before i is greater than the value of i,
            while (j >= 0 && a[j] > current){
                a[j+1] = a[j]; //move the val of slot i to the slot before it
                icount++; //counts every comparison insertionsort does
                j = j - 1; //make j the slot before itself
            }
            a[j+1] = current; //set the current slot we're looking at to slot i
        }
    }
}

