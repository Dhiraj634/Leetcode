package src;

import java.util.*;

public class FindDifferenceOfTwoArrays {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        Set<Integer> temp1 = new HashSet<>();
        Set<Integer> temp2 = new HashSet<>();
        List<List<Integer>> ans = new ArrayList<>();
        for(int num : nums1){
            boolean isPresent = false;
            for(int num2 : nums2){
                if(num == num2){
                    isPresent = true;
                }
            }
            if(!isPresent)temp1.add(num);
        }
        for(int num : nums2){
            boolean isPresent = false;
            for(int num2 : nums1){
                if(num == num2){
                    isPresent = true;
                }
            }
            if(!isPresent)temp2.add(num);
        }
        ans.add(new ArrayList<>(temp1));
        ans.add(new ArrayList<>(temp2));
        return ans;
    }
}
