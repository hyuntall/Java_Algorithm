package a0308;

import java.io.*;
import java.util.*;

public class Main_bj_1927_서울_20반_박현철 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		PriorityQueue<Integer> q = new PriorityQueue<>();
		int N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			int x = Integer.parseInt(br.readLine());
			if (x == 0) sb.append((q.isEmpty()?0:q.poll())+"\n");
			else q.offer(x);
		}
		System.out.println(sb);
		br.close();
	}
}
