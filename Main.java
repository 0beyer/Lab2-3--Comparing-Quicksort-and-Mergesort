import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        TestInteger[] arrMerge = populateOrd();
        TestInteger[] arrQuick = populateOrd();

        System.out.println("MergeSort:");
        mergeSort(arrMerge);

        System.out.println("QuickSort:");
        quickSort(arrQuick, 0, arrQuick.length - 1);
        printCount(arrQuick);

        // TestInteger[] sortedSeqs = populateOrd();
        // System.out.println("First sorted sequence:");
        // printCount(sortedSeqs[0]);

        // TestInteger[] reverseSortedSeqs = populateRevOrd(10, 1000);
        // System.out.println("First reverse-sorted sequence:");
        // printCount(reverseSortedSeqs[0]);
    }

    public static void mergeSort(TestInteger[] arr) {
        Arrays.sort(arr);
        printCount(arr);
    }

    // public static Integer returnCount(TestInteger[] arr) {
    //     int n = 0;
    //     for (int i = 0; i < arr.length - 1; i++) {
    //         n = arr[i].counter + n;
    //     }
    //     return n;
    // }

    public static boolean isSorted(TestInteger[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i].compareTo(arr[i + 1]) > 0) {
                return false;
            }
        }
        return true;
    }

    public static void printCount(TestInteger[] arr) {
        System.out.println(" ");
        System.out.println(" ");
        System.out.println("Counts: " + TestInteger.getCounter());
    }

    public static TestInteger[] populateRevOrd(int size) {
        TestInteger[] ArrOrd = new TestInteger[size];
        for (int i = 0; i < size; i++) {
            ArrOrd[i] = new TestInteger(i);
        }
        return ArrOrd;
    }

    public static TestInteger[] populateOrd() {
        TestInteger[] temp = new TestInteger[1000];
        TestInteger[] arr = new TestInteger[10000];

        for (int i = 0; i < 10; i++) {
            temp = populateRan(temp, 1000);
            Arrays.sort(temp);
            System.arraycopy(temp, 0, arr, 1000, 10000);
        }
        return arr;
    }

    public static TestInteger[] populateRan(TestInteger[] arr, int size) {
        Random rand = new Random();
        TestInteger[] ArrRan = new TestInteger[size];
        for (int i = 0; i < size; i++) {
            ArrRan[i] = new TestInteger(rand.nextInt(1_000_000) + 1);
        System.out.println(" ");
        }
        return ArrRan;
    }

    // public static TestInteger[][] populateOrd(int numSeq, int length) {
    //     Random rand = new Random();
    //     TestInteger[][] sequences = new TestInteger[numSeq][length];
    //     for (int i = 0; i < numSeq; i++) {
    //         int start = rand.nextInt(1000000 - length + 1) + 1;
    //         for (int j = 0; j < length; j++) {
    //             sequences[i][j] = new TestInteger(start + j);
    //         }
    //     }
    //     return sequences;
    // }

    // public static TestInteger[][] populateRevOrd(int numSeq, int length) {
    //     Random rand = new Random();
    //     TestInteger[][] sequences = new TestInteger[numSeq][length];
    //     for (int i = 0; i < numSeq; i++) {
    //         int start = rand.nextInt(1000000 - length + 1) + length;
    //         for (int j = 0; j < length; j++) {
    //             sequences[i][j] = new TestInteger(start - j);
    //         }
    //     }
    //     return sequences;
    // }

    public static void quickSort(TestInteger[] arr, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(arr, low, high);
            quickSort(arr, low, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, high);
        }
        printCount(arr);
    }

    private static int partition(TestInteger[] arr, int low, int high) {
        TestInteger pivot = arr[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j].compareTo(pivot) <= 0) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return i + 1;
    }

    private static void swap(TestInteger[] arr, int i, int j) {
        TestInteger temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
