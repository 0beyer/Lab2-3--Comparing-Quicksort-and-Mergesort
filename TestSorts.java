import org.junit.Test;
import static org.junit.Assert.*;

public class TestSorts {

    @Test
    public void testOriginalQuickSort() {
        TestInteger[] arr = Main.populateRan(1000);
        Main.quickSort(arr, 0, arr.length - 1);
        assertTrue(Main.isSorted(arr));
    }

    @Test
    public void testMergeSort() {
        TestInteger[] arr = Main.populateRan(1000);
        Main.mergeSort(arr);
        assertTrue(Main.isSorted(arr));
    }

    @Test void test() {
        
    }
}