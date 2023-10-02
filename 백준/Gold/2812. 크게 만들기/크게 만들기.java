import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		String line = br.readLine();
		char arr [] = line.toCharArray();
		for (int i = 0; i < N - K; i++) {
			for (int j = i+1; j < i + 1 + K; j++) {
				if (arr[i] < arr[j]) {
					arr[i] = 0;
					K--;
					break;
				}
			}
		}
		for (int i = N-K; i < N; i++) arr[i] = 0;
		StringBuilder sb = new StringBuilder();
		for (char c : arr) if (c != 0) sb.append(c);
		System.out.println(sb);
		br.close();
	}
}