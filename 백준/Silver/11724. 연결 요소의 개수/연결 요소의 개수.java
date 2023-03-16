import java.io.*;
import java.util.*;

public class Main {
	static int A, B, N, M, idx;
	static boolean [] visited = new boolean[1001];
	static int [][] graph = new int [1001][1001];
	
	public static void dfs(int idx) {
		visited[idx] = true;
		for (int i = 1; i <= N; i++) 
			if (graph[idx][i] == 1 && visited[i] == false) dfs(i);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			A = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());
			graph[A][B] = graph[B][A] = 1;
		}
		int result = 0;
		for (int i = 1; i <= N; i++) {
			if (visited[i] == false) {
				dfs(i);
				result++;
			}
		}
		System.out.println(result);
	}
}
