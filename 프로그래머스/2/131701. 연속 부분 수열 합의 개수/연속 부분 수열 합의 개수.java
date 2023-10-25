import java.util.*;
class Solution {
    public int solution(int[] elements) {
        int len = elements.length;
        int [] e = new int [len*2];
        for (int i = 0; i < len; i++) e[i] = elements[i];
        for (int i = 0; i < len; i++) e[i+len] = elements[i];

        HashSet<Integer> set = new HashSet<Integer>();
        
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                int sum = 0;
                for (int k = i; k <= i+j; k++) sum+=e[k];
                set.add(sum);
            }
        }
        
        return set.size();
    }
}