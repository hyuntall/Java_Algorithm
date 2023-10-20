import java.io.*;
import java.util.*;

class RGB {
	char dir;
	int a, b;
	public RGB(char dir, int a, int b) {
		this.dir = dir;
		this.a = a;
		this.b = b;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "dir="+dir + ", a="+a+", b="+b;
	}
}

public class Main {
	static int m, n;
	static char [][] arr;
	static int [][] dist;
	static boolean [][] v;
	static int RGB;
	static HashMap <Integer, RGB> rgbMap;
	static ArrayDeque<int []> q;
	static int [] dy = {-1, 1, 0, 0};
	static int [] dx = {0, 0, -1, 1};
	static int exit[] = new int[2];
	static boolean isAble;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			m = Integer.parseInt(st.nextToken());
			n = Integer.parseInt(st.nextToken());
//			System.out.println(m + " " + n);
			if (m == 0 && n == 0) break;
			arr = new char[m][n];
			dist = new int[m][n];
			v = new boolean[m][n];
			RGB = 0;
			rgbMap = new HashMap<>();
			q = new ArrayDeque<>();
			for (int i = 0; i < m; i++) {
				String line = br.readLine();
				for (int j = 0; j < n; j++) {
					arr[i][j] = line.charAt(j);
					if (arr[i][j] - '0' >= 0 && arr[i][j] - '0' <= 9) {
						RGB++;
					}
					if (arr[i][j] == 'A') {
						q.offer(new int[] {i, j, 0});
						v[i][j] = true;
					}
					if (arr[i][j] == 'B') {
						exit[0] = i;
						exit[1] = j;
					}
				}
			}
			for (int i = 0; i < RGB; i++) {
				st = new StringTokenizer(br.readLine());
				int n = Integer.parseInt(st.nextToken());
				char dir = st.nextToken().charAt(0);
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				if (dir == '-')
					rgbMap.put(n, new RGB(dir, a, b));
				else
					rgbMap.put(n, new RGB(dir, b, a));
			}
			
//			for (int i = 0; i < m; i++) System.out.println(Arrays.toString(arr[i]));
//			System.out.println(rgbMap);
			br.readLine();
			dijkstra();
			System.out.println(isAble ? dist[exit[0]][exit[1]] : "impossible");
//			for(int i = 0; i < m; i++) System.out.println(Arrays.toString(dist[i]));
//			
//			System.out.println("========");
		}
	}
	
	static void dijkstra() {
		isAble = false;
		while(!q.isEmpty()) {
			int cur [] = q.poll();
			if (cur[0] == exit[0] && cur[1] == exit[1]) {
				isAble = true;
			}
//			System.out.println(Arrays.toString(cur));
			for (int i = 0; i < 4; i++) {
				int ny = cur[0] + dy[i];
				int nx = cur[1] + dx[i];
				
				if (ny < 0 || ny >= m || nx < 0 || nx >= n) continue;
				if (arr[ny][nx] == '.') continue;
				int time = cur[2];
//				System.out.println("cur= " + Arrays.toString(cur));
//				System.out.println("next=" + ny + " " + nx);
				if (arr[ny][nx] - '0' >= 0 && arr[ny][nx] - '0' <= 9) {
					int n = arr[ny][nx] - '0';
					RGB rgb = rgbMap.get(n);
					int resTime = time%(rgb.a+rgb.b);
					// 신호등이 - 인지 | 인지도 확인해야함
					if (rgb.dir=='-') {
						if (resTime >= rgb.a) {
							// 현재 |
							if(i>1) {
								//못건넘
//								System.out.println("못건넘 " + resTime + " " + rgb.a);
								time += (rgb.b-resTime+rgb.a);
//								System.out.println(time);
							}
						}else {
							// 현재 -
							if(i<2) {
								// 못건넘
//								System.out.println("못건넘 " + resTime + " " + rgb.a);
								time += (rgb.a-resTime);
//								System.out.println(time);
							}
						}
					}
					else {
						// 초기 | 일때,5 3
						// cur 4
						if (resTime >= rgb.a) {
							// 현재 -
							if(i<2) {
								//못건넘
//								System.out.println("못건넘 " + resTime + " " + rgb.a);
								time += (rgb.b-resTime+rgb.a);
//								System.out.println(time);
							}
						}else {
							// 현재 |
							if(i>1) {
								//못건넘
//								System.out.println("못건넘 " + resTime + " " + rgb.a);
								time += (rgb.a-resTime);
//								System.out.println(time);
							}
						}
//						System.out.println(time);
						
					}
				}
				if (!v[ny][nx]) {
					v[ny][nx] = true;
					dist[ny][nx] = time + 1;
					q.offer(new int[] {ny, nx, time+1});
				}
				else if (dist[ny][nx] > time+1) {
					dist[ny][nx] = time+1;
					q.offer(new int[] {ny, nx, time+1});
				}
			}
		}
	}
}