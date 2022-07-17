

/**
 * LongestSubstringWithoutRepeatingCharacters
 */
public class LongestSubstringWithoutRepeatingCharacters {
    public  static int lengthOfLongestSubstring(String s) {
        int i=0;
        int j=0;
        int chars[]=new int[128];
        int max=1;
        while(j<s.length()){
            int value=s.charAt(j);
            chars[value]++;
            while(chars[s.charAt(j)]>1 && i<j){
                chars[s.charAt(i)]--;
                i++;
            }
            max=Math.max(max,j-i+1);
        j++;
        }

        return max;
    }


    public static void main(String[] args) {
        String str="abcbabcdefg";
        System.out.println(lengthOfLongestSubstring(str));

    }
}
