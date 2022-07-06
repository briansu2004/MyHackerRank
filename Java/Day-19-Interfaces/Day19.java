import java.io.*;

interface AdvancedArithmetic {
    int divisorSum(int n);
}

class Calculator implements AdvancedArithmetic {

    @Override
    public int divisorSum(int n) {
        System.out.println("I implemented: AdvancedArithmetic");

        int sum = 0;

        for (int i = 1; i <= n; ++i) {
            if (n % i == 0) {
                sum += i;
            }
        }

        return sum;
    }

}

public class Day19 {
    public static void main(String[] args) throws IllegalArgumentException, IOException {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            int n = Integer.parseInt(bufferedReader.readLine());
            bufferedReader.close();

            Calculator calc = new Calculator();
            System.out.println(calc.divisorSum(n));
        } catch (IOException ex) {
            throw new IOException("IOException");
        }
    }
}
