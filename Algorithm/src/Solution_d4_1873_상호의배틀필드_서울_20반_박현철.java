import java.io.*;
import java.util.*;

public class Solution_d4_1873_상호의배틀필드_서울_20반_박현철 {
	static int H, W, N;
	static int cur[];
	static char [][] arr;
	static int [] dy = {-1, 1, 0, 0};
	static int [] dx = {0, 0, -1, 1};
	static void shoot() {
		int y = cur[0], x = cur[1], d = cur[2];
		while (0<=y&&y<H&&0<=x&&x<W&&arr[y][x]!='#') {
			if (arr[y][x] == '*') {
				arr[y][x] = '.';
				break;
			}
			y += dy[d];
			x += dx[d];
		}
	}
	
	static void turn(char key) {
		int y = cur[0], x = cur[1];
		if (key == 'U') {
			cur[2] = 0;
			arr[y][x] = '^';
			if (y-1 >= 0 && arr[y-1][x] == '.') {
				cur[0]--;
				arr[y][x] = '.';
				arr[y-1][x] = '^';
			}
		}
		else if (key == 'D') {
			cur[2] = 1;
			arr[y][x] = 'v';
			if (y+1 < H && arr[y+1][x] == '.') {
				cur[0]++;
				arr[y][x] = '.';
				arr[y+1][x] = 'v';
			}
		}
		else if (key == 'L') {
			cur[2] = 2;
			arr[y][x] = '<';
			if (x - 1 >= 0 && arr[y][x-1] == '.') {
				cur[1]--;
				arr[y][x] = '.';
				arr[y][x-1] = '<';
			}
		}
		else if (key == 'R') {
			cur[2] = 3;
			arr[y][x] = '>';
			if (x+1 < W && arr[y][x+1] == '.') {
				cur[1]++;
				arr[y][x] = '.';
				arr[y][x+1] = '>';
			}
		}
	}
	
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_d3_1873.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb =new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			H = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			arr = new char [H][W];
			for (int i = 0; i < H; i++) {
				String line = br.readLine();
				for (int j = 0; j < W; j++) {
					arr[i][j] = line.charAt(j);
					if (arr[i][j]=='^') cur = new int[] {i ,j, 0};
					if (arr[i][j]=='v')	cur = new int[] {i ,j, 1};
					if (arr[i][j]=='<')	cur = new int[] {i ,j, 2};
					if (arr[i][j]=='>') cur = new int[] {i ,j, 3};
				}
			}
			N = Integer.parseInt(br.readLine());
			String input = br.readLine();
			for (int i = 0; i < N; i++) {
				char key = input.charAt(i);
				if (key == 'S') shoot();
				else turn(key);
				//for(char []a:arr)System.out.println(Arrays.toString(a));
				//System.out.println();
			}
			sb.append("#"+t+" ");
			for(char []a:arr) {
				for(char c:a) sb.append(c);
				sb.append("\n");
			}
		}
		System.out.println(sb);
		br.close();
	}
}
