import java.util.*;

class Solution {
    
    static void rebuild(int s, int e, int [] seq){
        if (seq[1] - seq[0] > e - s - 1) {
            seq[0] = s;
            seq[1] = e - 1;
        }
    }
    
    public int[] solution(int[] sequence, int k) {
        int [] answer = {0, sequence.length-1};
        int sum = sequence[0];
        int s = 0, e = 1;
        
        while (s <= e) {
            if (sum == k) {
                rebuild(s, e, answer);
                sum -= sequence[s++];
            }
            if (sum > k)                    sum -= sequence[s++];
            else if (e < sequence.length)   sum += sequence[e++];
            else                            break;
        }
        
        return answer;
    }
}