import java.io.*;
import java.util.*;

class FireBall{
	int r, c, m, s, d;
	public FireBall(int r, int c, int m, int s, int d) {
		this.r = r;
		this.c = c;
		this.m = m;
		this.s = s;
		this.d = d;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return ""+m;
	}
}

public class Main {
	static int N, M, K;
	static int [] dy = {-1, -1, 0, 1, 1, 1, 0, -1};
	static int [] dx = {0, 1, 1, 1, 0, -1, -1, -1};
	static List<FireBall> [][] arr;
	static List<FireBall> list = new ArrayList<FireBall>();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		arr = new List[N+1][N+1];
		for (int i = 1; i <= N; i++)
			for (int j = 1; j <= N; j++)
				arr[i][j] = new ArrayList<FireBall>();
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			arr[r][c].add(new FireBall(r, c, m, s, d));
		}
		
		for (int i = 0; i < K; i++) {
			// 이동
			move();
			// 합쳐
			sumAndDivide();
			// 나눠
		}
		System.out.println(getSum());
	}
	
	static int getSum() {
		int sum = 0;
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				for (FireBall f : arr[i][j]) {
					sum += f.m;
				}
			}
		}
		return sum;
	}
	
	static void move() {
		ArrayDeque<FireBall> addTmp = new ArrayDeque<>();
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				ArrayDeque<FireBall> tmp = new ArrayDeque<>();
				for (FireBall f : arr[i][j]) {
					int ny = f.r + dy[f.d]*f.s;
					int nx = f.c + dx[f.d]*f.s;
					if (ny > N) ny = ny%N;
					else if (ny <= 0) ny = N+ny%N;
					if (nx > N) nx = nx%N;
					else if (nx <= 0) nx = N+nx%N;
					if (ny == 0) ny = N;
					if (nx == 0) nx = N;
					f.r = ny;
					f.c = nx;
					tmp.offer(f);
					addTmp.offer(f);
				}

				while (!tmp.isEmpty()) {
					FireBall f = tmp.poll();
					arr[i][j].remove(f);
				}
			}
		}
		while (!addTmp.isEmpty()) {
			FireBall f = addTmp.poll();
			arr[f.r][f.c].add(f); 
		}
	}
	
	static void sumAndDivide() {
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (arr[i][j].isEmpty() || arr[i][j].size() < 2) continue;
				ArrayDeque<FireBall> tmp = new ArrayDeque<>();
				int cnt = 0;
				int mSum = 0;
				int sSum = 0;
				int odd = 0;
				for (FireBall f : arr[i][j]) {
					cnt++;
					if (f.d % 2 == 1) odd++;
					mSum += f.m;
					sSum += f.s;
					tmp.offer(f);
				}
				while (!tmp.isEmpty()) {
					arr[i][j].remove(tmp.poll());
				}
				int [] dArr;
				if (odd==cnt || odd==0)dArr = new int []{0, 2, 4, 6};
				else dArr = new int[] {1, 3, 5 ,7};
				
				for (int k = 0; k < 4; k++) {
					if (mSum/5 == 0) break;
					arr[i][j].add(new FireBall(i, j, mSum/5, sSum/cnt, dArr[k]));
				}
			}
		}
	}
}