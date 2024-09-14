package leecode.problem48;

import org.junit.jupiter.api.Test;

public class Solution48Test {

    @Test
    public void mainTest(){

    }

    private void rotate(int[][] matrix) {
        int lenght = matrix.length;
        int[] temp;
        for (int i = 0; i < lenght; i++) {
            if (i < lenght -1 - i){
                temp = matrix[i];
                matrix[i] = matrix[lenght -1 -i];
                matrix[lenght -1 -i] = temp;
            }
        }
        int tempInt;
        for (int i = 0; i < lenght; i++) {
            for (int j = 0; j < i; j++) {
                tempInt = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tempInt;
            }
        }
    }

}
