//GIVEN SET OF NUMBERS, FIND ALL POSTIVE NUMBERS WIHTOUT REPETED NUMBERES

//**********************************************************
//FILE: NAME   : intcoll6client.java
//DESCRIPTION  : This is a client of class Intcoll6.
//**********************************************************


import java.util.*;

public class intcoll6client
{
    public static final int SENTINEL = 0;

    public static void main(String[] args)
    {
        int value; Scanner keyboard=new Scanner(System.in);
        intcoll6 P=new intcoll6(), N=new intcoll6(), L= new intcoll6();

        System.out.println("Enter an integer to be inserted or 0 to quit:");
        value=keyboard.nextInt();
        while(value != SENTINEL)
        {
            if (value > 0) {P.insert(value); L.insert(value);}
            else {N.insert(-value); L.omit(-value);}
            System.out.println("Enter next integer to be inserted or 0 to quit:");
            value=keyboard.nextInt();
        }
        System.out.println("\nThe values in collection P are:");
        P.print();
        System.out.println("\nThe values in collection N are:");
        N.print();
        System.out.println("\nThe values in collection L are:");
        L.print();
        if (P.equals(N)) System.out.println("\nP and N are equal.");
        else System.out.println("\nP and N are NOT equal.");
        intcoll6 A=new intcoll6(); A.copy(L);
        System.out.println("\nThe values in the copy of L are:\n");
        A.print();

    }
}

