package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;

public class Q12100 {

    static int N;
    static int[][] map;
    static int max;
    static final int UP = 0;
    static final int RIGHT = 1;
    static final int DOWN = 2;
    static final int LEFT = 3;

    static ArrayList<LinkedList<Integer>> lists;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        max = 0;
        for (int i = 0; i < N; i++) {
            String[] a = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                int value = Integer.parseInt(a[j]);
                map[i][j] = value;
            }
        }
//        dfs(copyMap(map), UP, 0, false);
//        dfs(copyMap(map), DOWN, 0, false);
        dfs(copyMap(map), LEFT, 0, "L");
//        dfs(copyMap(map), RIGHT, 0, false);


        System.out.println(max);


    }

    static boolean dfs(int[][] map, int dir, int d, String a) {
        if (d == 5) return true;

        initList();
        mapToList(map, dir);
        boolean flag1 = combine(d, dir);
        int[][] combineMap = listToMap(dir);

//        System.out.println();
//        for (int i = 0; i < N; i++) {
//            for (int j = 0; j < N; j++) {
//                System.out.print(combineMap[i][j] + " ");
//            }
//            System.out.println();
//        }


        if (d == 0) {
            dfs(copyMap(combineMap), UP, d + 1, a);
        } else if (d == 1) {
            dfs(copyMap(combineMap), UP, d + 1, a);
        } else if (d == 2) {
            dfs(copyMap(combineMap), UP, d + 1, a);
        } else if (d == 3) {
            dfs(copyMap(combineMap), UP, d + 1, a);
        }
//
//        if (dfs(copyMap(combineMap), UP, d + 1, a+"U")) {
//            System.out.println(a+"#");
//        } else if (dfs(copyMap(combineMap), DOWN, d + 1, a+"D")) {
//            System.out.println(a+"!");
//        } else if (dfs(copyMap(combineMap), LEFT, d + 1, a+"L")) {
//            System.out.println(a+"@");
//        } else if (dfs(copyMap(combineMap), RIGHT, d + 1, a+"R")) {
//            System.out.println(a+"%");
//        }
////        dfs(copyMap(combineMap), UP, d + 1);
//        dfs(copyMap(combineMap), DOWN, d + 1);
//        dfs(copyMap(combineMap), LEFT, d + 1);
//        dfs(copyMap(combineMap), RIGHT, d + 1);

        return flag1;
    }


    //맵 복사
    static int[][] copyMap(int[][] map) {
        int[][] newMap = new int[N][N];
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++) {
                newMap[i][j] = map[i][j];
                max = Math.max(map[i][j], max);
            }
        return newMap;
    }

    //링크드 리스트 초기화
    static void initList() {
        lists = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            lists.add(new LinkedList<>());
        }
    }

    //배열을 링크드로 표현
    static void mapToList(int[][] map, int d) {
        initList();
        if (d == UP) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    lists.get(i).add(map[j][i]);
                }
            }
        } else if (d == LEFT) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    lists.get(i).add(map[i][j]);
                }
            }
        } else if (d == DOWN) {
            for (int i = 0; i < N; i++) {
                for (int j = N - 1; j >= 0; j--) {
                    lists.get(i).add(map[j][i]);
                }
            }
        } else if (d == RIGHT) {
            for (int i = 0; i < N; i++) {
                for (int j = N - 1; j >= 0; j--) {
                    lists.get(i).add(map[i][j]);
                }
            }
        }
    }

    //리스트를 맵으로 표현
    static int[][] listToMap(int d) {
        int[][] newMap = new int[N][N];

        if (d == UP) {
            for (int i = 0; i < lists.size(); i++) {
                for (int j = 0; j < lists.get(i).size(); j++) {
                    newMap[j][i] = lists.get(i).get(j);
                }
            }
        } else if (d == LEFT) {
            for (int i = 0; i < lists.size(); i++) {
                for (int j = 0; j < lists.get(i).size(); j++) {
                    newMap[i][j] = lists.get(i).get(j);

                }
            }
        } else if (d == DOWN) {
            for (int i = 0; i < lists.size(); i++) {
                int subIndex = 0;
                for (int j = N - 1; j >= N - lists.get(i).size(); j--) {
                    newMap[j][i] = lists.get(i).get(subIndex++);
                }
            }
        } else if (d == RIGHT) {
            for (int i = 0; i < lists.size(); i++) {
                int subIndex = 0;
                for (int j = N - 1; j >= N - lists.get(i).size(); j--) {
                    newMap[i][j] = lists.get(i).get(subIndex++);
                }

            }
        }


        return newMap;
    }

    //숫자 합체!
    static boolean combine(int d, int dir) {
        boolean flag = false;
        for (int i = 0; i < N; i++) {
            LinkedList<Integer> list = lists.get(i);
            LinkedList<Integer> newList = new LinkedList<>();

            for (int j = 0; j < N; ) {
                if (j != N - 1 && list.get(j).equals(list.get(j + 1))) {
                    newList.add(list.get(j) * 2);
                    if (list.get(j) * 2 == 1024) {
                        flag = true;
                    }
                    j = j + 2;
                } else if (!list.get(j).equals(0)) {
                    newList.add(list.get(j));
                    j++;
                } else {
                    j++;
                }

            }
            lists.set(i, newList);
        }
        return flag;
    }
}
