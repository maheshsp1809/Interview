package javacodes;

import java.util.Arrays;
import java.util.Stack;

public class nextgreaterTwo {
    public static void main(String[] args){
    Solution solution=new Solution();
    int []res =new int []{1,2,3,4,3};
    res=solution.nextGreaterElements(res);
    // for(int n:res)
    //    System.out.println(n);
    }  
}
class Solution {
    public int[] nextGreaterElements(int[] A) {
        int n = A.length, res[] = new int[n];
        Arrays.fill(res, -1);
        System.out.println(res[1]);
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n * 2; i++) {
            while (!stack.isEmpty() && A[stack.peek()] < A[i % n])
                res[stack.pop()] = A[i % n];   
            stack.push(i % n);
        }
        return res;
    } 
}