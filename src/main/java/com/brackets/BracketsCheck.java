package com.brackets;

import java.util.Stack;

class BracketsCheck {

    private BracketsCheck() {
    }

    static boolean checkBrackets(String str) {

        Stack<Character> stack = new Stack<>();

        String brackets = "(){}[]<>";

        for (int i = 0; i < str.length(); i++) {

            char ch = str.charAt(i);

            int index = brackets.indexOf(ch);

            if (index >= 0) {
                if ((index % 2) == 1) {
                    if (stack.isEmpty()) {
                        return false;
                    }
                    char tmpCh = stack.pop();
                    if (tmpCh != brackets.charAt(index - 1)) {
                        return false;
                    }
                } else {
                    stack.push(ch);
                }
            }
        }
        return stack.isEmpty();
    }

}
