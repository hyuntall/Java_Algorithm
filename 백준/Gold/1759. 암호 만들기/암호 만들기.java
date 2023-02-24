import java.io.*;
import java.util.*;

public class Main {
	static int L, C;
	static int [] arr, b;
	static boolean [] v;
	static StringBuilder sb = new StringBuilder();
	
	static boolean isMoum(int n) {
		if (n == 0 || n == 4 || n == 8 || n == 14 || n == 20)
			return true;
		return false;
	}
	
	static void comb(int cnt, int idx) {
		if (cnt == L) {
			int moum = 0, jaum = 0;
			for (int i = 0; i < L; i++) {
				if (isMoum(b[i])) moum++;
				else jaum++;
			}
			if (moum>0&&jaum>1) {
				for (int a : b) sb.append((char)(a+'a'));
				sb.append("\n");
			}
			return;
		}
		
		for (int i = idx; i < C; i++) {
			b[cnt] = arr[i];
			comb(cnt+1, i+1);
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		arr = new int[C];
		b = new int[L];
		v = new boolean[C];
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < C; i++)
			arr[i] = st.nextToken().charAt(0)-'a';
		Arrays.sort(arr);
		comb(0, 0);
		System.out.println(sb);
	}
}