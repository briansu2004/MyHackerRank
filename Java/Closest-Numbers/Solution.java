import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'closestNumbers' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static List<Integer> closestNumbers(List<Integer> arr) {
        // Write your code here
        List<Integer> listRes = new ArrayList<Integer>();
        List<Integer> listDiff = new ArrayList<Integer>();
        int diff = 0;
        Collections.sort(arr);

        for (int i = 1; i < arr.size(); i++) {
            listDiff.add(Math.abs(arr.get(i) - arr.get(i - 1)));
        }

        int min = Collections.min(listDiff);
        for (int i = 0; i < listDiff.size(); i++) {
            if (listDiff.get(i) == min) {
                listRes.add(arr.get(i));
                listRes.add(arr.get(i + 1));
            }
        }

        return listRes;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {

        try (InputStream inputStream = new FileInputStream("stdin.txt");
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));) {

            int n = Integer.parseInt(bufferedReader.readLine().trim());

            List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                    .map(Integer::parseInt)
                    .collect(toList());

            List<Integer> result = Result.closestNumbers(arr);

            System.out.println(
                    result.stream()
                            .map(Object::toString)
                            .collect(joining(" "))
                            + "\n");

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
