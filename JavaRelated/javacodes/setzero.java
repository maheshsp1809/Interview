package javacodes;

public class setzero {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] matr = {
            { 0,  1,  2 },
            { 3,  4,  5 },
            { 6,  0,  8 },
            { 9, 10, 11 }
          };
        int[][] merged = solution.setZeroes(matr);
        for(int i=0;i<4;++i){
            for(int j=0;j<3;++j)
                System.out.print(merged[i][j]+" ");
            System.out.println();
        }  
    }      
}

class Solution{
    public int[][] setZeroes(int[][] mat){
        int col0=1, rows=mat.length, cols=mat[0].length;
        for(int i=0;i<rows;++i){
           if(mat[i][0]==0) col0 =0;
           for(int j=1;j<cols;++j)
              if(mat[i][j]==0)
                mat[i][0]=mat[0][j]=0; 
        }
        for(int i=rows-1;i>=0;i--){
            for(int j=cols-1;j>=1;j--)
               if(mat[i][0]==0 || mat[0][j]==0)
                  mat[i][j]=0;
            if(col0==0) mat[i][0]=0;      
        }
    return mat;    
    }
}
