class Soad {
    public int[] getSumAbsoluteDifferences(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        
        long totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }
        
        long leftSum = 0;
        
        for (int i = 0; i < n; i++) {
            long rightSum = totalSum - leftSum - nums[i];
            
            long leftPart = (long) nums[i] * i - leftSum;
            long rightPart = rightSum - (long) nums[i] * (n - i - 1);
            
            result[i] = (int) (leftPart + rightPart);
            
            leftSum += nums[i];
        }
        
        return result;
    }
}