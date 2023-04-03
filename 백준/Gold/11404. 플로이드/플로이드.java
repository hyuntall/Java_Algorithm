import java.io.*;
import java.util.*;

public class Main {
	static final int INF = 987654321;
	static int N, M, dist[][];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		dist = new int[N+1][N+1];
		for (int d[]:dist)
			Arrays.fill(d, INF);
		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			dist[from][to] = Math.min(dist[from][to], cost);
		}
		
		for (int k = 1; k <= N; k++) {
			for (int i = 1; i <= N; i++) {
				if (i==k) continue;
				for (int j = 1; j <= N; j++) {
					if (i==j || k==j) continue;
					dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++)
				sb.append((dist[i][j]!=INF?dist[i][j]:0) + " ");
			sb.append("\n");
		}
		System.out.println(sb);
		br.close();
	}
}