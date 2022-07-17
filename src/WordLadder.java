import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class WordLadder {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<String> queue=new LinkedList<>();
        Set<String> words=new HashSet<>();

        words.remove(beginWord);
        queue.add(beginWord);

        int level=0;

        while(!queue.isEmpty()){
            int size=queue.size();
            level++;
            for(int i=0;i<size;i++){
                String word=queue.poll();

                if(word.equals(endWord)){
                    return level;
                }

                for(String neighbour:getNeighbours(word)){
                    if(wordList.contains(neighbour)){
                        wordList.remove(neighbour);
                        queue.add(neighbour);
                    }
                }
            }
        }

     return 0;
    }

    private ArrayList<String> getNeighbours(String word) {
        char arr[]=word.toCharArray();
        ArrayList<String> list=new ArrayList<>();
        for(int i=0;i<word.length();i++) {
            char temp=arr[i];
            for (char ch = 'a'; ch <= 'z'; ch++) {
             arr[i]=ch;
             String str=new String(arr);
             list.add(str);
            }
            arr[i]=temp;
        }
        return list;
    }
    //Time Complexity:O(M^2*N)
    //Space:O(M*N)
}
