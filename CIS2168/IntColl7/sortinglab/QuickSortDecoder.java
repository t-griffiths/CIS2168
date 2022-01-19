//This program requires two command line parameters f - the "encoded" file
//and fkey - the dat file with the "key" to decoding f. Both are binary files.
//It ouputs the "decoded" version of f.
import java.io.*;

//every one works except this one
public class QuickSortDecoder
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
        quicksort(array, 1, n);
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

    public static int partition(entry[] a, int i, int j){
        int pivot = a[j].key;
        int lower = i - 1; //contains the slot of the predecessor of i

        for (int k = i; k < j; k++){
            if (a[k].key <= pivot){ //if spot before i is less than pivot val switch i and lower
                lower++; //make lower one bigger
                //switch spot of new lower and k
                entry temp = a[lower];
                a[lower] = a[k];
                a[k] = temp;
            }
        }
        entry temp = a[lower + 1];
        a[lower + 1] = a[j];
        a[j] = temp;
        return lower + 1;
    }

    //taken from quicksort.doc on canvas
    // Sorts the array data between positions indexed by i and j in descending order.
    public static void quicksort(entry[] a, int i, int j) { //takes parameters of which array your working on, the slot that you start at i, and slot where it ends j
        int p;
        if (i < j) { //if i isnt less than j that means i is the only int in the array
            p = partition(a, i, j); //everything above slot p is greater than or equal to what's in slot p, and everything under slot p is less than or equal to what's in slot p
            quicksort(a, i, p - 1); //sorts everything above slot p
            quicksort(a, p + 1, j); //sorts everything below slot p
        }
    }
}
