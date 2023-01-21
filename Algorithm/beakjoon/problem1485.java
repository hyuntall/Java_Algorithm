package beakjoon;

import java.io.*;
import java.util.*;

public class problem1485 {
	static double getDist(int x1, int x2, int y1, int y2) {
		return Math.sqrt( Math.pow(y2 - y1, 2) + Math.pow(x2 - x1, 2));
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 0; tc < T; tc++) {
			int [][] pos = new int [4][4];
			double [] dists = new double [6];
			int cnt = 0;
			for (int i = 0; i < 4; i++)
				for (int j = 0; j < 2; j++)
					pos[i][j] = sc.nextInt();
			for (int i = 0; i < 3; i++) 
				for (int j = i + 1; j < 4; j++) 
					dists[cnt++] = getDist(pos[i][0], pos[j][0], pos[i][1], pos[j][1]);
			Arrays.sort(dists);
			if (dists[0] == dists[1] && dists[0] == dists[2] && dists[0] == dists[3]
					&& dists[1] == dists[2] && dists[1] == dists[3] && dists[2] == dists[3]
							&& dists[4] == dists[5])
				System.out.println(1);
			else System.out.println(0);
		}
	}
}
