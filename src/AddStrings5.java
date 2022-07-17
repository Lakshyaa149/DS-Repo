public class AddStrings5 {

    public static  String addStrings(String num1, String num2) {
        char arr1[]=num1.toCharArray();
        char arr2[]=num2.toCharArray();
        int i=arr1.length-1;
        int j=arr2.length-1;
        char arr[]=new char[Math.max(arr1.length,arr2.length)];
        int k=arr.length-1;
        int carry=0;
        while(i>=0 && j>=0){
            int no=(arr1[i]-48)+(arr2[j]-48)+carry;
            String str=String.valueOf(no);
            carry=no>9?1:0;
            arr[k]=str.charAt(str.length()-1);
            k--;
            i--;
            j--;
        }

        while(i>=0){

            int no=(arr1[i]-48)+carry;
            String str=String.valueOf(no);
            carry=no>9?1:0;
            arr[k]=str.charAt(str.length()-1);
            i--;
            k--;
        }
        while(j>=0){

            int no=(arr2[j]-48)+carry;
            String str=String.valueOf(no);
            carry=no>9?1:0;
            arr[k]=str.charAt(str.length()-1);
            j--;
            k--;
        }
        if(carry==1){
            return "1"+String.valueOf(arr);
        }

       return new String(arr);

    }

    public static void main(String[] args) {

        String str="11";
        String str2="123";
        System.out.println(addStrings(str,str2));

    }
}
