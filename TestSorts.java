import org.junit.Test;
import static org.junit.Assert.*;

public class TestSorts {

    @Test
    public void testOriginalQuickSort() {
        TestInteger[] arr = Main.newArrOrd();
        Main.quickSort(arr);
        assertTrue(Main.isSorted(arr));
    }

    @Test
    public void testMergeSort() {
        TestInteger[] arr = Main.newArrOrd();
        Main.mergeSort(arr);
        assertTrue(Main.isSorted(arr));
    }
}