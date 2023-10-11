import java.io.*;
import java.util.*;

public class Main {
	static int R, C, K;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		int [][] arr = new int [3][3];
		for (int i = 0; i < 3; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++)
				arr[i][j] = Integer.parseInt(st.nextToken());
		}
		
		
		int time = 0;
		while (true) {
			if (arr.length>=R && arr[0].length>=C && arr[R-1][C-1] == K) break;
			if (time>100) break;
			time++;
			arr = sort(arr);
		}
		System.out.println(time <= 100 ? time : -1);
	}
	
	static int [][] sort(int [][] arr) {
		int row = arr.length;
		int col = arr[0].length;

		if (row<col) 
			return rowSort(row, col, arr);
		else return colSort(row, col, arr);
		
	}
	
	static int [][] rowSort(int row, int col, int [][] arr) {
		int maxCnt = 0;
		List<Integer>[] aList = new ArrayList[col];
		for (int i = 0; i < col; i++)aList[i] = new ArrayList<Integer>();
		for (int j = 0; j < col; j++) {
			int [][] a = new int[101][2];
			for (int i = 0; i <= 100; i++)a[i][0] = i;
			for (int i = 0; i < row && i < 100; i++) {
				if (arr[i][j] == 0) continue;
				a[arr[i][j]][1]++;
			}
			Arrays.sort(a, (o1, o2) -> {
				if (o1[1]==o2[1]) 
					return o1[0]-o2[0];
				return o1[1]-o2[1];});

			int cnt = 0;
			for (int i = 0; i <= 100; i++) {
				if(a[i][1] == 0) continue;
				cnt+=2;
				aList[j].add(a[i][0]);
				aList[j].add(a[i][1]);
			}
			maxCnt = Math.max(maxCnt, cnt);
		}
		
		for (int i = 0; i < col; i++) 
			while(aList[i].size()<maxCnt)
				aList[i].add(0);
		
		int [][] newArr = new int[maxCnt][col];
		for (int i = 0; i < col; i++)
			for (int j = 0; j < maxCnt; j++)
				newArr[j][i] = aList[i].get(j);
		
		return newArr;
	}
	
	static int [][] colSort(int row, int col, int [][] arr) {
		
		int maxCnt = 0;
		List<Integer>[] aList = new ArrayList[row];
		for (int i = 0; i < row; i++)aList[i] = new ArrayList<Integer>();
		for (int j = 0; j < row; j++) {
			int [][] a = new int[101][2];
			for (int i = 0; i <= 100; i++)a[i][0] = i;
			for (int i = 0; i < col && i < 100; i++) {
				if (arr[j][i] == 0) continue;
				a[arr[j][i]][1]++;
			}
			Arrays.sort(a, (o1, o2) -> o1[1]-o2[1]);
			int cnt = 0;
			for (int i = 0; i <= 100; i++) {
				if(a[i][1] == 0) continue;
				cnt+=2;
				aList[j].add(a[i][0]);
				aList[j].add(a[i][1]);
			}
			maxCnt = Math.max(maxCnt, cnt);
		}
		
		for (int i = 0; i < row; i++) 
			while(aList[i].size()<maxCnt)
				aList[i].add(0);
		
		int [][] newArr = new int[row][maxCnt];
		for (int i = 0; i < row; i++)
			for (int j = 0; j < maxCnt; j++)
				newArr[i][j] = aList[i].get(j);
		
		return newArr;
	}
}