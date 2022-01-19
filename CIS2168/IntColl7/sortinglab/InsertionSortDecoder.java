//This program requires two command line parameters f - the "encoded" file
//and fkey - the dat file with the "key" to decoding f. Both are binary files.
//It ouputs the "decoded" version of f.
import java.io.*;
import java.util.*;

public class InsertionSortDecoder
{
    public static void main(String[] args)
    {
        int i, n=1; entry[] array = new entry[1000000];
        for (int h=1; h<1000000; h++) array[h]=new entry();
        try
        {
            DataInputStream ins=new DataInputStream(new FileInputStream(args[0]));
            DataInputStream inskey=new DataInputStream(new FileInputStream(args[1]));
            try
            {
                while (true)
                {
                    array[n].key=inskey.readInt();;
                    array[n].b=ins.readByte();
                    n++;
                }
            }
            catch(EOFException e)
            {
                System.out.println("Done reading file.");
            }
            ins.close(); inskey.close();
        }
        catch(FileNotFoundException e)
        {
            System.out.println("Cannot find file.");
        }
        catch(IOException e)
        {
            System.out.println("Input problem with file.");
        }
        n--; System.out.println("n is "+n);
        insertionsort(array);
        try
        {
            DataOutputStream outs=new DataOutputStream(new FileOutputStream("decoded"+args[0]));
            for (i=1; i<=n; i++) outs.writeByte(array[i].b);
            outs.close();
            System.out.println("The output file is "+"decoded"+args[0]);
        }
        catch(FileNotFoundException e)
        {
            System.out.println("Cannot find file.");
        }
        catch(IOException e)
        {
            System.out.println("Input problem with file.");
        }
    }

    public static void insertionsort(entry[] a){
        for(int i = 1; i < a.length; i++){
            int current = a[i].key;
            int j = i - 1;

            //while the spot before i isnt negative and the value
            //of the spot before i is greater than the value of i,
            while (j >= 0 && a[j].key > current){
                a[j+1] = a[j]; //move the val of slot i to the slot before it
                j = j - 1; //make j the slot before itself
            }
            a[j+1].key = current; //set the current slot we're looking at to slot i
        }
    }
}
