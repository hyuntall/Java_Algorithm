import java.io.*;
import java.util.*;

public class Solution_d3_2085_농작물수확하기_서울_20반_박현철 {
	static int N;
	static int farm [][];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			farm = new int[N][N];
			for (int i = 0; i < N; i++) {
				String line = br.readLine();
				for (int j = 0; j < N; j++)
					farm[i][j] = line.charAt(j) - '0';
			}
			int len = 0, mid = N / 2, sum = 0;
			for (int i = 0; i < N/2; i++, len++)
				for (int j = mid-len; j <= mid+len; j++)
					sum += farm[i][j];
			for (int i = N/2; i < N; i++, len--)
				for (int j = mid-len; j <= mid+len; j++)
					sum += farm[i][j];
			sb.append("#").append(tc).append(" ").append(sum).append("\n");
		}
		System.out.print(sb);
	}
}
