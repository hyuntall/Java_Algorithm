package beakjoon;

import java.io.*;
import java.util.*;

public class problem1931 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int [][] time = new int [N][2];
		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			time[i][0] = Integer.parseInt(st.nextToken());
			time[i][1] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(time, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
					if (o1[1] == o2[1])
						return o1[0] - o2[0];
				return o1[1] - o2[1];
			}
			
		});
		int result = 0, exitTime = 0;
		for (int i = 0; i < N; i++) {
			if (time[i][0] >= exitTime) {
				exitTime = time[i][1];
				result++;
			}
		}
		System.out.println(result);
	}
}
