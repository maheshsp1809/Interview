package javacodes;
import java.util.Arrays;
import java.util.Stack;
public class stockspan {
    public static void main(String[] args){
        Solution solution=new Solution();
        int []res =new int []{100,80,60,70,60,75,85};
        res=solution.nextGreaterElements(res);
        for(int i=1;i<res.length;++i)
           System.out.println(res[i]);
        }
}
class Solution {
    public int[] nextGreaterElements(int[] A) {
        int n = A.length, res[] = new int[n];
        Arrays.fill(res, 1);
        System.out.println(res[1]);
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> stack1 = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && A[stack.peek()] < A[i]){
                res[i]+=1;
                stack1.push(stack.pop());
        }
            while(!stack1.isEmpty())
                stack.push(stack1.pop());    
            stack.push(i);
        }
        return res;
    }
}