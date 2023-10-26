class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        int max = Math.max(arrayA[arrayA.length-1], arrayB[arrayB.length-1]);
        for (int i = max; i > 0; i--) {
            boolean flagA = true;
            boolean flagB = true;
            for (int j = 0; j < arrayA.length; j++){
                if (arrayA[j] % i != 0) flagA = false;
                else                    flagB = false;
                if (arrayB[j] % i != 0) flagB = false;
                else                    flagA = false;
                if (!flagA && !flagB) break;
            }
            if (flagA && !flagB) return i;
            if (!flagA && flagB) return i;
        }
        return 0;
    }
}