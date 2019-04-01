import java.util.ArrayList;
import java.util.Objects;
import java.util.PriorityQueue;

public class Test {

    public static void main(String[] args) {


        PriorityQueue<Integer> a = new PriorityQueue<>();
        a.add(1);
        a.add(2);
        a.add(0);

        System.out.println(a.poll());
    }


}
