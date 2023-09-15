import java.io.*;

public class Day16 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String S = bufferedReader.readLine();

        try {
            int n = Integer.parseInt(S);
            System.out.println(n);
        } catch (Exception ex) {
            System.out.println("Bad String");
        }

        bufferedReader.close();
    }
}
