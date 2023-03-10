package a0307;

import java.io.*;
import java.util.*;

public class Main_bj_1316_그룹단어체커_서울_20반_박현철 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int ans = 0;
		test: for (int t = 0; t < N; t++) {
			String line = br.readLine();
			int checker = 0 | 1 << line.charAt(0)-'a';
			int prev = line.charAt(0)-'a';
			for (int i = 1; i < line.length(); i++) {
				int n = line.charAt(i)-'a';
				if ((checker & 1<<n) != 0 && prev != n)
					continue test;
				prev = n;
				checker |= 1<<n;
			}
			ans++;
		}
		System.out.println(ans);
	}
}
