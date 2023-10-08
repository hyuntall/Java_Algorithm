import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int [][] arr;
	static int ans;
	static void dfs(int day, int sum, int curCon) {
		if (day == N) {
			if (curCon==0) ans = Math.max(ans, sum);
			return;
		}
		if (curCon == 0) 
			dfs(day+1, sum+arr[day][1], arr[day][0]-1);
		
		dfs(day+1, sum, curCon-1 >= 0 ? curCon-1:0);
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N][2];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
		dfs(0, 0, 0);
		System.out.println(ans);
	}
}