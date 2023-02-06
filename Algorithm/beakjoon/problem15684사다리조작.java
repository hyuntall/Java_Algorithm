package beakjoon;

import java.io.*;
import java.util.*;

public class problem15684사다리조작 {
	static int N, M, H;
	static int [][] arr;
	static StringTokenizer st;
	static boolean isAble;
	
	static boolean check() {
		for (int i = 1; i <= N; i++) {
			int x = i;
			int y = 0;
			while (++y <= H) {
				if (arr[y][x] == 1) x++;
				else if (arr[y][x] == 2) x--;
			}
			if (x != i) return false;
		}
		return true;
	}
	
	static void dfs(int x, int y, int cnt, int limit) {
		if (cnt == limit) {
			//if(limit==3) for(int a[]:arr) System.out.println(Arrays.toString(a));
			//System.out.println();
			if(check()) isAble = true;
			return;
		}
		for (int i = y; i <= H; i++) {
			for (int j = x; j < N; j++) {
				if (arr[i][j] == 0 && arr[i][j+1] == 0) {
					arr[i][j] = 1;
					arr[i][j + 1] = 2;
					dfs(1, 1, cnt+1, limit);
					arr[i][j] = 0;
					arr[i][j+1] = 0;
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		arr = new int [H + 1][N + 1];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			arr[a][b] = 1;
			arr[a][b+1] = 2;
		}
		for (int limit = 0; limit <= 3; limit++) {
			dfs(1, 1, 0, limit);
			if (isAble) {
				System.out.println(limit);
				return;
			}
		}
		System.out.println(-1);
	}
}
