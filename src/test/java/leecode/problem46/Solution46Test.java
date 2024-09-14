package leecode.problem46;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Solution46Test {

    @Test
    public void mainTest(){

    }


    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> resultList = new ArrayList<>();
        if (nums.length == 1){
            resultList.add(Arrays.stream(nums).boxed().collect(Collectors.toList()));
            return resultList;
        }
        List<List<Integer>> element;
        for (int i = nums.length - 1; i > -1 ; i--) {
            Integer value = nums[i];
            List<Integer> tempList = new ArrayList<>();
            for (int j = 0; j < nums.length; j++) {
                if (i != j){
                    tempList.add(nums[j]);
                }
            }
            element = permute(tempList.stream().mapToInt(Integer::intValue).toArray());
            element.forEach(item -> item.add(value));
            resultList.addAll(element);
        }
        return resultList;
    }

}
