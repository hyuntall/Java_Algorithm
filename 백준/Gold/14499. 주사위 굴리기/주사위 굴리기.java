import java.io.*;
import java.util.*;

class dice {
	int top = 0, bot = 0, up = 0, down = 0, left = 0, right = 0;
	public void move(int com) {
		int tmp = top;
		if (com == 1) {
			top = left;
			left = bot;
			bot = right;
			right = tmp;
		}
		if (com == 2) {
			top = right;
			right = bot;
			bot = left;
			left = tmp;
		}
		if (com == 3) {
			top = up;
			up = bot;
			bot = down;
			down = tmp;
		}
		if (com == 4) {
			top = down;
			down = bot;
			bot = up;
			up = tmp;
		}
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "top="+top+" bot="+bot+" up="+up+" down="+down+" left="+left+" right="+right;
	}
}

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int [][] arr = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dice dice = new dice();
		st = new StringTokenizer(br.readLine());

		int [] dy = {0, 0, 0, -1, 1};
		int [] dx = {0, 1, -1, 0, 0};
		for (int i = 0; i < K; i++) {
			int com = Integer.parseInt(st.nextToken());
			int ny = y + dy[com];
			int nx = x + dx[com];
//			System.out.println(ny + " " + nx + "com = " + com);
			if (ny < 0 || ny >= N || nx < 0 || nx >= M) continue;
			dice.move(com);
//			System.out.println("흡" + dice.top);
			sb.append(dice.top+"\n");
			if (arr[ny][nx] == 0) {
				arr[ny][nx] = dice.bot;
			} else {
				dice.bot = arr[ny][nx];	
				arr[ny][nx] = 0;
			}
			y = ny;
			x = nx;
//			System.out.println(dice);
		}
		System.out.println(sb);
		br.close();
	}
}