package a0313;

import java.io.*;
import java.util.*;

public class Main_bj_2665_미로만들기_서울_20반_박현철 {
	static int N;
	static int [][] arr;
	static boolean [][] v;
	static int [] dy = {-1, 1, 0, 0};
	static int [] dx = {0, 0, -1, 1};
	static int dijkstra() {
		PriorityQueue<int []> pq = new PriorityQueue<>((o1,o2)->Integer.compare(o1[0],o2[0]));
		pq.offer(new int[] {0, 0, 0});
		v[0][0] = true;
		while (!pq.isEmpty()) {
			int cur [] = pq.poll();
			int y = cur[1], x = cur[2];
			if (y==N-1&&x==N-1) return cur[0];
			for (int i = 0; i < 4; i++) {
				int ny = y + dy[i], nx = x + dx[i];
				if (0<=ny&&ny<N&&0<=nx&&nx<N&&!v[ny][nx]) {
					v[ny][nx] = true;
					int len = cur[0];
					if (arr[ny][nx]==0) len++;
					pq.offer(new int[] {len, ny, nx});
				}
			}
		}
		return 0;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int [N][N];
		v = new boolean [N][N];
		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			for (int j = 0; j < N; j++) arr[i][j] = line.charAt(j)-'0';
		}
		System.out.println(dijkstra());
	}
}
