import java.util.Arrays;

public class AppendKIntegerWithMinimalSum {
    public long minimalKSum(int[] nums, int k) {
        int last = 0;
        long sum = 0;
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++){
            if(nums[i] - last <=1){
                last=nums[i];
            }else{
                int gap = nums[i] - last - 1;
                if(k >= gap){
                    long n = gap;
                    sum += (n*(2L *(last+1)+(n-1)))/2;
                    last=nums[i];
                    k-=gap;
                }else{
                    int n = k;
                    sum += (n*(2L *(last+1)+(n-1)))/2;
                    last+=k;
                    k=0;
                }

            }
            if(k==0)break;
        }
        int n = k;
        sum += (n*(2L *(last+1)+(n-1)))/2;
        return sum;


    }
}
