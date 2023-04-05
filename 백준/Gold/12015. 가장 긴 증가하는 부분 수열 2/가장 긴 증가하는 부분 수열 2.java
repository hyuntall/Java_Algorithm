import java.io.*;
import java.util.*;

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
		int N = Integer.parseInt(br.readLine());
		int [] arr = new int[N], C = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());
		int size = 0;
		for (int i = 0; i < N; i++) {
			int tmp = binarySearch(C, 0, size, arr[i]);
			C[tmp] = arr[i];
			if (size == tmp) size++;
		}
		System.out.println(size);
	}
}