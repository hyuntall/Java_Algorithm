import java.io.*;
import java.util.*;

public class Main {
	static final int INF = 987654321;
	static int N;
	static int [][] dist;
	static boolean [] v;
	
	static String dijk() {
		ArrayDeque<int []> q = new ArrayDeque<>();
		q.offer(dist[0]);
		v[0] = true;
		while (!q.isEmpty()) {
			int cur[] = q.poll();
			int x = cur[0], y = cur[1];
			if (x==dist[N+1][0] && y==dist[N+1][1]) return "happy";
			for (int i = 1; i < N+2; i++) {
				if (v[i])continue;
				if (Math.abs(dist[i][0]-x)+Math.abs(dist[i][1]-y)<=1000) {
					v[i] = true;
					q.offer(dist[i]);
				}
			}
		}
		return "sad";
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			N = Integer.parseInt(br.readLine());
			dist = new int[N+2][2];
			v = new boolean[N+2];
			for (int i = 0; i < N+2; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 2; j++) 
					dist[i][j] = Integer.parseInt(st.nextToken());
			}
			System.out.println(dijk());
		}
	}
}