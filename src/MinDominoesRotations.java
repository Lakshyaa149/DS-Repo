public class MinDominoesRotations {

  public static int   findMinRotationsOfAandB(int x,int tops[],int bottoms[],int n){

    int rot_Tops=0;
    int rot_Bottom=0;
      for(int i=0;i<n;i++){
          if(tops[i]!=x && bottoms[i]!=x) {
              return -1 ;
          }
          else if(tops[i]!=x){
             rot_Tops++;
          }
          else if(bottoms[i]!=x){
              rot_Bottom++;
          }
      }
    return Math.min(rot_Bottom,rot_Tops);
  }

    public int minDominoRotations(int[] tops, int[] bottoms) {

      int n=bottoms.length;

        int first=findMinRotationsOfAandB(tops[0],tops,bottoms,n);
        if(first!=-1 && tops[0]==bottoms[0]){
            return first;
        }
        int second=findMinRotationsOfAandB(bottoms[0],tops,bottoms,n);

       if(first==-1){
           return second;
       }
       if(second==-1){
           return first;
       }
    return Math.min(first,second);
  }
}
