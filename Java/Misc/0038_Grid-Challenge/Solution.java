import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'gridChallenge' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING_ARRAY grid as parameter.
     */

    public static String gridChallenge(List<String> grid) {
        // Write your code here
        int row = grid.size();
        int col = grid.get(0).length();
        char[][] cgrid = new char[row][col];
        for (int i = 0; i < row; i++) {
            String s = grid.get(i);
            char[] cs = s.toCharArray();
            Arrays.sort(cs);
            cgrid[i] = cs;
        }

        for (int i = 0; i < col; i++) {
            for (int j = 0; j < row - 1; j++) {
                if (cgrid[j + 1][i] < cgrid[j][i]) {
                    return "NO";
                }
            }
        }

        return "YES";
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        try (
                InputStream inputStream = new FileInputStream("stdin.txt");
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));) {

            int t = Integer.parseInt(bufferedReader.readLine().trim());

            IntStream.range(0, t).forEach(tItr -> {
                try {
                    int n = Integer.parseInt(bufferedReader.readLine().trim());

                    List<String> grid = IntStream.range(0, n).mapToObj(i -> {
                        try {
                            return bufferedReader.readLine();
                        } catch (IOException ex) {
                            throw new RuntimeException(ex);
                        }
                    })
                            .collect(toList());

                    String result = Result.gridChallenge(grid);

                    System.out.println(result);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            });
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }
}
