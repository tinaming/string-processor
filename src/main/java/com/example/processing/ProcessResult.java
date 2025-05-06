package com.example.processing;

import java.util.Collections;
import java.util.List;

public class ProcessResult {
    private final String transformed;
    private final List<String> explanations;

    public ProcessResult(String transformed, List<String> explanations) {
        this.transformed = transformed;
        this.explanations = explanations != null ? explanations : Collections.emptyList();
    }

    public String getTransformed() {
        return transformed;
    }

    public List<String> getExplanations() {
        return explanations;
    }
}