import java.io.*;
import java.util.*;

public class Main_bj_2798_블랙잭_서울_20반_박현철 {
	static StringTokenizer st;
	static int N, M, ans = 0;
	static int arr [];
	static void comb(int cnt, int start, int sum) {
		if (cnt == 3) {
			if (sum > ans && sum <= M) ans = sum;
			return;
		}
		for (int i = start; i < N; i++)
			comb(cnt + 1, i + 1, sum + arr[i]);
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int [N];
		ans = N;
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());
		comb(0, 0, 0);
		System.out.println(ans);
	}
}
