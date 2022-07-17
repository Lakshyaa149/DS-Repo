import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class DecodeString {


    public static String decodeString(String s) {
        char arr[]=s.toCharArray();
        Stack<Character> stack=new Stack<>();
        List<Character> list=new ArrayList<>();
        int n=arr.length;
        for(int i=0;i<n;i++){

            if(arr[i]!=']'){
                stack.push(arr[i]);
            }
            else{
                while(stack.peek()!='['){
                    list.add(stack.pop());
                }
                stack.pop();
                int not=(int)stack.pop()-48;
                for(int k=0;k<not;k++) {
                    for (int j = list.size() - 1; j >= 0; j--) {
                        stack.push(list.get(j));
                    }
                }
                list=new ArrayList<>();
            }

        }
        StringBuilder sb=new StringBuilder();

        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }

    return sb.reverse().toString();
    }

    public static void main(String[] args) {

        String str="2[abc]3[cd]ef";

        System.out.println(decodeString(str));

    }
}
