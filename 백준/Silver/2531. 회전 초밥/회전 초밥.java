import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		
		int [] arr = new int[N];
		for(int i = 0; i < N; i++) arr[i] = Integer.parseInt(br.readLine());
		
		int [] eat = new int[d+1];
		eat[c]++;
		int ans = 0, cnt = 1; 
		
		for(int i = 0; i < k; i++) {
			if(eat[arr[i]] == 0) cnt++;
			eat[arr[i]]++;
			
		}
		ans = cnt;
		for(int i = 0; i < N; i++) {
			if(eat[arr[i%N]] == 1) cnt--; eat[arr[i%N]]--;
			if(eat[arr[(k+i)%N]] == 0) cnt++; eat[arr[(k+i)%N]]++;
			ans = Math.max(ans, cnt);	
		}
		System.out.println(ans);		
		br.close();
	}
}