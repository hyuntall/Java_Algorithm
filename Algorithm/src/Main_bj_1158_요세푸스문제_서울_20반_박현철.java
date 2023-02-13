import java.io.*;
import java.util.*;

public class Main_bj_1158_요세푸스문제_서울_20반_박현철 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder();
		LinkedList<Integer> list = new LinkedList<>();
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		for (int i = 1; i <= N; i++) list.add(i);
		sb.append("<");
		int index = 0;
		while(list.size() > 1) {
			index = (index + (K - 1)) % list.size();
			sb.append(list.remove(index)).append(", ");
		}
		sb.append(list.remove()).append(">");
		System.out.println(sb);
	}
}
