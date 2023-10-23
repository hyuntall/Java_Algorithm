import java.util.*;

class Solution {
    static int ans = Integer.MAX_VALUE;
    
    public int solution(int x, int y, int n) {
        int dp [] = new int[3000001];
        // dp[x] = 0;
        for (int i = x; i <= y; i++) {
            if(i!=x && dp[i] == 0) {
                dp[i] = -1;
                continue;
            }
            dp[i+n] = (dp[i+n] == 0) ? dp[i]+1 : Math.min(dp[i] + 1, dp[i+n]);
            dp[i*2] = (dp[i*2] == 0) ? dp[i]+1 : Math.min(dp[i] + 1, dp[i*2]);
            dp[i*3] = (dp[i*3] == 0) ? dp[i]+1 : Math.min(dp[i] + 1, dp[i*3]);
        }
        return dp[y];
    }
}