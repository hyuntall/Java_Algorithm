import java.io.*;
import java.util.*;

public class Main {
	static int N, M, K;
	static long []arr, tree;
	
	static void update(int i, long num) {
		while (i <= N) {
			tree[i] += num;
			i += (i & -i);
		}
	}
	
	static long sum(int i) {
		long ans = 0;
		while (i > 0) {
			ans += tree[i];
			i -= (i & -i);
		}
		return ans;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		arr = new long[N+1]; tree = new long[N+1];
		for (int i = 1; i <= N; i++) 
			update(i, arr[i] = Long.parseLong(br.readLine()));
		for (int i = 0; i < M+K; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			if (a == 1) {
				int b = Integer.parseInt(st.nextToken());
				long c = Long.parseLong(st.nextToken());
				long tmp = arr[b];
				arr[b] = c;
				update(b, c-tmp);
			}
			else {
				int b = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				sb.append(sum(c) - sum(b-1) + "\n");
			}
		}
		System.out.println(sb);
		br.close();
	}
}