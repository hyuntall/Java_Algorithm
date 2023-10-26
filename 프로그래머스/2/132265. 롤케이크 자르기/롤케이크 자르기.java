import java.util.*;

class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        HashMap<Integer, Integer> a = new HashMap<>();
        HashMap<Integer, Integer> b = new HashMap<>();
        for (int t : topping) a.put(t, a.getOrDefault(t, 0)+1);
        
        for (int t : topping) {
            a.put(t, a.get(t)-1);
            if (a.get(t) == 0) a.remove(t);
            b.put(t, b.getOrDefault(t, 0) + 1);
            if (a.size() == b.size()) answer++;
        }
        return answer;
    }
}