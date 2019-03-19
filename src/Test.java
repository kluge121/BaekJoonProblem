import java.util.ArrayList;
import java.util.Objects;

public class Test {

    public static void main(String[] args) {

        ArrayList<Point> list = new ArrayList<>();

        list.add(new Point(1,2,3));

        if(list.contains(new Point(1,2,4))){
            System.out.println("dddd");
        }

    }

    static class Point {

        int start, end, val;

        public Point(int start, int end, int val) {
            this.start = start;
            this.end = end;
            this.val = val;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Point point = (Point) o;
            return start == point.start &&
                    end == point.end;
        }

        @Override
        public int hashCode() {
            return Objects.hash(start, end);
        }
    }
}
