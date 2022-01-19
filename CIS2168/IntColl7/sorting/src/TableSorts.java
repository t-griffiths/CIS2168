import java.util.Random;
public class TableSorts {

    static int icount=0;
    static int mcount=0;
    static int qcount=0;

    public static void main(String[] args){
        mergesorttable(10);
        System.out.println(" ");
        quicksorttable(10);
        System.out.println(" ");
        insertiontable(10);
    }



    //fills arrays of sizes 64, 128, 256, and 512 then sorts them using mergesort
    //then stores the values of amount of comparisons done in array mcountvals[]
    //then finds min max and avg of each respective array size and returns those values
    public static void mergesorttable(int k){
        int[] mcountvals = new int[40];
        int j;
        int i = 0;
        Random gen = new Random();
        int[] a = new int[64];
        int[] b = new int[128];
        int[] c = new int[256];
        int[] d = new int[512];

        for (j = 0; j < 10; j++) {
            for (i = 0; i < a.length; i++) {
                a[i] = gen.nextInt(5000) + 1;
                //make clones of array to apply other methods to unsorted array
            }
            mergesort(a, 0, a.length -1);
            mcountvals[j] = mcount;
            mcount = 0;
        }

        for (j = 10; j < 20; j++) {
            for (i = 0; i < b.length; i++) {
                b[i] = gen.nextInt(5000) + 1;
            }
            mergesort(b, 0, b.length -1);
            mcountvals[j] = mcount;
            mcount = 0;
        }

        for (j = 20; j < 30; j++) {
            for (i = 0; i < c.length; i++) {
                c[i] = gen.nextInt(5000) + 1;
            }
            mergesort(c, 0, c.length -1);
            mcountvals[j] = mcount;
            mcount = 0;
        }

        for (j = 30; j < 40; j++) {
            for (i = 0; i < d.length; i++) {
                d[i] = gen.nextInt(5000) + 1;
            }
            mergesort(d, 0, d.length -1);
            mcountvals[j] = mcount;
            mcount = 0;
        }

        //icount max min and avg
        int max = mcountvals[0];
        int min = mcountvals[0];
        int sum = 0;
        for (i = 0; i < 10; i++){
            sum += mcountvals[i];
            if (mcountvals[i] > max){
                max = mcountvals[i];
            }
            if (mcountvals[i] < min){
                min = mcountvals[i];
            }
        }
        int avg = (sum/mcountvals.length);
        System.out.println("MergeSort Vals at size 64 - Minimum: " + min + " Maximum: " + max + " Average: " + avg);

        max = mcountvals[10];
        min = mcountvals[10];
        sum = 0;
        for (i = 10; i < 20; i++){
            sum += mcountvals[i];
            if (mcountvals[i] > max){
                max = mcountvals[i];
            }
            if (mcountvals[i] < min){
                min = mcountvals[i];
            }
        }
        avg = (sum/10);
        System.out.println("MergeSort Vals at size 128 - Minimum: " + min + " Maximum: " + max + " Average: " + avg);

        max = mcountvals[20];
        min = mcountvals[20];
        sum = 0;
        for (i = 20; i < 30; i++){
            sum += mcountvals[i];
            if (mcountvals[i] > max){
                max = mcountvals[i];
            }
            if (mcountvals[i] < min){
                min = mcountvals[i];
            }
        }
        avg = (sum/10);
        System.out.println("MergeSort Vals at size 256 - Minimum: " + min + " Maximum: " + max + " Average: " + avg);

        max = mcountvals[30];
        min = mcountvals[30];
        sum = 0;
        for (i = 30; i < 40; i++){
            sum += mcountvals[i];
            if (mcountvals[i] > max){
                max = mcountvals[i];
            }
            if (mcountvals[i] < min){
                min = mcountvals[i];
            }
        }
        avg = (sum/10);
        System.out.println("MergeSort Vals at size 512 - Minimum: " + min + " Maximum: " + max + " Average: " + avg);
    }

    //fills arrays of sizes 64, 128, 256, and 512 then sorts them using quicksort
    //then stores the values of amount of comparisons done in array qcountvals[]
    //then finds min max and avg of each respective array size and returns those values
    public static void quicksorttable(int k){
        int[] qcountvals = new int[40];
        int j;
        int i = 0;
        Random gen = new Random();
        int[] a = new int[64];
        int[] b = new int[128];
        int[] c = new int[256];
        int[] d = new int[512];

        for (j = 0; j < 10; j++) {
            for (i = 0; i < a.length; i++) {
                a[i] = gen.nextInt(5000) + 1;
                //make clones of array to apply other methods to unsorted array
            }
            quicksort(a, 0, a.length -1);
            qcountvals[j] = qcount;
            qcount = 0;
        }

        for (j = 10; j < 20; j++) {
            for (i = 0; i < b.length; i++) {
                b[i] = gen.nextInt(5000) + 1;
            }
            quicksort(b, 0, b.length -1);
            qcountvals[j] = qcount;
            qcount = 0;
        }

        for (j = 20; j < 30; j++) {
            for (i = 0; i < c.length; i++) {
                c[i] = gen.nextInt(5000) + 1;
            }
            quicksort(c, 0, c.length -1);
            qcountvals[j] = qcount;
            qcount = 0;
        }

        for (j = 30; j < 40; j++) {
            for (i = 0; i < d.length; i++) {
                d[i] = gen.nextInt(5000) + 1;
            }
            quicksort(d, 0, d.length -1);
            qcountvals[j] = qcount;
            qcount = 0;
        }

        //icount max min and avg
        int max = qcountvals[0];
        int min = qcountvals[0];
        int sum = 0;
        for (i = 0; i < 10; i++){
            sum += qcountvals[i];
            if (qcountvals[i] > max){
                max = qcountvals[i];
            }
            if (qcountvals[i] < min){
                min = qcountvals[i];
            }
        }
        int avg = (sum/qcountvals.length);
        System.out.println("QuickSort Vals at size 64 - Minimum: " + min + " Maximum: " + max + " Average: " + avg);

        max = qcountvals[10];
        min = qcountvals[10];
        sum = 0;
        for (i = 10; i < 20; i++){
            sum += qcountvals[i];
            if (qcountvals[i] > max){
                max = qcountvals[i];
            }
            if (qcountvals[i] < min){
                min = qcountvals[i];
            }
        }
        avg = (sum/10);
        System.out.println("QuickSort Vals at size 128 - Minimum: " + min + " Maximum: " + max + " Average: " + avg);

        max = qcountvals[20];
        min = qcountvals[20];
        sum = 0;
        for (i = 20; i < 30; i++){
            sum += qcountvals[i];
            if (qcountvals[i] > max){
                max = qcountvals[i];
            }
            if (qcountvals[i] < min){
                min = qcountvals[i];
            }
        }
        avg = (sum/10);
        System.out.println("QuickSort Vals at size 256 - Minimum: " + min + " Maximum: " + max + " Average: " + avg);

        max = qcountvals[30];
        min = qcountvals[30];
        sum = 0;
        for (i = 30; i < 40; i++){
            sum += qcountvals[i];
            if (qcountvals[i] > max){
                max = qcountvals[i];
            }
            if (qcountvals[i] < min){
                min = qcountvals[i];
            }
        }
        avg = (sum/10);
        System.out.println("QuickSort Vals at size 512 - Minimum: " + min + " Maximum: " + max + " Average: " + avg);
    }

    //fills arrays of sizes 64, 128, 256, and 512 then sorts them using insertionsort
    //then stores the values of amount of comparisons done in array icountvals[]
    //then finds min max and avg of each respective array size and returns those values
    public static void insertiontable(int k){
        int[] icountvals = new int[40];
        int j;
        int i = 0;
        Random gen = new Random();
        int[] a = new int[64];
        int[] b = new int[128];
        int[] c = new int[256];
        int[] d = new int[512];

        for (j = 0; j < 10; j++) {
            for (i = 0; i < a.length; i++) {
                a[i] = gen.nextInt(5000) + 1;
                //make clones of array to apply other methods to unsorted array
            }
            insertionsort(a);
            icountvals[j] = icount;
            icount = 0;
        }

        for (j = 10; j < 20; j++) {
            for (i = 0; i < b.length; i++) {
                b[i] = gen.nextInt(5000) + 1;
            }
            insertionsort(b);
            icountvals[j] = icount;
            icount = 0;
        }

        for (j = 20; j < 30; j++) {
            for (i = 0; i < c.length; i++) {
                c[i] = gen.nextInt(5000) + 1;
            }
            insertionsort(c);
            icountvals[j] = icount;
            icount = 0;
        }

        for (j = 30; j < 40; j++) {
            for (i = 0; i < d.length; i++) {
                d[i] = gen.nextInt(5000) + 1;
            }
            insertionsort(d);
            icountvals[j] = icount;
            icount = 0;
        }

        int max = icountvals[0];
        int min = icountvals[0];
        int sum = 0;
        for (i = 0; i < 10; i++){
            sum += icountvals[i];
            if (icountvals[i] > max){
                max = icountvals[i];
            }
            if (icountvals[i] < min){
                min = icountvals[i];
            }
        }
        int avg = (sum/10);
        System.out.println("InsertionSort Vals at size 64 - Minimum: " + min + " Maximum: " + max + " Average: " + avg);

        max = icountvals[10];
        min = icountvals[10];
        sum = 0;
        for (i = 10; i < 20; i++){
            sum += icountvals[i];
            if (icountvals[i] > max){
                max = icountvals[i];
            }
            if (icountvals[i] < min){
                min = icountvals[i];
            }
        }
        avg = (sum/10);
        System.out.println("InsertionSort Vals at size 128 - Minimum: " + min + " Maximum: " + max + " Average: " + avg);

        max = icountvals[20];
        min = icountvals[20];
        sum = 0;
        for (i = 20; i < 30; i++){
            sum += icountvals[i];
            if (icountvals[i] > max){
                max = icountvals[i];
            }
            if (icountvals[i] < min){
                min = icountvals[i];
            }
        }
        avg = (sum/10);
        System.out.println("InsertionSort Vals at size 256 - Minimum: " + min + " Maximum: " + max + " Average: " + avg);

        max = icountvals[30];
        min = icountvals[30];
        sum = 0;
        for (i = 30; i < 40; i++){
            sum += icountvals[i];
            if (icountvals[i] > max){
                max = icountvals[i];
            }
            if (icountvals[i] < min){
                min = icountvals[i];
            }
        }
        avg = (sum/10);
        System.out.println("InsertionSort Vals at size 512 - Minimum: " + min + " Maximum: " + max + " Average: " + avg);

    }



    //insertion sort method see InsertionSortTest.java
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

    //mergesort method see MergeSortTest.java
    public static void mergesort(int[] a, int top, int bottom)
    {
        if (top!=bottom) {
            int middle=(top+bottom)/2;
            mergesort(a, top, middle);
            mergesort(a, middle+1, bottom);
            merge(a, top, bottom);
        }
    }

    //merge method see MergeSortTest.java
    public static void merge(int[] a, int top, int bottom)
    {
        int t=top; int middle=(top+bottom)/2; int b=middle+1; int i=0;
        int[] s=new int[bottom-top+1];
        while ((t<=middle)&&(b<=bottom))
        {
            if (a[t]<a[b])
            {
                s[i]=a[t]; t++;
            }
            else
            {
                s[i]=a[b]; b++;
            }
            i++;
            mcount++; //keeps track of how many comparisons mergesort is doing
            //use m
        }
        int last=middle;
        if (b<=bottom) {t=b; last=bottom;}
        while (t<=last)
        {
            s[i]=a[t]; t++; i++; mcount++;
        }
        for (i=0; i<s.length; i++) {a[i+top]=s[i]; mcount++;}
    }

    //partition method see QuickSortTest.java
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
        int temp = a[lower + 1];
        a[lower + 1] = a[j];
        a[j] = temp;
        return lower + 1;
    }

    //quicksort method see QuickSortTest.java
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
