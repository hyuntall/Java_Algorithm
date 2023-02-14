import java.io.*;
import java.util.*;

public class Solution_d3_1233_사칙연산유효성검사_서울_20반_박현철 {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_d3_1233.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		for (int t = 1; t <= 10; t++) {
			int N = Integer.parseInt(br.readLine());
			ArrayDeque<Integer> q = new ArrayDeque<>();
			HashMap<Integer, int []> map = new HashMap<>();
			char [] arr = new char [N + 1];
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				int n = Integer.parseInt(st.nextToken());
				arr[n] = st.nextToken().charAt(0);
				int a = 0;
				int b = 0;
				if (st.hasMoreTokens()) {
					a = Integer.parseInt(st.nextToken());
				}
				if (st.hasMoreTokens()) {
					b = Integer.parseInt(st.nextToken());
				}
				if (a > 0 && b > 0)
					map.put(n, new int [] {a, b});
			}
			int data = 1;
			int [] curNode = map.get(1);
			q.offer(data);
			boolean able = true;
			while (data < N) {
				data = q.poll();
				curNode = map.get(data);
				if (arr[data] == '+' || arr[data] == '-' || arr[data] == '*' || arr[data] == '/') {
					for(int a : curNode) q.offer(a);
				}
				else {
					if(curNode != null) {
						able = false;
						break;
					}
				}
			}
			sb.append("#" + t + " " + (able ? "1":"0") + "\n");
		}
		System.out.println(sb);
	}

}
