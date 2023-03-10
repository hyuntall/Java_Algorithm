package a0307;

import java.io.*;
import java.util.*;

public class Main_bj_1932_정수삼각형_서울_20반_박현철 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int [][] dp = new int [N+1][N+1];
		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int level = st.countTokens();
			for (int j = 1; j <= level; j++) 
				dp[i][j] = Math.max(dp[i-1][j-1], dp[i-1][j]) + Integer.parseInt(st.nextToken());
		}
		int ans = 0;
		for (int i = 1; i <= N; i++) 
			ans = Math.max(ans, dp[N][i]);
		System.out.println(ans);
	}
}
