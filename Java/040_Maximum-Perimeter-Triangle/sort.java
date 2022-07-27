import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class sort {

    public static void print(List<Integer> lst) {
        System.out.println(
                lst.stream()
                        .map(Object::toString)
                        .collect(Collectors.joining(" ")));
    }

    public static void main(String[] args) {
        List<Integer> lst = new ArrayList<>();

        lst.add(100);
        lst.add(-1);
        lst.add(10);
        lst.add(1);
        print(lst);
        
        Collections.sort(lst);
        print(lst);

        Collections.sort(lst, Collections.reverseOrder());
        print(lst);
    }
}
