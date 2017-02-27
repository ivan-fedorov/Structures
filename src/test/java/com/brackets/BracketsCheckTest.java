package com.brackets;

import org.junit.jupiter.api.Test;

import static com.brackets.BracketsCheck.checkBrackets;
import static org.junit.jupiter.api.Assertions.assertTrue;

class BracketsCheckTest {

    @Test
    void bracketTest() {
        assertTrue(checkBrackets("{}(<>)"));
    }

}