public class WindowWithCharacters {


    public  static int numberOfSubstrings(String s) {
        int count[]={0,0,0};
        int i=0,res=0;
        for(int j=0;j<s.length();j++){
            ++count[s.charAt(j)-'a'];

            while(count[0]>0 && count[1]>0 && count[2]>0){
                --count[s.charAt(i++)-'a'];
            }
            res+=i;
        }
        return res;
    }

    public static void main(String[] args) {

        String str="abcabc";

        System.out.println(numberOfSubstrings(str));

    }
}
