import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();
		boolean [] sn = new boolean[10001];
		for (int n = 1; n <= 10000; n++) {
			String N = String.valueOf(n);
			int nn = n;
			for (int i = 0; i < N.length(); i++)
				nn += N.charAt(i)-'0';
			if (nn <= 10000) sn[nn] = true;
		}
		for (int n = 1; n <= 10000; n++)
			if(!sn[n]) sb.append(n+"\n");
		System.out.println(sb);
	}

}