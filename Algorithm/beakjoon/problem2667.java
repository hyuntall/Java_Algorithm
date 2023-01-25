package beakjoon;

import java.io.*;
import java.util.*;

public class problem2667 {
	static int [][] arr;
	static String line;
	static int [] dx = {0, 0, -1, 1};
	static int [] dy = {-1, 1, 0, 0};
	static int N, index;
	static int [][] visited;
	static int [] buildings;
	static void dfs(int x, int y) {
		buildings[index]++;
		visited[x][y] = 1;
		int nx, ny;
		for (int i = 0; i < 4; i++) {
			nx = x + dx[i];
			ny = y + dy[i];
			if (0 <= nx && nx < N && 0 <= ny && ny < N && arr[nx][ny] != 0 && visited[nx][ny] != 1) {
				dfs(nx, ny);
			}
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int [N][N];
		visited = new int [N][N];
		buildings = new int[N*N + 1];
		for (int i = 0; i < N; i++) {
			line = br.readLine();
			for (int j = 0; j < N; j++) arr[i][j] = line.charAt(j) - '0';
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (arr[i][j] == 1 && visited[i][j] == 0) {
					dfs(i, j);
					index++;
				}
			}
		}
		Arrays.sort(buildings);
		System.out.println(index);
		for (int i = 0; i < N * N + 1; i++) {
			if (buildings[i] > 0)
				System.out.println(buildings[i]);
		}
	}
}
