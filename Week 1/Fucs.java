class Fucs {
    public int firstUniqChar(String s) {
        int[] count = new int[26];  // Array to count occurrences of each character
        
        // Count frequency of each character
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
        }
        
        // Find first character with count 1
        for (int i = 0; i < s.length(); i++) {
            if (count[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }
        
        return -1;  // No unique character found
    }
}