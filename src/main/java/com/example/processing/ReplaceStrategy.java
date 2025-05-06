package com.example.processing;

public final class ReplaceStrategy extends CommonProcessingStrategy {
    @Override
    protected void handleRun(StringBuilder result, char currentChar, int count) {
        result.append(
                count >= minSequence ?
                        String.valueOf(getPreviousChar(currentChar)) :
                        String.valueOf(currentChar).repeat(count)
        );

    }

    private char getPreviousChar(char c) {
        return switch(Character.getType(c)) {
            case Character.LOWERCASE_LETTER ->
                    c == 'a' ? 'z' : (char)(c - 1);
            case Character.UPPERCASE_LETTER ->
                    c == 'A' ? 'Z' : (char)(c - 1);
            default -> (char)(c - 1);
        };
    }
}
