import java.util.Arrays;

public class MergeSort {

    public int count=0;

    public int[]  mergeSort(int arr[]){
        if(arr.length==1){
            return arr;
        }
        int mid=arr.length/2;
        int left[]=mergeSort(Arrays.copyOfRange(arr,0,mid));
        int right[]=mergeSort(Arrays.copyOfRange(arr,mid,arr.length));

        return merge(left,right);
    }

    public  int[] merge(int left[],int right[]){

        int main[]=new int[left.length+right.length];
        int l=0;int r=0;int m=0;
        while(l<left.length && r<right.length){

            if(left[l]<right[r]){
                main[m]=left[l];
                l++;
            }
            else {
                main[m]=right[r];
                r++;
            }
            m++;
        }
        while(l<left.length){
            main[m]=left[l];
            m++;
            l++;
        }
        while(r<right.length){

            main[m]=right[r];
            m++;
            r++;
        }
        return main;
    }

    public static void main(String[] args) {

        int arr[]={8,7,6,5,4,3,2,1};

        MergeSort m=new MergeSort();
        arr=m.mergeSort(arr);

        for(int i=0;i<arr.length;i++){

            System.out.println(arr[i]);

        }


    }
}
