import java.util.*;
class Solution {
    public int solution(int[] order) {
        int answer = 0;
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for (int i = 1; i <= order.length; i++) {
            stack.offer(i);
            while (!stack.isEmpty() && stack.peekLast() == order[answer]){
                stack.pollLast();
                answer++;
            }
        }
        return answer;
    }
}