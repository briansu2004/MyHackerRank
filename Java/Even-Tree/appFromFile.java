import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

public class appFromFile {
    public static void main(String[] args) throws IOException {
        try (InputStream inputStream = new FileInputStream("stdin.txt");
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));) {
            String strCurrentLine = bufferedReader.readLine();
            int[] nums = Arrays.stream(strCurrentLine.split(" ")).filter(x -> !x.equals("")).mapToInt(Integer::parseInt)
                    .toArray();
            int vertices = nums[0];
            int edges = nums[1];

            Node[] nodes = new Node[vertices];
            while (vertices-- > 0)
                nodes[vertices] = new Node();
            while (edges-- > 0) {
                strCurrentLine = bufferedReader.readLine();
                int[] data = Arrays.stream(strCurrentLine.split(" ")).filter(x -> !x.equals(""))
                        .mapToInt(Integer::parseInt)
                        .toArray();
                nodes[data[0] - 1].setParent(nodes[data[1] - 1]);

            }

            int disconnects = -1;
            for (Node n : nodes)
                if (n.descendantCount % 2 == 1)
                    disconnects++;
            System.out.println(disconnects);

            inputStream.close();
            bufferedReader.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
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