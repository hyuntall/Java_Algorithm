import java.util.*;
class Solution {
    public String solution(String number, int k) {
        String answer = "";
        char arr[] = number.toCharArray();
        int n = arr.length;
        for (int i = 0; i < n-k; i++) {
            for (int j = i+1; j < i+1+k; j++) {
                if (arr[i] < arr[j]) {
                    arr[i] = 0;
                    k--;
                    break;
                }
            }
        }
        for (int i = n-k; i < n; i++) arr[i] = 0;
        for (char c : arr) if (c!=0) answer+=c;
        return answer;
    }
}