import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'formingMagicSquare' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts 2D_INTEGER_ARRAY s as parameter.
     */

    public static int formingMagicSquare1(List<List<Integer>> lst) {
        // Write your code here
        int[][] s = lst.stream()
                .map(l -> l.stream().mapToInt(Integer::intValue).toArray())
                .toArray(int[][]::new);

        int cost[] = { 0, 0, 0, 0, 0, 0, 0, 0 };
        int t[][] = {
                { 4, 9, 2, 3, 5, 7, 8, 1, 6 },
                { 4, 3, 8, 9, 5, 1, 2, 7, 6 },
                { 2, 9, 4, 7, 5, 3, 6, 1, 8 },
                { 2, 7, 6, 9, 5, 1, 4, 3, 8 },
                { 8, 1, 6, 3, 5, 7, 4, 9, 2 },
                { 8, 3, 4, 1, 5, 9, 6, 7, 2 },
                { 6, 7, 2, 1, 5, 9, 8, 3, 4 },
                { 6, 1, 8, 7, 5, 3, 2, 9, 4 },
        };

        for (int i = 0; i < 8; i++) {
            cost[i] = Math.abs(t[i][0] - s[0][0]) + Math.abs(t[i][1] - s[0][1]) + Math.abs(t[i][2] - s[0][2]);
            cost[i] = cost[i] + Math.abs(t[i][3] - s[1][0]) + Math.abs(t[i][4] - s[1][1]) + Math.abs(t[i][5] - s[1][2]);
            cost[i] = cost[i] + Math.abs(t[i][6] - s[2][0]) + Math.abs(t[i][7] - s[2][1]) + Math.abs(t[i][8] - s[2][2]);
        }

        Arrays.sort(cost);
        return cost[0];
    }

    public static int formingMagicSquare(List<List<Integer>> lst) {
        // Write your code here
        int[][] s = lst.stream()
                .map(l -> l.stream().mapToInt(Integer::intValue).toArray())
                .toArray(int[][]::new);

        int cost = Integer.MAX_VALUE;
        int[][] t = {
                { 4, 9, 2, 3, 5, 7, 8, 1, 6 },
                { 4, 3, 8, 9, 5, 1, 2, 7, 6 },
                { 2, 9, 4, 7, 5, 3, 6, 1, 8 },
                { 2, 7, 6, 9, 5, 1, 4, 3, 8 },
                { 8, 1, 6, 3, 5, 7, 4, 9, 2 },
                { 8, 3, 4, 1, 5, 9, 6, 7, 2 },
                { 6, 7, 2, 1, 5, 9, 8, 3, 4 },
                { 6, 1, 8, 7, 5, 3, 2, 9, 4 },
        };
        int temp = 0;
        for (int i = 0; i < 8; i++) {
            temp = Math.abs(s[0][0] - t[i][0]) + Math.abs(s[0][1] - t[i][1]) + Math.abs(s[0][2] - t[i][2])
                    + Math.abs(s[1][0] - t[i][3]) + Math.abs(s[1][1] - t[i][4]) + Math.abs(s[1][2] - t[i][5])
                    + Math.abs(s[2][0] - t[i][6]) + Math.abs(s[2][1] - t[i][7]) + Math.abs(s[2][2] - t[i][8]);
            cost = Math.min(temp, cost);
        }
        return cost;
    }
}

public class Magic {
    public static void main(String[] args) throws IOException {
        // BufferedReader bufferedReader = new BufferedReader(new
        // InputStreamReader(System.in));
        // BufferedWriter bufferedWriter = new BufferedWriter(new
        // FileWriter(System.getenv("OUTPUT_PATH")));

        try (InputStream inputStream = new FileInputStream("stdin.txt");
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));) {

            List<List<Integer>> s = new ArrayList<>();

            IntStream.range(0, 3).forEach(i -> {
                try {
                    s.add(
                            Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                    .map(Integer::parseInt)
                                    .collect(toList()));
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            });

            int result = Result.formingMagicSquare(s);
            System.out.println(result);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        // bufferedWriter.write(String.valueOf(result));
        // bufferedWriter.newLine();

        // bufferedReader.close();
        // bufferedWriter.close();
    }
}
