import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        TestInteger[] TestArr = populateRan(1000);

        mergeSort(TestArr);
    }

    public static void mergeSort(TestInteger[] arr) {
        Arrays.sort(arr);
        printSorted(arr);
    }

    public static Integer returnCount(TestInteger[] arr) {
        int n = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            n = arr[i].counter + n;
        }
        return n;
    }

    public static boolean isSorted(TestInteger[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i].compareTo(arr[i + 1]) > 0) {
                return false;
            }
        }
        return true;
    }

    public static void printSorted(TestInteger[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println(" ");
        System.out.println(" ");
        System.out.println("Counts: " + returnCount(arr));
    }

    public static TestInteger[] populateOrd(int size) {
        TestInteger[] ArrOrd = new TestInteger[size];
        for (int i = 0; i < size; i++) {
            ArrOrd[i] = new TestInteger(i);
        }
        return ArrOrd;
    }

    public static TestInteger[] populateRan(int size) {
        Random rand = new Random();
        TestInteger[] ArrRan = new TestInteger[size];
        for (int i = 0; i < size; i++) {
            ArrRan[i] = new TestInteger(rand.nextInt(size));
        }
        return ArrRan;
    }
}