import java.util.Random;

public class InsertionSort {
    static final int N = 1000;

    static void sort(int[] a) {
        for (int i = 1; i < N; i++) {
            int key = a[i], j = i - 1;
            while (j >= 0 && a[j] > key) {
                a[j + 1] = a[j];
                j--;
            }
            a[j + 1] = key;
        }
    }

    static void fill(int[] a, int type) {
    Random r = new Random();
    for (int i = 0; i < N; i++) {
        switch (type) {
            case 0:
                a[i] = i + 1;
                break;
            case 1:
                a[i] = r.nextInt(1000) + 1;
                break;
            default:
                a[i] = N - i;
        }
    }
}

    public static void main(String[] args) {
        String[] cases = {"Best", "Average", "Worst"};
        int[] a = new int[N];
        for (int t = 0; t < 3; t++) {
            fill(a, t);
            long start = System.nanoTime();
            sort(a);
            long end = System.nanoTime();
            long ns = end - start;
            System.out.println("********** Insertion Sort Completed! (" + cases[t] + " case) **********");
            System.out.println("Total Elements: " + N);
            System.out.println("Execution time in NanoSeconds: " + ns);
            System.out.println("Execution time in MilliSeconds: " + (ns / 1000000.0));
            System.out.println("******** Sorted Array *******");
            for (int i = 0; i < N; i++) System.out.print(a[i] + " ");
            System.out.println("\n");
        }
    }
}
