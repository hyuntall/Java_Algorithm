import java.io.*;
import java.util.*;

public class Solution_d3_6808_규영이와인영이의카드게임_서울_20반_박현철 {
	static int [] gy, iy, pm;
	static boolean [] v;
	static int win, lose;
	static void perm(int cnt) {
		if (cnt == 9) {
			int g = 0, y = 0;;
			for (int i = 0; i < 9; i++) {
				if (gy[i] > pm[i]) g += gy[i] + pm[i];
				else if (pm[i] > gy[i]) y += gy[i] + pm[i];
			}
			if (g > y) win++;
			else if (g < y) lose++;
			return;
		}
		for (int i = 0; i < 9; i++) {
			if (v[i]) continue;
			pm[cnt] = iy[i];
			v[i] = true;
			perm(cnt + 1);
			v[i] = false;
		}
	}
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_d3_6808.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			gy = new int[9];
			iy = new int[9];
			pm = new int[9];
			v = new boolean[9];
			win = 0;
			lose = 0;
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < 9; i++)
				gy[i] = Integer.parseInt(st.nextToken());
			Arrays.sort(gy);
			int idx = 0, cnt = 0;
			for (int i = 1; i <= 18; i++) {
				if (idx < 9 && gy[idx] == i) idx++;
				else iy[cnt++] = i;
			}
			perm(0);
			sb.append("#" + t + " " + win + " " + lose + "\n");
		}
		System.out.println(sb);
		br.close();
	}
}
