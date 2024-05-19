// solution one of the quesion 
import java.util.HashMap;
import java.util.Map;

class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false; // Anagrams must have the same length
        }
        
        // Count occurrences of characters in string s
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        
        // Subtract occurrences of characters in string t
        for (char c : t.toCharArray()) {
            if (!map.containsKey(c)) {
                return false; // Character in t not found in s
            }
            int count = map.get(c) - 1;
            if (count == 0) {
                map.remove(c);
            } else {
                map.put(c, count);
            }
        }
        
        return map.isEmpty(); // If map is empty, all characters in s and t have the same counts
    }

solution2-->
import java.util.Stack;

class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false; // Anagrams must have the same length
        }
        
        // Create two stacks to store characters of strings s and t
        Stack<Character> stackS = new Stack<>();
        Stack<Character> stackT = new Stack<>();
        
        // Push characters of string s onto stackS
        for (char c : s.toCharArray()) {
            stackS.push(c);
        }
        
        // Push characters of string t onto stackT
        for (char c : t.toCharArray()) {
            stackT.push(c);
        }
        
        // Pop characters from both stacks and compare
        while (!stackS.isEmpty() && !stackT.isEmpty()) {
            if (stackS.pop() != stackT.pop()) {
                return false; // Characters don't match
            }
        }
        
        return true; // All characters match, s and t are anagrams
    }
solution3-->
import java.util.LinkedList;

class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false; // Anagrams must have the same length
        }
        
        // Create two linked lists to store characters of strings s and t
        LinkedList<Character> listS = new LinkedList<>();
        LinkedList<Character> listT = new LinkedList<>();
        
        // Add characters of string s to linked list listS
        for (char c : s.toCharArray()) {
            listS.add(c);
        }
        
        // Add characters of string t to linked list listT
        for (char c : t.toCharArray()) {
            listT.add(c);
        }
        
        // Sort the linked lists
        listS.sort(null);
        listT.sort(null);
        
        // Compare the sorted linked lists
        return listS.equals(listT);
    }



 