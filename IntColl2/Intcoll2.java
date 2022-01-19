//*********************************************************************
// FILE NAME    : Intcoll2.java
// DESCRIPTION  : This file contains the class Intcoll2.
//*********************************************************************

import java.util.*;

public class Intcoll2 {
    private int[] c;
    private int howmany;

    /*	Intcoll2() method initiates a new array "c"
     *  of length 500.                           */
    public Intcoll2() {
        c = new int[500];
        howmany = 0;
    }


    //Initiates a new array c of size input i
    public Intcoll2(int i) {
        c = new int[i];
        howmany = 0;
    }

    /*	After checking that a copy of this array doesn't already exist, this method
     *  creates a new array c of the size the array it is copying. It then iterates
     *  through the array that called the method copying every item in the collection
     *  to the object array */

    //i have no idea why this wont work
    public void copy(Intcoll2 obj) {
        if (this != obj) {
            c = new int[obj.c.length];
            int j = 0;
            while (j < howmany) {
                c[j] = obj.c[j];
                j++;
            }
        }
    }

    /*  This method takes integer i and checks if that int is inside
     *	of the array that is calling the method. Then iterates through
     *  the array checking each integer to see if it is equal to i
     *  If so, it returns true. If j = howmany then i isnt in the array
     *  It returns howmany != howmany which is obviously false.     */
    public boolean belongs(int i) {
        int j = 0;
        while ((j != howmany)&&(c[j] != i)) {
            j++;
        }
        return (j != howmany);
    }


    /* While j isnt howmany and j isnt i continue to iterate through array
     * if breaks because j = to howmany, means that i isnt already in array
     * If breaks because j = i it then confirms that j is equal to the length
     * of the array and sets c[j] = to input and increases howmany count   */
    public void insert(int i) {
        if (i > 0) {
            int j = 0;
            while ((j != howmany) && (c[j] != i))
                j++;
                if (j == howmany){
                    c[j] = i;
                    howmany++;
                }
        }
    }

    /*	Removes i from array if it is there.
     * 	Iterates through j until either j = howmany or c[j] = input
     *  Breaks if j=howmany. If c[j]=i it makes a new int k one larger
     *  than j. Replaces c[j] with c[j+1] until array is fully copied */
    public void omit(int i) {
        if (i>0) {
            int j = 0;
            while ((j != howmany)&&(c[j] != i)) {
                j++;
            }
            if (c[j] == i) {
                int k = j+1;
                while (k != howmany) {
                    c[j] = c[k];
                    k++;
                }
                howmany--;
            }
        }
    }

    /*	Since howmany is being recorded in intcoll2, this method
     *  simply returns howmany (the size of the array)         */
    public int get_howmany() {
        return howmany;
    }


    /*  Iterates through the array that called the method,
     *  printing each int of the array on a seperate line
     *  until every lines been printed                  */
    public void print() {
        int j = 0;
        System.out.println();
        while (j != howmany) {
            System.out.println(c[j]); j++;
        }
    }


    /*  Checks if the array calling the method contains the same integers
     *  as the object array. Two boolean statements set to true for each
     *  array, while both are true and j isnt howmany, j iterates through
     *  the method array checking that each int is also in the object array
     *  While the object array checks that each int is also in the method array */
    public boolean equals(Intcoll2 obj) {
        int j = 0;
        boolean result = true;
        boolean objresult = true;
        while ((j !=howmany) && result && objresult) {
        //uses belongs method to check if each iteration of j is in c, if so returns true
        //breaks once either result turns false or reaches end of array
            result = obj.belongs(c[j]);
            objresult = belongs(obj.c[j]);
            j++;
            ///result stays true every time j is in c, turns false if not
        }
        return result;
    }
}