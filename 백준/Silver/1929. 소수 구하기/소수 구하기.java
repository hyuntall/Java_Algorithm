import java.io.*;
import java.util.*;

public class Main {
	static boolean [] v;
	static void era(int n) {
		int range = n+1;
		v = new boolean[range];
		v[0] = v[1] = true;
		double sqrt = Math.sqrt(n);
		for (int i = 2; i <= sqrt; i++) 
			if (!v[i]) for (int j = i+i; j<range; j+=i) v[j] = true;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		era(1000000);
		int M = sc.nextInt();
		int N = sc.nextInt();
		for (int i = M; i <=N; i++)
			if(!v[i])sb.append(i+"\n");
		System.out.println(sb);
		sc.close();
	}

}