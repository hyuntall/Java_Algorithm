class Solution {
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        int [][] arr = new int [rows][columns];
        int n = 1, cnt = 0;
        
        for (int i = 0; i < rows; i++) 
            for (int j = 0; j < columns; j++)
                arr[i][j] = n++;
        
        for (int [] query : queries) {
            int x1 = query[1]-1, y1 = query[0]-1;
            int x2 = query[3]-1, y2 = query[2]-1;
            int min = 2147483647;
            int [][] tmp = new int [rows][columns+1];
            
            for (int i = x1; i < x2; i++) tmp[y1][i+1] = arr[y1][i];
            for (int i = y1; i < y2; i++) tmp[i+1][x2] = arr[i][x2];
            for (int i = x2; i > x1; i--) tmp[y2][i-1] = arr[y2][i];
            for (int i = y2; i > y1; i--) tmp[i-1][x1] = arr[i][x1];
            
            for (int i = 0; i < rows; i++) {// 회전된 값이 담긴 임시 배열 newArr에 복사
		        for (int j = 0; j < columns; j++) {
			        if (tmp[i][j] != 0) {
                        arr[i][j] = tmp[i][j]; // 회전된 값만 복사
                        min = Math.min(min, tmp[i][j]);
                    }
                }
            }
            
            answer[cnt++] = min;
        }
        return answer;
    }
}