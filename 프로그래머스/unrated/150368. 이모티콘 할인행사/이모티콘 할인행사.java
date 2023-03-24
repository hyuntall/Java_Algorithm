import java.io.*;
import java.util.*;

class Solution {
    int b[];
    int c, u;
    int [][] temp;
    int ans = 0;
    int maxCnt = 0;
    int [][] Users;
    int [] Emoticons;
    void perm(int cnt) {
        if (cnt==c){
            int [] tmp = new int[u];
            int joiner = 0;
            for (int j = 0; j < u; j++) {
                a : for (int i = 0; i < c; i++) {
                    if (b[i] >= Users[j][0]) {
                        int sum = 0;
                        tmp[j] += Emoticons[i] * (100-b[i])/100;
                        if (tmp[j] >= Users[j][1]) {
                            tmp[j] = 0;
                            joiner++;
                            break a;
                        }
                    }
                }
                int sum = 0;
                for (int a:tmp) sum+=a;
                if (maxCnt<joiner){
                    ans = sum;
                    maxCnt = joiner;
                }
                else if (maxCnt == joiner) ans = Math.max(ans, sum);
               }
            return;
        }
        for (int i = 1; i<=4; i++) {
            b[cnt] = i*10;
            perm(cnt+1);
        }
    }
    
    public int[] solution(int[][] users, int[] emoticons) {
        int[] answer = new int[2];
        c = emoticons.length;
        u = users.length;
        b = new int[c];
        Users = users;
        Emoticons = emoticons;
        perm(0);
        answer[0] = maxCnt;
        answer[1] = ans;
        return answer;
    }
}