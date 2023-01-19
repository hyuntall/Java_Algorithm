package beakjoon;

import java.io.*;
import java.util.*;

public class problem16439 {
	static int N, M, result = 0, favorit [][], combination [] = new int [3];
	static int getMaxFavorit(int index) {
		int maxFavorit = 0;
		for (int i = 0; i < 3; i++) maxFavorit = Math.max(maxFavorit, favorit[index][combination[i]]);
		return maxFavorit;
	}
	
	static void makeCombination(int start, int depth) {
		if (depth == 3) {
			int sum = 0;
			for (int i = 0; i < N; i++) sum += getMaxFavorit(i);
			result = Math.max(result, sum);
			return;
		}
		for (int i = start; i < M; i++) {
			combination[depth] = i;
			makeCombination(start + 1, depth + 1);
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		favorit = new int [N][M];
		for (int i = 0; i < N; i++) for(int j = 0; j < M; j++) favorit[i][j] = sc.nextInt();
		makeCombination(0, 0);
		System.out.println(result);
	}
}
