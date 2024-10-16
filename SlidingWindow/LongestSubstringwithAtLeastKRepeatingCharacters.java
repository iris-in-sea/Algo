class LongestSubstringwithAtLeastKRepeatingCharacters {
    // Method 1: Silding Window
    // TLE
    public int longestSubstring(String s, int k) {
        if (s == null || s.length() < k) {
            return 0;
        }

        Map<Character, Integer> map = new HashMap<>();
        int res = 0;

        for (int l = 0; l < s.length(); l++) {
            // reset the count map
            map.clear();

            for (int r = l; r < s.length(); r++) {
                char c = s.charAt(r);
                map.put(c, map.getOrDefault(c, 0) + 1);

                if (atLeasteK(map, k)) {
                    res = Math.max(res, r - l + 1);
                }
            }
        }

        return res;
    }

    private boolean atLeasteK(Map<Character, Integer> map, int k) {
        for (Integer value : map.values()) {
            if (value < k) {
                return false;
            }
        }
        return true;
    }


    // ========================================================
    // Method 2: DFS
    public int longestSubstring(String s, int k) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        Map<Character, Integer> freq = new HashMap<>();
        for (char c : s.toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }

        for (int i = 0; i < s.length(); i++) {
            if (freq.get(s.charAt(i)) < k) {
                int leftPart = longestSubstring(s.substring(0, i), k);
                int rightPart = longestSubstring(s.substring(i + 1), k);
                return Math.max(leftPart, rightPart);
            }
        }

        return s.length();
    }
}
