import java.io.*;
import java.util.*;

public class Main {
	static int N, M, ans = Integer.MAX_VALUE;
	static int [][]arr;
	static int [] dy = {-1, 1, 0, 0};
	static int [] dx = {0, 0, -1, 1};
	static boolean [][] v;
	static void bfs() {
		ArrayDeque<int []> q = new ArrayDeque<>();
		q.offer(new int[] {1, 1, 1});
		v[1][1] = true;
		while(!q.isEmpty()) {
			int cur[] = q.poll();
			int y = cur[0], x = cur[1], l = cur[2];
			if (y==N&&x==M) {
				ans = Math.min(ans, l);
				break;
			}
			for (int i=0; i<4; i++) {
				int ny = y+dy[i];
				int nx = x+dx[i];
				if(0<ny&&ny<=N&&0<nx&&nx<=M&&!v[ny][nx]&&arr[ny][nx]==1) {
					v[ny][nx] = true;
					q.offer(new int[] {ny,nx,l+1});
				}
			}
			
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N+1][M+1];
		v = new boolean[N+1][M+1];
		for (int i = 1; i <= N; i++) {
			String line = br.readLine();
			for (int j = 1; j <= M; j++) arr[i][j] = line.charAt(j-1)-'0';
		}
		bfs();
		System.out.println(ans);
	}
}