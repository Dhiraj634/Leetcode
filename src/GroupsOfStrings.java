import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GroupsOfStrings {
    public int[] groupStrings(String[] words) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(String word : words){
            int bitMask = 0;
            for(char ch : word.toCharArray()){
                bitMask |= (1 << (ch - 'a'));
            }
            map.put(bitMask, map.getOrDefault(bitMask,0)+1);
        }
        int groups = 0, maxSize = -1;
        List<Integer> uniqueString = new ArrayList<>(map.keySet());
        for(int num : uniqueString){
            if(map.containsKey(num)){
                groups++;
                int size = dfs(num,map);
                maxSize = Math.max(size, maxSize);
            }
        }
        return new int[]{groups,maxSize};

    }
    private int dfs(int bitMask, HashMap<Integer, Integer> map){
        if(!map.containsKey(bitMask)) return 0;
        int size = map.get(bitMask);
        map.remove(bitMask);
        // Deleting and adding a character
        // since we are flipping the bits, doing 1 -> 0 means deleting and 0 -> 1 means adding
        // so both the conditions are covered here
        for(int i=0;i<26;i++){
            int newBitMask = (bitMask ^ (1<<i));
            size+=dfs(newBitMask, map);
        }

        // Replacing a character with others . Picking one bit with value one  and set it as 0 and then pick one bit with value 0 and set it as 1
        for(int i=0;i<26;i++){
            // Checking for bit value = 1 at position i
            if((bitMask & (1<<i)) > 0){

                for(int j=0;j<26;j++){

                    if((bitMask & (1 << j)) == 0){
                        int newBitMask = bitMask ^ (1 << i); // changing bit value from 1 to 0
                        newBitMask = newBitMask ^ (1 << j); // changing bit value from 0 to 1
                        size+=dfs(newBitMask,map);
                    }

                }
            }
        }
        return size;
    }
}
