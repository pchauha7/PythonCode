package test.mywork;

public class CountAndSay {

    public static String countAndSay(int n) {
        String x = "";
        if (n>=1)
            x = "1";
        for (int i = 2; i<=n; i++){
            int j = 1;
            int count =1;
            String newStr = "";
            while (j<x.length()){
                if (x.charAt(j-1)==x.charAt(j)){
                    count++;
                }
                else {
                    newStr = newStr + count + x.charAt(j - 1);
                    count = 1;
                }
                j++;
            }
            newStr = newStr + count + x.charAt(j-1);
            x = newStr;
        }
        return x;
    }

    public static void main (String args[]){
        System.out.println(countAndSay(4));
    }

}
