package com.example.processing;

public class RemoveStrategy extends CommonProcessingStrategy {
    @Override
    protected void handleRun(StringBuilder result, char currentChar, int count) {
        if (count < minSequence) {
            result.append(String.valueOf(currentChar).repeat(count));
        }
    }
}