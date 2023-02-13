import java.io.*;
import java.util.*;

public class Main_bj_15686_드래곤커브_서울_20반_박현철 {
	static int d;
	static final int [] dy = {0, -1, 0, 1};
	static final int [] dx = {1, 0, -1, 0};
	static int arr [][] = new int [101][101];
	static ArrayList<Integer> list;
	static void draw_curve(int g) {
		list.add(d);
		for (int i = 0; i < g; i++) {
			int len = list.size();
			for (int j = len - 1; j >= 0; j--) {
				int n = list.get(j);
				list.add((n + 1) % 4);
			}
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			list = new ArrayList<>();
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			d = Integer.parseInt(st.nextToken());
			int g = Integer.parseInt(st.nextToken());
			draw_curve(g);
			arr[y][x] = 1;
			for (int dir : list) {
				x += dx[dir];
				y += dy[dir];
				arr[y][x] = 1;
			}
		}
		int ans = 0;
		for (int i = 1; i <= 100; i++) {
			for (int j = 1; j <= 100; j++) {
				if (arr[i][j] == 1 && arr[i - 1][j] == 1 && arr[i][j - 1] == 1 && arr[i - 1][j - 1] == 1)
					ans++;
			}
		}
		System.out.println(ans);
	}
}
