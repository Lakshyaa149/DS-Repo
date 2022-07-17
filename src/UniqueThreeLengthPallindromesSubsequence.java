import java.util.Arrays;
import java.util.HashSet;

public class UniqueThreeLengthPallindromesSubsequence {
    public static  int countPalindromicSubsequence(String s) {
        int n=s.length();
        int first[]=new int[26];
        int last[]=new int[26];

        Arrays.fill(first,-1);
        Arrays.fill(last,-1);

        for(int i=0;i<n;i++){

            char ch=s.charAt(i);
            if(first[ch-'a']==-1){
                first[ch-'a']=i;
            }
            else{
                last[ch-'a']=i;
            }
        }
        int count=0;

        for(int i=0;i<26;i++){

            int fp=first[i];
            int sp=last[i];

            if(fp!=-1&&sp!=-1){

                HashSet<Character> set=new HashSet<>();
                for(int j=fp+1;j<sp;j++){
                    set.add(s.charAt(j));
                }
                count+=set.size();
            }

        }
        return count;
    }

    public static void main(String[] args) {
        String s="aabca";

        System.out.println(countPalindromicSubsequence(s));
    }
}
