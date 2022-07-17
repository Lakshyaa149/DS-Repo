import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class TopoLogicalSort {


    static int[] topoSort(int N, ArrayList<ArrayList<Integer>> list){

        Queue<Integer> queue=new LinkedList<>();
        int in[]=new int[N];
        int topo[]=new int[N];
        for(int i=0;i<N;i++){

            for(int ele : list.get(i)){
                in[ele]++;
            }
        }

        for(int i=0;i<N;i++){

            if(in[i]==0){
                queue.add(i);
            }
        }
       int index=0;
        while (!queue.isEmpty()){
            int curr=queue.poll();
            topo[index++]=curr;
            for(int ele:list.get(curr)){
                in[ele]--;

                if(in[ele]==0){
                    queue.add(ele);
                }

            }
        }
     return topo;
    }
}
