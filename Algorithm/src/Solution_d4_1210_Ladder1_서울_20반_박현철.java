import java.io.*;
import java.util.*;

public class Solution_d4_1210_Ladder1_서울_20반_박현철 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		for (int tc = 1; tc <= 10; tc++) {
			int T = Integer.parseInt(br.readLine());
			int [][] ladder = new int [100][101];
			int G = 0;
			for (int i = 0; i < 100; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 1; j <= 100; j++) {
					ladder[i][j] = Integer.parseInt(st.nextToken());
					if (ladder[i][j] == 2) G = j;
				}
			}
			for (int i = 99; i > 0;) {
				ladder[i][G] = 0;
				if (G-1 > 0 && ladder[i][G-1] == 1) G--;
				else if(G+1 <= 100 && ladder[i][G+1] == 1) G++;
				else i--;
			}
			sb.append("#").append(T).append(" ").append(--G).append("\n");
		}
		System.out.print(sb);
		br.close();
	}
}
