import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static List<Integer>[] list;
    static boolean[] v;
    static int[] arr;
    static int minDif = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        list = new ArrayList[N];
        v = new boolean[N];
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            list[i] = new ArrayList<>();
            int population = Integer.parseInt(st.nextToken());
            arr[i] = population;
        }
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int n = Integer.parseInt(st.nextToken());
            for (int j = 0; j < n; j++) {
                // 각 리스트에 연결된 숫자는 구역 번호
                int to = Integer.parseInt(st.nextToken()) - 1;
                list[i].add(to);
                //list[to].add(i);
            }
        }

        subs(0);
        if (minDif != Integer.MAX_VALUE)
            System.out.println(minDif);
        else
            System.out.println(-1);
        br.close();
    }

    private static void subs(int cnt) {
        if (minDif == 0)
            return;
        // 인덱스가 1부터 시작이므로 N초과시 두 구역 검사
        if (cnt == N) {
            // a구역의 번호와 b구역의 번호를 담을 리스트
            ArrayList<Integer> a = new ArrayList<>();
            ArrayList<Integer> b = new ArrayList<>();
            int aSum = 0, bSum = 0;
            for (int i = 0; i < N; i++) {
                if (v[i]) {
                    a.add(i);
                    aSum += arr[i];
                } else {
                    b.add(i);
                    bSum += arr[i];
                }
            }
            // 하나 이상일 경우에 둘다 연결되어 있는지 체크
            if (aSum != 0 && bSum != 0 && isConnect(a, true) && isConnect(b, false)) {
                minDif = Math.min(minDif, Math.abs(aSum - bSum));
            }
            //System.out.println();
            return;
        }
        v[cnt] = true;
        subs(cnt + 1);
        v[cnt] = false;
        subs(cnt + 1);
    }

    private static boolean isConnect(ArrayList<Integer> l, boolean b) {
        ArrayDeque<Integer> q = new ArrayDeque<>();
        boolean[] visited = new boolean[N];
        // 시작 정점
        //System.out.println(l);
        int start = l.get(0);
        visited[start] = true;
        q.offer(start);
        while (!q.isEmpty()) {
            Integer i = q.poll();
            l.remove(i);
            //System.out.println(i);
            // 리스트에 있는 모든 구역을 방문했으면 연결된거임
            if (l.isEmpty()) {
                return true;
            }
            // 인접구역을 큐에 담는다.
            for (int n : list[i]) {
                if (!visited[n]&&v[n] == b) {
                    visited[n] = true;
                    q.offer(n);
                }
            }
        }
        //System.out.println("false");
        // 다돌았는데 리스트가 안비었으면 연결되지 않은 것
        return false;
    }

}