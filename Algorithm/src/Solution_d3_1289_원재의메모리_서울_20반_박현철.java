import java.io.*;
import java.util.*;

public class Solution_d3_1289_원재의메모리_서울_20반_박현철{
	static StringTokenizer st;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			String bits = br.readLine();
			int cnt = (bits.charAt(0) == '1') ? 1 : 0;
			for (int i = 1; i < bits.length(); i++)
				if(bits.charAt(i-1) != bits.charAt(i)) cnt++;
			System.out.println("#" + tc + " " + cnt);
		}
		br.close();
	}
}
