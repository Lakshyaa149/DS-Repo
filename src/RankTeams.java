import java.util.Arrays;
import java.util.HashMap;

public class RankTeams {

    public static  String rankTeams(String[] votes) {

        int rank[][]=new int[26][votes.length+1];
        int len=votes[0].length();
        for(int i = 0; i < 26; i++) rank[i][len] = i;

        for(int i=0;i<votes.length;i++){
            String vote=votes[i];
            for(int j=0;j<vote.length();j++){
                rank[vote.charAt(j)-'A'][j]++;
            }
        }

        HashMap<Integer,Integer> map=new HashMap<>();
        Arrays.sort(rank, (a, b) ->{
            for(int i = 0; i < len; i++){
                if(a[i] < b[i]) return 1;
                if(a[i] > b[i]) return -1;
            }
            return 0;
        });

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < len; i++){
            sb.append((char)('A' + rank[i][len]));
        }
        return sb.toString();
    }

    public static void main(String[] args) {

        String a[]={"AAA","AAA","AAA","AAA","AAA"};

        System.out.println(rankTeams(a));
    }
}
