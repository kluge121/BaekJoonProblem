package solve;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Q7576 {


    final static int GOOD = 1;
    final static int BAD = 0;
    final static int VISIT = 1;
    static int mX;
    static int mY;
    static int[][] adj;
    static int[][] minMap;
    static int[][] visited;
    static int[] xDirection = {0, 1, 0, -1};
    static int[] yDirection = {1, 0, -1, 0};
    static Queue<Node2178> queue = new LinkedList<>();

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        mX = sc.nextInt();
        mY = sc.nextInt();
        adj = new int[mX + 1][mY + 1];
        minMap = new int[mX + 1][mY + 1];
        visited = new int[mX + 1][mY + 1];
        int badCount = 0;
        for (int i = 1; i <= mY; i++) {
            for (int j = 1; j <= mX; j++) {
                int tmp = sc.nextInt();
                adj[j][i] = tmp;
                if (tmp == GOOD) queue.offer(new Node2178(j, i));
                if (tmp == BAD) badCount++;
            }
        }
        //익은게 아무것도 없으면
        if (queue.size() == 0) {
            System.out.print(-1);
            return;
        }

        //입력받은게 전부 익어있거나 전부 벽이면
        if (badCount == 0) {
            System.out.print(0);
            return;
        }

        //큐 빙빙
        while (queue.size() != 0) {
            Node2178 thisNode = queue.poll();
            int x = thisNode.x;
            int y = thisNode.y;
            if (visited[x][y] == VISIT) continue;
            visited[x][y] = VISIT;
            for (int j = 0; j <= 3; j++) {
                int cX = x + xDirection[j];
                int cY = y + yDirection[j];

                // 영역을 벗어나지 않으면서, (아직 안익었거나 이미 탐색해서 익었지만 걸리는 날짜가 더 적다면)
                if (isPossibleMove(cX, cY) && (isMinDay(x, y, cX, cY) || adj[cX][cY] == BAD)) {
                    queue.offer(new Node2178(cX, cY));
                    minMap[cX][cY] = minMap[x][y] + 1;
                    adj[cX][cY] = GOOD;
                }
            }
        }
        int maxDay = 0; // 출력용 날짜
        int badCheck = 1;  // 안익은거 체크
        for (int i = 1; i <= mY; i++) {
            for (int j = 1; j <= mX; j++) {
                maxDay = Math.max(minMap[j][i], maxDay);
                badCheck *= adj[j][i]; // 모든 값들을 곱하다가 0이있어 값이 0이되면 안익은게 있는걸로 간주
                if (badCheck == 0) {
                    System.out.print(-1);
                    return;
                }
            }
        }
        System.out.print(maxDay);
    }

    static boolean isPossibleMove(int x, int y) {
        return (x >= 1 && y >= 1 && x <= mX && y <= mY);
    }

    static boolean isMinDay(int x, int y, int cX, int cY) {

        return (minMap[cX][cY] > minMap[x][y] + 1);

    }
}

class Node7576 {
    int x;
    int y;

    public Node7576(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

