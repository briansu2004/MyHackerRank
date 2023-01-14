package Java.FirstUnique;

import java.util.stream.Collectors;
import java.util.*;

class Solution {
    public static int solution(int[] a) {
        Set<Integer> aSet = Arrays.stream(a).boxed().collect(Collectors.toSet());

        List<Integer> aList = Arrays.stream(a).boxed().collect(Collectors.toList());

        for (int i = 0; i < a.length; i++) {
            if (Collections.frequency(aList, a[i]) == 1) {
                return a[i];
            }
        }

        return -1;
    }


    public static int solution2(int[] a) {
        int firstUnique = a[0];

        // for (int i = 1; i < a.length; i++) {
        // }

        return firstUnique;
    }

    public static void main(String[] args) {
        int[] intArray = new int[5];
        intArray[0] = 3;
        intArray[1] = 12;
        intArray[2] = 45;
        intArray[3] = 23;
        intArray[4] = 11;

        System.out.println(Solution.solution(intArray));
    }
}
