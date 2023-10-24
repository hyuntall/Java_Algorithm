import java.util.*;

class Solution {
    
    static boolean [][] v;
    static int [] dy = {-1, 1, 0, 0};
    static int [] dx = {0, 0, -1, 1};
    
    static int bfs(int y, int x, String [] maps){
        int cnt = 0;
        ArrayDeque<int []> q = new ArrayDeque<>();
        
        q.offer(new int[]{y, x});
        v[y][x] = true;
        while (!q.isEmpty()){
            int cur[] = q.poll();
            cnt += maps[cur[0]].charAt(cur[1]) - '0';
            for (int i = 0; i < 4; i++) {
                int ny = cur[0] + dy[i];
                int nx = cur[1] + dx[i];
                
                if (ny < 0 || ny >= maps.length || nx < 0 || nx >= maps[0].length())
                    continue;
                if (v[ny][nx] || maps[ny].charAt(nx) == 'X') continue;
                v[ny][nx] = true;
                q.offer(new int[]{ny, nx});
            }
            
        }        
        return cnt;
    }
    
    public int[] solution(String[] maps) {
        v = new boolean[maps.length][maps[0].length()];
        List<Integer> island = new ArrayList<>();
        for (int i = 0; i < maps.length; i++) {
            for (int j = 0; j < maps[0].length(); j++) {
                if (v[i][j] || maps[i].charAt(j) == 'X') continue;
                island.add(bfs(i, j, maps));
            }
        }
        if (island.size() == 0) return new int[]{-1};

        Collections.sort(island);

        int answer [] = new int[island.size()];
        for (int i = 0; i < island.size(); i++) answer[i] = island.get(i);
        
        return answer;
    }
}