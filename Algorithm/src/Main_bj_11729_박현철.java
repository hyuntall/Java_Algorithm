import java.io.*;
import java.util.*;

public class Main_bj_11729_박현철 {
	static StringBuilder sb = new StringBuilder();
	static int K;
	static void hanoi(int n, int from, int mid, int to) {
		if (n == 0) return;	
		hanoi(n-1, from, to, mid);
		sb.append(from + " " + to + "\n"); K++;
		hanoi(n-1, mid, from, to);
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		hanoi(N, 1, 2, 3);
		sb.insert(0, K + "\n");
		System.out.println(sb.toString());
	}
}
