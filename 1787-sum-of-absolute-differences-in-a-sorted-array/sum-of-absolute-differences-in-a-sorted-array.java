class Solution {
    
    public int[] getSumAbsoluteDifferences(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        
        // Calculate total sum
        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }
        
        int leftSum = 0;
        
        for (int i = 0; i < n; i++) {
            int rightSum = totalSum - leftSum - nums[i];
            
            // left side contribution
            int leftPart = nums[i] * i - leftSum;
            
            // right side contribution
            int rightPart = rightSum - nums[i] * (n - i - 1);
            
            result[i] = leftPart + rightPart;
            
            leftSum += nums[i];
        }
        
        return result;
    }
}