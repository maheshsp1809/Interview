package javacodes;
public class search2d {
    public static boolean searchMatrix(int[][] mat, int t) {
    int n=mat.length;
    int m=mat[0].length;
    int mid;
    int l=0;
    int h=(m*n)-1;
    while(l<=h){
        mid=l+(h-l)/2;
        if(mat[mid/m][mid%m]==t) return true;
        else if(mat[mid/m][mid%m]<t) l=mid+1;
        else h=mid-1;
    } 
    return false; 
        }    
    public static void main(String[] args){
    int[][] matr = {
        { 0,  1,  2 },
        { 3,  4,  5 },
        { 6,  7,  8 },
        };
    System.out.println(searchMatrix(matr, 7));
 }   
}
