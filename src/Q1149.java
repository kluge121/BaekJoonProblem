import java.util.Scanner;

public class Q1149 {
    static int[][] cost; // 각 집의 페인팅 비용
    static int[][] cache; // 메모이제이션
    static int houseCount; // 집의 개수
    final static int RED = 1;
    final static int GREEN = 2;
    final static int BLUE = 3;

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        houseCount = sc.nextInt();
        cost = new int[houseCount][4];
        cache = new int[houseCount][4];
        // 굳이 컬러 배열공간을 4로 둔 것은 1,2,3에 컬러를 할당하고
        // 초기화 값 0을 활용한다.. 였는데 지금 생각해보니 불필요한 것..

        for (int i = 0; i < houseCount; i++) {
            cost[i][RED] = sc.nextInt();
            cost[i][GREEN] = sc.nextInt();
            cost[i][BLUE] = sc.nextInt();
        }
        //문제에서 주어진 입력 모두 받음
        //첫 번째 집을 무슨색으로 칠할 것인가 -> 빨초파 각각 시작
        int redStart = search(0, RED);
        int greenStart = search(0, GREEN);
        int blueStart = search(0, BLUE);
        System.out.print(Math.min(redStart, Math.min(greenStart, blueStart)));
    }

    //재귀 탐색을 위한 부분
    //리턴 값을 n번째까지 최소 비용
    public static int search(int n, int preColor) {
        //재귀의 첫 시작은 역시 종료 조건, n은 0부터 시작하지만 n==housecount를 해야
        //마지막 집까지 확인하고 그 다음 재귀 호출시 여기서 재귀가 끝난것을 확인 0을 리턴
        if (n == houseCount) return 0;
        //DP문제니 당연히 메모이제이션 체크, 중복계산을 방지하기 위함
        if (cache[n][preColor] != 0) {
            return cache[n][preColor];
        }
        int value1;
        int value2;
        // 이웃한 색이 같을 수는 없기 때문에 이전 색을 확인한 후 제외한 재귀 호출
        //(이번 집의 비용 + 그 뒤의 집의 최소비용을 구하는 재귀함수)
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
        // 해당 재귀시점에서 최소값을 찾아 메모이제이션하고 리턴
        cache[n][preColor] = Math.min(value1, value2);
        return cache[n][preColor];
    }
}
