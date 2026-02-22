class Mz {
    public void moveZeroes(int[] nums) {
        int insertPos = 0; // Position to insert the next non-zero element
        
        // Move all non-zero elements to the front
        for (int num : nums) {
            if (num != 0) {
                nums[insertPos++] = num;
            }
        }
        
        // Fill the remaining positions with zeros
        while (insertPos < nums.length) {
            nums[insertPos++] = 0;
        }
    }
}