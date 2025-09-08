import java.util.Arrays;
import java.util.Random;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        int size = 3;

        mergeSort(newArrOrd(size));
        quickSort(newArrOrd(size));
        quickSortRanPiv(newArrOrd(size));
        
        // mergeSort(newArrRevOrd(size));
        // quickSort(newArrRevOrd(size));

        // quickSort(populateRan(new TestInteger[10*size]));
        // mergeSort(populateRan(new TestInteger[10*size]));

        // mergeSort(newSortedArr(10*size););
        // quickSort(newSortedArr(10*size););
        // 

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

    public static void quickSortRanPiv(TestInteger[] arr) {
        quickSortRecursiveRanPiv(arr, 0, arr.length - 1);
        System.out.println("QuickSort Count: " + TestInteger.getCounter());
        System.out.println("Sorted: " + isSorted(arr));
        TestInteger.resetCounter();
    }

    public static void quickSortMedPiv(TestInteger[] arr) {
        quickSortRecursiveRanPiv(arr, 0, arr.length - 1);
        System.out.println("QuickSort Count: " + TestInteger.getCounter());
        System.out.println("Sorted: " + isSorted(arr));
        TestInteger.resetCounter();
    }

    public static void quickSortInsSort(TestInteger[] arr) {
        quickSortRecursiveRanPiv(arr, 0, arr.length - 1);
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
        return true;
    }

    public static void printArr(TestInteger[] a) {
        for(int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }

    public static TestInteger[] newArrOrd(int size) {
        TestInteger[] base = orderedArrayTemp(size);
        for (int i = 0; i < 9; i++) {
            base = concatenate(base, orderedArrayTemp(size));
        }
        return base;
    }

    public static TestInteger[] newSortedArr(int size) {
        TestInteger[] base = new TestInteger[size];
        populateRan(base);
        Arrays.sort(base);
        TestInteger.resetCounter();
        return base;
    }

    public static TestInteger[] newArrRevOrd(int size) {
        TestInteger[] base = revOrderedArrayTemp(size);
        for (int i = 0; i < 9; i++) {
            base = concatenate(base, revOrderedArrayTemp(size));
        }
        return base;
    }

    public static TestInteger[] orderedArrayTemp(int size) {
        TestInteger[] base = new TestInteger[size];
        populateRan(base);
        Arrays.sort(base);
        TestInteger.resetCounter();
        return base;
    }
    
    public static TestInteger[] revOrderedArrayTemp(int size) {
        TestInteger[] base = new TestInteger[size];
        populateRan(base);
        Arrays.sort(base);
        base = reverse(base);
        TestInteger.resetCounter();
        return base;
    }

    static TestInteger[] reverse(TestInteger[] a) {
        TestInteger[] b = new TestInteger[a.length];
        int j = a.length;
        for (int i = 0; i < a.length; i++) {
            b[j - 1] = a[i];
            j = j - 1;
        }
        return b;
    }

    public static TestInteger[] populateRan(TestInteger[] arr) {
        Random rand = new Random();
        for (int i = 0; i < arr.length; i++) {
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

    public static void quickSortRecursiveRanPiv(TestInteger[] arr, int low, int high) {
        if (low < high) {
            int pivotIndex = partitionRan(arr, low, high);
            quickSortRecursiveRanPiv(arr, low, pivotIndex - 1);
            quickSortRecursiveRanPiv(arr, pivotIndex + 1, high);
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

    private static int partitionRan(TestInteger[] arr, int low, int high) {
        Random rand = new Random();
        TestInteger pivot = arr[rand.nextInt(arr.length - 1)];
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
