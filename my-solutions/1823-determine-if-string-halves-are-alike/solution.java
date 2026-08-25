class Solution {
    public boolean halvesAreAlike(String s) {
        int leftVowels = 0;
        int rightVowels = 0;
        int n = s.length();
        String vowels = "aeiouAEIOU";
        
        for (int i = 0; i < n / 2; i++) {
            if (vowels.indexOf(s.charAt(i)) != -1) {
                leftVowels++;
            }
            if (vowels.indexOf(s.charAt(i + n / 2)) != -1) {
                rightVowels++;
            }
        }
        
        return leftVowels == rightVowels;
    }
}
