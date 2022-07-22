import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'twoStrings' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     * 1. STRING s1
     * 2. STRING s2
     */

    /* Assuming s only contains a-z, or A-Z */
    public static int[] countingSortString(String s, char firstChar) {
        int[] cs = new int[26];
        for (int i = 0; i < s.length(); i++) {
            cs[s.charAt(i) - firstChar]++;
        }
        return cs;
    }

    public static String twoStrings(String s1, String s2) {
        // Write your code here
        char firstChar = 'a';
        int[] cs1 = countingSortString(s1, firstChar);
        int[] cs2 = countingSortString(s2, firstChar);
        for (int i = 0; i < 26; i++) {
            if (cs1[i] > 0 && cs2[i] > 0) {
                return "YES";
            }
        }

        return "NO";
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        try (InputStream inputStream = new FileInputStream("stdin.txt");
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));) {

            int q = Integer.parseInt(bufferedReader.readLine().trim());

            IntStream.range(0, q).forEach(qItr -> {
                try {
                    String s1 = bufferedReader.readLine();

                    String s2 = bufferedReader.readLine();

                    String result = Result.twoStrings(s1, s2);

                    System.out.println(result);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            });
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
