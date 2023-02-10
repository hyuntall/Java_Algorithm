import java.io.*;
import java.util.*;

public class Main_bj_2961_도영이가만든맛있는음식_서울_20반_박현철 {
	static int N, result, C;
	static int [] s, b;
	static void subsetRecipe(int cnt, int S, int B) {
		if (cnt == N) {
			if (B > 0) result = Math.min(result, Math.abs(S - B));
			return;
		}
		subsetRecipe(cnt + 1, S, B);
		subsetRecipe(cnt + 1, S * s[cnt], B + b[cnt]);
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		s = new int [N];
		b = new int [N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int S = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			s[i] = S;
			b[i] = B;
		}
		result = Integer.MAX_VALUE;
		subsetRecipe(0, 1, 0);
		System.out.println(result);
		br.close();
	}
}
