package baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Q2178 {

    static int[][] adj;
    static int[][] visited;
    static int[][] distance;
    static int mX;
    static int mY;
    static final int VISIT = 1;
    static final int ASCII_ONE = 49;

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        mY = sc.nextInt();
        mX = sc.nextInt();
        adj = new int[mX + 1][mY + 1];
        visited = new int[mX + 1][mY + 1];
        distance = new int[mX + 1][mY + 1];


        for (int i = 1; i <= mY; i++) {
            //한 줄로 들어오는 숫자 입력을 어떻게 분해할까 고민하다 마땅한 방법이 떠오르지 않아서...
            //따라서 char형태로 저장하기 때문에 숫자1은 실제로 아스키코드 49에 대응되서
            //1은 int = 49 , 0은 int = 48 이 되어버렸다.
            String line = sc.next();
            for (int j = 1; j <= mX; j++) {
                int tmp = line.charAt(j - 1);
                adj[j][i] = tmp;
            }
        }
        bfs();
    }
    static void bfs() {
        int[] xDirection = {0, 1, 0, -1};
        int[] yDirection = {1, 0, -1, -0};
        Queue<Node2178> queue = new LinkedList();
        queue.offer(new Node2178(1, 1));
        distance[1][1] = 1;
        while (!queue.isEmpty()) {
            Node2178 thisNode = queue.poll();
            if (visited[thisNode.x][thisNode.y] == VISIT) continue;
            else visited[thisNode.x][thisNode.y] = VISIT;
            if (thisNode.x == mX && thisNode.y == mY) {
                System.out.print(distance[thisNode.x][thisNode.y]);
                return;
            }
            for (int i = 0; i <= 3; i++) {
                int cX = thisNode.x + xDirection[i];
                int cY = thisNode.y + yDirection[i];
                //숫자1이 char형으로 저장되기 떄문에 ASCII_ONE = 49 => 문자 1의 아스키코드로 조건을 확인한다.
                if (isMoveRange(cX, cY) && isNotVisited(cX, cY) && adj[cX][cY] == ASCII_ONE) {
                    queue.offer(new Node2178(cX, cY));
                    distance[cX][cY] = distance[thisNode.x][thisNode.y] + 1;
                }
            }

        }
    }

    static boolean isMoveRange(int x, int y) {
        return (x >= 1 && y >= 1 && x <= mX && y <= mY);
    }

    static boolean isNotVisited(int x, int y) {
        return visited[x][y] != VISIT;
    }

}

class Node2178 {
    int x;
    int y;

    public Node2178(int x, int y) {
        this.x = x;
        this.y = y;
    }
}