import java.io.*;
import java.util.*;

public class Main {
//G*(A-B*(C/D+E)/F)
	//GABCD/E+*F/-*
	
	static int priority(char c) {
		if(c=='*'||c=='/')return 2;
		else if(c=='+'||c=='-')return 1;
		return 0;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		String line = sc.next();
		ArrayDeque<Character> oper = new ArrayDeque<>();
		ArrayDeque<Character> path = new ArrayDeque<>();
		for (int i = 0; i < line.length(); i++) {
			char c = line.charAt(i);
			if (c>='A'&&c<='Z') {
				sb.append(c);
			}
			else if (c=='(') oper.offer(c);
			else if (c==')') {
				while (!oper.isEmpty()) {
					if(oper.peekLast()=='(') {
						oper.pollLast();
						break;
					}
					sb.append(oper.pollLast());
				}
			}else {
				while (!oper.isEmpty()&&priority(oper.peekLast())>=priority(c))
					sb.append(oper.pollLast());
				oper.offer(c);
			}
		}
		while (!oper.isEmpty())sb.append(oper.pollLast());
		System.out.println(sb);
		sc.close();
	}

}