package com.example.processing;

public class ReplaceStrategy extends CommonProcessingStrategy {
    @Override
    protected void handleRun(StringBuilder result, char currentChar, int count) {
        if (count >= minSequence) {
            result.append(getPreviousChar(currentChar));
        } else {
            result.append(String.valueOf(currentChar).repeat(count));
        }
    }

    private char getPreviousChar(char c) {
        if (Character.isLowerCase(c)) {
            return c == 'a' ? 'z' : (char)(c - 1);
        } else if (Character.isUpperCase(c)) {
            return c == 'A' ? 'Z' : (char)(c - 1);
        }
        return (char)(c - 1);
    }
}
