import java.io.*;
import java.util.*;

public class Main {
	static int N, size = 2, exp, result;
	static int [][] space;
	static StringTokenizer st;
	static int [] dy = {0, -1, 0, 1};
	static int [] dx = {-1, 0, 1, 0};
	static int cur [];
	static PriorityQueue<int []> q = new PriorityQueue<>((o1, o2) -> {
		if (o1[2] != o2[2])
			return Integer.compare(o1[2],  o2[2]);
		else if (o1[0] != o2[0])
			return Integer.compare(o1[0],  o2[0]);
		else
			return Integer.compare(o1[1],  o2[1]);
	});

	static boolean bfs() {
		q.clear();
		int x, y, nx, ny;
		boolean [][] visited = new boolean[N][N];
		q.add(new int [] {cur[0], cur[1], 0});
		visited[cur[0]][cur[1]] = true;
		
		while (!q.isEmpty()) {
			cur = q.poll();
			x = cur[0];
			y = cur[1];
			
			if (space[x][y] != 0 && space[x][y] < size) {
				space[x][y] = 0;
				exp++;
				result += cur[2];
				if (size == exp) {
					size++;
					exp = 0;
				}
				return true;
			}
			
			for (int i = 0; i <4; i++) {
				nx = x + dx[i];
				ny = y + dy[i];
				if (0 <= nx && nx < N && 0 <= ny && ny < N
						&& visited[nx][ny] == false
						&& space[nx][ny] <= size) {
					q.add(new int[] {nx, ny, cur[2] + 1});
					visited[nx][ny] = true;
				}
			}
		}
		return false;
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		space = new int [N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				space[i][j] = Integer.parseInt(st.nextToken());
				if (space[i][j] == 9) {
					cur = new int [] {i, j, 0};
					space[i][j] = 0;
				}
			}
		}
		while (bfs());
		System.out.println(result);
	}
}