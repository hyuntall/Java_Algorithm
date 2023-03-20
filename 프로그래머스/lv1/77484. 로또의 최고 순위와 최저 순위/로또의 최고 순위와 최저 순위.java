import java.io.*;
import java.util.*;

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        int cnt = 0;
        for (int i = 0; i < 6; i++) {
            if (lottos[i]==0)continue;
            for (int j = 0; j < 6; j++) {
                if (lottos[i]>0&&win_nums[j]>0&&lottos[i] == win_nums[j]) {
                    win_nums[j] = -1;
                    lottos[i] = -1;
                    cnt++;
                }
            }
        }
        answer[1] = 7-cnt<6?7-cnt:6;
        for (int i = 0; i < 6; i++) {
            if (lottos[i]==0)cnt++;
        }
        answer[0] = 7-cnt<6?7-cnt:6;
        return answer;
    }
}