import java.io.*;
import java.util.*;

public class Main {
	// N = (x+1) + (x+2) + (x+3) + ... + (x+L)
	// Lx = N - L * (L+1) / 2
	// x = (N - L * (L+1)/2) / L
	// x % L == 0 이면 수열 출력가능
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int L = sc.nextInt();
		boolean able = false;
		for (int i = L; i <= 100; i++) {
			int x = N - (i * (i + 1) / 2);
			if (x%i==0) {
				x = x/i;
				if (x>=-1) {
					for (int j = 1; j <= i; j++)
						System.out.print(x + j + " ");
					able = true;
					System.out.println();
					break;
				}
			}
		}
		if (!able) System.out.println(-1);
	}
}