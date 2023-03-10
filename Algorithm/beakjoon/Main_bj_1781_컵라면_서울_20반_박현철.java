package a0310;

import java.io.*;
import java.util.*;

public class Main_bj_1781_컵라면_서울_20반_박현철 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int [][] arr = new int[N][2];
		PriorityQueue<Integer> q = new PriorityQueue<>();
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int deadline = Integer.parseInt(st.nextToken());
			int ramen = Integer.parseInt(st.nextToken());
			arr[i][0] = deadline; arr[i][1] = ramen;
		}
		Arrays.sort(arr, (o1, o2)->Integer.compare(o1[0], o2[0]));
		for (int i = 0; i < N; i++) {
			q.offer(arr[i][1]);
			if (arr[i][0] < q.size()) q.poll();
		}
		int ans = 0;
		while (!q.isEmpty()) ans += q.poll();
		System.out.println(ans);
	}
}
