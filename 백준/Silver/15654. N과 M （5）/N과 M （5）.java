import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N, M, a[], b[];
	static boolean [] v;
	static StringBuilder sb = new StringBuilder();
	static void perm(int cnt) {
		if (cnt==M) {
			for (int n:b) sb.append(n + " ");
			sb.append("\n");
			return;
		}
		for (int i = 0; i < N; i++) {
			if(v[i]) continue;
			b[cnt] = a[i];
			v[i] = true;
			perm(cnt+1);
			v[i] = false;
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		a = new int[N];
		b = new int[M];
		v = new boolean[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) a[i] = Integer.parseInt(st.nextToken());
		Arrays.sort(a);
		perm(0);
		System.out.println(sb);
		br.close();
	}
}