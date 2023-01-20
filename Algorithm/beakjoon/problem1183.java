package beakjoon;

import java.io.*;
import java.util.*;

public class problem1183 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(), arr [] = new int [N];
		for (int i = 0; i < N; i++) arr[i] = sc.nextInt() - sc.nextInt();
		Arrays.sort(arr);
		if (arr.length % 2 == 1) System.out.println(1);
		else System.out.println(arr[N/2] - arr[N/2 - 1] + 1);
		sc.close();
	}
}
