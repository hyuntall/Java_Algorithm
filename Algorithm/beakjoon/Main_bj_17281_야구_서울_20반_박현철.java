package a0307;

import java.io.*;
import java.util.*;

public class Main_bj_17281_야구_서울_20반_박현철 {

	static int N, ans;
	static int [] b = new int[9], a;
	static boolean v[] = new boolean [9];
	static int [][] arr;
	static void perm(int cnt) {
		if (cnt == 9) {
			int point = 0;
			int n = 0;
			for (int i = 0; i < N; i++) {
				a = new int[9];
				int out = 0;
				while (out < 3) {
					n %= 9;
					int p = arr[i][b[n]];
					if (p>0) {
						for (int j = 0; j < 9; j++)
							if(a[j]>0) a[j]+=p;
						a[b[n]]+=p;
						for (int j = 0; j < 9; j++) {
							if(a[j]>=4) {
								a[j]=0;
								point++;
							}
						}
					}
					else if(p==0) out++;
					n++;
				}
			}
			ans = Math.max(ans, point);
			return;
		}
		if(cnt==3) perm(cnt+1);
		else {
			for (int i = 1; i < 9; i++) {
				if (v[i]) continue;
				b[cnt] = i;
				v[i] = true;
				perm(cnt+1);
				v[i] = false;
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N][9];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < 9; j++)
				arr[i][j] = Integer.parseInt(st.nextToken());
		}
		perm(0);
		System.out.println(ans);
	}

}
