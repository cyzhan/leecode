package simple;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SimpleTest {

    @Test
    public void mainTest(){
//        List<List<Integer>> result = permutation(new int[]{1,2,3});
//        List<List<Integer>> result = permutation(new int[]{1,2,3,4});
//        System.out.printf("result.length = %d\n", result.size());
//        result.forEach(item -> {
//            System.out.printf("item = %s\n", item.toString());
//        });
        int a = maxProfit(new int[]{1,2,3,4});
        System.out.println("ok: " + a);
    }

    @Test
    public void binarySearch(){
        int index = binarySearchArray(1, new int[]{1,2,3,4,5});
        assert index == 0:System.out.printf("index should be 0, not %d", index);

       index = binarySearchArray(7, new int[]{2,7,10,21,28});
        assert index == 1:System.out.printf("index should be 1, not %d", index);

        index = binarySearchArray(10, new int[]{2,7,10,21,28});
        assert index == 2:System.out.printf("index should be 2, not %d", index);

        index = binarySearchArray(28, new int[]{2,7,10,21,28});
        assert index == 4:System.out.printf("index should be 4, not %d", index);
        System.out.println("pass");
    }

    private List<List<Integer>> permutation(int[] nums){
        if (0 == nums.length){
            return new ArrayList<>();
        } else if (1 == nums.length) {
            List<List<Integer>> result = new ArrayList<>();
            result.add(Arrays.stream(nums).boxed().collect(Collectors.toList()));
            return result;
        }

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp;
        for (int i = 0; i < nums.length; i++) {
            int value = nums[i];
            temp = new ArrayList<>();
            for (int j = 0; j < nums.length; j++) {
                if (j == i){
                    continue;
                }
                temp.add(nums[j]);
            }
            List<List<Integer>> subResult = permutation(temp.stream().mapToInt(Integer::intValue).toArray());
            subResult.forEach(item -> {
                item.add(value);
            });
            result.addAll(subResult);
        }

        return result;
    }


    public static int maxProfit(int[] prices) {
// Write your code here
        int min = prices[0];
        int max = prices[0];
        for(int i = 0; i < prices.length; i++){
            if(prices[i] < min){
                min = prices[i];
            }else if(prices[i] > max){
                max = prices[i];
            }
        }
        if(max > min){
            return max - min;
        }else{
            return max;
        }
    }

    /**
     * int[] nums must be a sorted array
     * @return index of target if target is in nums, otherwise return -1
     */
    private int binarySearchArray(int target, int[] nums){
        if (nums.length == 0){
            return -1;
        }

        int left = 0;
        int right = nums.length - 1;

        while (left <= right){
            int mid = left + (right - left) / 2; //To avoid potential overflow
            if (target == nums[mid]){
                return mid;
            }

            if (target > nums[mid]){
                left = mid + 1;
            }else {
                right = mid - 1;
            }
        }

        return -1;
    }


}
