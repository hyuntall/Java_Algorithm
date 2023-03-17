import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int [][] arr = new int[N][2];
		for (int i = 0; i < N; i++) {
			arr[i][0] = sc.nextInt();
			arr[i][1] = sc.nextInt();
		}
		Arrays.sort(arr, ((o1, o2)->Integer.compare(o1[1], o2[1])));
		int time = 0;
		while (true) {
			int sumTime = time;
			for (int a[] :arr) {
				if (sumTime+a[0] <= a[1])
					sumTime+=a[0];
				else {
					System.out.println(time-1);
					System.exit(0);;
				}
			}
			time++;
		}
	}
}