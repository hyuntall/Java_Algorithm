import java.io.*;
import java.util.*;
public class Main {
	static int dp[][] = new int[31][31];
	static int comb(int n, int r) {
		if (dp[n][r] > 0) return dp[n][r];
		if (n==r||r==0) return dp[n][r] = 1;
		return dp[n][r] = comb(n-1, r-1) + comb(n-1, r);
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for (int i = 0; i < t; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			System.out.println(comb(m, n));
		}
	}
}