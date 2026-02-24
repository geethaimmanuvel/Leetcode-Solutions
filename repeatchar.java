class Srepeatchar {
    public int lengthOfLongestSubstring(String s) {
        int left = 0;
        int right = 0;
        int max = 0;
        int[] counts = new int[128]; // Basic array to track ASCII characters

        while (right < s.length()) {
            char currentChar = s.charAt(right);

            // If the character is already in our window, 
            // move the left side of the window forward
            while (counts[currentChar] > 0) {
                char leftChar = s.charAt(left);
                counts[leftChar]--;
                left++;
            }

            // Add the current character to our "checklist"
            counts[currentChar]++;

            // Manually check for the longest length
            int currentWindowSize = right - left + 1;
            if (currentWindowSize > max) {
                max = currentWindowSize;
            }

            right++;
        }
        
        return max;
    }
}
