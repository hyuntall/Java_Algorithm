import java.io.*;
import java.util.*;

public class Solution_d4_1218_괄호짝짓기_서울_20반_박현철 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_d4_1218.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		for (int tc = 1; tc <= 10; tc++) {
			ArrayDeque<String> q = new ArrayDeque<>();
			int len = Integer.parseInt(br.readLine());
			String str = br.readLine();
			int able = 1;
			for (int i = 0; i < len; i++) {
				char c = str.charAt(i);
				if (c == '(') q.offer(")");
				else if (c == '[') q.offer("]");
				else if (c == '{') q.offer("}");
				else if (c == '<') q.offer(">");
				else {
					String s = q.pollLast();
					if (s.charAt(0) != c) {
						able = 0;
						break;
					}
				}
			}
			sb.append("#").append(tc).append(" ").append(able).append("\n");
		}
		System.out.println(sb);
	}
}
