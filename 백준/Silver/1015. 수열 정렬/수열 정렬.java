import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int [] A = new int[N];
		int [] P = new int[N];
		for (int i = 0; i < N; i++) A[i] = Integer.parseInt(st.nextToken());
		P = Arrays.copyOf(A, N);
		Arrays.sort(A);
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (P[i]==A[j]) {
					sb.append(j + " ");
					A[j] = 1001;
					break;
				}
			}
		}
		System.out.println(sb);
		br.close();
	}
}