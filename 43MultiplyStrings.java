public String multiply(String num1, String num2) {
        if (num1 == null || num2 == null) return "";
        
        int[] pos = new int[num1.length() + num2.length()];
        
        for (int i = num1.length()-1; i >= 0; i--) {
            for (int j = num2.length()-1; j >= 0; j--) {
                int multi = (num1.charAt(i)-'0') *  (num2.charAt(j)-'0');
                int pos1 = i + j;
                int pos2 = i + j + 1;
                multi += pos[pos2];
                pos[pos1] += multi / 10;
                pos[pos2] = multi % 10;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int num: pos) if (!(sb.length() == 0 && num == 0)) sb.append(num);
        return sb.length() == 0? "0":sb.toString();
    }