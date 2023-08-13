package actions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class exercise {

    public void exerciseSort(ArrayList<Integer> list){


        Collections.sort(list);

        for (Integer i : list) {
            if((list.get(i+1) - list.get(i)) != 0){

            }
        }


        for (Integer i : list) {



        }




    }

    public class ConsecutiveGroups {
        public static void main(String[] args) {
            int[] inputArray = {2, 5, 7, 6, 9, 1};

            List<int[]> consecutiveGroups = groupConsecutiveNumbers(inputArray);

            // Output the result
            for (int[] group : consecutiveGroups) {
                System.out.println("[" + group[0] + "," + group[1] + "]");
            }
        }

        public static List<int[]> groupConsecutiveNumbers(int[] nums) {
            List<int[]> result = new ArrayList<>();
            if (nums == null || nums.length == 0) {
                return result;
            }

            int start = nums[0];
            int end = nums[0];

            for (int i = 1; i < nums.length; i++) {
                if (nums[i] == end + 1) {
                    end = nums[i];
                } else {
                    result.add(new int[]{start, end});
                    start = nums[i];
                    end = nums[i];
                }
            }

            result.add(new int[]{start, end}); // Add the last group
            return result;
        }
    }
}
