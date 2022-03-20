import java.util.Stack;

public class CountCollisionsOnARoad {
    public int countCollisions(String directions) {
        Stack<Character> stack = new Stack<>();
        int collide = 0;
        for(char ch: directions.toCharArray()){
            if(stack.empty())stack.push(ch);
            else{
                if(ch == 'L'){
                    if(stack.peek() == 'R'){
                        collide+=2;
                        stack.pop();
                        while(stack.size() > 0 && stack.peek() == 'R'){
                            collide++;
                            stack.pop();
                        }
                        stack.push('S');
                    }else if(stack.peek() == 'L'){
                        stack.push(ch);
                    }else{
                        collide++;
                        stack.push('S');
                    }
                }else if(ch == 'R'){
                    stack.push(ch);
                }else{
                    while(stack.size() > 0 && stack.peek() == 'R'){
                        collide++;
                        stack.pop();
                    }
                    stack.push(ch);
                }
            }
        }
        return collide;
    }
}
