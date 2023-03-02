import java.io.*;
import java.util.*;

public class Main {
	//N+1 x N+1
	// 상어(크기, 속도)
	
	// 낚시왕 오른쪽으로 이동
	
	// 가장 위에있는 상어 잡기
	
	// 상어 이동?
	
	static class Shark{
		int r;
		int c;
		int s;
		int d;
		int z;
		public Shark(int r, int c, int s, int d, int z) {
			// TODO Auto-generated constructor stub
			this.r = r;
			this.c = c;
			this.s = s;
			this.d = d;
			this.z = z;
		}
		@Override
		public String toString() {
			return "shark [r=" + r + ", c=" + c + ", s=" + s + ", d=" + d + ", z=" + z + "]";
		}
		
	}
	static int R, C, M, ans;
	static PriorityQueue<Shark> [][] arr;
	static int [] dy = {-1, 1, 0, 0};
	static int [] dx = {0, 0, 1, -1};
	static ArrayList<Shark> sharks = new ArrayList<>();
	
	static void fishing (int x) {
		for (int i = 1; i <= R; i++) {
			if (!arr[i][x].isEmpty()) {
				Shark s = arr[i][x].poll();
				ans += s.z;
				sharks.remove(s);
				return;
			}
		}
	}
	
	static void move(Shark s) {
		int dist = s.s;
		int d = s.d;
		int y = s.r;
		int x = s.c;
		int ny = y, nx = x;
		for (int i = 0; i < dist; i++) {
			y+=dy[d];
			x+=dx[d];
			if (y <= 0 || y > R || x <= 0 || x > C) {
				y-=dy[d]; x-=dx[d];
				if (d%2==0) d++;
				else d--;
				y+=dy[d]; x+=dx[d];
			}
		}
		s.r = y;
		s.c = x;
		s.d = d;
		arr[y][x].offer(s);
		ArrayDeque<Shark> temp = new ArrayDeque<>();
		while (!arr[ny][nx].isEmpty()) {
			Shark tmp = arr[ny][nx].poll();
			if (!tmp.equals(s)) temp.offer(tmp);
			else break;
		}
		while(!temp.isEmpty()) {
			Shark tmp = temp.poll();
			arr[ny][nx].offer(tmp);
		}
	}
	static void eat() {
		for (int i = 1; i <= R; i++) {
			for (int j = 1; j <= C; j++) {
				while (arr[i][j].size()>1) {
					Shark s = arr[i][j].poll();
					sharks.remove(s);
				}
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new PriorityQueue[R+1][C+1];
		int r, c, s, d, z;
		for (int i = 1; i <= R; i++)
			for (int j = 1; j <= C; j++)
				arr[i][j] = new PriorityQueue<>((o1, o2)-> Integer.compare(o1.z, o2.z));
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			r = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			s = Integer.parseInt(st.nextToken());
			d = Integer.parseInt(st.nextToken());
			z = Integer.parseInt(st.nextToken());
			Shark shark = new Shark(r, c, s, d-1, z);
			sharks.add(shark);
			arr[r][c].offer(shark);
		}
		//for (Shark shk : sharks) System.out.print(shk + "\t");;
		//System.out.println();
		for (int i = 1; i <= C; i++) {
			fishing(i);
			for (Shark shk : sharks) move(shk);
			//for (Shark shk : sharks) System.out.print(shk + "\t");;
			//System.out.println();
			eat();
		}
		System.out.println(ans);
	}
}