import java.io.*;
import java.util.*;

public class Solution_d3_5215_햄버거다이어트_서울_20반_박현철 {
	static int arr[][];
	static int N, L, ans;
	static void subs(int cnt, int flv, int cal) {
		if (cal > L) return;
		if (cnt == N) {
			ans = Math.max(ans, flv);
			return;
		}
		subs(cnt + 1, flv + arr[cnt][0], cal + arr[cnt][1] );
		subs(cnt + 1, flv, cal);
	}
	
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_d2_5125.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			arr = new int[N][2];
			ans = 0;
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				arr[i][0] = Integer.parseInt(st.nextToken());
				arr[i][1] = Integer.parseInt(st.nextToken());
			}
			subs(0, 0, 0);
			sb.append("#" + t + " " + ans + "\n");
		}
		br.close();
		System.out.println(sb);
	}
}
