import java.io.*;
import java.util.*;

class Fish implements Comparable<Fish>{
	int n, dir, y, x;
	boolean feeded = false;
	public Fish(int n, int dir, int y, int x, boolean feeded) {
		this.n = n;
		this.dir = dir;
		this.y = y;
		this.x = x;
		this.feeded = feeded;
	}
	
	public void swap(Fish f) {
		int tmpY = f.y;
		int tmpX = f.x;
		f.y = this.y;
		f.x = this.x;
		this.y = tmpY;
		this.x = tmpX;
	}
	
	public Fish cpFish() {
		return new Fish(n, dir, y, x, feeded);
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "["+n + " dir="+dir+"]";
	}

	@Override
	public int compareTo(Fish o) {
		// TODO Auto-generated method stub
		return this.n - o.n;
	}
}

class Shark {
	int dir, y, x, score;
	public Shark(int dir, int y, int x, int score) {
		this.dir = dir;
		this.y = y;
		this.x = x;
		this.score = score;
	}

	public Shark cpShark() {
		return new Shark(dir, y, x, score);
	}
	
}

public class Main {

	static List<Fish> fishList = new ArrayList<Fish>();
	
	static int [] dy = {-1, -1, 0, 1, 1, 1, 0, -1};
	static int [] dx = {0, -1, -1, -1, 0, 1, 1, 1};
	static int ans = 0;
	static int [][] cpArr(int [][]arr) {
		int [][] copyArr = new int[4][4];
		for (int i = 0; i < 4; i++)
			for (int j = 0; j < 4; j++)
				copyArr[i][j] = arr[i][j];
		return copyArr;
	}
	
	static List<Fish> cpList(List<Fish> fishList) {
		List<Fish> copyList = new ArrayList<Fish>();
		for (Fish f : fishList) copyList.add(f.cpFish());
		return copyList;
	}
	
	static void dfs(Shark s, List<Fish> fList, int [][]arr) {
//		System.out.println(s.score);
//		System.out.println("\n\n============");
		for (int i = 1; i < 5; i++) {
			int ny = s.y + dy[s.dir] * i;
			int nx = s.x + dx[s.dir] * i;
//			System.out.println(ny + " " + nx);
			if (ny < 0 || ny >= 4 || nx < 0 || nx >= 4) break;
			if (arr[ny][nx] == 0) continue;
			Shark cpShark = s.cpShark();
			int [][]cpArr = cpArr(arr);
//			System.out.println("BEFORE");
//			for (int a[]:cpArr) System.out.println(Arrays.toString(a));
			List<Fish> cpList = cpList(fList);
//			System.out.println(cpList);
//			System.out.println(ny + " " + nx + " " + cpArr[ny][nx]);
			Fish f = cpList.get(cpArr[ny][nx]-1);
//			System.out.println("shark="+cpShark.score + " fish="+f.n + " " +ny + " " + nx + " " + s.y + " " + s.x);
			cpShark.score += f.n;
			int tmpY = cpShark.y;
			int tmpX = cpShark.x;
			cpShark.y = ny;
			cpShark.x = nx;
			cpArr[ny][nx] = -1;
			cpArr[tmpY][tmpX] = 0;
			f.feeded = true;
			cpShark.dir = f.dir;
//			System.out.println(cpList);
			ans = Math.max(ans, cpShark.score);
//			System.out.println("AFTER");
//			System.out.println("AFTER SHARK DIR = " + cpShark.dir);
//			for (int a[]:cpArr) System.out.println(Arrays.toString(a));
			fishMove(cpList, cpArr);
			dfs(cpShark, cpList, cpArr);
//			for (int a[]:cpArr) System.out.println(Arrays.toString(a));
//			break;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int [][] arr = new int[4][4];
		for (int i = 0; i < 4; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < 4; j++) {
				int n = Integer.parseInt(st.nextToken());
				int dir = Integer.parseInt(st.nextToken())-1;
				fishList.add(new Fish(n, dir, i, j, false));
				arr[i][j] = n;
			}
		}
		Collections.sort(fishList);
		Fish f = fishList.get(arr[0][0]-1);
		Shark shark = new Shark(f.dir, f.y, f.x, 0);
		shark.score = f.n;
		arr[0][0] = -1;
		f.feeded = true;
//		System.out.println(fishList);
//		for (int a[]:arr)System.out.println(Arrays.toString(a));

//		System.out.println("------------");
		fishMove(fishList, arr);
		
//		for (int a[]:arr)System.out.println(Arrays.toString(a));
		dfs(shark, fishList, arr);
		System.out.println(ans);
//		System.out.println(fishList);
	}
	
	static void fishMove(List<Fish> fishList, int [][] arr) {
//		for(int a[]:arr) System.out.println(Arrays.toString(a));
		for (Fish fish : fishList) {
			if (fish.feeded == true) continue;
			
			for (int i = 0; i < 8; i++) {
				int ny = fish.y + dy[fish.dir];
				int nx = fish.x + dx[fish.dir];
//				System.out.println(fish.dir + " " + ny + " " + nx);
				if (ny < 0 || ny >= 4 || nx < 0 || nx >= 4) {
					fish.dir = (fish.dir+1)%8;
					continue;
				}
				if (arr[ny][nx] == -1) {
					fish.dir = (fish.dir+1)%8;
					continue;
					
				}
				if (arr[ny][nx] != 0) {
					int target = arr[ny][nx]-1;
					Fish targetFish = fishList.get(target);
	//				System.out.println(fish.n + "와 " + arr[ny][nx] + " 스왑");
					arr[ny][nx] = fish.n;
					arr[fish.y][fish.x] = targetFish.n; 
					
					fish.swap(targetFish);
				}else {
					int tmpY = fish.y;
					int tmpX = fish.x;
					fish.y = ny;
					fish.x = nx;
					arr[ny][nx] = fish.n;
					arr[tmpY][tmpX] = 0;
				}
				
				
//				for (int a[]:arr)System.out.println(Arrays.toString(a));
//				System.out.println("===========");
				break;
			}
			
		}
	}
}