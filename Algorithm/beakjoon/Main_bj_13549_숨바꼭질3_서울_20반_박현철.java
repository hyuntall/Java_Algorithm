package a0306;

import java.io.*;
import java.util.*;

public class Main_bj_13549_숨바꼭질3_서울_20반_박현철 {
	static int N, K;
	static int [] dist = new int [200001];
	static boolean [] v = new boolean [200001];
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		K = sc.nextInt();
		ArrayDeque<int []> q = new ArrayDeque<>();
		q.offer(new int[] {N, 0});
		v[N] = true;
		while (!q.isEmpty()) {
			int cur [] = q.poll();
			int x = cur[0];
			int t = cur[1];
			for (int X : new int[] {x*2, x+1, x-1}) {
				int T;
				if (X==x*2) T = t;
				else T = t+1;
				if (0<=X && X <= 200000) {
					if (!v[X]) {
						v[X] = true;
						dist[X] = T;
						q.offer(new int[] {X, T});
					}else if(dist[X] > T) {
						dist[X] = T;
						q.offer(new int[] {X, T});
					}
				}
			}
		}
		System.out.println(dist[K]);
		sc.close();
	}
}
