import java.util.*;

class Solution {
    public int solution(String[][] book_time) {
        PriorityQueue<int []> q = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int [] o1, int [] o2){
                if (o1[0]==o2[0]) return o1[1] - o2[1];
                return o1[0] - o2[0];
            }
        });
        for (String time[] : book_time) {
            String start[] = time[0].split(":");
            String end[] = time[1].split(":");
            int startAt = Integer.parseInt(start[0])*60 + Integer.parseInt(start[1]);
            int endAt = Integer.parseInt(end[0])*60 + Integer.parseInt(end[1]);
            q.offer(new int[]{startAt, endAt});
        }
        
        PriorityQueue<Integer> rooms = new PriorityQueue<>();
        
        rooms.add(q.poll()[1]);
        int ans = 1;
        while (!q.isEmpty()) {
            int cur [] = q.poll();
            if(rooms.peek() + 10 <= cur[0]) rooms.poll();
            
            rooms.offer(cur[1]);
            ans = Math.max(ans, rooms.size());
        }
        return ans;
    }
}