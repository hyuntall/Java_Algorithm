import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int [] classRoom = new int [N+1];
		int [][] cls = new int[N+1][3];
		PriorityQueue<int []> pq = new PriorityQueue<>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[1]-o2[1];
			}
			
		});
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			cls[i][0] = num;
			cls[i][1] = start;
			cls[i][2] = end;
		}
		Arrays.sort(cls, (o1, o2) -> {
			if(o1[1]==o2[1]) return o1[2]-o2[2];
			return o1[1]-o2[1];
		});
//		for (int a[]:cls)System.out.println(Arrays.toString(a));
//		clsList.add(new int[] {cls[1][0], cls[1][2]});
//		classRoom[cls[1][0]] = 1;
		for (int i = 1; i <= N; i++) {
			int [] c = cls[i];
			boolean flag = false;
			int [] cur = pq.peek();
//			System.out.println(Arrays.toString(c) + " vs " + Arrays.toString(cur));
			if (cur != null && c[1] >= cur[1]) {
//				cur[0] = c[0];
//				cur[1] = c[2];
				pq.poll();
				pq.offer(new int[] {c[0], c[2], cur[2]});
				classRoom[c[0]] = cur[2];
//				System.out.println("교체");
//				System.out.println(classRoom[c[0]] + "번방");
				flag = true;
			}
			if (!flag) {
//				System.out.println("추가");
				pq.offer(new int[] {c[0], c[2], pq.size()+1});
				classRoom[c[0]] = pq.size();
//				System.out.println(classRoom[c[0]] + "번방");
			}
		}
		System.out.println(pq.size());
		for(int i = 1; i <= N; i++) System.out.println(classRoom[i]);
//		System.out.println(Arrays.toString(classRoom));
	}
}