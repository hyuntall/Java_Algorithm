import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        Map map = new HashMap<String, Integer>();
        for (int i = 0; i < players.length; i++) 
            map.put(players[i], i);
        for (String called: callings) {
            int index = (int)map.get(called);
            String tmp = players[index];
            players[index] = players[index-1];
            players[index-1] = tmp;
            map.put(called, index-1);
            map.put(players[index], index);
        }
        return players;
    }
}