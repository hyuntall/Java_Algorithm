import java.io.*;
import java.util.*;

public class Main {
	static class target{
		int iHp, cHp;
		public target(int iHp, int cHp) {
			this.iHp = iHp;
			this.cHp = cHp;
		}
	}
	static int N, K;
	static target [][]arr, newArr;
	static int []b;
	static int [] bullet;
	static int [] dy = {-1, 1, 0, 0};
	static int [] dx = {0, 0, -1, 1};
	static int point, ans;
	static void boom(int y, int x, target [][] newArr, int dmg) {
		if (newArr[y][x].iHp >= 10) {
			point+= newArr[y][x].iHp;
			newArr[y][x].iHp = 0;
			newArr[y][x].cHp = 0;
			return;
		}
		newArr[y][x].cHp -= dmg;
		if (newArr[y][x].cHp > 0) return;
		point+=newArr[y][x].iHp;
		for (int i = 0; i < 4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];
			if (0<ny&&ny<=N&&0<nx&&nx<=N&&newArr[ny][nx].iHp==0) {
				newArr[ny][nx].iHp = newArr[y][x].iHp/4;
				newArr[ny][nx].cHp = newArr[y][x].iHp/4;
			}
		}
		newArr[y][x].iHp = 0;
		newArr[y][x].cHp = 0;
	}
	
	static void shoot(int y, target [][] newArr, int dmg) {
		for (int i = 1; i <= N; i++) {
			if (newArr[y][i].iHp > 0) {
				boom(y, i, newArr, dmg);
				break;
			}
		}
	}
	
	static void perm(int cnt) {
		if (cnt == K) {
			point = 0;
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					int hp = arr[i][j].iHp;
					newArr[i][j] = new target(hp, hp);
				}
			}
			for (int i = 0; i < K; i++) {
				shoot(b[i], newArr, bullet[i]);
			}
			ans = Math.max(ans, point);
			return;
		}
		for (int i = 1; i <= N; i++) {
			b[cnt] = i;
			perm(cnt+1);
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		K = Integer.parseInt(br.readLine());
		arr = new target[N+1][N+1];
		newArr = new target[N+1][N+1];
		b = new int[K];
		bullet = new int[K];
		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 1; j <= N; j++) {
				int hp = Integer.parseInt(st.nextToken());
				arr[i][j] = new target(hp, hp);
			}
		}
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < K; i++) {
			bullet[i] = Integer.parseInt(st.nextToken());
		}
		perm(0);
		System.out.println(ans);
	}

}