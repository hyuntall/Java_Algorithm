import java.io.*;
import java.util.*;

// 진짜 난 바보다 이걸 중복순열로 풀었어야했는데 그냥 순열로 풀었다 진짜 난 바보인가????
// 어쩐지 답이 계속 안나오더라니 순열 중복 체크하는게 습관이 되어서 ㅡㅡ
// 주입식 교육의 결과다 이건...
public class Main_bj_17779_게리맨더링2_서울_20반_박현철 {
	static int N, ans = Integer.MAX_VALUE;
	static int [][] arr;
	static int [][] v;
	static int perm [] = new int [2];
	static int [] dy = {-1, 1, 0, 0};
	static int [] dx = {0, 0, -1, 1};

	static int getPopulationGap() {
		int min = Integer.MAX_VALUE;
		int max = 0;
		int [] p = new int[5];
		for (int i=1; i<=N; i++) {
			for (int j=1; j<=N; j++) {
				if (v[i][j]==1)		p[1]+=arr[i][j];
				else if (v[i][j]==2)p[2]+=arr[i][j];
				else if (v[i][j]==3)p[3]+=arr[i][j];
				else if (v[i][j]==4)p[4]+=arr[i][j];
				else 				p[0]+=arr[i][j];
			}
		}
		for (int i=0; i<5; i++) {
			min = Math.min(min, p[i]);
			max = Math.max(max, p[i]);
		}
		return (max-min);
	}
	
	static void dfs(int y, int x, int n) {
		v[y][x] = n;
		for (int i = 0; i < 4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];
			if (0<ny&&ny<=N&&0<nx&&nx<=N&&v[ny][nx]==0)
				dfs(ny, nx, n);
		}
	}
	
	static void draw(int y, int x, int d1, int d2) {
		for (int i=0; i<=d1; i++) {
			v[y-i][x+i] 	 = 5;
			v[y+d2-i][x+d2+i]= 5;
		}
		for (int i=0;i<=d2; i++) {
			v[y+i][x+i] 	 = 5;
			v[y-d1+i][x+d1+i]= 5;
		}
		for (int i=y-d1-1; i>0; i--) 	v[i][x+d1] 	 = 1;
		for (int i=x+d1+d2+1; i<=N; i++)v[y-d1+d2][i]= 2;
		for (int i=x-1; i>0; i--) 		v[y][i] 	 = 3;
		for (int i=y+d2+1; i<=N; i++) 	v[i][x+d2] 	 = 4;
	}
	
	static void perm(int cnt) {
		if (cnt == 2) {
			int d1 = perm[0];
			int d2 = perm[1];
			
			for (int y=1; y<=N; y++) {
				for (int x=1; x<=N; x++) {
					if (x<x+d1+d2&&x+d1+d2<=N&&1<=y-d1&&y+d2<=N) {
						v = new int [N+1][N+1];
						draw(y, x, d1, d2);
						dfs(1, 1, 1);
						dfs(1, N, 2);
						dfs(N, 1, 3);
						dfs(N, N, 4);
						ans = Math.min(ans, getPopulationGap());
					}
				}
			}
			return;
		}
		
		for (int i=1; i<N; i++) {
			perm[cnt] = i;
			perm(cnt + 1);
		}
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int [N + 1][N + 1];
		for (int i=1; i<=N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j=1; j<=N; j++) arr[i][j] = Integer.parseInt(st.nextToken());
		}

		perm(0);
		System.out.println(ans);
	}

}