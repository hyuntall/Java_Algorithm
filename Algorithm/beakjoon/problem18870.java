package beakjoon;

import java.io.*;
import java.util.*;

public class problem18870 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int arr[] = new int[N];
		int sortedArr[] = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		HashMap<Integer, Integer> rankingMap = new HashMap<Integer,  Integer>();
		for (int i = 0; i < N; i++) arr[i] = sortedArr[i] = Integer.parseInt(st.nextToken());
		Arrays.sort(sortedArr);
		int rank = 0;
		for (int v : sortedArr) if(!rankingMap.containsKey(v)) rankingMap.put(v, rank++);
		StringBuffer sb = new StringBuffer();
		for (int key : arr) sb.append(rankingMap.get(key)).append(" ");
		System.out.println(sb);
	}
}
