package javacodes;

public class rotateMatrix {
 public int[][] rotate(int[][] mat){
    for(int i=0;i<mat.length;++i){
        for(int j=i;j<mat[0].length;++j){
            int temp=0;
            temp=mat[i][j];
            mat[i][j]=mat[j][i];
            mat[j][i]=temp;
        }
    }
    for(int i=0;i<mat.length;++i){
        for(int j=0;j<mat[0].length/2;++j){
            int temp=0;
            temp=mat[i][j];
            mat[i][j]=mat[i][mat.length-1-j];
            mat[i][mat.length-1-j]=temp;
        }
    }
    return mat;
}
    public static void main(String[] args){
        int[][] matr = {
            { 0,  1,  2 },
            { 3,  4,  5 },
            { 6,  0,  8 },
            };
        rotateMatrix obj= new rotateMatrix();    
        int[][]mat=obj.rotate(matr);
        for(int i=0;i<3;++i){
            for(int j=0;j<3;++j)
                System.out.print(mat[i][j]+" ");
            System.out.println();
        }  

    }   
 }   

