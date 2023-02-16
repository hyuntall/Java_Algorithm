import java.io.*;
import java.util.*;

public class Solution_4012_요리사_서울_20반_박현철 {
	static int arr [][];
	static int N;
	static int [] cook, otherCook;
	static int minGap;
	static int synergy(int [] a) {
		int sum = 0;
		for (int i : a) 
			for (int j : a) 
				sum += arr[i][j];
		return sum;
	}
	static void comb(int cnt, int start) {
		if (cnt == N / 2) {
			int j = 0, k = 0;
			for (int i = 0; i < N; i++) {
				if (j < N/2 && i == cook[j]) j++;
				else otherCook[k++] = i;
			}
			minGap = Math.min(minGap, Math.abs(synergy(cook) - synergy(otherCook)));
			return;
		}
		for (int i = start; i < N; i++) {
			cook[cnt] = i;
			comb(cnt + 1, i + 1);
		}
	}
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_4012.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			arr = new int [N][N];
			cook = new int [N/2];
			otherCook = new int[N/2];
			minGap = Integer.MAX_VALUE;
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < N; j++) arr[i][j] = Integer.parseInt(st.nextToken());
			}
			comb(0, 0);
			sb.append("#" + t + " " + minGap + "\n");
		}
		br.close();
		System.out.println(sb);
	}
}
