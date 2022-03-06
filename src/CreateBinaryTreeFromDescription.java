import java.util.HashMap;
import java.util.HashSet;

public class CreateBinaryTreeFromDescription {
    public TreeNode createBinaryTree(int[][] descriptions) {
        HashMap<Integer, TreeNode> map = new HashMap<>();
        for(int[] des : descriptions){
            if(map.containsKey(des[0])){
                if(des[2]==1){
                    if(map.containsKey(des[1])){
                        map.get(des[0]).left = map.get(des[1]);
                    }else{
                        TreeNode node = new TreeNode(des[1]);
                        map.get(des[0]).left = node;
                        map.put(des[1],node);
                    }
                }else{
                    if(map.containsKey(des[1])){
                        map.get(des[0]).right = map.get(des[1]);
                    }else{
                        TreeNode node = new TreeNode(des[1]);
                        map.get(des[0]).right = node;
                        map.put(des[1],node);
                    }
                }
            }else{
                TreeNode node = new TreeNode(des[0]);
                map.put(des[0],node);
                if(des[2]==1){
                    if(map.containsKey(des[1])){
                        map.get(des[0]).left = map.get(des[1]);
                    }else{
                        TreeNode node1 = new TreeNode(des[1]);
                        map.get(des[0]).left = node1;
                        map.put(des[1],node1);
                    }
                }else{
                    if(map.containsKey(des[1])){
                        map.get(des[0]).right = map.get(des[1]);
                    }else{
                        TreeNode node1 = new TreeNode(des[1]);
                        map.get(des[0]).right = node1;
                        map.put(des[1],node1);
                    }
                }

            }
        }
        HashSet<Integer> set = new HashSet<>();
        for(int[] des : descriptions){
            set.add(des[1]);
        }
        for(int node: map.keySet()){
            if(!set.contains(node)){
                return map.get(node);
            }
        }
        return null;
    }
}
