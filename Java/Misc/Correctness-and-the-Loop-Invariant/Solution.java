import java.io.*;
import java.util.*;
import java.util.stream.Stream;

public class Solution {

    public static void insertionSort(int[] A) {
        for (int i = 1; i < A.length; i++) {
            int value = A[i];
            int j = i - 1;
            while (j >= 0 && A[j] > value) {
                A[j + 1] = A[j];
                j = j - 1;
            }
            A[j + 1] = value;
            //printArray(A);
        }

        printArray(A);
    }

    static void printArray(int[] ar) {
        for (int n : ar) {
            System.out.print(n + " ");
        }
        System.out.print("\n");
    }

    public static void main(String[] args) {
        try (InputStream inputStream = new FileInputStream("stdin.txt");
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));) {

            // Scanner in = new Scanner(System.in);
            // int[] ar = new int[n];
            // for(int i=0;i<n;i++){
            // ar[i]=in.nextInt();
            // }

            int n = Integer.parseInt(bufferedReader.readLine());
            int[] ar = Stream.of(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            insertionSort(ar);

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

    }
}