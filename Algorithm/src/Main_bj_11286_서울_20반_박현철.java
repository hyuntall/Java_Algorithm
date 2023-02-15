import java.io.*;
import java.util.*;

public class Main_bj_11286_서울_20반_박현철 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PriorityQueue<Integer> q = new PriorityQueue<>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				int r = Integer.compare(Math.abs(o1), Math.abs(o2));
				if (r == 0) r = Integer.compare(o1, o2);
				return r;
			}
		});
		int N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			int x = Integer.parseInt(br.readLine());
			if (x != 0) q.offer(x);
			else System.out.println(q.isEmpty() ? 0 : q.poll());
		}
	}
}
