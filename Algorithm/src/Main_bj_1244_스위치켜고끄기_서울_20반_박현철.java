import java.io.*;
import java.util.*;

public class Main_bj_1244_스위치켜고끄기_서울_20반_박현철 {
	static StringTokenizer st;
	static int N, M, gender, num;
	static int arr[];
	
	static void male(int num) {
		for (int i = num; i <= N; i+=num)
			arr[i] = 1 - arr[i];
	}
	
	static void female(int num) {
		for (int i = 0; 0 < num - i && num + i <= N; i++) {
			if (arr[num-i] == arr[num+i]) arr[num+i] = arr[num-i] = 1 - arr[num-i];
			else break;
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		arr = new int[N + 1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(br.readLine());
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			gender = Integer.parseInt(st.nextToken());
			num = Integer.parseInt(st.nextToken());
			if (gender == 1) male(num);
			else female(num);
		}
		for (int i = 1; i <= N; i++) {
			sb.append(arr[i]).append(" ");
			if (i % 20 == 0) sb.append("\n");
		}
		System.out.println(sb);
	}
}
