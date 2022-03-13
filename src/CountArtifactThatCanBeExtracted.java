import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CountArtifactThatCanBeExtracted {
    public int digArtifacts(int n, int[][] artifacts, int[][] dig) {
        int[][] grid = new int[n][n];
        for(int[] arr : grid){
            Arrays.fill(arr,-1);
        }
        HashMap<Integer, Integer> original = new HashMap<>();
        for(int i=0;i<artifacts.length;i++){
            int count = 0;
            for(int j=artifacts[i][0]; j<=artifacts[i][2];j++){
                for(int k=artifacts[i][1];k<=artifacts[i][3];k++){
                    grid[j][k] = i+1;
                    count++;
                }
            }
            original.put(i+1,count);
        }
        HashMap<Integer, Integer> fre = new HashMap<>();
        for(int[] arr : dig){
            fre.put(grid[arr[0]][arr[1]],fre.getOrDefault(grid[arr[0]][arr[1]],0)+1);
        }
        int count = 0;
        for(Map.Entry<Integer,Integer> entry : fre.entrySet()){
            int ans = entry.getValue();
            int s = entry.getKey();
            if(original.containsKey(s) && original.get(s) == ans)count++;
        }
        return count;
    }
}
