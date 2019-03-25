package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;


public class Q16947 {
    static int N;

    //간선 정보 저장
    static ArrayList<Integer>[] adj;

    //스패닝트리 방문순서 배열
    static int[] discover;

    //한 정점에서 간선이 3개이상 있으면 지선으로 이어질 가능성 존재
    //이러한 정점을 저장하는 배열
    static Queue<Integer> candidate;

    //답 출력용 배열
    static int[] out;

    //스패닝트리 방문순서 시퀀스
    static int seq;

    //사이클 여부 확인
    static boolean[] isCycle;

    //지선dfs용 방문체크
    static boolean[] visit;

    //사이클을 찾았을 때 시작점과 끝점을 저장할 변수
    static int start;
    static int end;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        adj = new ArrayList[N + 1];
        discover = new int[N + 1];
        isCycle = new boolean[N + 1];
        visit = new boolean[N + 1];
        out = new int[N + 1];
        seq = 1;
        candidate = new LinkedList<>();
        Arrays.fill(discover, -1);

        //입력정보 받음
        for (int i = 0; i < N; i++) {
            String[] a = br.readLine().split(" ");
            int s = Integer.parseInt(a[0]);
            int e = Integer.parseInt(a[1]);
            if (adj[s] == null) {
                adj[s] = new ArrayList<>();
            }
            if (adj[e] == null) {
                adj[e] = new ArrayList<>();
            }
            adj[s].add(e);
            adj[e].add(s);
        }

        //스패닝트리 생성 -> 순환선을 찾아서 isCycle에 순환선에 포함되는 정점 표시
        makeSpanningTree(1, -1);

        //순환선을 다 찾은 뒤 지선을 거리 계산
        while (!candidate.isEmpty()) {
            int n = candidate.poll();
            for (int i : adj[n]) {
                if (isCycle[i]) continue;
                dfs(i, 1);
            }
        }

        //결과 출력
        for (int i = 1; i <= N; i++) {
            System.out.print(out[i] + " ");
        }
    }

    static boolean makeSpanningTree(int n, int prev) {

        //스패닝 트리 생성중 처음 방문한 정점
        if (discover[n] == -1) {
            discover[n] = seq++;
        }

        //현재 정점에서 갈 수 있는 정점들 탐색
        for (int next : adj[n]) {

            //아직 방문하지 않은 정점이라면
            if (discover[next] == -1) {
                //스패닝트리를 계속 (재귀)생성하고 그 결과에 따라 순환선안에 속하는지 체크
                //스패닝 트리 생성 재귀함수의 결과가 return true이고 순환선 안에 속한다면 해당 정점은 사이클
                //방문 순서에서 순환선 안의 정점들은 시작점과 끝점의 방문순서 사이에 존재할 수 밖에 없음
                if (makeSpanningTree(next, n) && discover[start] < discover[n] && discover[end] > discover[n]) {
                    isCycle[n] = true;

                    //순환선 위의 정점이면서 간선이 3개이상이면 후보군에 저장
                    if (adj[n].size() > 2)
                        candidate.add(n);
                    return true;
                }
            }

            //스패닝 트리의 역방향 간선을 찾았으면
            else if (prev != next && discover[n] > discover[next]) {
                //시작점과 끝점을 세팅하고 재귀 true리턴
                isCycle[n] = true;
                isCycle[next] = true;
                start = next;
                end = n;

                //순환선의 시작점과 끝점이 간선 3개 이상이면 후보군에 저장
                if (adj[n].size() > 2)
                    candidate.add(n);
                if (adj[next].size() > 2)
                    candidate.add(next);
                return true;
            }
        }
        return false;
    }


    //순환선을 찾은 다음 지선들 거리를 구하기 위한 dfs
    static void dfs(int index, int d) {
        out[index] = d;
        visit[index] = true;
        if (adj[index] != null) {
            for (int i : adj[index]) {
                if (!isCycle[i] && !visit[i]) {
                    dfs(i, d + 1);
                }
            }
        }
    }
}