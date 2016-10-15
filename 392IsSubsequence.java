public boolean isSubsequence(String s, String t) {
        if (s == null || t == null || s.length() > t.length() ) return false;
        int walker1 = 0;
        int walker2 = 0;
        while (walker2 < t.length()) {
            if (walker1 == s.length()) return true;
            while (walker2 < t.length() && t.charAt(walker2) != s.charAt(walker1)) walker2++;
            if (walker2 == t.length()) break;
            walker1++;
            walker2++;
        }
        return walker1 == s.length();
    }