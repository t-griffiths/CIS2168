//**********************************************************
//FILE: NAME   : intcoll4client.java
//DESCRIPTION  : This is a client of class Intcoll4.
//**********************************************************


import java.util.*;

public class multistringcollclient
{
    public static final String SENTINEL = "###";

    public static void main(String[] args)
    {

        String value; Scanner keyboard=new Scanner(System.in);
        stringcoll P=new stringcoll(), N=new stringcoll(), L= new stringcoll();

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
        stringcoll A=new stringcoll(); A.copy(L);
        System.out.println("\nThe values in the copy of L are:\n");
        A.print();



        multistringcoll B = new multistringcoll();
        B.insert("Hey");
        B.insert("Test");
        B.insert("Dababy");
        B.insert("yeet");
        B.insert("Dababy");
        B.insert("Dababy");
        System.out.println("Tree B:");
        B.print();
        System.out.println("");
        System.out.println("Get count dababy");
        System.out.println(B.get_count("Dababy"));
        System.out.println("");
        System.out.println("Omit Dababy:");
        B.omit("Dababy");
        B.print();
        multistringcoll C = new multistringcoll();
        C.copy(B);
        System.out.println("");
        System.out.println("New copied tree:");
        C.print();
        System.out.println("");
        if (C.equals(B)) {
            System.out.println("Equals works :D");
        }
        if (C.belongs("Dababy")){
            System.out.println("Belongs works :D");
        }
        System.out.println("Distinct total " + B.get_howmany());
        System.out.println("Total total " + B.get_total());
    }
}

