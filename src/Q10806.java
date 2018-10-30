import java.util.Scanner;

public class Q10806 {


    static int[][] adj;
    static int[] visited;
    final static int POSSIBLE = 1;
    final static int VISIT = 1;

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int cityCount = sc.nextInt();
        int bridgeCount = sc.nextInt();
        adj = new int[cityCount + 1][cityCount + 1];

        for (int i = 0; i < bridgeCount; i++) {
            int tmp1 = sc.nextInt();
            int tmp2 = sc.nextInt();
            adj[tmp1][tmp2] = POSSIBLE;
            adj[tmp2][tmp1] = POSSIBLE;
        }

    }

    static void search(int vertex) {

        if (visited[vertex] == VISIT) return;


    }
}
