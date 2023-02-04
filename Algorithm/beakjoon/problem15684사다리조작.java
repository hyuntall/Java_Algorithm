package beakjoon;

import java.io.*;
import java.util.*;

public class problem15684사다리조작 {
	static int N, M, H;
	static int [][] arr;
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		arr = new int [M + 2][N];
		int a, b;
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			arr[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())-1] = 1;
		}
		for (int c[]: arr) System.out.println(Arrays.toString(c));
	}
}
