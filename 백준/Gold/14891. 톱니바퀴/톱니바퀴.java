import java.io.*;
import java.util.*;

public class Main {
	static StringTokenizer st;
	static String gears [] = new String [4];
	static boolean visited [];
	public static void rotate(int num, int dir, boolean isRotate) {
		visited[num] = true;
		String curGear = new String(gears[num]);
		if (isRotate) {
			if (dir == 1) {
				String first = gears[num].substring(0, gears[num].length()-1);
				String last = gears[num].substring(gears[num].length()-1);
				gears[num] = last + first;
			}
			else {
				String first = gears[num].substring(0, 1);
				String last = gears[num].substring(1);
				gears[num] = last+first;
			}
		}
		boolean newRotate = false;
		if (num - 1 >= 0 && !visited[num - 1]) {
			if (isRotate && curGear.charAt(6) != gears[num-1].charAt(2))
				newRotate = true;
			rotate(num-1, -dir, newRotate);
		}
		newRotate = false;
		if (num + 1 < 4 && !visited[num + 1]) {
			if (isRotate && curGear.charAt(2) != gears[num+1].charAt(6)) 
                    newRotate = true;
			rotate(num+1, -dir, newRotate);
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int i = 0; i < 4; i++) 
			gears[i] = br.readLine();
		int K = Integer.parseInt(br.readLine());
		int num, dir;

		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			num = Integer.parseInt(st.nextToken()) - 1;
			dir = Integer.parseInt(st.nextToken());
			visited = new boolean[4];
			rotate(num, dir, true);
		}
		int point = 1;
		int result = 0;
		for (String s : gears) {
			if (s.charAt(0) == '1') result += point;
			point *= 2;
		}
		System.out.println(result);
	}
}