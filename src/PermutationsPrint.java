public class PermutationsPrint {


    public static void main(String[] args) {

        String str="ABC";
        permutations(str.toCharArray(),0,str.length());
    }

    private static  void permutations(char arr[], int start,int end){

        if(start==end){
            for(int i=0;i<arr.length;i++){
                System.out.print(arr[i]+"");
            }
            System.out.println();
            return;
        }

        for(int i=start;i<end;i++){

            char temp=arr[start];
            arr[start]=arr[i];
            arr[i]=temp;
            permutations(arr,start+1,end);
            temp=arr[start];
            arr[start]=arr[i];
            arr[i]=temp;
        }
    }

}
