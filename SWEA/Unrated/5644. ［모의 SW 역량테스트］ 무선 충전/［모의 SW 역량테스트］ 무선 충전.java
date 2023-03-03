import java.io.*;
import java.util.*;

public class Solution {
	static int M, A;
	static int [][] charger;
	static int [] moveA, moveB;
	static int [] dy = {0, -1, 0, 1, 0};
	static int [] dx = {0, 0, 1, 0, -1};
	static int aY, aX, bY, bX;
	
	static int charge() {
		int sumE = 0;
		for (int a = 0; a < A; a++) {
			for (int b = 0; b < A; b++) {
				int E = 0;
				int aE = (Math.abs(charger[a][1]-aY) + Math.abs(charger[a][0]-aX) <= charger[a][2])?charger[a][3]:0;
				int bE = (Math.abs(charger[b][1]-bY) + Math.abs(charger[b][0]-bX) <= charger[b][2])?charger[b][3]:0;
				if (a==b) E = Math.max(aE, bE);
				else E = aE+bE;
				sumE = Math.max(sumE, E);
			}
		}
		return sumE;
	}
	
	static void move(int i) {
		aY += dy[moveA[i]];
		aX += dx[moveA[i]];
		bY += dy[moveB[i]];
		bX += dx[moveB[i]];
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			M = Integer.parseInt(st.nextToken());
			A = Integer.parseInt(st.nextToken());
			moveA = new int[M];
			moveB = new int[M];
			charger = new int[A][4];
			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < M; i++) moveA[i] = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < M; i++) moveB[i] = Integer.parseInt(st.nextToken());
			for (int i = 0; i < A; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < 4; j++) charger[i][j] = Integer.parseInt(st.nextToken());
			}
			aY = 1;aX = 1;bY = 10;bX = 10;
			int ans = charge();
			for (int i = 0; i < M; i++) {
				move(i);
				ans += charge();
			}
			sb.append("#"+t+" "+ans+"\n");
		}
		System.out.println(sb);
		br.close();
	}
}