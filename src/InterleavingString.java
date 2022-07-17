public class InterleavingString {


    public static boolean isInterleave(String s1, String s2, String s3) {
        int memo[][] = new int[s1.length()][s2.length()];
        if(s1.length()+s2.length()!=s3.length()){
            return false;
        }
        for (int i = 0; i < s1.length(); i++) {
            for (int j = 0; j < s2.length(); j++) {
                memo[i][j] = -1;
            }
        }
        return isInterleaveString(s1,s2,s3,0,0,0,memo);
    }


    static boolean   isInterleaveString(String s1, String s2, String s3, int i, int j, int k,int memo[][]){
        boolean res1=false;
        boolean res2=false;
        boolean res3=false;



        if(s1.length()==i || s2.length()==j){

            if(s1.length()==i){

                for(int l=j;l<s2.length();l++){
                    if(s2.charAt(l)!=s3.charAt(k)){
                        return false;
                    }
                    k++;
                }
            }
            else{
                for(int l=i;l<s1.length();l++){
                    if(s1.charAt(l)!=s3.charAt(k)){
                        return false;
                    }
                    k++;
                }
            }
            return true;
        }

        if(memo[i][j]!=-1){
            return memo[i][j] == 1 ? true : false;
        }
        if((s1.charAt(i)==s3.charAt(k)) && s2.charAt(j)==s3.charAt(k)){

           res1= isInterleaveString(s1,s2,s3,i+1,j,k+1,memo) ||  isInterleaveString(s1,s2,s3,i,j+1,k+1,memo);
        }
        else if(s1.charAt(i)==s3.charAt(k)){
            res2=isInterleaveString(s1,s2,s3,i+1,j,k+1,memo);
        }
        else if(s2.charAt(j)==s3.charAt(k)){
            res3=isInterleaveString(s1,s2,s3,i,j+1,k+1,memo);
        }

        boolean res =res1||res2||res3;

        memo[i][j]= res?1:0;

        return res;

    }

    public static void main(String[] args) {

        String str="";
        String str2="";
        String str3="";

        System.out.println(isInterleave(str,str2,str3));

    }

}
