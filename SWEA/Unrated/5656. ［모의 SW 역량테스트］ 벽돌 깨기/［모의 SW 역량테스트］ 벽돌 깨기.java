import java.io.*;
import java.util.*;

public class Solution {
	static int N, W, H, ans;
	static int [][] originArr, arr;
	static int [] b;
	static int [] dy = {-1, 1, 0, 0};
	static int [] dx = {0, 0, -1, 1};
	static ArrayDeque<int []> q = new ArrayDeque<>();
	
	static void shoot(int x) {
		for (int i = 0; i < H; i++)
			if (arr[i][x]>0) {
				crash(i, x);
				fall();
				return;
			}
	}
	
	static void crash(int y, int x) {
		q.offer(new int[] {y, x});
		while (!q.isEmpty()) {
			int [] brick = q.poll();
			y = brick[0];
			x = brick[1];
			int len = arr[y][x];
			arr[y][x] = 0;
			for (int i = 1; i < len; i++) {
				for (int d = 0; d < 4; d++) {
					int ny = y + dy[d]*i;
					int nx = x + dx[d]*i;
					if (0<=ny&&ny<H&&0<=nx&&nx<W)
						q.offer(new int[] {ny, nx});
				}
			}
		}
	}
	
	static void fall() {
		for (int j = 0; j < W; j++) {
			for (int i = H-1; i >= 1; i--) {
				if (arr[i][j] > 0) continue;
				find:for (int k = i-1; k >= 0; k--) {
					if(arr[k][j]>0) {
						arr[i][j] = arr[k][j];
						arr[k][j] = 0;
						break find;
					}
				}
			}
		}
	}
	
	static int count() {
		int sum = 0;
		for (int i = 0; i < H; i++) 
			for (int j = 0; j < W; j++)
				if (arr[i][j] > 0) sum++;
		return sum;
	}
	
	static void perm(int cnt) {
		if (ans == 0) return;
		if (cnt == N) {
			for (int i = 0; i < H; i++)
				for (int j = 0; j < W; j++)
					arr[i][j] = originArr[i][j];
			for (int x : b) shoot(x);
			ans = Math.min(ans, count());
			return;
		}
		for (int i = 0; i < W; i++) {
			b[cnt] = i;
			perm(cnt + 1);
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			originArr = new int[H][W];
			arr = new int[H][W];
			b = new int[N];
			for (int i = 0; i < H; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < W; j++) originArr[i][j] = Integer.parseInt(st.nextToken());
			}
			ans = Integer.MAX_VALUE;
			perm(0);
			sb.append("#"+t+" "+ans+"\n");
		}
		System.out.println(sb);
		br.close();
	}
}