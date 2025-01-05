package leecode.problem62;

import org.junit.jupiter.api.Test;

public class Solution62Test {

    @Test
    public void mainTest(){
        int result = uniquePaths(3,2);
        System.out.printf("result = %s", result);
    }

    /**
     * 1 <= m, n <= 100
     */
    public int uniquePaths(int m, int n) {
        if ((1 == m) && (1 == n)){
            return 1;
        } else if ((1 == m) && (2 == n)){
            return 1;
        } else if ((1 == n) && (2 == m)) {
            return 1;
        }

        int result = 0;
        if (m >= 2){
            result += uniquePaths(m - 1, n);
        }
        if (n >= 2){
            result += uniquePaths(m, n - 1);
        }
        return result;
    }

}
