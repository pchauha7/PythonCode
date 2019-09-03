package test.mywork;

import java.util.*;

public class NoPrefixSet {

    static class Node{
        Map<Character, Node> map = new HashMap<>();
        boolean isComplete;
        public boolean add(String word){
            return add(word,0);
        }
        private boolean add(String word, int index){
            if(isComplete){
                return false;
            }
            if(index == word.length()){
                isComplete = true;
                return true;
            }
            Node child = map.get(word.charAt(index));
            if(child == null){
                child = new Node();
                map.put(word.charAt(index),child);
            }else if(index + 1 == word.length()){
                return false;
            }
            return child.add(word,index+1);
        }
    }


    
    static void checkPrefix(String str[]){
        
        Node head = new Node();
        for(int i=0; i<str.length; i++){
            
            if (!head.add(str[i])){
                    System.out.println("BAD SET");
                    System.out.println(str[i]);
                    return;
                }
            }
        
        System.out.println("GOOD SET");
    }
    
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        int l = Integer.parseInt(scanner.nextLine());

        String str[] = new String[l];

        for (int i=0; i<l; i++)
            str[i] = scanner.nextLine();
        
        scanner.close();
        //System.out.println(Arrays.toString(str));
        

        checkPrefix(str);

    }
}


