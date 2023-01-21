package beakjoon;

import java.io.*;
import java.util.*;

public class problem11399 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int i = 0, result = 0;
		int arr [] = new int [N];
		while (st.hasMoreTokens())
			arr[i++] = Integer.parseInt(st.nextToken());
		Arrays.sort(arr);
		for (i = 0; i < N; i++)
			result += (arr[i] * (N - i));
		System.out.println(result);
	}
}
