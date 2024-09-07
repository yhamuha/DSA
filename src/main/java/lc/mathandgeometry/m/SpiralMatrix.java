package lc.mathandgeometry.m;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    // O(m*n) O(m*n)
    public List<Integer> spiralOrder(int[][] matrix) {
        int m=matrix.length;
        int n=matrix[0].length;
        List<Integer> ans = new ArrayList<>();
        int top=0,left=0;
        int right=n-1,bottom=m-1;
        while(top<=bottom && left<=right){
            for (int i = left; i <= right; i++)
                ans.add(matrix[top][i]);
            top++;
            for (int i = top; i <= bottom; i++)
                ans.add(matrix[i][right]);
            right--;
            if (top <= bottom) {
                for (int i = right; i >= left; i--)
                    ans.add(matrix[bottom][i]);
                bottom--;
            }
            if (left <= right) {
                for (int i = bottom; i >= top; i--)
                    ans.add(matrix[i][left]);
                left++;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        SpiralMatrix spiralMatrix = new SpiralMatrix();
        List<Integer> result = spiralMatrix.spiralOrder(matrix);
        System.out.println(result);
    }
}