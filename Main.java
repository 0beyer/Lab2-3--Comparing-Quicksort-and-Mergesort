import java.util.Arrays;
import java.util.Random;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        TestInteger[] arrOrd = newArrOrd();
        TestInteger[] arrRevOrd = newArrRevOrd();

        System.out.println(isSorted(arrRevOrd));

        mergeSort(arrOrd);

        quickSort(arrOrd);
        
        mergeSort(arrRevOrd);

        quickSort(arrRevOrd);
    }

    public static void mergeSort(TestInteger[] arr) {
        Arrays.sort(arr);
        System.out.println("MergeSort Count: " + TestInteger.getCounter());
        System.out.println("Sorted: " + isSorted(arr));
        TestInteger.resetCounter();
    }

    public static void quickSort(TestInteger[] arr) {
        quickSortRecursive(arr, 0, arr.length - 1);
        System.out.println("QuickSort Count: " + TestInteger.getCounter());
        System.out.println("Sorted: " + isSorted(arr));
        TestInteger.resetCounter();
    }

    public static boolean isSorted(TestInteger[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i].compareTo(arr[i + 1]) > 0) {
                return false;
            }
        }
        TestInteger.resetCounter();
        return true;
    }

    public static TestInteger[] newArrOrd() {
        TestInteger[] base = orderedArrayTemp();
        for (int i = 0; i < 10; i++) {
            base = concatenate(base, orderedArrayTemp());
        }
        return base;
    }

    public static TestInteger[] newArrRevOrd() {
        TestInteger[] base = revOrderedArrayTemp();
        for (int i = 0; i < 10; i++) {
            base = concatenate(base, revOrderedArrayTemp());
        }
        return base;
    }

    public static TestInteger[] orderedArrayTemp() {
        TestInteger[] base = new TestInteger[1000];
        populateRan(base, 1000);
        Arrays.sort(base);
        TestInteger.resetCounter();
        return base;
    }
    
    public static TestInteger[] revOrderedArrayTemp() {
        TestInteger[] base = new TestInteger[1000];
        populateRan(base, 1000);
        Arrays.sort(base);
        reverse(base);
        TestInteger.resetCounter();
        return base;
    }

    static void reverse(TestInteger[] a) {
        TestInteger[] b = new TestInteger[1000];
        int j = 1000;
        for (int i = 0; i < 1000; i++) {
            b[j - 1] = a[i];
            j = j - 1;
        }
    }

    public static TestInteger[] populateRan(TestInteger[] arr, int size) {
        Random rand = new Random();
        for (int i = 0; i < size; i++) {
            arr[i] = new TestInteger(rand.nextInt(1_000_000) + 1);
        }
        return arr;
    }

    public static TestInteger[] concatenate(TestInteger[] a, TestInteger[] b) {
        TestInteger[] both = Stream.concat(Arrays.stream(a), Arrays.stream(b)).toArray(TestInteger[]::new);
        TestInteger.resetCounter();
        return both;
    }

    public static void quickSortRecursive(TestInteger[] arr, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(arr, low, high);
            quickSortRecursive(arr, low, pivotIndex - 1);
            quickSortRecursive(arr, pivotIndex + 1, high);
        }
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
