import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int [] a, b, nums;
	static boolean [] v;
	static int minAns = Integer.MAX_VALUE;
	static int maxAns = Integer.MIN_VALUE;
	static void dfs(int i, int sum) {
		if (i == N-1) {
			minAns = Math.min(minAns, sum);
			maxAns = Math.max(maxAns, sum);
			return;
		}
		int next = 0;
		if (b[i]==0) next = sum + nums[i+1];
		if (b[i]==1) next = sum - nums[i+1];
		if (b[i]==2) next = sum * nums[i+1];
		if (b[i]==3) {
			next = Math.abs(sum) / nums[i+1];
			if (sum < 0) next *= -1;
		}
		dfs(i+1,next);
	}
	
	static void perm(int cnt) {
		if (cnt == N-1) {
			dfs(0, nums[0]);
			return;
		}
		for (int i = 0; i < N-1; i++) {
			if (v[i]) continue;
			v[i] = true;
			b[cnt] = a[i];
			perm(cnt+1);
			v[i] = false;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		nums = new int[N];
		a = new int[N-1];
		b = new int[N-1];
		v = new boolean[N-1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N;)nums[i++] = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int index = 0;
		for (int i = 0; i < 4; i++) {
			int com = Integer.parseInt(st.nextToken());
			for (int j = 0; j < com; j++)
				a[index++] = i;
		}
		perm(0);
		System.out.println(maxAns);
		System.out.println(minAns);
	}
}