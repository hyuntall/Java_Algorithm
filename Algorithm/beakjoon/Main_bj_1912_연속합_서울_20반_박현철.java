package a0307;

import java.util.*;
import java.io.*;

public class Main_bj_1912_연속합_서울_20반_박현철 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int [] dp = new int[N], arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());
        int ans = dp[0] = arr[0];
        for (int i = 1; i < N; i++) {
        	dp[i] = Math.max(arr[i], arr[i] + dp[i-1]);
        	ans = Math.max(ans, dp[i]);
        }
        System.out.println(ans);
    }
}