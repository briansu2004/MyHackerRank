import java.util.Scanner;

public class app {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int vertices = s.nextInt();
        int edges = s.nextInt();
        Node[] nodes = new Node[vertices];
        while (vertices-- > 0)
            nodes[vertices] = new Node();
        while (edges-- > 0)
            nodes[s.nextInt() - 1]
                    .setParent(nodes[s.nextInt() - 1]);
        s.close();
        int disconnects = -1;
        for (Node n : nodes)
            if (n.descendantCount % 2 == 1)
                disconnects++;
        System.out.println(disconnects);
    }
}

class Node {
    private Node parent;
    int descendantCount = 0;

    void setParent(Node parent) {
        this.parent = parent;
        Node ancestor = parent;
        while (ancestor != null) {
            ancestor.descendantCount++;
            ancestor = ancestor.getParent();
        }
    }

    Node getParent() {
        return this.parent;
    }
}