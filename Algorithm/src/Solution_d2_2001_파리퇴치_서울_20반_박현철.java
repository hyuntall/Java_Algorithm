import java.io.*;
import java.util.*;

public class Solution_d2_2001_파리퇴치_서울_20반_박현철 {	
	static StringTokenizer st;
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_d2_2001.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int maxSum = 0;
			int[][] arr = new int [N + M][N + M];
			for (int i = M; i < N + M; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = M; j < N + M; j++) {
					arr[i][j] = arr[i-1][j] + arr[i][j-1] - arr[i-1][j-1] + Integer.parseInt(st.nextToken());
					maxSum = Math.max(arr[i][j] - (arr[i][j-M] + arr[i-M][j] - arr[i-M][j-M]), maxSum);
				}
			}
			sb.append("#" + tc + " " + maxSum + "\n");
		}
		System.out.println(sb);
	}
}
