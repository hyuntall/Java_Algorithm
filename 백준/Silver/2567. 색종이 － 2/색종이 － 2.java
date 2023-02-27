import java.io.*;
import java.util.*;

public class Main {
	static int [] dy = {-1, 1, 0, 0};
	static int [] dx = {0, 0, -1, 1};
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int arr [][] = new int [101][101];
		for (int k = 0; k < N; k++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			for (int i = y; i < y+10; i++) 
				for (int j = x; j < x+10; j++)
					arr[i][j] = 1;
		}
		int ans = 0;
		for (int i = 0; i <= 100; i++) {
			for (int j = 0; j <= 100; j++) {
				if (arr[i][j] == 1) {
					for (int d = 0; d < 4; d++) {
						int ny = i + dy[d];
						int nx = j + dx[d];
						if (0<=nx&&nx<=100&&0<=ny&&ny<=100)
							if (arr[ny][nx] == 0) ans++;
						else if (nx<0 || nx>100 || ny<0 || ny>100) ans++;
					}
				}
			}
		}
		System.out.println(ans);
	}
}