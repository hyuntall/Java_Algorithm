import java.util.*;
class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = new int [numbers.length];
        ArrayDeque<Integer> q = new ArrayDeque<>();
        q.offer(0);
        for (int i = 1; i < numbers.length; i++) {
            // 현재 스택 끝 값이 numbers[i] 보다 크면, numbers[i]는 스택 끝 값의 뒤 큰 수
            while (!q.isEmpty() && numbers[i] > numbers[q.peekLast()]) {
                if (numbers[i] > numbers[q.peekLast()]){
                    answer[q.pollLast()] = numbers[i];
                }
            }
            q.offer(i);
        }
        while (!q.isEmpty()) answer[q.poll()] = -1;
        return answer;
    }
}