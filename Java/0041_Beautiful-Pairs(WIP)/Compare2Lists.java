import java.util.ArrayList;
import java.util.Arrays;

public class Compare2Lists {
    public static void main(String[] args) {
        ArrayList<String> listOne = new ArrayList<>(Arrays.asList("a", "b", "c", "d", "f"));

        ArrayList<String> listTwo = new ArrayList<>(Arrays.asList("a", "b", "c", "d", "e"));

        // Check two lists are equal
        boolean isEqual = listOne.equals(listTwo); // false
        System.out.println(isEqual);

        ArrayList<String> listThree = new ArrayList<>(Arrays.asList("a", "b", "c", "d", "f"));
        isEqual = listOne.equals(listThree); // true
        System.out.println(isEqual);

        listOne = new ArrayList<>(Arrays.asList("a", "b", "c", "d", "f"));
        listTwo = new ArrayList<>(Arrays.asList("a", "b", "c", "d", "e"));
        // Find additional elements in a list
        listTwo.removeAll(listOne);
        System.out.println(listTwo);

        listOne = new ArrayList<>(Arrays.asList("a", "b", "c", "d", "f"));
        listTwo = new ArrayList<>(Arrays.asList("a", "b", "c", "d", "e"));
        // Find missing elements in a list
        listTwo.removeAll(listOne);
        System.out.println(listTwo);

        listOne = new ArrayList<>(Arrays.asList("a", "b", "c", "d", "f"));
        listTwo = new ArrayList<>(Arrays.asList("a", "b", "c", "d", "e"));
        // Find common elements in two lists
        listOne.retainAll(listTwo);
        System.out.println(listOne);

        ArrayList<Integer> list1 = new ArrayList<>(Arrays.asList(1, 2, 3, 3));
        ArrayList<Integer> list2 = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
        list1.removeAll(list2);
        System.out.println(list1);

        list1 = new ArrayList<>(Arrays.asList(1, 2, 3, 3));
        list2 = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
        list1.retainAll(list2);
        System.out.println(list1);
    }
}