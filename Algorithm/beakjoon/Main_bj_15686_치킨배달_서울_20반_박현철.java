import java.io.*;
import java.util.*;

public class Main_bj_15686_치킨배달_서울_20반_박현철 {
	static int N, M, L, ans=Integer.MAX_VALUE;
	static int [][] arr, chick;
	static List<int []> chickens = new ArrayList<>();
	static void comb(int cnt, int start) {
		if (cnt == M) {
			int distance = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (arr[i][j] == 1) {
						int minDist = Integer.MAX_VALUE;
						for (int c[]:chick) {
							int dist = Math.abs(c[0]-i) + Math.abs(c[1]-j);
							minDist = minDist>dist?dist:minDist;
						}
						distance+=minDist;
					}
				}
			}
			ans = ans>distance?distance:ans;
			return;
		}
		for (int i = start; i < L; i++) {
			chick[cnt] = chickens.get(i);
			comb(cnt+1, i+1);
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int [N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if (arr[i][j] == 2) {
					chickens.add(new int[] {i, j});
					L++;
				}
			}
		}
		chick = new int[M][2];
		comb(0, 0);
		System.out.println(ans);
		br.close();
	}
}
