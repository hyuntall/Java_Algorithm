import java.io.*;
import java.util.*;

public class Main_bj_15649_N과M_서울_20반_박현철 {
	static StringBuilder sb = new StringBuilder();
	static int N, M;
	static boolean v[];
	static int arr[];
	static void perm(int cnt) {
		if (cnt == M) {
			for (int a : arr) sb.append(a).append(" ");
			sb.append("\n");
			return;
		}
		for (int i = 1; i <= N; i++) {
			if (v[i]) continue;
			arr[cnt] = i;
			v[i] = true;
			perm(cnt + 1);
			v[i] = false;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		v = new boolean [N + 1];
		arr = new int [M];
		perm(0);
		System.out.println(sb);
	}
}
