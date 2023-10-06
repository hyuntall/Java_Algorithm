import java.util.*;

class Solution {
    public String solution(String[] survey, int[] choices) {
        HashMap<Character, Integer> mbti = new HashMap<>();
        for (int i = 0; i < survey.length; i++) 
            mbti.put(survey[i].charAt(0), mbti.getOrDefault(survey[i].charAt(0), 0)+ choices[i]-4); 
        String answer = "";
        answer+=(mbti.getOrDefault('R', 0)<=mbti.getOrDefault('T', 0)? "R" : "T");
        answer+=(mbti.getOrDefault('C', 0)<=mbti.getOrDefault('F', 0)? "C" : "F");
        answer+=(mbti.getOrDefault('J', 0)<=mbti.getOrDefault('M', 0)? "J" : "M");
        answer+=(mbti.getOrDefault('A', 0)<=mbti.getOrDefault('N', 0)? "A" : "N");
        return answer;
    }
}