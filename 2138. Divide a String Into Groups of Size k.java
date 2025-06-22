class Solution {
    public String[] divideString(String s, int k, char fill) {
        List<String> res = new ArrayList<>();

        for (int i = 0; i < s.length(); i += k) {
            int end = Math.min(i + k, s.length());
            String group = s.substring(i, end);
            if (group.length() < k) {
                group += String.valueOf(fill).repeat(k - group.length());
            }
            res.add(group);
        }
        
        return res.toArray(new String[0]);
    }
}
