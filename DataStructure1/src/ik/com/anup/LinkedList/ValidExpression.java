package ik.com.anup.LinkedList;

//Hint:: 1. intStk and CharOPstk, isOPr, getcorrespondingBrak, isOPenBrack,isDigit
//2. keep on adding until you see closing bracket-  internal while loop..
// for char use ..getCorrespondingOpenBracket and also pop intstack
//3. outside while loop for emptyting charStack ..everycharstk pop needs intStk pop as well
//4. char stk==0 and intStk<2 othrwise false


/*You have to check whether a given string is a valid mathematical expression or not. 
A string is considered valid if it contains matching opening and closing parenthesis as well as valid 
mathematical operations. The string contains the following set of parentheses ‘(‘, ’)’, ’[’, ’]’, ’{’, ’}’, 
numbers from 0 to 9 and following operators ‘+’, ’-’ and ‘*’.

Example One
{
"expression": "{(1+2)*3}+4"
}
Output:

1
The mathematical expression as well as the parentheses are valid.

Example Two
{
"expression": "((1+2)*3*)"
}
Output:

0
Here the parentheses are valid but the mathematical expression is not. There is an operator ‘*’ without any operand after it.

Notes
An expression that consists of only parentheses is considered valid if it contains correct opening and
 closing parentheses. Example: “{()}” is considered valid.
Constraints:

1 <= length of the expression <= 100000
Possible characters in the expression string: ‘+’, ‘-’, ‘*’ and [0-9]*/
import java.util.Stack;

public class ValidExpression {
    /*
    * Asymptotic complexity in terms of length of `expression` `n`:
    * Time: O(n).
    * Auxiliary space: O(n).
    * Total space: O(n).
    */

    public static boolean is_valid(String expression) {
        boolean result = true;
        /*stores digits*/
        Stack<Integer> intStack = new Stack<>();
        /*stores operators and parantheses*/
        Stack<Character> charStack = new Stack<>();
        boolean isTrue = true;
       
        for (int i = 0; i < expression.length(); i++) {
            char inputChar = expression.charAt(i);
            /*if the character is a digit, we push it to st1*/
            if (isDigit(inputChar)) {
                intStack.push(inputChar - '0');// converting char to integer
                if(isTrue) {
                    isTrue = false;
                }
                else {
                    return false;
                }
            }
            /*if the character is an operator, we push it to st2*/
            else if (isOperator(inputChar)) {
                charStack.push(inputChar);
                isTrue = true;
            }
            else {
                /*if the character is an opening parantheses we push it to st2*/
                if(isBracketOpen(inputChar)) {
                    charStack.push(inputChar);
                }
                /*If it is a closing bracket*/
                else {
                    boolean flag = true;
                    /*we keep on removing characters until we find the corresponding
                    open bracket or the stack becomes empty*/
                    while (!charStack.isEmpty()) {
                        char c = charStack.pop();
                        if (c == getCorrespondingOpenBracket(inputChar)) {/// top of stack ***********
                            flag = false;
                            break;
                        }
                        else {// for int Stack
                            if (intStack.size() < 2) {
                                return false;
                            }
                            else {
                                intStack.pop();
                            }
                        }
                    }
                    if (flag) {
                        return false;
                    }

                }
            }
        }
        
        //empty charstacks until the empty and if clause for operator >>>>>>>>>by this time only opr should be in Charstk
        while (!charStack.isEmpty()) {
            char c = charStack.pop();
            if (!isOperator(c)) {
                return false;
            }
            if (intStack.size() < 2) {
                return false;
            }
            else {
                intStack.pop();
            }
        }
        if (intStack.size() > 1 || !charStack.isEmpty()) {
            return false;
        }
        return result;
    }
    /*method to get corresponding opening and closing bracket.*/
    public static char getCorrespondingOpenBracket(char c) {
        if (c == ')') {
            return '(';
        }
        else if (c == ']') {
            return '[';
        }
        return '{';
    }

    /*checks if the given bracket is open or not.*/
    public static boolean isBracketOpen(char c) {
        if (c == '(' || c == '[' || c == '{') {
            return true;
        }
        return false;
    }

    /*checks if the given character is a digit.*/
    public static boolean isDigit(char c) {
        if (c >= '0' && c <= '9') {
            return true;
        }
        return false;
    }

    public static boolean isOperator(char c) {
        if (c == '+' || c == '-' || c == '*') {
            return true;
        }
        return false;
    }

}
/*
 * We traverse the string from left to right and maintain 2 stacks – one for
 * numbers and the other one for operators and parentheses. When we encounter a
 * number we push it to the integer stack and similarly, in case of an operator
 * or an open bracket, we push it to the character stack. 
 * 
 * When we encounter a
 * closed bracket, we remove characters from the character stack until we
 * encounter the corresponding open parentheses. 
 * Also, when we get an operator
 * we remove 2 integers from the integer stack. In case we are not able to
 * perform any of the operations, we return false, thus considering the
 * expression invalid.
 */