import java.io.*;
import java.util.*;

public class Main {
	static long A, B, ans = Long.MAX_VALUE;
	static void dfs(long n, int cnt) {
		if (n == B) {
			ans = Math.min(ans, cnt);
			return;
		}
		if (n < B) {
			dfs(n*2, cnt+1);
			dfs(n*10+1, cnt+1);
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		dfs(A, 1);
		System.out.println(ans != Long.MAX_VALUE ? ans : -1);
	}
}