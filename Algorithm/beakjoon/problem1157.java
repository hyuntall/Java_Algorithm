package beakjoon;

import java.io.*;
import java.util.*;

public class problem1157 {
	/**
	 * 알파벳 대소문자로 된 단어가 주어지면, 
	 * 이 단어에서 가장 많이 사용된 알파벳이 무엇인지 알아내는 프로그램을 작성하시오. 
	 * 단, 대문자와 소문자를 구분하지 않는다.
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[26];
		String s = sc.next();
		
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) >= 65 && s.charAt(i) <= 90) {
				arr[s.charAt(i) - 'A']++;
			}
			else {
				arr[s.charAt(i) - 'a']++;
			}
		}
		int max = -1;
		char ans = '?';
		
		for (int i = 0; i < 26; i++) {
			if (arr[i] > max) {
				max = arr[i];
				ans = (char) (i + 65);
			}
			else if (arr[i] == max) {
				ans = '?';
			}
		}
		System.out.println(ans);
		sc.close();
	}
}
