
//*********************************************************************
// FILE NAME    : Intcoll3.java
// DESCRIPTION  : This file contains the class Intcoll3.
//*********************************************************************

import java.util.*;

public class Intcoll3 {
    private boolean[] c;
    private int howmany;

    /*  The Intcoll1() method initiates a new array "c"
     *	of legnth 500. Sets every boolean in the array to false   */
    public Intcoll3() {
        c = new boolean[500+1];
        int j = 0;
        while (j < c.length){
            c[j] = false;
            j++;
        }
        howmany = 0;
    }



    /*  This method intiates an array just like the
     *	method above, except this method takes a parameter
     *	i, which sets the size of the array               */
    public Intcoll3(int i) {
        c = new boolean[i+1];
        int j = 0;
        while (j < c.length){
        c[j] = false;
        j++;
        }
        howmany = 0;
    }

    /*  This method starts by checking if the array being copied
     *	already has a copy made of it. If not, it creates a new
     *	arrray "obj.c" the same size as the length of c[]. It then
     *	runs through the array c copying every integers in that
     *	collection into obj.c[] until j is the same size as array.
     *  This makes a complete copy of the oringal array.       */

    //doesnt really work :/
    public void copy(Intcoll3 obj) {
        if (this != obj) {
            c = new boolean[obj.c.length];
            int j = 0;
            while (j < howmany) {
                c[j] = obj.c[j];
                j++;
            }
        }
    }

    /* Checks if inputted integer is true at that slot of the array
     * returns c[i] = true, if false returns false                */
    public boolean belongs(int i) {
        if (c[i] == true){
            return true;
        }
        return false;
    }

    /* If c[input] is false, makes it true     */
    public void insert(int i) {
        if (i > 0) {
            if (c[i] == false) {
                c[i] = true;
                howmany++;
            }
        }
    }




    /* If c[input] is true, this method makes it false     */
    public void omit(int i) {
            if (i > 0 && i < howmany && c[i] == true){
                    c[i] = false;
                  //  howmany--;
                  //doesnt work when i update howmany i have no idea why
            }
        }

    /*  Since howmany is being updated in the insert method every
     *  time a slot in the collection is true, this simply has to
     *  return howmany                                          */
    public int get_howmany() {
        return howmany;
    }


    /* Iterates through array and prints every spot in the collection that is true   */
    public void print() {
        int j = 1;
        while (j <= howmany) {
            if (c[j] == true){
                System.out.println(j);
            }
            j++;
        }
    }

    /*	Checks if the array calling the method has the same amount of truth value
     *  as the array in the object of the method                               */
    public boolean equals(Intcoll3 obj) {
        int i = 0;
        boolean result = true;
        while ((i <= howmany) && result) {
            if (this.belongs(i) == obj.belongs(i)){
                result = true;
                i++;
            }
        }
        return result;
    }
}



