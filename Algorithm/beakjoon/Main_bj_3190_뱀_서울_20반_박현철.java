import java.io.*;
import java.util.*;

public class Main_bj_3190_뱀_서울_20반_박현철 {
	static int N, K, L;
	static int [][] arr;
	static int [] dy = {0, -1, 0, 1};
	static int [] dx = {1, 0, -1, 0};
	static ArrayDeque<int []> snake = new ArrayDeque<>();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N+1][N+1];
		K = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < K; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int row = Integer.parseInt(st.nextToken());
			int col = Integer.parseInt(st.nextToken());
			arr[row][col] = 2;
		}
		
		int L = Integer.parseInt(br.readLine());
		ArrayDeque<int []> comm = new ArrayDeque<>();
		for (int i = 0; i < L; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int X = Integer.parseInt(st.nextToken());
			int C = st.nextToken().charAt(0);
			comm.add(new int[] {X, C});
		}
		
		arr[1][1] = 1;
		snake.add(new int[] {1, 1});
		int d = 0;
		int ans = 1;
		while (true) {
			int head [] = snake.peek();
			int ny = head[0] + dy[d];
			int nx = head[1] + dx[d];
			
			if (0<ny&&ny<=N&&0<nx&&nx<=N&&arr[ny][nx]!=1) {
				snake.addFirst(new int [] {ny,nx});
				if (arr[ny][nx] == 0) {
					int del[] = snake.pollLast();
					arr[del[0]][del[1]] = 0;
				}
				arr[ny][nx] = 1;
			} else break;
			
			if (!comm.isEmpty() && ans == comm.peek()[0]) {
				if (comm.peek()[1] == 'L') d = (d + 1)%4;
				else d = (d+3)%4;
				comm.poll();
			}
			ans++;
		}
		System.out.println(ans);
	}
}
