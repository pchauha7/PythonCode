package test.mywork;
import java.util.*;
public class PartitionLabels {
    public List<Integer> partitionLabels(String S) {
        List<Integer> res = new ArrayList<>();
        int len = S.length();
        HashMap<Character, Integer> mp = new HashMap<>();
        for(int i=0; i<len; i++)
            mp.put(S.charAt(i), i);

        int start = -1, end = -1, i = 0;

        while (i<len) {
            if (start == -1) {
                start = i;
                end = mp.get(S.charAt(i));
                if (start == end) {
                    res.add(1);
                    start = end = -1;
                } else if (end == len - 1) {
                    res.add(end - start + 1);
                    break;
                }
            } else {
                if (i == end) {
                    res.add(end - start + 1);
                    start = end = -1;
                } else {
                    int newEnd = mp.get(S.charAt(i));
                    if (newEnd > end)
                        end = newEnd;
                }

            }

            i++;
        }
        return res;
    }
}
