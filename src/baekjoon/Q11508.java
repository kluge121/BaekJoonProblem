package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Q11508 {


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
        int price = 0;

        for (int i = 0; i < N; i++)
            queue.add(Integer.parseInt(br.readLine()));
        while (queue.size() > 2) {
            price += queue.poll();
            price += queue.poll();
            queue.poll();
        }
        while (!queue.isEmpty())
            price += queue.poll();
        System.out.println(price);

    }
}
