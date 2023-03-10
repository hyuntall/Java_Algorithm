package a0307;

import java.io.*;
import java.util.*;

public class Main_bj_1541_잃어버린괄호_서울_20반_박현철 {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		String line = sc.nextLine();

		int ans = 0, oper = 1;
		String n = "";
		for (int i = 0; i < line.length(); i++) {
			if (line.charAt(i) == '+'||line.charAt(i) == '-') {
				ans += Integer.parseInt(n)*oper;
				if (line.charAt(i) == '-') oper = -1;
				n = "";
				continue;
			}
			n += line.charAt(i);
		}
		ans += Integer.parseInt(n)*oper;
		System.out.println(ans);
	}
}
