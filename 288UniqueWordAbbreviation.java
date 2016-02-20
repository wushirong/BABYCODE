public class ValidWordAbbr {
    HashMap<String, String> map = new HashMap<String, String>();
    public ValidWordAbbr(String[] dictionary) {
        if(dictionary == null || dictionary.length == 0) return;
        for(String item: dictionary) {
            String str = abbr(item);
            if(map.containsKey(str)) {
                if(! map.get(str).equals(item)) map.put(str, "");
            }
            else map.put(str, item);
        }
    }

    public boolean isUnique(String word) {
        String str = abbr(word);
        return !map.containsKey(str) || map.get(str).equals(word);
    }
    
    private String abbr(String word) {
        if(word.length() < 3) return word;
        else {
            StringBuilder sb = new StringBuilder();
            sb.append(word.charAt(0));
            sb.append(word.length() - 2);
            sb.append(word.charAt(word.length() - 1));
            String str = sb.toString();
            return str;
        }
    }
}