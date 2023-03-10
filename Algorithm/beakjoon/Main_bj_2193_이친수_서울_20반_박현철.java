package a0307;

import java.io.*;
import java.util.*;

public class Main_bj_2193_이친수_서울_20반_박현철 {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		long [] dp = new long [n+1];
		dp[1] = 1;
		for (int i = 2; i <= n; i++)
			dp[i] = dp[i-2]+dp[i-1];
		System.out.println(dp[n]);
	}

}
