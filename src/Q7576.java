import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Q7576 {


    static final int EMPTY = -1;
    static final int GOOD = 1;
    static final int BAD = 0;
    static final int VISIT = 1;
    static int mX;
    static int mY;
    static int[][] adj;
    static int[][] visited;
    static ArrayList<Integer> parentList = new ArrayList();
    static int[] xDirection = {0, 1, 0, -1};
    static int[] yDirection = {1, 0, -1, 0};
    static Queue<Node> queue = new LinkedList<Node>();

    static int maxLevel = 0;

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
        for (int i = 1; i <= mY; i++) {
            for (int j = 1; j <= mX; j++) {
                if (visited[j][i] != VISIT && adj[j][i] == GOOD) {
                    search(j, i);
                }
            }
        }
        System.out.print(maxLevel);
    }

    static void search(int x, int y) {
        int level = 1; // 경로 기록 인덱스
        parentList.clear();
        parentList.add(0,-1);
        parentList.add(1,-1);
        Node rootNode = new Node(x, y);
        queue.offer(rootNode);

        while (queue.size() != 0) {
            Node tmpNode = queue.poll();
            if (visited[tmpNode.x][tmpNode.y] == VISIT) continue;
            else visited[tmpNode.x][tmpNode.y] = VISIT;
            for (int i = 0; i <= 3; i++) {
                int cX = tmpNode.x + xDirection[i];
                int cY = tmpNode.y + yDirection[i];
                if (isPossibleMove(cX, cY) && adj[cX][cY] == BAD) {
                    parentList.add(level); // 부모 노드 기록
                    queue.offer(new Node(cX, cY));
                }
            }
            level++;
        }
        if (parentList.size() == 1) return;
        int depthCount = 0;
        int parent;
        int index = parentList.get(parentList.size() - 1);
        while (true) {
            parent = parentList.get(index);
            depthCount++;
            if (parent == -1) break;
            index = parent;
        }
        maxLevel = Math.max(depthCount, maxLevel);

    }

    static boolean isPossibleMove(int x, int y) {
        return (x >= 1 && y >= 1 && x <= mX && y <= mY);
    }
}

class Node {
    int x;
    int y;

    Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

