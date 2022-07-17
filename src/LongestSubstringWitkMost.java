import java.util.HashMap;
import java.util.HashSet;

public class LongestSubstringWitkMost {
    public static int lengthOfLongestSubstringKDistinct(String s, int k) {
        int left=0;
        int right=0;

        int n=s.length();
        int currK=0;
        HashSet<Character> set=new HashSet<>();
        HashMap<Character,Integer> map=new HashMap<>();
        int max=Integer.MIN_VALUE;
        while(right<n){
            while(currK>k && left<right){

                if(set.contains(s.charAt(left)) && (map.get(s.charAt(left))==left)){
                    currK--;
                    set.remove(s.charAt(left));
                    map.remove(s.charAt(left));
                }
                left++;
            }

            if(!set.contains(s.charAt(right))){
                set.add(s.charAt(right));
                currK++;
            }
            map.put(s.charAt(right),right);
            max=Math.max(right-left,max);
            right++;
        }

        //max=Math.max(right-left,max);
        return max;
    }

    public static void main(String[] args) {
        String str="loveleetcode";
        int k=4;
        System.out.println(lengthOfLongestSubstringKDistinct(str,k));


    }

}
