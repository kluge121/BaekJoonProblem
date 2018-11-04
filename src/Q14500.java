import java.util.Scanner;

public class Q14500 {

    static int mX, mY;
    static int[][] map;

    static int[] square = {1, -1, 1, -1};

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        mY = sc.nextInt();
        mX = sc.nextInt();
        map = new int[mX + 1][mY + 1];


        // 입력부
        for (int i = 1; i <= mY; i++) {
            for (int j = 1; j <= mX; j++) {
                map[j][i] = sc.nextInt();
            }
        }

        //모든 블록, 모든 방향을 다 넣어본다.
        //회전이나 대칭도 가능하다

        for (int i = 0; i <= 4; i++) {
        }

    }


    static boolean isMoveRange(int x, int y) {
        return (x <= mX && y <= mY && x >= 1 && y >= 1);
    }


}
