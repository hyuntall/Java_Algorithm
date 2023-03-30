import java.io.*;
import java.util.*;

public class Main {
	static int [][] arr = new int[9][9];
	static boolean able;
	
	static void printBoard() {
		StringBuilder sb = new StringBuilder();
		for (int row[]:arr) {
			for (int n : row) sb.append(n);
			sb.append("\n");
		}
		System.out.println(sb);
	}
	
	static boolean isAble(int y, int x, int n) {
		for (int i = 0; i < 9; i++) 
			if (arr[i][x] == n) return false;
		for (int i = 0; i < 9; i++) 
			if (arr[y][i] == n) return false;
		int row = y/3*3;
		int col = x/3*3;
		for (int i = row; i < row+3; i++) 
			for (int j = col; j < col+3; j++)
				if (arr[i][j]==n) return false;
		return true;
	}
	
	static void fillBoard(int y, int x) {
		if (able) return;
		
		if (y==9) {
			printBoard();
			able = true;
			return;
		}
		
		if (x==9) {
			fillBoard(y+1, 0);
			return;
		}
		
		if (arr[y][x]==0) {
			for (int i = 1; i <= 9; i++) {
				if (isAble(y, x ,i)) {
					arr[y][x]=i;
					fillBoard(y, x+1);
				}
			}
			arr[y][x] = 0;
		}
		else fillBoard(y, x+1);
	};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int i = 0; i < 9; i++) {
			String line = br.readLine();
			for (int j = 0; j < 9; j++) arr[i][j] = line.charAt(j)-'0';
		}
		fillBoard(0, 0);
		br.close();
	}
}