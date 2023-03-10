package a0305;

import java.io.*;
import java.util.*;

public class Main_bj_16236_아기상어_서울_20반_박현철 {
	static int N, sharkX, sharkY, size=2, exp, ans;
	static int [][] arr;
	static boolean [][] v;
	static int [] dy = {-1, 0, 1, 0}; //상좌하우
	static int [] dx = {0, -1, 0, 1};
	static PriorityQueue<int []> q;
	static boolean bfs() {
		q = new PriorityQueue<int []>((o1, o2) -> {
			if(o1[2]!=o2[2]) return Integer.compare(o1[2], o2[2]);
			if(o1[0]!=o2[0]) return Integer.compare(o1[0], o2[0]);
			return Integer.compare(o1[1], o2[1]);
		});
		v = new boolean[N][N];
		v[sharkY][sharkX] = true;
		q.offer(new int[] {sharkY, sharkX, 0});
		while(!q.isEmpty()) {
			int cur[] = q.poll();
			int y = cur[0];
			int x = cur[1];
			if (arr[y][x]>0 && arr[y][x] < size) {
				ans+=cur[2];
				exp++;
				arr[y][x] = 0;
				if (exp==size) {
					size++;
					exp = 0;
				}
				sharkY = y; sharkX = x;
				return true;
			}
			for (int i = 0; i < 4; i++) {
				int ny = y + dy[i];
				int nx = x + dx[i];
				if (0<=ny&&ny<N&&0<=nx&&nx<N&&!v[ny][nx]&&arr[ny][nx]<=size) {
					v[ny][nx] = true;
					q.offer(new int[] {ny, nx, cur[2]+1});
				}
			}
		}
		return false;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if (arr[i][j]==9) {
					sharkY = i; sharkX = j;
					arr[i][j] = 0;
				}
			}
		}
		while(bfs());
		System.out.println(ans);
	}
}
