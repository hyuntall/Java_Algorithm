package a0306;

import java.io.*;
import java.util.*;

public class Main_bj_10158_개미_서울_20반_박현철 {
	// arr h x w
	// q,p 에 개미
	// 벽에 부딛히면  0->1 1->2 1->1 
	static int [] dq = {1, 1, -1, 1};
	static int [] dp = {1, -1, -1, -1};
	static int h, w, q, p, t;
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		w = sc.nextInt();
		h = sc.nextInt();
		p = sc.nextInt();
		q = sc.nextInt();
		t = sc.nextInt();
		int d = 0;
		for (int i = 0; i < t; i++) {
			q += dq[d];
			p += dp[d];
			if ((p>w||p<0)&&(q>h||q<0)) {
				q -= dq[d];
				p -= dp[d];
				d = (d+2)%4;
				q += dq[d];
				p += dp[d];
			}
			if (p>w||p<0||q>h||q<0) {
				q -= dq[d];
				p -= dp[d];
				d = (d+1)%4;
				q += dq[d];
				p += dp[d];
			}
		}
		System.out.println(p + " " + q);
	}

}
