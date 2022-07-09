class MyGeneric {
    static <T> void printArray(T[] a) {
        for (T o : a) {
            System.out.print(o + " ");
        }
        System.out.print("\n");
    }
}

public class Day21 {

    public static void main(String[] args) {
        /*
         * Enter your code here. Read input from STDIN. Print output to STDOUT. Your
         * class should be named Solution.
         */
        String[] stringArray = new String[] { "a", "b", "c" };
        MyGeneric.printArray(stringArray);
        Integer[] intArray = new Integer[] { 1, 2, 3, 4 };
        MyGeneric.printArray(intArray);
        Double[] doubleArray = { 7.0, 9.0, 5.0, 1.0, 3.0 };
        MyGeneric.printArray(doubleArray);
    }
}