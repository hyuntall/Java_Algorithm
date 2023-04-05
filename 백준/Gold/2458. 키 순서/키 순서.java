import java.io.*;
import java.util.*;

public class Main {
	static final int INF = 987654321;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int [][] arr = new int [N+1][N+1];
		for (int a[]:arr)Arrays.fill(a, INF);
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			arr[a][b] = 1;
		}
		for (int k = 1; k <= N; k++) {
			for (int i = 1; i <= N; i++) {
				if (i==k)continue;
				for (int j = 1; j <= N; j++) {
					if(i==j||j==k)continue;
					arr[i][j] = Math.min(arr[i][j], arr[i][k] + arr[k][j]);
				}
			}
		}
		int [] ans = new int[N+1];
		int cnt = 0;
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (i==j)continue;
				if (arr[i][j]!=INF) ans[i]++;
				if (arr[j][i]!=INF) ans[i]++;
			}
			if(ans[i]==N-1)cnt++;
		}
		System.out.println(cnt);
	}
}