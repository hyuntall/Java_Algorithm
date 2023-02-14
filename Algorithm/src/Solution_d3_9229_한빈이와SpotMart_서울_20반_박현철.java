import java.io.*;
import java.util.*;

public class Solution_d3_9229_한빈이와SpotMart_서울_20반_박현철 {
	static int N, M, maxSum;
	static int [] a;
	static int [] b;
	static void comb(int cnt, int start) {
		if (cnt == 2) {
			int sum = b[0] + b[1];
			if (sum > maxSum && sum <= M) maxSum = sum;
			return;
		}
		for (int i = start; i < N; i++) {
			b[cnt] = a[i];
			comb(cnt + 1, i + 1);
		}
	}
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_d3_9229.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			maxSum = -1;
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine(), " ");
			a = new int [N];
			b = new int [2];
			for (int i = 0; i < N; i++)  a[i] = Integer.parseInt(st.nextToken());
			comb(0, 0);
			sb.append("#" + t + " " + maxSum + "\n");
		}
		System.out.println(sb);
	}
}
