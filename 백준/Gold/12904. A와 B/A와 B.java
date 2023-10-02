import java.util.*;
import java.io.*;

public class Main {
	static String reverse(String line) {
		String reverse = "";
		for (int i = line.length()-1; i >= 0; i--)
			reverse += line.charAt(i);
		return reverse;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String S = br.readLine();
		String T = br.readLine();
		int ans = 0;
		while (T.length() != S.length()) {
			int len = T.length();
			if (T.charAt(len-1) == 'A')
				T = T.substring(0, len-1);
			else if (T.charAt(len-1) == 'B') {
				T = T.substring(0, len-1);
				T = reverse(T);
			}
		}
		if (T.equals(S)) ans = 1;
		System.out.println(ans);
	}
}