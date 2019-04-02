import java.util.*;

public class Test {

    public static void main(String[] args) {


        Deque<Integer> q = new LinkedList<>();

        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
        q.addFirst(q.pollLast());
        System.out.println(Arrays.toString(q.toArray()));



    }


}
