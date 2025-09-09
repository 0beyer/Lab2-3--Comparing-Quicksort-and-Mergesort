import java.util.Arrays;
import java.util.Random;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        int size = 1000;

        System.out.println(" ");
        System.out.println("newArrOrd Sorting:");
        mergeSort(newArrOrd(size));
        quickSort(newArrOrd(size));
        quickSortRanPiv(newArrOrd(size));
        quickSortMedPiv(newArrOrd(size));
        quickSortInsSort(newArrOrd(size));

        System.out.println(" ");
        System.out.println("newArrRevOrd Sorting:");
        mergeSort(newArrRevOrd(size));
        quickSort(newArrRevOrd(size));
        quickSortRanPiv(newArrRevOrd(size));
        quickSortMedPiv(newArrRevOrd(size));
        quickSortInsSort(newArrRevOrd(size));

        System.out.println(" ");
        System.out.println("newArrRand Sorting:");
        mergeSort(newArrRand(size));
        quickSort(newArrRand(size));
        quickSortRanPiv(newArrRand(size));
        quickSortMedPiv(newArrRand(size));
        quickSortInsSort(newArrRand(size));

        System.out.println(" ");
        System.out.println("newArrSort Sorting:");
        mergeSort(newArrSort(size));
        quickSort(newArrSort(size));
        quickSortRanPiv(newArrSort(size));
        quickSortMedPiv(newArrSort(size));
        quickSortInsSort(newArrSort(size));

    }
        
    // these are variations of the sort function that also prints and resets count
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
        System.out.println("QuickSortRanPiv Count: " + TestInteger.getCounter());
        System.out.println("Sorted: " + isSorted(arr));
        TestInteger.resetCounter();
    }
        
    public static void quickSortMedPiv(TestInteger[] arr) {
        quickSortRecursiveMedPiv(arr, 0, arr.length - 1);
        System.out.println("QuickSortMedPiv Count: " + TestInteger.getCounter());
        System.out.println("Sorted: " + isSorted(arr));
        TestInteger.resetCounter();
    }

    public static void quickSortInsSort(TestInteger[] arr) {
        quickSortRecursiveInsSort(arr, 0, arr.length - 1);
        insertionSort(arr);
        System.out.println("QuickSortInsSort Count: " + TestInteger.getCounter());
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
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }

    // will create an an array with 10 subarrays that are in order
    public static TestInteger[] newArrOrd(int size) {
        TestInteger[] base = orderedArrayTemp(size);
        for (int i = 0; i < 9; i++) {
            base = concatenate(base, orderedArrayTemp(size));
        }
        return base;
    }

    // revered order subarrays
    public static TestInteger[] newArrRevOrd(int size) {
        TestInteger[] base = revOrderedArrayTemp(size);
        for (int i = 0; i < 9; i++) {
            base = concatenate(base, revOrderedArrayTemp(size));
        }
        return base;
    }

    // sorted array
    public static TestInteger[] newArrSort(int size) {
        TestInteger[] base = new TestInteger[10 * size];
        populateRan(base);
        Arrays.sort(base);
        TestInteger.resetCounter();
        return base;
    }

    // random ordered array
    public static TestInteger[] newArrRand(int size) {
        TestInteger[] base = new TestInteger[10 * size];
        populateRan(base);
        return base;
    }

    // temp sorted array made for newArrOrd and newArrRevOrd
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

    // helper function that reverses an array
    static TestInteger[] reverse(TestInteger[] a) {
        TestInteger[] b = new TestInteger[a.length];
        int j = a.length;
        for (int i = 0; i < a.length; i++) {
            b[j - 1] = a[i];
            j = j - 1;
        }
        return b;
    }

    // populates an array with random elements from 0 to a million
    public static TestInteger[] populateRan(TestInteger[] arr) {
        Random rand = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = new TestInteger(rand.nextInt(1_000_000) + 1);
        }
        return arr;
    }

    // concatenates two arrays
    public static TestInteger[] concatenate(TestInteger[] a, TestInteger[] b) {
        TestInteger[] both = Stream.concat(Arrays.stream(a), Arrays.stream(b)).toArray(TestInteger[]::new);
        TestInteger.resetCounter();
        return both;
    }

    // quick sort v1
    public static void quickSortRecursive(TestInteger[] arr, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(arr, low, high);
            quickSortRecursive(arr, low, pivotIndex - 1);
            quickSortRecursive(arr, pivotIndex + 1, high);
        }
    }

    // quick sort with a random pivot
    public static void quickSortRecursiveRanPiv(TestInteger[] arr, int low, int high) {
        if (low < high) {
            int pivotIndex = partitionRan(arr, low, high);
            quickSortRecursiveRanPiv(arr, low, pivotIndex - 1);
            quickSortRecursiveRanPiv(arr, pivotIndex + 1, high);
        }
    }

    // quick sort with a median pivot of 3 random pivots, and a random pivot when the
    // subarray has length of 30
    public static void quickSortRecursiveMedPiv(TestInteger[] arr, int low, int high) {
        if (low < high) {
            if(high - low > 30) {
                int pivotIndex = partitionMid(arr, low, high);
                quickSortRecursiveMedPiv(arr, low, pivotIndex - 1);
                quickSortRecursiveMedPiv(arr, pivotIndex + 1, high);
            }
            else {
                int pivotIndex = partitionRan(arr, low, high);
                quickSortRecursiveMedPiv(arr, low, pivotIndex - 1);
                quickSortRecursiveMedPiv(arr, pivotIndex + 1, high);
            }
        }
    }

    // quick sort using median pivot, and returns after subarray is 2 long
    // it will then call insertion sort to finish sorting the array
    public static void quickSortRecursiveInsSort(TestInteger[] arr, int low, int high) {
        if (low < high) {
            if (high - low > 30) {
                int pivotIndex = partitionMid(arr, low, high);
                quickSortRecursiveInsSort(arr, low, pivotIndex - 1);
                quickSortRecursiveInsSort(arr, pivotIndex + 1, high);
            }
            if (high - low <= 30 && high - low > 3) {
                int pivotIndex = partitionRan(arr, low, high);
                quickSortRecursiveInsSort(arr, low, pivotIndex - 1);
                quickSortRecursiveInsSort(arr, pivotIndex + 1, high);
            }
            else {
                return;
            }
        }
    }

    // insertion sort
    public static void insertionSort(TestInteger[] arr) {
    
        int n = arr.length;
        for (int i = 1; i < n; ++i) {
            TestInteger key = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j].compareTo(key) > 0) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }  

    // helper function for partitioning
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

    // helper function that uses a random pivot
    private static int partitionRan(TestInteger[] arr, int low, int high) {
        random(arr, low, high);
        TestInteger pivot = arr[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j].compareTo(pivot) < 0) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return i + 1;
    }

    // helper function that uses a median of 3 points
    private static int partitionMid(TestInteger[] arr, int low, int high) {
        randomMid(arr, low, high);
        TestInteger pivot = arr[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j].compareTo(pivot) < 0) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return i + 1;
    }

    // chooses a random pivot
    static void random(TestInteger[] arr, int low, int high) {
        Random rand = new Random();
        int pivot = rand.nextInt(high - low) + low;
        TestInteger temp1 = arr[pivot];
        arr[pivot] = arr[high];
        arr[high] = temp1;
    }

    // chooses a median of 3 random points
    static void randomMid(TestInteger[] arr, int low, int high) {
        Random rand = new Random();
        int p1 = rand.nextInt(high - low) + low;
        int p2 = rand.nextInt(high - low) + low;
        int p3 = rand.nextInt(high - low) + low;

        int pivot = midpoint(arr, p1, p2, p3);
        TestInteger temp1 = arr[pivot];
        arr[pivot] = arr[high];
        arr[high] = temp1;
    }

    // helper function that returns the midpoint of 3 given array indexes
    static int midpoint(TestInteger[] arr, int p1, int p2, int p3) {
        if (arr[p1].compareTo(arr[p2]) < 0) {
            if (arr[p2].compareTo(arr[p3]) <= 0)
                return p2;
            if (arr[p1].compareTo(arr[p3]) < 0)
                return p3;
            return p1;
        } else {
            if (arr[p1].compareTo(arr[p3]) <= 0)
                return p1;
            if (arr[p2].compareTo(arr[p3]) <= 0)
                return p3;
            return p2;
        }
    }

    private static void swap(TestInteger[] arr, int i, int j) {
        TestInteger temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
