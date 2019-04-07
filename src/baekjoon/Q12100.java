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
        max = 0;
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            String[] b = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                int value = Integer.parseInt(b[j]);
                map[i][j] = value;
            }
        }
        search(copyMap(map), 0, UP);
        search(copyMap(map), 0, DOWN);
        search(copyMap(map), 0, RIGHT);
        search(copyMap(map), 0, LEFT);
        System.out.println(max);

    }

    static void search(int[][] dMap, int d, int dir) {
        if (d == 5) return;
        init();
        mapToList(dMap, dir);
        combine();
        int[][] combineMap = listToMap(dir);
        search(copyMap(combineMap), d + 1, UP);
        search(copyMap(combineMap), d + 1, DOWN);
        search(copyMap(combineMap), d + 1, LEFT);
        search(copyMap(combineMap), d + 1, RIGHT);
    }

    static void init() {
        lists = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            lists.add(new LinkedList<>());
        }
    }

    static int[][] copyMap(int[][] oMap) {

        int[][] newMap = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                newMap[i][j] = oMap[i][j];
            }
        }
        return newMap;
    }

    static int[][] listToMap(int d) {
        int tmpIndex = (d == DOWN || d == RIGHT) ? N - 1 : 0;
        int value = 0;
        int[][] tMap = new int[N][N];
        if (tmpIndex == 0) {
            for (int i = 0; i < lists.size(); i++) {
                for (int j = 0; j < lists.get(i).size(); j++) {
                    value = lists.get(i).get(j);
                    if (d == UP) {
                        tMap[tmpIndex][i] = value;
                    }
                    if (d == LEFT) {
                        tMap[i][tmpIndex] = value;
                    }
                    tmpIndex++;
                    max = Math.max(value, max);
                }
                tmpIndex = 0;
            }
        } else {
            for (int i = 0; i < lists.size(); i++) {
                for (int j = 0; j < lists.get(i).size(); j++) {
                    value = lists.get(i).get(j);
                    if (d == DOWN) {
                        tMap[tmpIndex][i] = value;
                    }
                    if (d == RIGHT) {
                        tMap[i][tmpIndex] = value;
                    }
                    tmpIndex--;
                    max = Math.max(value, max);
                }
                tmpIndex = N - 1;
            }
        }
        return tMap;

    }

    static void mapToList(int[][] tMap, int d) {
        if (d == UP || d == LEFT) {
            for (int i = 0; i < N; i++) {
                LinkedList<Integer> tmpList = lists.get(i);
                for (int j = 0; j < N; j++) {
                    if (d == UP && tMap[j][i] != 0) {
                        tmpList.add(tMap[j][i]);
                    }
                    if (d == LEFT && tMap[i][j] != 0) {
                        tmpList.add(tMap[i][j]);
                    }
                }
            }
        }

        if (d == DOWN || d == RIGHT) {
            for (int i = N - 1; i >= 0; i--) {
                LinkedList<Integer> tmpList = lists.get(i);
                for (int j = N - 1; j >= 0; j--) {
                    if (d == DOWN && tMap[j][i] != 0) {
                        tmpList.add(tMap[j][i]);
                    }
                    if (d == RIGHT && tMap[i][j] != 0) {
                        tmpList.add(tMap[i][j]);
                    }

                }
            }
        }
    }

    static void combine() {

        for (int i = 0; i < lists.size(); i++) {
            LinkedList<Integer> tmpList = lists.get(i);
            LinkedList<Integer> newList = new LinkedList<>();
            for (int j = 0; j < tmpList.size(); ) {
                if (j != tmpList.size() - 1 && tmpList.get(j).equals(tmpList.get(j + 1))) {
                    newList.add(tmpList.get(j) * 2);
                    j = j + 2;
                } else {
                    newList.add(tmpList.get(j));
                    j++;
                }
            }
            lists.set(i, newList);
        }


    }

}
