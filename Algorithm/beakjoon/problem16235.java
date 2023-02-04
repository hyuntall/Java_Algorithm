package beakjoon;

import java.io.*;
import java.util.*;

public class problem16235 {
	static StringTokenizer st;
	static int ground[][];
	static ArrayDeque<int []> woods = new ArrayDeque<>();
	static ArrayDeque<int []> deadWoods = new ArrayDeque<>();
	static ArrayDeque<int []> babywoods = new ArrayDeque<>();
	static int nutrient[][];
	static int N;
	static int [] dx = {-1, 0, 1, 1, 1, 0, -1, -1};
	static int [] dy = {-1, -1, -1, 0, 1, 1, 1, 0};
	static void spring() {
		int x, y, age;
		for (int i = 0; i < woods.size();) {
			int [] wood = woods.pollLast();
			x = wood[0];
			y = wood[1];
			age = wood[2];
			if (ground[x][y] >= age) {
				ground[x][y] -= age;
				wood[2] += 1;
				i++;
				woods.addFirst(wood);
			}
			else deadWoods.add(wood);
		}
	}
	static void summer() {
		int x, y, age;
		while (deadWoods.isEmpty() == false) {
			int [] wood = deadWoods.poll();
			x = wood[0];
			y = wood[1];
			age = wood[2];
			ground[x][y] += age/2;
		}
	}
	static void fall() {
		int x, y, age, nx, ny;
		for (int i = 0 ; i < woods.size(); i++) {
			int [] wood = woods.poll();
			x = wood[0];
			y = wood[1];
			age = wood[2];
			if (age % 5 == 0) {
				for (int j = 0; j < 8; j++) {
					nx = x + dx[j];
					ny = y + dy[j];
					if (0 <= nx && nx < N && 0 <= ny && ny < N) {
						int arr [] = {nx, ny, 1};
						babywoods.add(arr);
					}
				}
			}
			woods.add(wood);
		}
		while (babywoods.isEmpty() == false)
			woods.add(babywoods.poll());
	}
	static void winter() {
		for (int i = 0; i < N; i++ ) 
			for (int j = 0; j < N; j++)
				ground[i][j] += nutrient[i][j];
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		ground = new int [N][N];
		nutrient = new int [N][N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				nutrient[i][j] = Integer.parseInt(st.nextToken());
				ground[i][j] = 5;
			}
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());
			int arr[] = {x-1, y-1, z};
			woods.add(arr);
		}
		for (int i = 0; i < K; i++) {
			spring();
			summer();
			fall();
			winter();
		}
		System.out.println(woods.size());
	}
}
