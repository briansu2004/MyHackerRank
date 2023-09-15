import java.io.*;

class Result {

    /*
     * Complete the 'makingAnagrams' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     * 1. STRING s1
     * 2. STRING s2
     */

    public static int makingAnagrams(String s1, String s2) {
        // Write your code here
        int total = 0;

        int[] cs1 = new int[26];
        int[] cs2 = new int[26];

        for (int i = 0; i < s1.length(); i++) {
            cs1[s1.charAt(i) - 'a'] += 1;
        }
        for (int i = 0; i < s2.length(); i++) {
            cs2[s2.charAt(i) - 'a'] += 1;
        }
        for (int i = 0; i < 26; i++) {
            total += Math.abs(cs1[i] - cs2[i]);
        }

        return total;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        try (InputStream inputStream = new FileInputStream("stdin.txt");
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));) {

            String s1 = bufferedReader.readLine();

            String s2 = bufferedReader.readLine();

            int result = Result.makingAnagrams(s1, s2);

            System.out.println(String.valueOf(result));
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
