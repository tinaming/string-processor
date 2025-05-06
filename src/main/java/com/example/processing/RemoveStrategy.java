package com.example.processing;

import java.util.Collections;

public class RemoveStrategy extends CommonProcessingStrategy {
    @Override
    protected void handleRun(StringBuilder result, char currentChar, int count) {
        if (count < 3) {
            result.append(String.valueOf(currentChar).repeat(count));
        }
    }
}