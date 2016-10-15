// add a count to exclude all easy find mistakes can avoid TML error
public boolean isScramble(String s1, String s2) {
         if (s1.equals(s2)) return true; 
        int len = s1.length();
        int[] letters = new int[26];
        for (int i=0; i<s1.length(); i++) {
            letters[s1.charAt(i)-'a']++;
            letters[s2.charAt(i)-'a']--;
        }
        for (int i=0; i<26; i++) if (letters[i]!=0) return false;

        for(int i=1; i<=len-1; i++)
        {
            if( isScramble(s1.substring(0,i), s2.substring(0,i)) && isScramble(s1.substring(i), s2.substring(i)) || 
            isScramble(s1.substring(0,i), s2.substring(len-i)) && isScramble(s1.substring(i), s2.substring(0,len-i)))
                return true;
        }
        return false;
    }

// a TML solution
public boolean isScramble(String s1, String s2) {
        if(s1.length() != s2.length()) return false;
        ArrayList<String> res = build(s1);
        return res.contains(s2);
    }
    
    private ArrayList<String> build(String s) {
    	ArrayList<String> res  = new ArrayList<String>();
    	if (s.length() == 1) {
    		res.add(s);
    		return res;
    	}
    	else {
    		for (int i = 1; i < s.length(); i++) {
    			ArrayList<String> left = build(s.substring(0, i));
        		ArrayList<String> right = build(s.substring(i));
        		for(String leftS: left) {
        			for(String rightS: right) {
        				res.add(leftS + rightS);
        				res.add(rightS + leftS);
        			}
        		}
    		}  		
    		return res;
    	}
    }