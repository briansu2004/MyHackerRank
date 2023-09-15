import java.io.*;
import java.util.*;

class Result {

    /*
     * Complete the 'permutationEquation' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts INTEGER_ARRAY p as parameter.
     */

    // public static List<Integer> permutationEquation(List<Integer> p) {
    // // Write your code here

    // }

}

public class se {
    public static void main(String[] args) throws IOException {
        /* Create function: p_inverse */
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int [] p_inverse = new int[n + 1];
        for (int x = 1; x <= n; x++) {
            int px = scan.nextInt();
            p_inverse[px] = x;
        }
        scan.close();
        
        /* Calculate and print each y */
        for (int x = 1; x <= n; x++) {
            int y = p_inverse[p_inverse[x]];
            System.out.println(y);
        }
    }
}
