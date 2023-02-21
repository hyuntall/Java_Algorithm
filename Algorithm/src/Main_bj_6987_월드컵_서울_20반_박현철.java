import java.io.*;
import java.util.*;

public class Main_bj_6987_월드컵_서울_20반_박현철 {
	static int [][] arr = new int [6][3];
	static int [] win = new int [6], draw = new int[6], lose = new int [6];
	static int team1 [] = {0, 0, 0, 0, 0, 1, 1, 1, 1, 2, 2, 2, 3, 3, 4};
	static int team2 [] = {1, 2, 3, 4, 5, 2, 3, 4, 5, 3, 4, 5, 4, 5, 5};
	static boolean able;
	static void solve(int n) {
		if (n == 15) {
			able = true;
			return;
		}
		
		int t1 = team1[n];
		int t2 = team2[n];
		if (win[t1] > 0 && lose[t2] > 0) {
			win[t1]--;
			lose[t2]--;
			solve(n+1);
			win[t1]++;
			lose[t2]++;
		}
		if (draw[t1] > 0 && draw[t2] > 0) {
			draw[t1]--;
			draw[t2]--;
			solve(n+1);
			draw[t1]++;
			draw[t2]++;
		}
		if (lose[t1] > 0 && win[t2] > 0) {
			lose[t1]--;
			win[t2]--;
			solve(n+1);
			lose[t1]++;
			win[t2]++;
		}
		return;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 4; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			able = false;
			int sum = 0;
			for (int j = 0; j < 6; j++) {
				win[j] = Integer.parseInt(st.nextToken());
				draw[j] = Integer.parseInt(st.nextToken());
				lose[j] = Integer.parseInt(st.nextToken());
				sum += win[j] + draw[j] + lose[j];
			}
			if (sum==30) solve(0);
			sb.append((able ? 1 : 0) + " ");
		}
		System.out.println(sb);
		br.close();
	}
}
