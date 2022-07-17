public class LongestCommonSubsequence {


    public static int longestCommonSubsequence(String text1, String text2) {
        return lcs(text1,text2,0,0,0);
    }
    public static int lcs(String text1,String text2,int index,int index2,int result){
        int res=0;

        if(text1.length()==index || text2.length()==index2){
            return result;
        }

        if(text1.charAt(index)==text2.charAt(index2)){
            res= lcs(text1,text2,index+1,index2+1,result+1);
        }
        return  Math.max(Math.max(lcs(text1,text2,index+1,index2,result),lcs(text1,text2,index,index2+1,result)),res);
    }

    public static void main(String[] args) {

        String str1="";
        String str2="";

        System.out.println(longestCommonSubsequence(str1,str2));
    }
}
