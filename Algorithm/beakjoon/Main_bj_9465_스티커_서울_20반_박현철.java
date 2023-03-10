package a0309;

import java.io.*;
import java.util.*;

public class Main_bj_9465_스티커_서울_20반_박현철 {
	static int N;
	static int [][] arr;
	static int [][] dp;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			N = Integer.parseInt(br.readLine());
			arr = new int[2][N+2];
			dp = new int[2][N+2];
			for (int i = 0; i < 2; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				for (int j = 2; j < N+2; j++) arr[i][j] = Integer.parseInt(st.nextToken());
			}
			for (int i = 2; i < N+2; i++) {
				dp[0][i] = Math.max(dp[1][i-2], dp[1][i-1]) + arr[0][i];
				dp[1][i] = Math.max(dp[0][i-2], dp[0][i-1]) + arr[1][i];
			}
			System.out.println(Math.max(dp[0][N+1], dp[1][N+1]));
		}
	}
}
