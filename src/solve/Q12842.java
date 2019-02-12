package solve;

import org.jetbrains.annotations.NotNull;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Q12842 {

    public static void main(String[] args) {

        PriorityQueue<Node> queue = new PriorityQueue<>();

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int reminder = sc.nextInt();
        int peopleCount = sc.nextInt();
        int nowTime = 0;

        //사람들이 먹은 개수
        int count = n - reminder;


        int map[] = new int[peopleCount + 1];


        for (int i = 0; i < peopleCount; i++) {
            map[i + 1] = sc.nextInt();
        }

        if (peopleCount == 1) {
            System.out.println(1);
            return;
        }

        //처음에 사람수 만큼 소보루를 삭-제한다.
        for (int i = 0; i < peopleCount; i++) {
            queue.add(new Node(i + 1, map[i + 1]));
            count--;
            if (count == 0) {
                System.out.println(i+1);
                return;
            }
        }

        Node node;

        while (!queue.isEmpty()) {


            node = queue.poll();
            if (nowTime != node.resultTime) {
                nowTime = node.resultTime;
            }
            if (count > 0) {
                queue.add(new Node(node.num, nowTime + map[node.num]));
                count--;
                if (count == 0) {
                    System.out.println(node.num);
                    return;
                }
            }


        }
    }

    static class Node implements Comparable<Node> {
        int num;
        int resultTime;

        public Node(int num, int resultTiem) {
            this.num = num;
            this.resultTime = resultTiem;
        }
        @Override
        public int compareTo(Node o) {
            if (Integer.compare(resultTime, o.resultTime) == 0) {
                return Integer.compare(num, o.num);
            }
            return Integer.compare(resultTime, o.resultTime);
        }

    }
}
