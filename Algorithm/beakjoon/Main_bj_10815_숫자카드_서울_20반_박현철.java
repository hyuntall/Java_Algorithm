package a0308;

import java.io.*;
import java.util.*;

public class Main_bj_10815_숫자카드_서울_20반_박현철 {
	static int [] arr;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		arr = new int [N];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++)arr[i] = Integer.parseInt(st.nextToken());
		Arrays.sort(arr);
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < M; i++) 
			sb.append((Arrays.binarySearch(arr, Integer.parseInt(st.nextToken()))>=0?1:0)+" ");
		System.out.println(sb);
		br.close();
	}
}
