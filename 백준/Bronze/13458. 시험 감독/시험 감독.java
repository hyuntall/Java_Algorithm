import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int [] arr = new int[N];
		for (int i=0;i<N;)arr[i++] = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int B = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		for (int i=0;i<N;)arr[i++]-=B;
		long ans = (long) N;
		for (int i=0;i<N;i++)ans += arr[i]>0?(arr[i]/C+(arr[i]%C>0?1:0)):0;
		System.out.println(ans);
	}
}