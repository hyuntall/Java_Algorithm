import java.io.*;
import java.util.*;

public class Main {
	static int N, M, Y, X;
	static char [][] arr;
	static int keys;
	static boolean [][][] v;
	static int [] dy = {-1, 1, 0, 0};
	static int [] dx = {0, 0, -1, 1};
	static int bfs() {
		ArrayDeque<int []> q = new ArrayDeque<>();
		q.offer(new int[] {Y, X, 0, 0});
		v[Y][X][0] = true;
		while (!q.isEmpty()) {
			int cur[] = q.poll();
			int y = cur[0], x = cur[1], key = cur[2];
			if (arr[y][x]=='1') return cur[3];
			for (int i = 0; i < 4; i++) {
				int ny = y + dy[i];
				int nx = x + dx[i];
				if (0>ny||ny>=N||0>nx||nx>=M||arr[ny][nx]=='#') continue;
				
				if ('A'<=arr[ny][nx]&&arr[ny][nx]<='F') {
					if ((key & 1<<(arr[ny][nx]-'A'))!=0&&!v[ny][nx][key]) {
						v[ny][nx][key] = true;
						q.offer(new int[] {ny, nx, key, cur[3]+1});
					}
				}
				else if ('a'<=arr[ny][nx]&&arr[ny][nx]<='f'&&!v[ny][nx][key]) {
					v[ny][nx][key] =true;
					q.offer(new int [] {ny, nx, (key | 1<<(arr[ny][nx]-'a')), cur[3]+1});
				}
				else if (!v[ny][nx][key]) {
					v[ny][nx][key] =true;
					q.offer(new int [] {ny, nx, key, cur[3]+1});
				}
			}
		}
		return -1;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new char [N][M];
		v = new boolean[N][M][1<<7];
		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			for (int j = 0; j < M; j++) {
				arr[i][j] = line.charAt(j);
				if (arr[i][j]=='0') {
					Y = i;X = j;
				}
			}
		}
		System.out.println(bfs());
	}
}