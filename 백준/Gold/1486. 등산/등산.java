import java.io.*;
import java.util.*;

public class Main {
	static int N, M, T, D;
	static int [][] map, dist, down;
	static int [] dy = {-1, 1, 0, 0};
	static int [] dx = {0, 0, -1, 1};
	static int ans;
	static PriorityQueue<int []> q = new PriorityQueue<int[]>(new Comparator<int[]>() {

		@Override
		public int compare(int[] o1, int[] o2) {
			return o1[2]-o2[2];
		}
	});
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		dist = new int[N][M];
		down = new int [N][M];
		for (int i = 0; i < N; i++) {
			String line =br.readLine();
			for (int j = 0; j < M; j++) {
				int c = line.charAt(j);
				if (c >= 'A' && c <= 'Z')
					c -= 'A';
				else if (c >= 'a' && c <= 'z')
					c -= 'a' - 26;
				map[i][j] = c;
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (i == 0 && j == 0) continue;
				dijkstra(i, j, false);
			}
		}
		dijkstra(0, 0, true);
		
		System.out.println(ans);
	}
	
	static void dijkstra(int iy, int jx, boolean up) {
		for (int i = 0; i < N; i++)
			for (int j = 0; j < M; j++)
				dist[i][j] = Integer.MAX_VALUE;
		// y, x, 남은 시간, 방문한 최대 높이
		q.offer(new int[] {iy, jx, 0, 0});
		while(!q.isEmpty()) {
			int cur[] = q.poll();
			int y = cur[0];
			int x = cur[1];
			if (!up && y == 0 && x == 0) {
				down[iy][jx] = cur[2];
				q.clear();
				return;
			}
			if(up && cur[2] + down[y][x] > D) continue;
			if(up && map[y][x] > ans) ans = map[y][x]; 
			
			for (int i = 0; i < 4; i++) {
				int ny = y + dy[i];
				int nx = x + dx[i];
				
				if (ny < 0 || ny >= N || nx < 0 || nx >= M) continue;
				if (Math.abs(map[y][x] - map[ny][nx]) > T) continue;
				
				int t;
				if (map[y][x] >= map[ny][nx]) t = cur[2] + 1;
				else t = cur[2] + (int)Math.pow(map[y][x] - map[ny][nx],2);
				
				if (t > D) continue;
				if (dist[ny][nx] > t) {
					dist[ny][nx] = t;
					q.offer(new int[] {ny, nx, t, Math.max(map[y][x], map[ny][nx])});
				}
			}
		}
	}
}