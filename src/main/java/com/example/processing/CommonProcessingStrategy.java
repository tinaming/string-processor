package com.example.processing;

import java.io.InputStream;
import java.util.Properties;

public sealed abstract class CommonProcessingStrategy implements ProcessingStrategy
        permits RemoveStrategy, ReplaceStrategy {
    protected int minSequence;

    public CommonProcessingStrategy() {
        try (InputStream input = getClass().getClassLoader().getResourceAsStream("application.properties")) {
            Properties prop = new Properties();
            prop.load(input);
            this.minSequence = Integer.parseInt(prop.getProperty("string.processor.min.sequence",
                    String.valueOf(DEFAULT_MIN_SEQUENCE)));
        } catch (Exception ex) {
            this.minSequence = DEFAULT_MIN_SEQUENCE;
        }
    }

    @Override
    public ProcessResult processStep(String input) {
        if (input.isEmpty()) {
            return new ProcessResult(input);
        }
        
        StringBuilder result = new StringBuilder();
        processEntireString(input, result);
        
        String transformed = result.toString();
        return transformed.equals(input) ? 
            new ProcessResult(transformed) :
            processStep(transformed);
    }

    private void processEntireString(String input, StringBuilder result) {
        char[] chars = input.toCharArray();
        char currentChar = chars[0];
        int count = 1;
        
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] == currentChar) {
                count++;
            } else {
                handleRun(result, currentChar, count);
                currentChar = chars[i];
                count = 1;
            }
        }
        handleRun(result, currentChar, count);
    }

    protected abstract void handleRun(StringBuilder result, char currentChar, int count);
}