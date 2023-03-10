package a0305;

import java.io.*;
import java.util.*;

public class Main_bj_17472_다리만들기2_서울_20반_박현철 {

	static class Bridge implements Comparable<Bridge>{
		int to, dist;
		public Bridge(int to, int dist) {
			this.to = to;
			this.dist = dist;
		}
		public int compareTo(Bridge o) {
			return Integer.compare(dist, o.dist);
		}
	}
	
	static int N, M, n = 1;
	static int [][] arr;
	static int [] dy = {-1, 1, 0, 0};
	static int [] dx = {0, 0, -1, 1};
	static boolean [][] v;
	static List<Bridge>[] bridges;
	
	static void islandNum(int y, int x, int n) {
		arr[y][x] = n;
		v[y][x] = true;
		for (int i = 0; i < 4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];
			// 인접한 칸이 섬이고, 방문하지 않았다면 n으로 섬 넘버링
			if (0<=ny&&ny<N&&0<=nx&&nx<M&&arr[ny][nx]==1&&!v[ny][nx])
				islandNum(ny, nx, n);
		}
	}
	
	static void linkIsland(int y, int x, int n) {
		for (int i = 0; i < 4; i++) { // 사방 탐색
			int ny = y + dy[i], nx = x + dx[i];
			int len = 0;
			// 이동하려는 방향이 현재 섬이 아닐 경우 거리를 늘려가며 반복
			while (0<=ny&&ny<N&&0<=nx&&nx<M&&arr[ny][nx]!=n) {
				if (arr[ny][nx] > 0) { // 섬을 만났을 경우
					// 거리가 1보다 크다면 인접 리스트에 추가
					if (len>1) bridges[arr[y][x]].add(new Bridge(arr[ny][nx], len));
					break;
				}
				// 해당 방향으로 좌표 이동 및 거리 증가
				ny += dy[i];
				nx += dx[i];
				len++;
			}
		}
	}
	
	static int prim() {
		PriorityQueue<Bridge> pq = new PriorityQueue<>();
		boolean [] isLinked = new boolean[n+1];
		int total = 0, cnt = 1;
		pq.offer(new Bridge(1, 0));
		while (!pq.isEmpty()) {
			Bridge cur = pq.poll();
			if (isLinked[cur.to]) continue;
			isLinked[cur.to] = true;
			total += cur.dist;
			for (Bridge bridge : bridges[cur.to])
				if (!isLinked[bridge.to]) pq.offer(bridge);
			cnt++;
		}
		// cnt가 섬의 갯수와 다르다면 모든 섬을 연결할 수 없으므로 -1 리턴
		return cnt==n?total:-1;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		v = new boolean[N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) arr[i][j] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 0; i < N; i++) // 각 섬마다 넘버링
			for (int j = 0; j < M; j++) 
				if (!v[i][j]&&arr[i][j] == 1) islandNum(i, j, n++);

		bridges = new ArrayList[n]; // 섬의 갯수만큼 인접 리스트 생성 및 초기화
		for (int i = 1; i < n; i++) bridges[i] = new ArrayList<>();
		
		for (int i = 0; i < N; i++) // 각 칸마다 인접한 섬 사방탐색
			for (int j = 0; j < M; j++) 
				if (arr[i][j] > 0) linkIsland(i, j, arr[i][j]);
			
		System.out.println(prim());
	}
}
