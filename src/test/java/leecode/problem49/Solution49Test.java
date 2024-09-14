package leecode.problem49;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Solution49Test {

    @Test
    public void mainTest(){

    }

    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        if (strs.length == 0){
            return result;
        }

        Map<String, List<String>> map = new HashMap<>();
        char[] charArray;
        for (String str : strs) {
            charArray = str.toCharArray();
            Arrays.sort(charArray);
            String key = new String(charArray);
            map.computeIfAbsent(key, k -> new ArrayList<>());
            map.get(key).add(str);
        }
        return new ArrayList<>(map.values());
    }

}
