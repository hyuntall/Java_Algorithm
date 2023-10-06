import java.io.*;
import java.util.*;

public class Main {
	static int N, ans = 0;
	static int [][] board;
	static boolean [][] merged;
	static int getMaxNum(int [][] board) {
		int max = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N;) 
				max = Math.max(max, board[i][j++]);
		}
		return max;
	}
	
	static void dfs(int [][] board, int cnt) {
//		for(int []a:board) System.out.println(Arrays.toString(a));
//		System.out.println("-------");
		if (cnt > 4) {
			ans = Math.max(ans, getMaxNum(board));
			return;
		}
		int [][] cpBoard = cp(board);
		up(cpBoard);
		dfs(cpBoard, cnt+1);
		
		cpBoard = cp(board);
		down(cpBoard);
		dfs(cpBoard, cnt+1);
		
		cpBoard = cp(board);
		left(cpBoard);
		dfs(cpBoard, cnt+1);
		
		cpBoard = cp(board);
		right(cpBoard);
		dfs(cpBoard, cnt+1);
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		board = new int[N][N];
		merged = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N;) board[i][j++] = Integer.parseInt(st.nextToken());
		}
		dfs(board, 0);
//		right(board);
//		up(board);
//		left(board);
//		down(board);
//		for(int []a:board) System.out.println(Arrays.toString(a));
//		System.out.println("-------");
		System.out.println(ans);
	}
	
	static int [][] cp(int [][] board) {
		int [][] cpBoard = new int[N][N];
		for (int i = 0; i < N;) cpBoard[i] = Arrays.copyOf(board[i++], N);
		return cpBoard;
	}
	
	static void up(int [][] b) {
		merged = new boolean[N][N];
		for (int i = 1; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (b[i][j] == 0) continue;
				int y = i-1;
				while (y>0) {
					if(b[y][j]!=0) break;
					y--;
				}
				if (b[y][j]==b[i][j]&&!merged[y][j]) {
					b[y][j]*=2;
					b[i][j]=0;
					merged[y][j] = true;
				}else if (b[y][j]==0) {
					int tmp = b[y][j];
					b[y][j] = b[i][j];
					b[i][j] = tmp;
				}else {
					int tmp = b[y+1][j];
					b[y+1][j] = b[i][j];
					b[i][j] = tmp;
				}
			}
//			for(int []a:board) System.out.println(Arrays.toString(a));
//			System.out.println("-----");
		}
	}
	
	static void down(int [][] b) {
		merged = new boolean[N][N];
		for (int i = N-2; i >= 0; i--) {
			for (int j = 0; j < N; j++) {
				if (b[i][j] == 0) continue;
				int y = i+1;
				while (y<N-1) {
					if(b[y][j]!=0) break;
					y++;
				}
				if (b[y][j]==b[i][j]&&!merged[y][j]) {
					b[y][j]*=2;
					b[i][j]=0;
					merged[y][j] = true;
				}else if (b[y][j]==0) {
					int tmp = b[y][j];
					b[y][j] = b[i][j];
					b[i][j] = tmp;
				}else {
					int tmp = b[y-1][j];
					b[y-1][j] = b[i][j];
					b[i][j] = tmp;
				}
			}
		}
	}
	
	static void left(int [][] b) {
		merged = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 1; j < N; j++) {
				if (b[i][j] == 0) continue;
				int x = j-1;
				while (x>0){
					if(b[i][x]!=0)break;
					x--;
				}
				if (b[i][x]==b[i][j]&&!merged[i][x]) {
//					System.out.println("왜이거징" + x + " " + j);
//					for(int []a:board) System.out.println(Arrays.toString(a));
//					System.out.println("-----");
					b[i][x]*=2;
					b[i][j]=0;
					merged[i][x] = true;
//					for(int []a:board) System.out.println(Arrays.toString(a));
//					System.out.println("-----");
				}else if (b[i][x]==0) {
					int tmp = b[i][x];
					b[i][x] = b[i][j];
					b[i][j] = tmp;
				}else {
//					System.out.println("이겅가");
//					for(int []a:board) System.out.println(Arrays.toString(a));
//					System.out.println("-----");
					int tmp = b[i][x+1];
					b[i][x+1] = b[i][j];
					b[i][j] = tmp;
				}
			}
		}
	}
	
	static void right(int [][] b) {
		merged = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = N-2; j >= 0; j--) {
				if (b[i][j] == 0) continue;
				int x = j+1;
				while (x<N-1) {
					if (b[i][x]!=0) break;
					x++;
				}
				if (b[i][x]==b[i][j]&&!merged[i][x]) {
					b[i][x]*=2;
					b[i][j]=0;
					merged[i][x] = true;
				}else if (b[i][x]==0) {
					int tmp = b[i][x];
					b[i][x] = b[i][j];
					b[i][j] = tmp;
				}else {
					int tmp = b[i][x-1];
					b[i][x-1] = b[i][j];
					b[i][j] = tmp;
				}
//					for(int []a:board) System.out.println(Arrays.toString(a));
//					System.out.println("-----");
			}
		}
	}
}