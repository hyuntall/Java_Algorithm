package beakjoon;

import java.io.*;
import java.util.*;

public class problem14889 {
	static int N;
	static int [][] S;
	static StringTokenizer st;
	static int [] teamStart;
	static int [] teamLink;
	static int result = Integer.MAX_VALUE;
	static int synergy(int [] arr) {
		int sum = 0;
		for (int i : arr) 
			for (int j : arr) 
				sum += S[i][j];
		return sum;
	}
	static void combination(int cnt, int idx) {
		if (cnt == N / 2) {
			int synergyGap;
			int index = 0;
			label : for (int i = 0; i < N; i++) {
				for (int j = 0; j < N / 2; j++) {
					if (i == teamStart[j]) continue label;
				}
				teamLink[index++] = i;
			}
			synergyGap = Math.abs(synergy(teamLink) - synergy(teamStart));
			if (synergyGap < result)
				result = synergyGap;
			return;
		}
		for (int i = idx; i < N; i++) {
			teamStart[cnt] = i;
			combination(cnt + 1, i + 1);
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		S = new int [N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++)
				S[i][j] = Integer.parseInt(st.nextToken());
		}
		teamStart = new int [N/2];
		teamLink = new int [N/2];
		combination(0, 0);
		System.out.println(result);
	}
}
