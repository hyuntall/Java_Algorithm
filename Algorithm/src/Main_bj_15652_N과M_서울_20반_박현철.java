import java.io.*;
import java.util.StringTokenizer;

public class Main_bj_15652_N과M_서울_20반_박현철 {
	static StringTokenizer st;
	static StringBuilder sb;
	static int N, M;
	static int arr [];
	static void comb(int cnt, int start) {
		if (cnt == M) {
			for (int a : arr) sb.append(a).append(" ");
			sb.append("\n");
			return;
		}
		for (int i = start; i <= N; i++) {
			arr[cnt] = i;
			comb(cnt + 1, i);
		}
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[M];
		comb(0, 1);
		System.out.println(sb);
		br.close();
	}
}
