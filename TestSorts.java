import org.junit.Test;
import static org.junit.Assert.*;

public class TestSorts {

    @Test
    public void testOriginalQuickSort() {
        TestInteger[] arr = Main.newArrOrd(3);
        Main.quickSort(arr);
        assertTrue(Main.isSorted(arr));
    }

    @Test
    public void testMergeSort() {
        TestInteger[] arr = Main.newArrOrd(3);
        Main.mergeSort(arr);
        assertTrue(Main.isSorted(arr));
    }

    @Test
    public void testMidpoint() {
        TestInteger[] arr = new TestInteger[3];
        arr[0] = new TestInteger(0);
        arr[1] = new TestInteger(1);
        arr[2] = new TestInteger(2);
        assertTrue(Main.midpoint(arr, 0, 1, 2) == 1);
    }

    @Test
    public void testInsertionSort() {
        TestInteger[] arr = Main.newArrOrd(100);
        assertFalse(Main.isSorted(arr));
        Main.insertionSort(arr);
        assertTrue(Main.isSorted(arr));
    }
}