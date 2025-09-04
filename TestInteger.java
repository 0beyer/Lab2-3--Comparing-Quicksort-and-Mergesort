class TestInteger implements Comparable<TestInteger> {

    private int value;
    private static int counter = 0;

    public TestInteger(int n) {
        value = n;
    } 

    public int value() {
        return value;
    }

    public String toString() {
        return "" + value;
    }

    public int compareTo(TestInteger other) {
        counter = counter + 1;
        return value - other.value;
    }

    public static void resetCounter() {
        counter = 0;
    }

    public static int getCounter() {
        return counter;
    }
}
