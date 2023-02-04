package beakjoon;

import java.io.*;
import java.util.*;

public class problem1992 {
	static String line;
	static int [][] arr;
	static void quad(int x, int y, int len) {
		int first = arr[x][y];
		for (int i = x; i < x + len; i++) {
			for (int j = y; j < y + len; j++) {
				if (arr[i][j] != first) {
					System.out.print("(");
					quad(x, y, len / 2);
					quad(x, y + len / 2, len / 2);
					quad(x + len / 2, y, len / 2);
					quad(x + len / 2, y + len / 2, len / 2);
					System.out.print(")");
					return;
				}
			}
		}
		System.out.print(first);
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		arr = new int [N][N];
		for (int i = 0; i < N; i++) {
			line = br.readLine();
			for (int j = 0; j < N; j++) arr[i][j] = line.charAt(j) - '0';
		}
		quad(0, 0, N);
	}
}
