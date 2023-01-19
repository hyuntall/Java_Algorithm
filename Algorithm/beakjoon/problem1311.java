package beakjoon;

import java.io.*;
import java.util.*;

public class problem1311 {
	static final int [] dx = {-2, -1, 1, 2, 2, 1, -1, -2};
	static final int [] dy = {1, 2, 2, 1, -1, -2, -2, -1};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int board[][] = new int [6][6];
		String input = sc.nextLine();
		int curX = input.charAt(0) - 'A';
		int curY = input.charAt(1) - '1';
		board[curX][curY] = 1;
		int startX = curX;
		int startY = curY;
	
		boolean isValid = false;
		for (int i = 0; i < 35; i++) {
			isValid = false;
			input = sc.nextLine();
			int nextX = input.charAt(0) - 'A';
			int nextY = input.charAt(1) - '1';
			if (board[nextX][nextY] == 1) break;
			board[nextX][nextY] = 1;
			for (int j = 0; j < 8; j++) {
				if (curX + dx[j] == nextX && curY + dy[j] == nextY) {
					isValid = true;
					break;
				}
			}
			if (!isValid) break;
			curX = nextX;
			curY = nextY;
		}
		if (isValid) {
			isValid = false;
			for (int j = 0; j < 8; j++) {
				if (curX + dx[j] == startX && curY + dy[j] == startY) {
					isValid = true;
					break;
				}
			}
		}
		if (isValid) System.out.println("Valid");
		else System.out.println("Invalid");
		
	}
}
