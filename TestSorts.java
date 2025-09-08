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
}