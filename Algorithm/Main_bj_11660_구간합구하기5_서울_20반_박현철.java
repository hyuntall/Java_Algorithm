import java.io.*;
import java.util.*;

public class Main_bj_11660_구간합구하기5_서울_20반_박현철 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int [][] dp = new int [N + 1][N + 1];
		int [][] arr = new int [N][N];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 1; j <= N; j++) {
				//arr[i][j] = Integer.parseInt(st.nextToken());		
				dp[i][j] = (dp[i-1][j] + dp[i][j-1] - dp[i-1][j-1]) + Integer.parseInt(st.nextToken());	
			}
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			sb.append(dp[x2][y2] - (dp[x1 - 1][y2] + dp[x2][y1 - 1] - dp[x1 - 1][y1 - 1])).append("\n");
		}
		System.out.println(sb);
	}
}
