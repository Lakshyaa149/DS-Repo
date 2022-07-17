import java.util.ArrayList;
import java.util.HashMap;

public class CourseSchedule {


    public boolean canFinish(int numCourses, int[][] prerequisites) {


        HashMap<Integer, ArrayList<Integer>>  coursesRelations=new HashMap<>();

        for(int i=0;i<prerequisites.length;i++){

            if(!coursesRelations.containsKey(prerequisites[i][0])){
                ArrayList<Integer> al=new ArrayList<>();
                al.add(prerequisites[i][1]);
                coursesRelations.put(prerequisites[i][0],al);
            }
            else{

                ArrayList<Integer> list=coursesRelations.get(prerequisites[i][0]);
                list.add(prerequisites[i][0]);
                coursesRelations.put(prerequisites[i][0],list);
            }

        }
        boolean checked[]=new boolean[numCourses];
        for(int i=0;i<numCourses;i++){

            if(isCyclic(i,coursesRelations,checked)){
                return true;
            }
        }
        return false;
    }

    public boolean isCyclic(int cc,HashMap<Integer,ArrayList<Integer>> map,boolean path[]){
        //cycle condition
        if(path[cc]){
            return true;
        }

        if(!map.containsKey(cc)){
            return false;
        }

        path[cc]=true;
        boolean isCyclic=false;
        for(int newCourse:map.get(cc)){

             isCyclic=isCyclic(newCourse,map,path);
            if(isCyclic){
                break;
            }
        }

        path[cc]=false;

        return isCyclic;
    }
}
