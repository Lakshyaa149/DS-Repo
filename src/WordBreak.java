import java.util.List;

public class WordBreak {

    public static boolean wordBreak(String s, List<String> wordDict) {

        Boolean dp[]=new Boolean[s.length()];
        for(int i=0;i<s.length();i++){

            if(wordDict.contains(s.substring(0,i+1))){
                boolean ans=wb(s,i+1,wordDict,dp);
                if(ans)
                    return true;
            }
        }

    return false;
    }

    private static boolean wb(String s, int i,List<String> wordDict,Boolean dp[]) {

        if(i>=s.length())
            return true;

        if(dp[i]!=null){
            return dp[i];
        }
        for(int j=i;j<s.length();j++){
            if(wordDict.contains(s.substring(i,j+1))){
                boolean ans=wb(s,j+1,wordDict,dp);
                if(ans)
                    return dp[i]=true;
            }
        }

        return dp[i]=false;
    }

    public static void main(String[] args) {

        String s="catsandog";
        String dict[]={"cats","dog","sand","and","cat"};
        List<String> d=List.of(dict);

         System.out.println(wordBreak(s,d));
    }
}
