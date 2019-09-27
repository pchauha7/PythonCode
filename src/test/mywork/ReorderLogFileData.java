package test.mywork;

import java.util.Arrays;
import java.util.Comparator;

public class ReorderLogFileData {
    public String[] reorderLogFiles(String[] logs) {

        Arrays.sort(logs, new Comparator<String>(){

            public int compare(String s1, String s2) {
                String [] a = s1.split(" ", 2);
                String [] b = s2.split(" ", 2);
                if (!Character.isDigit(a[1].charAt(0)) && Character.isDigit(b[1].charAt(0)))
                    return -1;
                if (!Character.isDigit(b[1].charAt(0)) && Character.isDigit(a[1].charAt(0)))
                    return 1;
                if (!Character.isDigit(a[1].charAt(0)) && !Character.isDigit(b[1].charAt(0))){

                    int x = a[1].compareTo(b[1]);
                    if (x!=0)
                        return x;
                    return a[0].compareTo(b[0]);
                }
                else
                    return 0;
            }
        });

        return logs;
    }
}
