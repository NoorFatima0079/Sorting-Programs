import java.util.Random;

public class BubbleSort {
    static final int N = 1000;

    static void sort(int[] a) {
        for (int i = 0; i < N - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < N - i - 1; j++) {
                if (a[j] > a[j + 1]) {
                    int t = a[j]; a[j] = a[j + 1]; a[j + 1] = t;
                    swapped = true;
                }
            }
            if (!swapped) break;
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
        System.out.println("Bubble Sort:");
        for (int t = 0; t < 3; t++) {
            fill(a, t);
            long start = System.nanoTime();
            sort(a);
            long end = System.nanoTime();
            System.out.println(cases[t] + " case: " + (end - start) / 1000 + " microseconds");
        }
        System.out.print("First 10 sorted: ");
        for (int i = 0; i < 10; i++) System.out.print(a[i] + " ");
        System.out.println();
    }
}