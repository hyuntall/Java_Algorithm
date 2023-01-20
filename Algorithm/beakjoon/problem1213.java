package beakjoon;

import java.io.*;
import java.util.*;

public class problem1213 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String input = sc.next();
		int [] arr = new int [26];
		int oddCnt = 0, oddIdx = -1;
		String ans = "";
		for (int i = 0; i < input.length(); i++) {
			arr[input.charAt(i)-'A']++;
		}
		for (int i = 0; i < 26; i++) {
			if (arr[i] % 2 == 1) {
				oddCnt++;
				oddIdx = i;
			}
			if (oddCnt > 1)
			{
				System.out.println("I'm Sorry Hansoo");
				return;
			}
			for (int j = 0; j < arr[i]/2; j++)
				ans += (char)('A' + i);
		}
		if (oddIdx > -1)
			ans += (char)('A' + oddIdx);
		for(int i = 25; i >= 0; i--) {
			for (int j = 0; j < arr[i]/2; j++)
				ans += (char)('A' + i);
		}
		System.out.println(ans);
		sc.close();
	}
}
