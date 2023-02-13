import java.io.*;
import java.util.*;

public class Solution_d3_1228_암호문1_서울_20반_박현철 {
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_d3_1228.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		for (int t = 1; t <= 10; t++) {
			int N = Integer.parseInt(br.readLine());
			ArrayList<Integer> list = new ArrayList<>();
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < N; i++)
				list.add(Integer.parseInt(st.nextToken()));
			int M = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < M; i++) {
				st.nextToken();
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				for (int j = 0; j < y; j++)
					list.add(x++, Integer.parseInt(st.nextToken()));
			}
			sb.append("#" + t + " ");
			for (int i = 0; i < 10; i++) sb.append(list.get(i) + " ");
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
