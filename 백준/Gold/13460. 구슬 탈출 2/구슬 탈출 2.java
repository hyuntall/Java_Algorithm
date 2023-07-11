import java.io.*;
import java.util.*;

public class Main {
	static int N, M;
	static char [][] board;
	static int ans = 11;
	
	public static int left(char [][] cpBoard) {
		int flag = 0;
		for (int i = 1; i < N - 1; i++) {
			for (int j = 1; j < M - 1; j++) {
				if (cpBoard[i][j] == 'R' || cpBoard[i][j] == 'B') {
					int x = j;
					x--;
					while (cpBoard[i][x] == '.') x--;
					
					 if (cpBoard[i][x] == 'O') {
						if (cpBoard[i][j] == 'B') {
							return -1;
						} else {
							cpBoard[i][j] = '.';
							flag = 1;
						}
					}else if (cpBoard[i][x] != '.') {
						char tmp = cpBoard[i][x+1];
						cpBoard[i][x+1] = cpBoard[i][j];
						cpBoard[i][j] = tmp;
					} 
					
				}
			}
		}
		return flag;
	}
	public static int right(char [][] cpBoard) {
		int flag = 0;
		for (int i = 1; i < N-1; i++) {
			for (int j = M-2; j > 0; j--) {
				if (cpBoard[i][j] == 'R' || cpBoard[i][j] == 'B') {
					int x = j;
					x++;
					while (cpBoard[i][x] == '.') x++;
					
					if (cpBoard[i][x] == 'O') {
						if (cpBoard[i][j] == 'B') {
							return -1;
						} else {
							cpBoard[i][j] = '.';
							flag = 1;
						}
					}else if (cpBoard[i][x] != '.') {
						char tmp = cpBoard[i][x-1];
						cpBoard[i][x-1] = cpBoard[i][j];
						cpBoard[i][j] = tmp;
					} 
					
				}
			}
		}
		return flag;
	}
	public static int up(char [][] cpBoard) {
		int flag = 0;
		for (int i = 1; i < N-1; i++) {
			for (int j = 1; j < M-1; j++) {
				if (cpBoard[i][j] == 'R' || cpBoard[i][j] == 'B') {
					int y = i;
					y--;
					while (cpBoard[y][j] == '.') y--;
					
					if (cpBoard[y][j] == 'O') {
						if (cpBoard[i][j] == 'B') {
							return -1;
						} else {
							cpBoard[i][j] = '.';
							flag = 1;
						}
					}else if (cpBoard[y][j] != '.') {
						char tmp = cpBoard[y+1][j];
						cpBoard[y+1][j] = cpBoard[i][j];
						cpBoard[i][j] = tmp;
					} 
					
				}
			}
		}
		return flag;
	}
	public static int down(char [][] cpBoard) {
		int flag = 0;
		for (int i = N-2; i > 0; i--) {
			for (int j = 1; j < M-1; j++) {
				if (cpBoard[i][j] == 'R' || cpBoard[i][j] == 'B') {
					int y = i;
					y++;
					while (cpBoard[y][j] == '.') y++;
					
					if (cpBoard[y][j] == 'O') {
						if (cpBoard[i][j] == 'B') {
							return -1;
						} else {
							cpBoard[i][j] = '.';
							flag = 1;
						}
					}else if (cpBoard[y][j] != '.') {
						char tmp = cpBoard[y-1][j];
						cpBoard[y-1][j] = cpBoard[i][j];
						cpBoard[i][j] = tmp;
					} 
					
				}
			}
		}
		return flag;
	}
	
	static public void dfs(char [][] Board, int cnt) {
		if (cnt > 10 || cnt > ans) return;
		cnt++;
		int able = 0;
		char [][] cpBoard = new char[N][M];
		
		for (int i = 0; i < N; i++) cpBoard[i] = Arrays.copyOf(Board[i], M);
		able = left(cpBoard);
		if (able == 1) ans = Math.min(ans, cnt);
		if (able > -1) dfs(cpBoard, cnt);
		
		for (int i = 0; i < N; i++) cpBoard[i] = Arrays.copyOf(Board[i], M);
		able = right(cpBoard);
		if (able == 1) ans = Math.min(ans, cnt);
		if (able > -1 ) dfs(cpBoard, cnt);
		
		for (int i = 0; i < N; i++) cpBoard[i] = Arrays.copyOf(Board[i], M);
		able = up(cpBoard);
		if (able == 1) ans = Math.min(ans, cnt);
		if (able > -1) dfs(cpBoard, cnt);
		
		for (int i = 0; i < N; i++) cpBoard[i] = Arrays.copyOf(Board[i], M);
		able = down(cpBoard);
		if (able == 1) ans = Math.min(ans, cnt);
		if (able > -1 ) dfs(cpBoard, cnt);
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		board = new char[N][M];
		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			for (int j = 0; j < M; j++) 
				board[i][j] = line.charAt(j);
		}
		dfs(board, 0);
		System.out.println(ans != 11 ? ans : -1);
	}
}