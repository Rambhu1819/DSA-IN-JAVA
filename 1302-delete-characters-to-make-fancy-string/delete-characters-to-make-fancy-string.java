class Solution {
    public String makeFancyString(String s) {
        char[] chars = s.toCharArray();
        char last = chars[0];
        int count = 1;
        int pos = 1;

        for (int idx = 1; idx < chars.length; idx++) {
            if (chars[idx] != last) {
                last = chars[idx];
                count = 0;
            }

            if (++count > 2) continue;

            chars[pos++] = chars[idx];
        }

        return new String(chars, 0, pos);
    }
}