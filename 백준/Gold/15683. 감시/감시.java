import java.io.*;
import java.util.*;

public class Main {
	static int N, M, K, ans = Integer.MAX_VALUE;
	static int [][] arr, newArr;
	static int [] dy = {0, 1, 0, -1}; //좌하우상
	static int [] dx = {1, 0, -1, 0};
	static int [] b;
	static ArrayList<int []> cctv = new ArrayList<>();
	
	static int count() {
		int sum = 0;
		for(int i = 0; i < N; i++) 
			for (int j = 0; j < M; j++)
				if(newArr[i][j]==0)sum++;
		return sum;
	}
	
	static void monitoring(int y, int x, int d) {
		while (0<=y&&y<N&&0<=x&&x<M&&newArr[y][x]!=6) {
			newArr[y][x] = 1;
			y += dy[d];
			x += dx[d];
		}
	}
	
	static void comb(int cnt) {
		if (cnt == K) {
			for(int i=0; i<N; i++) for (int j=0; j<M; j++) newArr[i][j]=arr[i][j];
			for (int i = 0; i < K; i++) {
				int y = cctv.get(i)[0];
				int x = cctv.get(i)[1];
				int d = b[i], num = arr[y][x];
				monitoring(y, x, d);
				if(num==2) monitoring(y, x, (d+2)%4);
				if(num==3) monitoring(y, x, (d+3)%4);
				if(num==4) {
					monitoring(y, x, (d+2)%4);
					monitoring(y, x, (d+3)%4);
				}
				if(num==5) {
					monitoring(y, x, (d+1)%4);
					monitoring(y, x, (d+2)%4);
					monitoring(y, x, (d+3)%4);
				}
				
			}
			ans = Math.min(ans, count());
			return;
		}
		for (int i = 0; i < 4; i++) {
			b[cnt] = i;
			comb(cnt+1);
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int [N][M]; newArr = new int [N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++)  {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if (arr[i][j] > 0 && arr[i][j] < 6) {
					cctv.add(new int[] {i, j});
					K++;
				}
			}
		}
		b = new int[K];
		comb(0);
		System.out.println(ans);
	}
}