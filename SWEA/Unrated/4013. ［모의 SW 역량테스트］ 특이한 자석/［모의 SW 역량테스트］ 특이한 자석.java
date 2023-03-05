import java.io.*;
import java.util.*;

public class Solution {
	// 4개의 자석, 8개의 날
	// 각 날마다 N극(0) S극(1)
	// K번 회전
	// 하나의 자석이 1칸 회전할 때, 서로 붙어있는 날의 자성과 다르면
	// 그 자석은 반대 방향으로 회전
	// 자석 번호는 1 2 3 4
	// 맨 위가 N이면 각 1 2 4 8
	
	static int N;
	static int [][] m = new int [4][8];;
	
	static void rotate(int n, int d, boolean l, boolean r) {
		// 본인 회전
		int left = m[n][6];
		int right = m[n][2];
		if (d==1) {
			int tmp = m[n][7];
			for (int i = 7; i > 0; i--) 
				m[n][i] = m[n][i-1];
			m[n][0] = tmp;
		}
		else {
			int tmp = m[n][0];
			for (int i = 0; i < 7; i++) 
				m[n][i] = m[n][i+1];
			m[n][7] = tmp;
		}
		
		if (n-1 >= 0&&m[n-1][2]!=left && l)
			rotate(n-1, 0-d, true, false);
		
		if (n+1 < 4 && m[n+1][6]!=right && r) 
			rotate(n+1, 0-d, false, true);
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			int K = Integer.parseInt(br.readLine());
			for (int i = 0; i < 4; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < 8; j++)
					m[i][j] = Integer.parseInt(st.nextToken());
			}
			for (int i = 0; i < K; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				int n = Integer.parseInt(st.nextToken());
				int d = Integer.parseInt(st.nextToken());
				rotate(n-1, d, true, true);
			}
			int ans = 0;
			for (int i = 0; i < 4; i++) 
				if(m[i][0]==1) ans += Math.pow(2, i);
			
			sb.append("#"+t+" "+ans+"\n");
		}
		System.out.println(sb);
		br.close();
	}
}