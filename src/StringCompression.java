public class StringCompression {

    public static  int compress(char[] chars) {
        int n=chars.length;
        int i=0;
        int j=1;
        String s="";
        while(i<n){

            while(j<n && chars[j]==chars[i]){
                j++;
            }

            if(j<n && chars[j]!=chars[i]){
                if(j-i==1){
                    s+=""+(j-i);
                }
                else{
                    s+=chars[i]+""+(j-i);
                }
                i=j;
            }
            if(j==n)
                break;
            j++;
        }

        if(j-i==1){
            s+=""+(j-i);
        }
        else
            s+=chars[i]+""+(j-i);

        chars=s.toCharArray();
        for(int k=0;k<chars.length;k++){
            System.out.print(chars[k]+"");
        }

        return s.length();
    }

    public static void main(String[] args) {

        char arr[]={'a','a','b','b','c','c','c'};

        System.out.println(compress(arr));


    }
}
