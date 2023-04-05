import java.io.*;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
	static int binarySearch(int src[], int left, int right, int target) {
		int mid;
		
		while (left < right) {
			mid = (left+right)/2;
			if (src[mid]<target) left = mid+1;
			else right = mid;
		}
		return right;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		int [] arr = new int[N], C = new int[N], dp = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());
		int size = 0;
		int max = 0;
		for (int i = 0; i < N; i++) {
			int tmp = binarySearch(C, 0, size, arr[i]);
			C[tmp] = arr[i];
			dp[i] = tmp+1;
			if (size == tmp) size++;
		}
		sb.append(size+"\n");
		ArrayDeque<Integer> q = new ArrayDeque<>();
		for (int i = N-1; i >= 0; i--) {
			if (dp[i]==size) {
				q.offer(arr[i]);
				size--;
			}
		}
		while (!q.isEmpty())
			sb.append(q.pollLast() + " ");
		System.out.println(sb);
		br.close();
	}
}