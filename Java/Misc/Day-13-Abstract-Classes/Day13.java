import java.util.*;
/*
The Alchemist
Paulo Coelho
248
 */

abstract class Book {
    // instance variables
    String title;
    String author;
    int price;

    abstract void display();
}

class MyBook extends Book {
    MyBook(String title, String author, int price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }

    void display() {
        System.out.println("Title: " + this.title);
        System.out.println("Author: " + this.author);
        System.out.println("Price: " + this.price);
    }
}

public class Day13 {
    public static void main(String[] args) {
        /*
         * Enter your code here. Read input from STDIN. Print output to STDOUT. Your
         * class should be named Solution.
         */
        Scanner scanner = new Scanner(System.in);
        String title = scanner.nextLine();
        String author = scanner.nextLine();
        int price = scanner.nextInt();
        scanner.close();

        MyBook myBook = new MyBook(title, author, price);
        myBook.display();
    }
}
