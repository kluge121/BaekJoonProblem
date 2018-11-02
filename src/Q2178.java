import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Q2178 {


    static int[][] adj;
    static int[][] visited;
    static int mX;
    static int mY;

    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);
        mX = sc.nextInt();
        mY = sc.nextInt();
        adj = new int[mX + 1][mY + 1];
        visited = new int[mX + 1][mY + 1];

        for (int i = 1; i <= mY; i++) {
            for (int j = 1; j <= mX; j++) {
                adj[j][i] = sc.nextInt();
            }
        }

        bfs();

    }


    static int bfs() {

        int[] xDirection = {0, 1, 0, -1};
        int[] yDirection = {1, 0, -1, -0};
        Queue<Node> queue = new LinkedList();
        queue.offer(new Node(1, 1));
        while (!queue.isEmpty()) {
            Node thisNode = queue.poll();
            if (visited[thisNode.x][thisNode.y] == 1) continue;
            if (thisNode.x == mX && thisNode.y == mY) {
                //찾았으면 백트레킹
            }

        }

        return 1;
    }

    static boolean isMoveRange(int x, int y) {
        return (x >= 1 && y >= 1 && x <= mX && y <= mY);
    }

}

class Node {
    int x;
    int y;

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}