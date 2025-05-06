package com.example.processing;

import java.util.Collections;

public class RemoveStrategy implements ProcessingStrategy {
    @Override
    public ProcessResult processStep(String input) {
        StringBuilder result = new StringBuilder();
        if (input.isEmpty()) {
            return new ProcessResult(input, Collections.emptyList());
        }
        char[] chars = input.toCharArray();
        char currentChar = chars[0];
        int count = 1;
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] == currentChar) {
                count++;
            } else {
                processRun(result, currentChar, count);
                currentChar = chars[i];
                count = 1;
            }
        }
        processRun(result, currentChar, count);
        String transformed = result.toString();
        if (!transformed.equals(input)) {
            return processStep(transformed);
        }
        return new ProcessResult(transformed, Collections.emptyList());
    }

    private void processRun(StringBuilder result, char currentChar, int count) {
        if (count < 3) {
            for (int j = 0; j < count; j++) {
                result.append(currentChar);
            }
        }
    }
}