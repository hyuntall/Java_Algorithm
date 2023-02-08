import java.io.*;
import java.util.*;

public class Solution_d2_1954_달팽이숫자_서울_20반_박현철 {
	static int [] dx = {1, 0, -1, 0};
	static int [] dy = {0, 1, 0, -1};
	static int[][] arr;
	static boolean [][] v;
	static int N, num;
	static void snail(int x, int y, int dir) {
		arr[y][x] = num;
		if (num == N*N) return;
		v[y][x] = true;
		int nx = x + dx[dir], ny = y + dy[dir];
		if (0 <= nx && nx < N && 0 <= ny && ny < N && !v[ny][nx]) {
			num++;
			snail(nx, ny, dir);
		}
		else snail(x, y, (dir + 1) % 4);
		
	}
	
	public static void main(String[] args) throws Exception{
		//System.setIn(new FileInputStream("res/input_d2_1954.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			arr = new int [N][N];
			v = new boolean [N][N];
			num = 1;
			snail(0, 0, 0);
			sb.append("#").append(tc).append("\n");
			for(int a[]:arr) {
				for (int n : a) sb.append(n).append(" ");
				sb.append("\n");
			}
		}
		System.out.println(sb);
	}
}
