import java.io.*;
import java.util.*;

public class Main {
	static int N, M, K;
	static long []arr, tree;
	
	static void rangeUpdate(int i, int j, long num) {
		update(i, num);
		update(j+1, -num);
	}
	
	static void update(int i, long num) {
		while (i <= N) {
			arr[i] += num;
			i += (i & -i);
		}
	}
	
	static long sum(int i) {
		long ans = 0;
		while (i > 0) {
			ans += arr[i];
			i -= (i & -i);
		}
		return ans;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		arr = new long[N+1];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		for (int i = 1; i <= N; i++) 
			rangeUpdate(i, i, Long.parseLong(st.nextToken()));
		
		M = Integer.parseInt(br.readLine());
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			if (a == 1) {
				int b = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				long d = Long.parseLong(st.nextToken());
				rangeUpdate(b, c, d);
			}
			else {
				int b = Integer.parseInt(st.nextToken());
				sb.append(sum(b) + "\n");
			}
		}
		System.out.println(sb);
		br.close();
	}
}