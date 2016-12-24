String[] items = new String[]{"", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<String>();
        if (digits == null || digits.length() == 0) return res;
        helper(digits, res, 0, new StringBuilder());
        return res;
    }
    
    private void helper(String digits, List<String> res, int index, StringBuilder cur) {
        if (index == digits.length()) res.add(cur.toString());
        else {
            String item = items[Integer.parseInt(Character.toString(digits.charAt(index)))-1];
            for (char ch: item.toCharArray()) {
                cur.append(ch);
                helper(digits, res, index+1, cur);
                cur.deleteCharAt(cur.length()-1);
            }
        }
    }