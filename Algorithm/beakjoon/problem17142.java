package beakjoon;

import java.io.*;
import java.util.*;

public class problem17142 {
	static int [] dx = {0, 0, 1, -1};
	static int [] dy = {-1, 1, 0, 0};
	static StringTokenizer st;
	static int N, M;
	static int [][] arr;
	static ArrayDeque<int []> q = new ArrayDeque<>();
	static ArrayList<int []> viruses = new ArrayList<>();
	static ArrayList <int [][]> comb = new ArrayList<>();
	static int result = Integer.MAX_VALUE;
	static void combination(int cnt, int idx, int [][] position) {
		if (cnt == M) {
			comb.add(Arrays.copyOf(position, M));
			return;
		}
		for (int i = idx; i < viruses.size(); i++) {
			position[cnt] = viruses.get(i);
			combination(cnt + 1, i + 1, position);
		}
	}
	public static void bfs() {
		int x, y, nx, ny, seconds = 0;
		int [] pos;
		int [][] visited = new int [N][N];
		int [][] times = new int [N][N];
		ArrayDeque<int []> clone = q.clone();
		while (clone.isEmpty() == false) {
			pos = clone.poll();
			visited[pos[0]][pos[1]] = 1;
		}
		while(q.isEmpty() == false) {
			pos = q.poll();
			x = pos[0];
			y = pos[1];
			for (int i = 0; i < 4; i++) {
				nx = x + dx[i];
				ny = y + dy[i];
				if (0 <= nx && nx < N 
					&& 0 <= ny && ny < N 
					&& visited[nx][ny] == 0
					&& arr[nx][ny] != 1
					&& arr[nx][ny] != 1) {
					int [] newPos = {nx, ny};
					q.add(newPos);
					times[nx][ny] = times[x][y] + 1;
					visited[nx][ny] = 1;
					if (arr[nx][ny] == 0 && seconds < times[nx][ny]) seconds = times[nx][ny];
				}
			}
		}
		label: for (int i = 0; i < N; i++)
			for (int j = 0; j < N; j++)
				if (arr[i][j] != 1 && visited[i][j] == 0) {
					seconds = -1;
					break label;
				}
		if (seconds > -1 && result > seconds) result = seconds;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int [N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if (arr[i][j] == 2) {
					int [] virus = {i, j};
					viruses.add(virus);
				}
			}
		}
		int [][] position = new int [M][2];
		combination(0, 0, position);
		for (int [][] positions : comb) {
			q.clear();
			for (int [] pos : positions)
				q.add(pos);
			bfs();
		}
		if (result == Integer.MAX_VALUE)
			result = -1;
		System.out.println(result);
	}
}
