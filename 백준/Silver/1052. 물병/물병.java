import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		if (K>=N) {
			System.out.println(0);
			return;
		}
		int ans = 0;
		while (true) {
			int cnt = 0;
			int n = N;
			while (n!=0) {
				if(n%2==1) cnt++;
				n/=2;
			}
			if (cnt<=K) break;
			N++;
			ans++;
		}
		System.out.println(ans);
	}
}