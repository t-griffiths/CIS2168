
//*********************************************************************
// FILE NAME    : Intcoll1.java
// DESCRIPTION  : This file contains the class Intcoll1.
//*********************************************************************


import java.util.*;

public class Intcoll1
{
    private int[] c;

    /*
     *	The Intcoll1() method initiates a new array "c"
     *	of legnth 500. Also sets the first element in
     *	collection c to 0                           */
    public Intcoll1() {
        c = new int[500+1];
        c[0] = 0;
    }

    /*
     *	This method intiates an array just like the
     *	method above, except this method takes a parameter
     *	i, which sets the size of the array           */
    public Intcoll1(int i) {
        c = new int[i+1];
        //ic3 same as above except itd be i + 1
        c[0] = 0;
    }

    /*
     *	This method starts by checking if the array being copied
     *	already has a copy made of it. If not, it creates a new
     *	object array c of the same size as the length of c[]. It then
     *	runs through the array c copying every integers in that
     *	collection into obj.c[] until c[j] = 0. This makes a complete
     *	copy of the oringal array.                                 */
    public void copy(Intcoll1 obj) {
        if (this != obj){
            c = new int[obj.c.length];
            int j = 0;
            while (obj.c[j] != 0) {
                c[j] = obj.c[j];
                j++;
            }
            c[j] = 0;
        }
    }

    /*
     *	This method takes integer i and checks if that int is inside
     *	of whatever array is calling the method and returns true if so
     *	Runs through array and checks if c[j] equals 0 or i,
     *	If equals i, returns true, if equals 0, the statement
     *	0 = not 0 is false thus returns false.                       */
    public boolean belongs(int i)
    {
        int j = 0;
        while ((c[j] != 0)&&(c[j] != i)){
            j++;
        }
        return (c[j] != 0);
    }

    /* This method inserts a number into the array if it is not already there.
     * Starts by making sure input is greater than 0. Then while loop until
     * either c[j] = 0 or c[j] = i. If while loop breaks becuase c[j] = 0,
     * this means the array isnt big enough to insert a new number so it
     * makes a new array twice the size of original ray and copies it back over
     * to original array.
     * If while loop breaks becuase c[j] = 0, it replaces the 0 with the integer
     * that was inputted and inserts a zero in the slot after it to mark end of array  */
    public void insert(int i) {
        if (i > 0) {
            int j = 0;
            while ((c[j] != 0) && (c[j] != i)) j++;
            if (c[j] == 0) {
                if (j == c.length - 1) {
                    int[]d = new int[2*c.length];
                    // create new array d twice the legnth c[]
                    int k = 0;
                    while (d[k] != 0){
                    //while loop iterates through c[], copying it to d[] until it reaches 0
                        c[k] = d[k]; k++; //wait maybe x++
                    }
                    if (d[k] == 0) {
                        d[k] = d[i];
                        d[k+1] = 0;
                        //sets d[k] (that was previously 0) to input i
                    }
                    c = d;
                }
                c[j] = i; c[j + 1] = 0;
                // if c[j] == 0 , replace the 0 with input i
            }
        }
    }

    /*
     * 	Removes i from array if it is there.
     * 	Starts by making sure i is positive and not 0. Iterates through
     * 	c[j] until c[i] either = 0 or i. If = 0 it will break becuase you cant
     *  omit an number if it isnt there. If = i it replaces c[j] with the
     *  number in the slot after it and replaces all of the following ints
     *  in the collection with the int that occurs one after it.
     *  Eg
     *  A = [1,2,3,4,0]
     *  A.omit(2)
     *  A = [1,3,4,0]                                                   */
    public void omit(int i) {
        if (i>0) {
            int j = 0;
            while ((c[j] != 0)&&(c[j] != i)) {
                j++;
            }
            if (c[j] == i) {
                int k = j+1;
                while (c[k] != 0) k++;
                c[j] = c[k-1]; c[k-1]=0;
            }
        }
    }

    /* Makes new counter 'howmany' and iterates through the array that called
     * the method adding 1 to the count for every int in the collection.
     * Then returns howmany (total size of array)                          */
    public int get_howmany() {
        int j=0, howmany=0;
        while (c[j]!=0) {howmany++; j++;}
        return howmany;
    }

    /* Iterated through the array that called the method printing
     * every integer in collection until it reaches 0           */
    public void print() {
        int j = 0;
        System.out.println();
        while (c[j] != 0) {
            System.out.println(c[j]); j++;
        }
    }

    /*
     *	Checks if the array that called the method contains the same integers
     *  as the array being called in the object of the method. Iterates through
     *  the method array making sure every integer that is in it is also in the obj array
     *  then iterates through the object array making sure that every integer that is in it
     *  is also in the method array. Will keep running as long as both are true until
     *  c[j] = 0                                                                         */
    public boolean equals(Intcoll1 obj) {
        int j = 0; boolean result = true;
        while ((c[j] != 0)&&result) {
            result = obj.belongs(c[j]); j++;
        }
        j = 0;
        while ((obj.c[j] != 0)&&result) {
            result = belongs(obj.c[j]); j++;
        }
        return result;
    }
}




