import java.io.*;
import java.util.*;

public class Main {
	static int [][] arr = new int[200][200];
	static boolean [][][] v = new boolean[200][200][31];
	static int [] dy = {-1, 1, 0, 0}, dx = {0, 0, -1, 1};
	static int [] hdy = {1, 2, 2, 1, -1, -2, -2, -1}, hdx = {-2, -1, 1, 2, 2, 1, -1, -2};
	
	static int bfs(int W, int H, int K) {
		ArrayDeque<int []> q = new ArrayDeque<>();
		q.offer(new int[] {0, 0, 0, 0});
		v[0][0][0] = true;
		
		while(!q.isEmpty()) {
			int cur[] = q.poll();
			int y=cur[0],x=cur[1],k=cur[2],l=cur[3];
			
			// 목적지에 도착 시
			if (y==H-1&&x==W-1) return l;
			
			// 한칸 씩 이동하는 경우의 수
			for (int i = 0; i < 4; i++) {
				int ny = y + dy[i], nx = x + dx[i];;
				// 현재 말처럼 이동한 횟수에서 처음 방문한 지점일 때
				if (0<=ny&&ny<H&&0<=nx&&nx<W&&
				arr[ny][nx]==0&&!v[ny][nx][k]) {
					v[ny][nx][k] = true;
					q.offer(new int[] {ny, nx, k, l+1});
				}
			}
			
			if (k >= K) continue;
			// 말처럼 움직일 수 있는 횟수가 남았다면
			for (int i = 0; i < 8; i++) {
				int ny = y + hdy[i], nx = x + hdx[i];
				// 말처럼 이동할 지점이 처음 방문한 지점일 때
				if (0<=ny&&ny<H&&0<=nx&&nx<W&&
				arr[ny][nx]==0&&!v[ny][nx][k+1]) {
					// 말처럼 k번 이동한 경우의 해당 지점 방문 여부
					v[ny][nx][k+1] = true;
					q.offer(new int[] {ny, nx, k+1, l+1});
				}
			}
		}
		// 목적지에 도달할 수 없을 시
		return -1;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int K = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int W = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());
		
		for (int i = 0; i < H; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < W; j++) arr[i][j] = Integer.parseInt(st.nextToken());
		}
		
		System.out.println(bfs(W,H,K));
	}
}