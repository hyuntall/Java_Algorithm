package a0307;

import java.io.*;
import java.util.*;

public class Main_bj_11053_가장긴증가하는부분수열_서울_20반_박현철 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int ans = 0;
		int [] arr = new int[n];
		int [] dp = new int[n];
		Arrays.fill(dp, 1);
		for (int i = 0; i < n; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		for (int i = 0; i < n; i++)
			for (int j = 0; j < i; j++)
				if (arr[i]>arr[j])
					dp[i] = Math.max(dp[i], dp[j]+1);
		for (int i = 0; i < n; i++)
			ans = Math.max(ans, dp[i]);
		System.out.println(ans);
	}
}
