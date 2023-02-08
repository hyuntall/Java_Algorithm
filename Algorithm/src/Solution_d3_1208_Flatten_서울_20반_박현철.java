import java.io.*;
import java.util.*;

public class Solution_d3_1208_Flatten_서울_20반_박현철 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("res/input_d3_1208.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		for (int tc = 1; tc <= 10; tc++) {
			int dump = Integer.parseInt(br.readLine()) + 1;
			int arr [] = new int [100];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 100; i++) arr[i] = Integer.parseInt(st.nextToken());
			int ans = 0;
			while (--dump > 0) {
				Arrays.sort(arr);
				ans = arr[99]-- - arr[0]++;
			}
			sb.append("#").append(tc).append(" ").append(ans).append("\n");
		}
		System.out.print(sb);
	}
}
