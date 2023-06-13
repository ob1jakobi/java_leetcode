package Easy;

import java.util.HashMap;

public class TwoSum {

    public int[] twosum(int[] nums, int target) {
        HashMap<Integer, Integer> numMap = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];

            if (numMap.containsKey(diff)) {
                return new int[] {numMap.get(diff), i};
            }
            numMap.put(nums[i], i);
        }
        return null;
    }
}
