import java.util.LinkedList;

public class RemoveKDigits {

    public static String removeKdigits(String num, int k) {

        LinkedList<Character> stack=new LinkedList<>();

        for(int i=0;i<num.length();i++){
            char ch=num.charAt(i);
            while(!stack.isEmpty() && k>0 && (stack.peekLast()-48)>(ch-48)){
             stack.poll();
             k-=1;
            }
            stack.addLast(num.charAt(i));
        }


        for(int i=0; i<k; ++i) {
            stack.removeLast();
        }

        StringBuilder ret = new StringBuilder();
        boolean leadingZero = true;
        for(char digit: stack) {
            if(leadingZero && digit == '0') continue;
            leadingZero = false;
            ret.append(digit);
        }

        if (ret.length() == 0) return "0";
        return ret.toString();
    }

    public static void main(String[] args) {

        String s="10200";
        int k=1;

        System.out.println(removeKdigits(s,k));
    }


}
