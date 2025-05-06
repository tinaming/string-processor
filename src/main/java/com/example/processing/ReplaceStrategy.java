package com.example.processing;

import java.util.ArrayList;
import java.util.List;

public class ReplaceStrategy implements ProcessingStrategy {
    @Override
    public ProcessResult processStep(String input) {
        StringBuilder result = new StringBuilder();
        List<String> explanations = new ArrayList<>();
        if (input.isEmpty()) {
            return new ProcessResult(input, explanations);
        }
        char[] chars = input.toCharArray();
        char currentChar = chars[0];
        int count = 1;
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] == currentChar) {
                count++;
            }
        }
        processRun(result, explanations, currentChar, count);
        return new ProcessResult(result.toString(), explanations);
    }

    private void processRun(StringBuilder result, List<String> explanations, char currentChar, int count) {
        if (count >= 3) {
            if (currentChar > 'a') {
                char replacement = (char) (currentChar - 1);
                result.append(replacement);
                explanations.add(String.format("%s is replaced by %s", repeat(currentChar, count), replacement));
            } else {
                explanations.add(String.format("%s is replaced by nothing", repeat(currentChar, count)));
            }
        } else {
            for (int j = 0; j < count; j++) {
                result.append(currentChar);
            }
        }
    }

    private String repeat(char c, int count) {
        return String.valueOf(c).repeat(count);
    }
}