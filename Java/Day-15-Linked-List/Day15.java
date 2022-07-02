import java.util.*;

class Node {
    private int data;
    private Node next;

    Node(int data) {
        this.data = data;
    }

    Node insert(Node head, int data) {
        Node tail = head;
        while (tail.next != null) {
            tail = tail.next;
        }
        tail.next = new Node(data);
        return head;
    }

    void print(Node head) {
        if (head != null) {
            System.out.print(head.data + " ");
            Node nextNode = head.next;
            while (nextNode != null) {
                System.out.print(nextNode.data + " ");
                nextNode = nextNode.next;
            }
        }
    }
}

public class Day15 {

    public static void main(String[] args) {
        /*
         * Enter your code here. Read input from STDIN. Print output to STDOUT. Your
         * class should be named Solution.
         */
        Scanner scanner = new Scanner(System.in);
        int cnt = Integer.parseInt(scanner.nextLine());
        int n = Integer.parseInt(scanner.nextLine());
        Node head = new Node(n);
        for (int i = 1; i < cnt; ++i) {
            int k = Integer.parseInt(scanner.nextLine());
            head = head.insert(head, k);
        }
        scanner.close();

        head.print(head);
    }
}