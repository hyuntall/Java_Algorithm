import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int t=0; t<T; t++) {
			int ans = 0;
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int x1= Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			int n = Integer.parseInt(br.readLine());
			for (int i=0; i<n; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				int r = Integer.parseInt(st.nextToken());
				double a = Math.sqrt(Math.pow(x1-x, 2) + Math.pow(y1-y, 2));
				double b = Math.sqrt(Math.pow(x-x2, 2) + Math.pow(y-y2, 2));
				if (a<r&&b<r);
				else if (a<r||b<r)ans++;
			}
			sb.append(ans+"\n");
		}
		System.out.println(sb);
		br.close();
	}

}