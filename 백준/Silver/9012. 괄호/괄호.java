import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		ArrayDeque<Character> q = new ArrayDeque<>();
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		a : for (int i = 0; i < N; i++) {
			q.clear();
			String line = br.readLine();
			for (int j = 0; j < line.length(); j++) {
				char c = line.charAt(j);
				if (c=='(') q.offer(c);
				else {
					if (q.isEmpty()) {
						sb.append("NO\n");
						continue a;
					} else q.pollLast();
				}
			}
			if (!q.isEmpty()) sb.append("NO\n");
			else sb.append("YES\n");
		}
		System.out.println(sb);
		br.close();
	}
}