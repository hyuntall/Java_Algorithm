import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int arr[] = new int[10000001];
        int sum = tangerine.length;
        for (int i = 0; i < tangerine.length; i++)
            arr[tangerine[i]]++;
        
        Arrays.sort(arr);
        int answer = 0;
        for (int i = 0; i <= 10000000; i++) {
            if (arr[i] == 0) continue;
            if (sum == k) {
                answer++;
                continue;
            }
            if (sum - arr[i] >= k){
                sum -= arr[i];
                arr[i] = 0;
            }else{
                arr[i] -= (k - sum);
                sum = k;
                if (arr[i] > 0) answer++;
            }
        }
        return answer;
    }
}