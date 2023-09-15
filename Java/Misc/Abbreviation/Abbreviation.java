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
     * Complete the 'abbreviation' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     * 1. STRING a
     * 2. STRING b
     */

    public static String abbreviation(String a, String b) {
        // Write your code here
        int aLen = a.length(), bLen = b.length();
        // arr[i][j] = true iff a(0..i-1) can match b(0..j-1)
        boolean[][] arr = new boolean[aLen + 1][bLen + 1];
        arr[0][0] = true;
        for (int i = 1; i <= aLen; i++) {
            arr[i][0] = arr[i - 1][0] && Character.isLowerCase(a.charAt(i - 1));
        }
        for (int i = 1; i <= aLen; i++) {
            for (int j = 1; j <= bLen; j++) {
                arr[i][j] = (arr[i - 1][j - 1] && Character.toUpperCase(a.charAt(i - 1)) == b.charAt(j - 1)) ||
                        (arr[i - 1][j] && Character.isLowerCase(a.charAt(i - 1)));
            }
        }

        return (arr[aLen][bLen]) ? "YES" : "NO";
    }

}

public class Abbreviation {
    public static void main(String[] args) throws IOException {
        // BufferedReader bufferedReader = new BufferedReader(new
        // InputStreamReader(System.in));
        InputStream inputStream = new FileInputStream("stdin.txt");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        // BufferedWriter bufferedWriter = new BufferedWriter(new
        // FileWriter(System.getenv("OUTPUT_PATH")));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, q).forEach(qItr -> {
            try {
                String a = bufferedReader.readLine();

                String b = bufferedReader.readLine();

                String result = Result.abbreviation(a, b);

                System.out.println(result);

                // bufferedWriter.write(result);
                // bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        // bufferedWriter.close();
    }
}
