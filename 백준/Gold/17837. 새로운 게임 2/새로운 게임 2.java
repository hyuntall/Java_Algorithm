import java.io.*;
import java.util.*;

class piece {
	int y;
	int x;
	int d;
	
	public piece(int y, int x, int d) {
		this.y = y;
		this.x = x;
		this.d = d;
	}
}

public class Main {
	static int N, K;
	static int [][] arr;
	static ArrayDeque<piece> [][] pieces;
	static ArrayList<piece> list = new ArrayList<>();
	static int [] dy = {0, 0, -1, 1};
	static int [] dx = {1, -1, 0, 0};

	static boolean check() {
		for (int i = 1; i <= N; i++) 
			for (int j = 1; j <= N; j++)
				if (pieces[i][j].size()>=4) return false;
		return true;
	}
	
	static void reverseMove(piece cur, int ny, int nx) {
		ArrayDeque<piece> tmp = pieces[cur.y][cur.x];
		
		while (!tmp.isEmpty()) {
			piece man = tmp.pollLast();
			man.y = ny;
			man.x = nx;
			pieces[ny][nx].offer(man);
			if (man.equals(cur)) break;
		}
	}
	
	static void move(piece cur, int ny, int nx) {
		ArrayDeque<piece> tmp = pieces[cur.y][cur.x];
		ArrayDeque<piece> tmp2 = new ArrayDeque<>();
		
		while (!tmp.isEmpty()) {
			piece man = tmp.poll();
			if (!man.equals(cur)) tmp2.offer(man);
			else {
				tmp.offerFirst(man);
				break;
			}
		}
		
		while (!tmp.isEmpty()) {
			piece man = tmp.poll();
			man.y = ny;
			man.x = nx;
			pieces[ny][nx].offer(man);
		}
		
		while (!tmp2.isEmpty()) tmp.offer(tmp2.poll());
	}
	static void blue(piece man) {
		if (man.d%2==0) man.d++;
		else man.d--;
		int ny = man.y+dy[man.d];
		int nx = man.x+dx[man.d];
		if (0<ny&&ny<=N&&0<nx&&nx<=N) {
			if (arr[ny][nx]==0) move(man, ny, nx);
			if (arr[ny][nx]==1) reverseMove(man, ny, nx);
		}
	}
	static void turn(piece man) {
		int ny = man.y+dy[man.d];
		int nx = man.x+dx[man.d];
		if (0<ny&&ny<=N&&0<nx&&nx<=N&&arr[ny][nx]!=2) {
			if (arr[ny][nx]==0) move(man, ny, nx);
			if (arr[ny][nx]==1) reverseMove(man, ny, nx);
		}
		else if (0>=ny||ny>N||0>=nx||nx>N||arr[ny][nx]==2) blue(man);
		
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		arr = new int [N+1][N+1];
		pieces = new ArrayDeque[N+1][N+1];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 1; j <= N; j++) {
				pieces[i][j] = new ArrayDeque<>();
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int y = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken())-1;
			piece man = new piece(y, x, d);
			pieces[y][x].offer(man);
			list.add(man);
		}
		
		int ans = 0;
		while (ans<=1000 && check()) {
			
			for (piece man : list) {
				turn(man);
				if (!check()) break;
			}
			ans++;
		}
		System.out.println(ans<=1000?ans:-1);
	}
}