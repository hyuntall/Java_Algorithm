package beakjoon;

import java.io.*;
import java.util.*;

public class problem14890경사로 {
	static int N, L, result;
	static StringTokenizer st;
	static int[][] arr;
	static void checkRow(int index) {
		int down = 0;
		int ableUp = 1;
		int up = 0;
		int curH = arr[index][0];
		for (int i = 1; i < N; i++) {
			if (curH - arr[index][i] == 0) {
				if (down == 0 && up == 0)
					ableUp++;
			}
			else if (down == 0 && up == 0 && curH - arr[index][i] == 1) {
				down = L;
				ableUp = 0;
			}
			else if (down == 0 && curH - arr[index][i] == -1) {
				if (ableUp >= L) {
					ableUp = 1;
				}
				else return;
			}
			else {
				return;
			}
			if (down > 0)
				down--;
			if (up > 0)
				up--;
			curH = arr[index][i];
		}
		if (down > 0) return;
		result++;
	}
	
	static void checkCol(int index) {
		int down = 0;
		int ableUp = 1;
		int up = 0;
		int curH = arr[0][index];
		for (int i = 1; i < N; i++) {
			if (curH - arr[i][index] == 0) {
				if (down == 0 && up == 0)
					ableUp++;
			}
			else if (down == 0 && up == 0 && curH - arr[i][index] == 1) {
				down = L;
				ableUp = 0;
			}
			else if (down == 0 && curH - arr[i][index] == -1) {
				if (ableUp >= L) {
					ableUp = 1;
				}
				else return;
			}
			else return;
			
			if (down > 0)
				down--;
			if (up > 0)
				up--;
			curH = arr[i][index];
		}
		if (down > 0) return;
		result++;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		arr = new int [N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++)
				arr[i][j] = Integer.parseInt(st.nextToken());
		}
		for (int i = 0; i < N; i++) {
			checkRow(i);
			checkCol(i);
		}
		System.out.println(result);
	}
}
