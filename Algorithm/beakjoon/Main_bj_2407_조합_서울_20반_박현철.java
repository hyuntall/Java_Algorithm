package a0307;

import java.io.*;
import java.util.*;
import java.math.*;

public class Main_bj_2407_조합_서울_20반_박현철 {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		BigInteger n1 = BigInteger.ONE;
		BigInteger n2 = BigInteger.ONE;
		for (int i = 0; i < m; i++) {
			n1 = n1.multiply(new BigInteger(String.valueOf(n-i)));
			n2 = n2.multiply(new BigInteger(String.valueOf(i+1)));
		}
		System.out.println(n1.divide(n2));
	}
}
