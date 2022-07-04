import java.io.*;
import java.util.Arrays;

public class Day17ForSubmit {
    public static void main(String[] args) throws Exception {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

            int n = Integer.parseInt(bufferedReader.readLine());

            for (int i = 0; i < n; i++) {
                int[] nums = Arrays.stream(bufferedReader.readLine().trim().split(" ")).filter(x -> !x.equals(""))
                        .mapToInt(Integer::parseInt).toArray();
                int m = nums[0];
                int p = nums[1];
                if (m < 0 || p < 0) {
                    throw new Exception("n and p should be non-negative");
                }

                System.out.println((int) Math.pow(m, p));
            }

            bufferedReader.close();
        } catch (Exception ex) {
            throw new Exception("n and p should be non-negative");
        }
    }
}
