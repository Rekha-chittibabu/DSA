class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int low = 0;
        int high = m * n - 1;

        while(low<=high){
            int mid = low + (high - low)/2;
            // we are flattening row-wise
            int mid_val = matrix[mid/n][mid%n];

            if(mid_val == target)
                return true;
            else if(mid_val < target)
                low = mid +1;
            else
                high = mid - 1;
        }
    return false;
    }
}