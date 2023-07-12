import java.util.Scanner;
public class Main {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		int ans = 0;
		for (int i = 1; i <= A; i++) ans += i;
		System.out.println(ans);
	}
}