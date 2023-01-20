package beakjoon;

import java.io.*;
import java.util.*;

public class problem25180 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int result = (N - 1) / 9 + 1;
		if (N % 2 == 1 && result % 2 == 0)
			result++;
		System.out.println(result);
		sc.close();
	}
}
