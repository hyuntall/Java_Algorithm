import java.io.*;
import java.util.*;

public class Main {
	static int N, M, hands[][];
	static char map[][];
	static boolean v[][];
	static ArrayDeque<int []> q;
	static ArrayDeque<int []> d = new ArrayDeque<>();
	static int [] dy = {-1, 1, 0, 0};
	static int [] dx = {0, 0, -1, 1};
	
	static int bfs() {
		while(!q.isEmpty()) {
			int cur[] = q.poll();
			int y = cur[0], x = cur[1];
			v[y][x] = true;
			for (int i = 0; i < 4; i++) {
				int ny = y+dy[i], nx = x+dx[i];
				if (0<=ny&&ny<N&&0<=nx&&nx<M&&map[ny][nx]!='X'&&map[ny][nx]!='*'&&!v[ny][nx]) {
					if (map[ny][nx]=='D') return cur[2]+1;
					if ((hands[ny][nx]==0?Integer.MAX_VALUE:hands[ny][nx])<=cur[2]+1) continue;
					v[ny][nx] = true;
					q.offer(new int[] {ny, nx, cur[2]+1});
				}
			}
		}
		return -1;
	}
	
	static void bfs2() {
		while(!d.isEmpty()) {
			int cur[] = d.poll();
			int y = cur[0], x = cur[1];
			for (int i = 0; i < 4; i++) {
				int ny = y + dy[i], nx = x + dx[i];
				if (0<=ny&&ny<N&&0<=nx&&nx<M&&hands[ny][nx]==0&&map[ny][nx]=='.') {
					hands[ny][nx] = cur[2]+1;
					d.offer(new int[] {ny, nx, cur[2]+1});
				}
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		q = new ArrayDeque<>();
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		hands = new int[N][M];
		v = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = line.charAt(j);
				if (map[i][j]=='S') {
					q.offer(new int[] {i, j, 0});
					map[i][j] = '.';
				}
				if (map[i][j]=='*') {
					d.offer(new int[] {i, j, 0});
					v[i][j] = true;
				}
			}
		}
		bfs2();
		v = new boolean[N][M];
		int ans = bfs();
		System.out.println(ans!=-1?ans:"KAKTUS");
		br.close();
	}
}