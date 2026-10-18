import java.util.Arrays;
import java.util.Random;

public class MergeSort {
    static final int N = 1000;

    static void sort(int[] a) {
        mergeSort(a, 0, N - 1);
    }

    static void mergeSort(int[] a, int l, int r) {
        if (l >= r) return;
        int m = (l + r) / 2;
        mergeSort(a, l, m);
        mergeSort(a, m + 1, r);
        merge(a, l, m, r);
    }

    static void merge(int[] a, int l, int m, int r) {
        int[] L = Arrays.copyOfRange(a, l, m + 1);
        int[] R = Arrays.copyOfRange(a, m + 1, r + 1);
        int i = 0, j = 0, k = l;
        while (i < L.length && j < R.length)
            a[k++] = (L[i] <= R[j]) ? L[i++] : R[j++];
        while (i < L.length) a[k++] = L[i++];
        while (j < R.length) a[k++] = R[j++];
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
            System.out.println("********** Merge Sort Completed! (" + cases[t] + " case) **********");
            System.out.println("Total Elements: " + N);
            System.out.println("Execution time in NanoSeconds: " + ns);
            System.out.println("Execution time in MilliSeconds: " + (ns / 1000000.0));
            System.out.println("******** Sorted Array *******");
            for (int i = 0; i < N; i++) System.out.print(a[i] + " ");
            System.out.println("\n");
        }
    }
}
