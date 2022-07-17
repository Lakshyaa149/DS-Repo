import java.util.ArrayList;

public class IntervalListIntersections {


    public  static int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        int m=firstList.length;
       int n=secondList.length;
        ArrayList<int[]> result=new ArrayList<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(secondList[j][0]<=firstList[i][1] && firstList[i][0]<=secondList[j][0]){
                    int arr[]=new int[2];
                    arr[0]=secondList[j][0];
                    arr[1]=Math.min(firstList[i][1],secondList[j][1]);
                    result.add(arr);
                }
                else if(secondList[j][1]>=firstList[i][0] && secondList[j][0]<=firstList[i][0]){
                    int arr[]=new int[2];
                    arr[0]=firstList[i][0];
                    arr[1]=Math.min(firstList[i][1],secondList[j][1]);
                    result.add(arr);
                }
                }
        }

    int res[][]=new int[result.size()][2];

        for(int i=0;i<result.size();i++){

            int arr[]=result.get(i);
            res[i]=arr;
        }
        return res;
    }

    public static void main(String[] args) {

      /*  int firstList[][]={{0,2},{5,10},{13,23},{24,25}};
        int secondList[][]={{1,5},{8,12},{15,24},{25,26}};
*/
        int firstList[][]={{0,2},{5,10},{13,23},{24,25}};
        int secondList[][]={};


        int arr[][]=intervalIntersection(firstList,secondList);

        for(int i=0;i<arr.length;i++){

            System.out.println(arr[i][0]+" "+arr[i][1]);
        }


    }


}
