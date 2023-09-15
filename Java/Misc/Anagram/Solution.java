import java.io.*;
import java.util.stream.*;

class Result {

    /*
     * Complete the 'anagram' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts STRING s as parameter.
     */

    public static int anagram(String s) {
        // Write your code here
        if (s.length() % 2 == 1) {
            return -1;
        }

        int cnt = 0;

        int[] cnt1 = new int[26];
        int[] cnt2 = new int[26];

        for (int i = 0; i < s.length() / 2; i++) {
            cnt1[s.charAt(i) - 'a']++;
        }
        for (int i = s.length() / 2; i < s.length(); i++) {
            cnt2[s.charAt(i) - 'a']++;
        }

        for (int i = 0; i < 26; i++) {
            cnt += Math.abs(cnt1[i] - cnt2[i]);
        }
        
        return cnt / 2;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        try (InputStream inputStream = new FileInputStream("stdin.txt");
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));) {

            int q = Integer.parseInt(bufferedReader.readLine().trim());

            IntStream.range(0, q).forEach(qItr -> {
                try {
                    String s = bufferedReader.readLine();

                    int result = Result.anagram(s);

                    System.out.println(String.valueOf(result));
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            });

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}