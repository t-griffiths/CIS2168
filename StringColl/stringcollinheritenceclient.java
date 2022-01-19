//**********************************************************
//FILE: NAME   : intcoll4client.java
//DESCRIPTION  : This is a client of class Intcoll4.
//**********************************************************


import java.util.*;

public class stringcollinheritenceclient
{
    public static final String SENTINEL = "###";

    public static void main(String[] args)
    {

        String value; Scanner keyboard=new Scanner(System.in);
        stringcollinheritence P=new stringcollinheritence(), N=new stringcollinheritence(), L= new stringcollinheritence();
        System.out.println("Enter a string to be inserted or ### to quit:");
        value=keyboard.next();
        while(!value.equals(SENTINEL)) {
            if (P.belongs(value)) {P.insert(value); L.insert(value);}
            else {N.insert("-" + value); L.omit(value);}
            System.out.println("Enter next string to be inserted or ### to quit:");
            value=keyboard.next();
        }
        System.out.println("\nThe values in collection P are:");
        P.print();
        System.out.println("\nThe values in collection N are:");
        N.print();
        System.out.println("\nThe values in collection L are:");
        L.print();
        if (P.equals(N)) System.out.println("\nP and N are equal.");
        else System.out.println("\nP and N are NOT equal.");
        stringcollinheritence A=new stringcollinheritence(); A.copy(L);
        System.out.println("\nThe values in the copy of L are:\n");
        A.print();



        stringcollinheritence B = new stringcollinheritence();
        B.insert("Hey");
        B.insert("Test");
        B.insert("Dababy");
        B.insert("yeet");
        System.out.println("Tree B:");
        B.print();
        System.out.println("");
        System.out.println("Omit Dababy:");
        B.omit("Dababy");
        B.print();
        stringcollinheritence C = new stringcollinheritence();
        C.copy(B);
        System.out.println("");
        System.out.println("New copied tree:");
        C.print();
        System.out.println("");
        if (C.equals(B)){
            System.out.println("Equals works :D");
        }
        if (C.belongs("Test")){
            System.out.println("Belongs works :D");
        }
    }
}

