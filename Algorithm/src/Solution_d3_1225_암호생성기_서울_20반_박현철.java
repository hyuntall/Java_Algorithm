import java.io.*;
import java.util.*;

public class Solution_d3_1225_암호생성기_서울_20반_박현철 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_d3_1225.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		for (int tc = 1; tc <= 10; tc++) {
			int T = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			ArrayDeque<Integer> q = new ArrayDeque<>();
			for (int i = 0; i < 8; i++) q.offer(Integer.parseInt(st.nextToken()));
			int cnt = 1, n = 1;
			while (n > 0) {
				n = q.poll() - cnt;
				if (n < 0) n = 0;
				q.offer(n);
				cnt = cnt % 5 + 1;
			}
			sb.append("#" + T + " ");
			for (int i : q) sb.append(i + " ");
			sb.append("\n");
		}
		br.close();
		System.out.println(sb);
	}
}
