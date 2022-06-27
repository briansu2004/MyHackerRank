import java.util.Scanner;

class app {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        int n = 0;
        String strBinary = Integer.toString(num, 2);
        // above is binary of given in in string
        String[] strparts = strBinary.split("0");
        // above we get all strings of ones, below find max from them
        for (int i = 0; i < strparts.length; i++) {
            if (n < strparts[i].length()) {
                n = strparts[i].length();
            }
        }
        System.out.println(n); // result
    }
}