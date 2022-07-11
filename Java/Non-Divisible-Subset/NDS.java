import static java.util.stream.Collectors.toList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Stream;

class Result {

    /*
     * Complete the 'nonDivisibleSubset' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     * 1. INTEGER k
     * 2. INTEGER_ARRAY s
     */
    public static int nonDivisibleSubset1(int k, List<Integer> s) {
        // In maths. if (a + b) % k = 0 => then ((a % k) + (b % k)) % k = 0
        // Example: (5 + 7) % 6 = 0 => then (5 % 6) + (7 % 6) > (5 + 1) % 6 = 0

        // Solution: Find remainder of each element in the array.
        // then, choose max element from the pair which together can able to be divided
        // by k. If one pair is "i" then other pair will be "k-i"
        // For example: S = {2, 3, 7, 8, 12} and k = 5.
        // Now we have 3 numbers whose remainder 2 => ( 2 % 5 = 2, 7 % 5 = 2, 12 % 5 =
        // 2)
        // and also we have 2 numbers whose remainder 3 => (3, 8)
        // Right now we have to choose one of the element from that pair (3, 2) (where 3
        // > numbers 2, 7, 12 && 2 > numbers 3, 8)
        // Because of the problem, we will choose the max which is 3.

        int[] remainderArr = new int[k];
        // find remainder of each element in the array S
        // For example k = 4, S = {0, 5, 7, 10} => remainderArr will be: {0, 1, 1, 1}
        // where each index represents remainder. For example remainderArr[2] = 1 means
        // that there is 1 number whose remainder 2 after divided 4. (10 % 4 = 2)
        for (Integer each : s) {
            remainderArr[each % k]++;
        }

        // After getting each remainder, index 0 (actually remainder 0) is a special
        // case
        // Think of it like this:
        // 1. There will be no element such as k - 0 = k. (remainderArr[k] will give us
        // ArrayIndexOutOfBoundsException)
        // 2. If there are 2 elements in remainderArr[0], we have to choose only 1,
        // otherwise, we can sum up 2 or more
        // zeros, then non-sub divisible set could be divisible by k.
        int zeroRemainder = remainderArr[0];

        // That's why, our initial subset size is 1, if there is a zero remainder,
        // otherwise it is 0
        int maxNumberOfDivisibleSet = zeroRemainder > 0 ? 1 : 0;

        // Another thing is that pair which is itself. That's means, let's say k = 4,
        // therefore pair of remainderArr[2]
        // will also be remainderArr[2]( i = 2 then, k - i = 2). Thus, we have to choose
        // only 1 element from that pair (or we should increment
        // the result number just 1)
        // if condition "i != k - i" will handle this situation.
        for (int i = 1; i <= (k / 2); i++) {
            if (i != k - i)
                maxNumberOfDivisibleSet += Math.max(remainderArr[i], remainderArr[k - i]);
            else
                maxNumberOfDivisibleSet++;
        }

        return maxNumberOfDivisibleSet;
    }

    public static int nonDivisibleSubset(int k, List<Integer> s) {
        int[] remainderArr = new int[k];
        for (Integer each : s) {
            remainderArr[each % k]++;
        }

        int zeroRemainder = remainderArr[0];

        int maxNumberOfDivisibleSet = zeroRemainder > 0 ? 1 : 0;

        for (int i = 1; i <= (k / 2); i++) {
            if (i != k - i)
                maxNumberOfDivisibleSet += Math.max(remainderArr[i], remainderArr[k - i]);
            else
                maxNumberOfDivisibleSet++;
        }

        return maxNumberOfDivisibleSet;
    }
}

public class NDS {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int k = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> s = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int result = Result.nonDivisibleSubset(k, s);
        System.out.println(result);

        bufferedReader.close();
    }
}
