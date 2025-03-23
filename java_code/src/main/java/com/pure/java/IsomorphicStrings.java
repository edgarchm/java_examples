package com.pure.java;
class IsomorphicStrings {
    /**
     * Determines if two strings are isomorphic.
     *
     * @param s The first string.
     * @param t The second string.
     * @return true if the strings are isomorphic, false otherwise.
     */
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) {// 1. Check if lengths are equal
            return false;
        }
        // 2. Initialize maps
        java.util.Map<Character, Character> mapS = new java.util.HashMap<>();
        java.util.Map<Character, Character> mapT = new java.util.HashMap<>();

        for (int i = 0; i < s.length(); i++) {// 3. Iterate through strings
            char charS = s.charAt(i);
            char charT = t.charAt(i);
            // 4. Check mappings
            if (mapS.containsKey(charS)) {
                if (mapS.get(charS) != charT) {
                    return false;
                }
            } else {
                mapS.put(charS, charT);
            }

            if (mapT.containsKey(charT)) {
                if (mapT.get(charT) != charS) {
                    return false;
                }
            } else {
                mapT.put(charT, charS);
            }
        }
        return true;// 5. Strings are isomorphic
    }

    public static void main(String[] args) {
        IsomorphicStrings isomorphic = new IsomorphicStrings();

        String[] testS = {"egg", "foo", "paper", "ab"};
        String[] testT = {"add", "bar", "title", "aa"};

        for (int i = 0; i < testS.length; i++) {
            System.out.println("Test " + (i + 1) + ": " + isomorphic.isIsomorphic(testS[i], testT[i]));
            // Expected Output: True, False, True, False
        }
    }
}