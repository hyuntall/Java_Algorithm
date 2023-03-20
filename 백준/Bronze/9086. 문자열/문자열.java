import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
        	String line = br.readLine();
        	System.out.println(line.charAt(0) + ""+line.charAt(line.length()-1));
        }
        br.close();
    }
}