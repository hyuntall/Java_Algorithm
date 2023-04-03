import java.io.*;
import java.util.*;

public class Main {
	static final int INF = 987654321;
	static int N, dist[][];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		dist = new int[N][N];
		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			for (int j = 0; j < N; j++) {
				dist[i][j] = line.charAt(j)=='Y'?1:INF;
				if (i == j) dist[i][j] = 0;
			}
		}	
		
		for (int k = 0; k < N; k++) {
			for (int i = 0; i < N; i++) {
				if(i==k) continue;
				for (int j = 0; j < N; j++) {
					if(i==j || k==j) continue;
					dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
				}
			}
		}
		int ans = 0;
		for (int i = 0; i < N; i++) {
			int sum = 0;
			for (int j = 0; j < N; j++) 
				if(i!=j&&dist[i][j]<=2) sum++;
			ans = Math.max(ans, sum);
		}
		System.out.println(ans);
	}
}