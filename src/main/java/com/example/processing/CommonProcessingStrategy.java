package com.example.processing;

public abstract class CommonProcessingStrategy implements ProcessingStrategy {
    
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
            processStep(transformed); // 递归处理变化后的字符串
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