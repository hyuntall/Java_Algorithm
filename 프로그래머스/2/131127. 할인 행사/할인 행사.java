import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < want.length; i++) map.put(want[i], i);
        int [] disc = new int[discount.length];
        int [] check = new int[12];
        for (int i = 0; i < discount.length; i++) disc[i] = map.getOrDefault(discount[i], 11);
        
        for (int i = 0; i < 10; i++) check[disc[i]]++;
        
        
        for (int i = 0; i <= discount.length - 10; i++){
            boolean isAble = true;
            for (int j = 0; j < want.length; j++) {
                if (check[j] != number[j]) {
                    isAble = false;
                    break;
                }
            }
            if (isAble) answer++;
            if(i+10 <discount.length){
                check[disc[i]]--;
                check[disc[i+10]]++;
            }
            
        }
        
        return answer;
    }
}