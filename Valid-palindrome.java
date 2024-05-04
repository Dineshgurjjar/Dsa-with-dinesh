A phrase is a palindrome if, after converting all uppercase letters into lowercase letters
and removing all non-alphanumeric characters, it reads the same forward and backward.
 Alphanumeric characters include letters and numbers.Given a string s, return true
 if it is a palindrome, or false otherwise.

solution is-->

import java.util.Stack;
class Solution {
    public boolean isPalindrome(String s) {
        // Remove non-alphanumeric characters and convert to lowercase
        String cleanString = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        
        // Create a stack to store characters
        Stack<Character> stack = new Stack<>();
        
        // Push half of the characters into the stack
        int length = cleanString.length();
        for (int i = 0; i < length / 2; i++) {
            stack.push(cleanString.charAt(i));
        }
        
        // Compare the remaining characters with those popped from the stack
        int start = (length + 1) / 2;
        for (int i = start; i < length; i++) {
            if (cleanString.charAt(i) != stack.pop()) {
                return false;
            }
        }
        
        return true;
    }
