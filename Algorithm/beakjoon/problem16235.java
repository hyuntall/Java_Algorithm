package beakjoon;

import java.io.*;
import java.util.*;

import javax.swing.text.html.parser.Entity;

public class problem16235 {
	static StringTokenizer st;
	static int ground[][];
	//static HashMap<int [], Integer> woods = new HashMap<>();
	static PriorityQueue<int []> woods = new PriorityQueue<>(new Comparator<int []>() {

		@Override
		public int compare(int[] o1, int[] o2) {
			// TODO Auto-generated method stub
			return Integer.compare(o1[2], o2[2]);
		}
	});
	static int nutrient[][];
	static int N;
	static int [] dx = {-1, 0, 1, 1, 1, 0, -1, -1};
	static int [] dy = {-1, -1, -1, 0, 1, 1, 1, 0};
	static void spring() {
		int x, y, age;

		for (int [] wood : woods) {
			x = wood[0];
			y = wood[1];
			age = wood[2];
			if (ground[x][y] >= age) {
				ground[x][y] -= age;
				wood[2] += 1;
			}
			else wood[2] = 0;
		}
	}
	static void summer() {
		int x, y, age;
		for (int [] wood : woods) {
			x = wood[0];
			y = wood[1];
			age = wood[2];
			if (age == 0) {
				ground[x][y] += age/2;
				woods.poll();
			}
		}
	}
	static void fall() {
		int x, y, age, nx, ny;
		for (int i = 0; i < woods.size(); i++) {
			x = woods[i] [0];
			y = wood[1];
			age = wood[2];
			if (age % 5 == 0) {
				for (int i = 0; i < 8; i++) {
					nx = x + dx[i];
					ny = y + dy[i];
					if (0 <= nx && nx < N && 0 <= ny && ny < N) {
						int arr [] = {nx, ny, 1};
						woods.add(arr);
					}
				}
			}
		}
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
		//woods = new int [N][N];
		
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
			System.out.println(i);
			spring();
			//System.out.println(woods);
			
			summer();
			
			fall();
			
			winter();
		}
		System.out.println(woods.size());
		for (int[] v : ground) System.out.println(Arrays.toString(v));
	}

}
