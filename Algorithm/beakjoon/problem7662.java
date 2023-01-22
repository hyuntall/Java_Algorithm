package beakjoon;

import java.io.*;
import java.util.*;

public class problem7662 {
	static int k, n;
	static String c;
	static StringTokenizer st;
	
	static int removeMap(PriorityQueue<Integer> queue, HashMap<Integer, Integer> map) {
		int num;
		while (true) {
			num = queue.poll();
			int cnt = map.getOrDefault(num, 0);
			if (cnt == 0)
				continue;
			if (cnt > 1)
				map.put(num, cnt - 1);
			else
				map.remove(num);
			break;
		}
		return num;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < T; tc++) {
			PriorityQueue<Integer> pq = new PriorityQueue<>();
			PriorityQueue<Integer> rpq = new PriorityQueue<>(Collections.reverseOrder());
			// 선언
			HashMap<Integer, Integer> map = new HashMap<>();
			k = Integer.parseInt(br.readLine());
			for (int i = 0; i < k; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				c = st.nextToken();
				n = Integer.parseInt(st.nextToken());
				if (c.equals("I")) {
					map.put(n, map.getOrDefault(n, 0) + 1);
					pq.add(n);
					rpq.add(n);
				} else {
					if (map.size() == 0)
						continue;
					if (n == 1)
						removeMap(rpq, map);
					else
						removeMap(pq, map);
				}
			}
			if (map.size() == 0)
				System.out.println("EMPTY");
			else {
				int maxNum = removeMap(rpq, map);
				int minNum;
				if (map.size() == 0)
					minNum = n;
				else
					minNum = removeMap(pq, map);
				System.out.println(maxNum + " " + minNum);
			}
				
		}
	}
}
