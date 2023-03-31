import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int ans = 0;
		int [] arr = new int[n];
		int [] dp = new int[n];
		for (int i = 0; i < n; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		for (int i = 0; i < n; i++) {
			dp[i] = 1;
			for (int j = 0; j < i; j++)
				if (arr[i]>arr[j])
					dp[i] = Math.max(dp[i], dp[j]+1);
			ans = Math.max(ans, dp[i]);
		}
		System.out.println(ans);
	}
}