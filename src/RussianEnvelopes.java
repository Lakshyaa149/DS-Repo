/*
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

class Doll implements Comparator<Doll> {

    int weight;
    int height;

    Doll(int weight,int height){
        this.weight=weight;
        this.height=height;
    }
    Doll(){

    }

    @Override
    public String toString() {
        return "Doll{" +
                "weight=" + weight +
                ", height=" + height +
                '}';
    }

    @Override
    public int compare(Doll o1, Doll o2) {
        if(o1.weight==o2.weight){
            return (o1.height-o2.height);
        }
        return (o1.weight-o2.weight);
    }
}
public class RussianEnvelopes {

    public static int maxEnvelopes(int[][] envelopes) {

       ArrayList<Doll> dolls =new ArrayList<>();
        for(int i=0;i<envelopes.length;i++){
            dolls.add(new Doll(envelopes[i][0],envelopes[i][1]));
        }

        */
/*for(int i=0;i<dolls.size();i++){
            System.out.println(dolls[i]);
        }*//*



        Collections.sort(dolls,new Doll());

        System.out.println(dolls);

        int dp[]=new int[dolls.size()];
        Arrays.fill(dp,1);
        int max=1;
        for(int i=1;i<dolls.size();i++){
            for(int j=0;j<i;j++){
                Doll ithDoll=dolls.get(i);
                Doll jthDoll=dolls.get(j);
                if((ithDoll.weight>jthDoll.weight && ithDoll.height>jthDoll.height){
                    dp[i]=Math.max(dp[i],dp[j]+1);

                }
            }
            max=Math.max(dp[i],max);
        }
        return max;

    }

    public static void main(String[] args) {

        int arr[][]={{1,4},{1,3},{1,2},{2,4},{2,7}};

        maxEnvelopes(arr);
    }
}
*/
