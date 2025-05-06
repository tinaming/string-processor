package com.example.processing;

import java.util.ArrayList;
import java.util.List;

public class StringProcessor {
    private final ProcessingStrategy strategy;

    public StringProcessor(ProcessingStrategy strategy) {
        this.strategy = strategy;
    }

    public List<ProcessResult> process(String input) {
        List<ProcessResult> steps = new ArrayList<>();
        String current = input;
        while (true) {
            ProcessResult result = strategy.processStep(current);
            if (result.getTransformed().equals(current)) {
                break;
            }
            steps.add(result);
            current = result.getTransformed();
        }
        return steps;
    }
}