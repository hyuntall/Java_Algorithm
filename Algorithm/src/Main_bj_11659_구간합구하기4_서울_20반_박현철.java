import java.io.*;
import java.util.*;

public class Main_bj_11659_구간합구하기4_서울_20반_박현철 {
	static StringTokenizer st;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int arr [] = new int [N + 1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) arr[i] = arr[i-1] + Integer.parseInt(st.nextToken());
		for (int tc = 0; tc < M; tc++) {
			st = new StringTokenizer(br.readLine());
			int i = Integer.parseInt(st.nextToken()) - 1;
			int j = Integer.parseInt(st.nextToken());
			sb.append(arr[j] - arr[i]).append("\n");
		}
		System.out.println(sb);
	}
}
