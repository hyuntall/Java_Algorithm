import java.io.*;
import java.util.*;

public class Main {
	
	static int[][] arr = new int[10][10];
    static int[] paper = { 0, 5, 5, 5, 5, 5 };
    static int ans = Integer.MAX_VALUE;
 
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
 
        for (int i = 0; i < 10; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 10; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dfs(0, 0, 0);
        System.out.println(ans!=Integer.MAX_VALUE?ans:-1);
        br.close();
    }
    
    public static void dfs(int y, int x, int cnt) {
        if (y>9) {
        	ans = Math.min(ans, cnt);
        	return;
        }
        
        if (cnt>ans) return;
        
        if (x>9) {
        	dfs(y+1, 0, cnt);
        	return;
        }
        
        if (arr[y][x] == 0) {
        	dfs(y, x+1, cnt);
        	return;
        }
        
        for (int size = 5; size > 0; size--) {
        	if (paper[size]>0 && isAble(y, x, size)) {
        		attach(y, x, size, 0);
        		paper[size]--;
        		dfs(y, x+1, cnt+1);
        		attach(y, x, size, 1);
        		paper[size]++;
        	}
        }
    }
    static boolean isAble(int y, int x, int s) {
    	for (int i = y; i < y+s; i++) 
    		for (int j = x; j < x+s; j++) 
    			if (i>9||j>9||arr[i][j]==0) 
    				return false;
    	return true;
    }
    static void attach(int y, int x, int s, int b) {
    	for (int i = y; i < y+s; i++) 
    		for (int j = x; j < x+s; j++) 
    			arr[i][j]=b;
    }
}