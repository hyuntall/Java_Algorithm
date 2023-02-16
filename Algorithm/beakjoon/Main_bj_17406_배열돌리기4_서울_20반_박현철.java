import java.io.*;
import java.util.*;

public class Main_bj_17406_배열돌리기4_서울_20반_박현철 {
	static int N, M, K;
	static int [][]arr, newArr;
	static int [][] cycles, tmp[][];
	static int perm[];
	static boolean v[];
	static int ans = Integer.MAX_VALUE, sum;
	static int getMinSum() {
		int a = 0, b = Integer.MAX_VALUE;
		for (int i = 1; i <= N; i++) {
			a = 0;
			for (int j = 1; j <= M; j++) {
				a += newArr[i][j];
			}
			if (b > a) b = a;
		}
		return b;
	}
	
	static void cycleArr(int r, int c, int s) {
		int y1 = r-s;
		int x1 = c-s;
		int y2 = r+s;
		int x2 = c+s;
		int len = Math.min(Math.abs(y1-y2), Math.abs(x1-x2)) / 2;
		int ylen = Math.abs(y1-y2);
		int xlen = Math.abs(x1-x2);
		int [][] tmp = new int [N+1][M+1];
		int cnt = 1;
		//System.out.println(len);
		//System.out.println(r + " " + c + " " + s);
		//System.out.println(y1 + ", " + x1 + " " + y2 + ", " + x2);
		while (cnt++ <= len) {
			for (int i = x1; i < x2; i++) { // >
				tmp[y1][i+1] = newArr[y1][i];
			}
			//tmp[y1][x2] = ntmp;
			for (int i = y1; i < y2; i++) { // v
				tmp[i+1][x2] = newArr[i][x2];
			}
			//tmp[y2][x2] = ntmp;
			for (int i = x2; i > x1; i--) { // <<
				tmp[y2][i-1] = newArr[y2][i];
			}
			for (int i = y2; i > y1; i--) { // ^
				tmp[i-1][x1] = newArr[i][x1];
			}
			x1 += 1;
			x2 -= 1;
			y1 += 1;
			y2 -= 1;
		}
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				if (tmp[i][j] != 0) newArr[i][j] = tmp[i][j];
			}
		}
		//for(int a[]:tmp)System.out.println(Arrays.toString(a));
		//System.out.println("-----------");
	}
	
	static void perm(int cnt) {
		if (cnt == K) {
			sum = 0;
			newArr = new int [N+1][];
			for (int i = 0; i <= N; i++)
				newArr[i] = Arrays.copyOf(arr[i], M+1);
			for (int i = 0; i < K; i++) {
				int r = cycles[perm[i]][0];
				int c = cycles[perm[i]][1];
				int s = cycles[perm[i]][2];
				cycleArr(r, c, s);
			}
			//for(int a[]:newArr)System.out.println(Arrays.toString(a));
			//System.out.println("--");
			sum = getMinSum();
			//System.out.println(sum);
			if (sum < ans) ans = sum;
		}
		for (int i = 0; i < K; i++) {
			if (v[i]) continue;
			perm[cnt] = i;
			v[i] = true;
			perm(cnt + 1);
			v[i] = false;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		arr = new int [N+1][M+1];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 1; j <= M; j++) arr[i][j] = Integer.parseInt(st.nextToken());
		}
		cycles = new int [K][];
		perm = new int [K];
		v = new boolean[K];
		for (int t = 0; t < K; t++) {
			st = new StringTokenizer(br.readLine(), " ");
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			cycles[t] = new int [] {r, c, s};
		}
		perm(0);
		System.out.println(ans);
	}

}
