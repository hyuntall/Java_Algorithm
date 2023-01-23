package beakjoon;

import java.io.*;
import java.util.*;

public class problem1780 {
	static int paper[][];
	static StringTokenizer st;
	static int a, b, c;
	static void check(int x, int y, int len) {
		int curPaper = paper[x][y];
		if (len == 1) {
			if (curPaper == -1) a++;
			else if (curPaper == 0) b++;
			else c++;
			return;
		}
		int newLen = len / 3;
		for (int i = x; i < x + len; i++) {
			for (int j = y; j < y + len; j++) {
				if (curPaper != paper[i][j]) {
					for (int k = 0; k < 3; k++)
						for (int l = 0; l < 3; l++) 
							check(x + newLen * k, y + newLen * l, newLen);
					return ;
				}
			}
		}
		if (curPaper == -1) a++;
		else if (curPaper == 0) b++;
		else c++;
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		paper = new int [N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++)
				paper[i][j] = Integer.parseInt(st.nextToken());
		}
		check(0, 0, N);
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
	}
}
