package javacodes;

public class mergesorted {
    public static void main(String[] args){
        Solution solution=new Solution();
        int[] n1=new int[]{1,2,3,0,0,0};
        int[] n2=new int[]{2,5,6};
        int[]res=solution.merge(n1, 3,n2,3);
        for(int k: res)
           System.out.print(k+" ");
    }
}
class Solution {
    public int[] merge(int[] n1, int m, int[] n2, int n) {
     int j=0;
     if(n==0) return n1;
     for(int i=0;i<m+n;++i){
         if(n1[i]==0 && n2[j]!=0)
            while(j<n) n1[i++]=n2[j++];
         else   if(n1[i]<n2[j]) ++i;
                else{
                    for(int k=i;k<m+n-2;++k){
                        int t=n1[k];
                        n1[k]=n1[k+1];
                        n1[k+1]=t;
                    }
                    n1[i++]=n2[j++]; 
                }
        
     } 
     return n1;   
    }
}