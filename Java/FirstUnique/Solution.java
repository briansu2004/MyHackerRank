import java.util.stream.Collectors;
import java.util.*;

class Solution {
    public int solution(int[] a) {
        Set<Integer> aSet = Arrays.stream(a).boxed().collect(Collectors.toSet());

        List<Integer> aList = Arrays.stream(a).boxed().collect(Collectors.toList());

        for (int i = 0; i < a.length; i++) {
            if (Collections.frequency(aList, a[i]) == 1) {
                return a[i];
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println(solution());
    }
}
