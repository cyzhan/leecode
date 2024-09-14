package leecode.problem38;

import org.junit.jupiter.api.Test;

public class Solution38Test {

    @Test
    public void mainTest(){
        String output = countAndSay(3);
        assert "21".equals(countAndSay(3)):"countAndSay(3) should be 21, output = " + output;
        System.out.println("pass");
    }

    public String countAndSay(int n) {
        if (1 == n){
            return "1";
        } else if (2 == n) {
            return "11";
        }

        char[] charArray = countAndSay(n-1).toCharArray();
        int count = 1;
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < charArray.length; i++) {
            if (i == charArray.length - 1){
                stringBuilder.append(count).append(charArray[i]);
                break;
            }

            if (charArray[i] != charArray[i+1]){
                stringBuilder.append(count).append(charArray[i]);
                count = 1;
            } else if (charArray[i] == charArray[i+1]){
                count += 1;
            }
        }
        return stringBuilder.toString();
    }

}
