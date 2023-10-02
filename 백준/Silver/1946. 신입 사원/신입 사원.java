import java.io.*;
import java.util.*;

public class Main {
	static int solve(BufferedReader br) throws Exception {
		int N = Integer.parseInt(br.readLine());
		int [] arr = new int [N + 1];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr[Integer.parseInt(st.nextToken())] = Integer.parseInt(st.nextToken());
		}
		int ans = 1;
		int tmp = arr[1];
		for (int i = 2; i <= N; i++) {
			if (tmp >= arr[i]) {
				tmp = arr[i];
				ans++;
			}
		}
		return ans;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int _ = 0; _ < T; _++) sb.append(solve(br)+"\n");
		System.out.println(sb);
		br.close();
	}
}