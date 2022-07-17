public class MaxConfusion {


    public static  int maxConsecutiveAnswers(String answerKey, int k) {
        return Math.max(maxCheck(answerKey,k,'F'),maxCheck(answerKey,k,'T'));

    }
    public static int maxCheck(String answerKey,int k,char check) {



        int MaxCount = Integer.MIN_VALUE;
        int n = answerKey.length();
        if(k==n){
            return n;
        }
        int i = 0;
        int j = 0;
        int currentF = k;
        while (j < n && i <= j) {

            if(currentF==0 && answerKey.charAt(j) == check) {
                if ((answerKey.charAt(j) == check) && currentF == 0) {
                    MaxCount = Math.max(MaxCount, j - i );
                    while (i <= j && currentF <= 0) {
                        if (answerKey.charAt(i) == check) {
                            currentF++;
                        }
                        i++;
                    }
                }
            }
            if (answerKey.charAt(j) == check) {
                currentF--;
                }
                j++;
            }

        MaxCount = Math.max(MaxCount, j - i);
        return MaxCount;
    }

    public static void main(String[] args) {

        String str="TTFF";
        int k=2;

        System.out.println(maxConsecutiveAnswers(str,k));
    }
}

