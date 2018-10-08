import java.util.Scanner;

public class Q1149 {
    static int[][] cost;
    static int[][] cache;
    static int houseCount;
    final static int RED = 1;
    final static int GREEN = 2;
    final static int BLUE = 3;
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        houseCount = sc.nextInt();
        cost = new int[houseCount][4];
        cache = new int[houseCount][4];
        for (int i = 0; i < houseCount; i++) {
            cost[i][RED] = sc.nextInt();
            cost[i][GREEN] = sc.nextInt();
            cost[i][BLUE] = sc.nextInt();
        }
        int redStart = search(0, RED);
        int greenStart = search(0, GREEN);
        int blueStart = search(0, BLUE);
        System.out.print(Math.min(redStart, Math.min(greenStart, blueStart)));
    }
    public static int search(int n, int preColor) {
        if (n == houseCount) return 0;
        if (cache[n][preColor] != 0) {
            return cache[n][preColor];
        }
        int value1;
        int value2;
        if (preColor == RED) {
            value1 = cost[n][RED] + search(n + 1, GREEN);
            value2 = cost[n][RED] + search(n + 1, BLUE);
        } else if (preColor == GREEN) {
            value1 = cost[n][GREEN] + search(n + 1, RED);
            value2 = cost[n][GREEN] + search(n + 1, BLUE);
        } else {
            value1 = cost[n][BLUE] + search(n + 1, RED);
            value2 = cost[n][BLUE] + search(n + 1, GREEN);
        }
        cache[n][preColor] = Math.min(value1, value2);
        return cache[n][preColor];
    }
}
