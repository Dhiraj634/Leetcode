import java.util.Arrays;

class Solution {
    public int maximumsSplicedArray(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int[] newArr = new int[n];
        for(int i=0;i<n;i++){
            newArr[i] = nums2[i] - nums1[i];
        }
        int max1 = findMaxSumSubArray(newArr);
        int sum1 = Arrays.stream(nums1).sum();
        for(int i=0;i<n;i++){
            newArr[i] = -newArr[i];
        }

        int max2 = findMaxSumSubArray(newArr);
        int sum2 = Arrays.stream(nums2).sum();
        
        return Math.max(sum1+max1, sum2+max2);
        
    }
    
    private int findMaxSumSubArray(int[] newArr){
        int sum = 0,max = 0;
        for(int i=0;i<newArr.length;i++){
            if(sum+newArr[i] <=0 ){
                sum = 0;
            }else{
                sum+=newArr[i];
                max = Math.max(sum, max);
            }
        }
        return max;
    }
}
