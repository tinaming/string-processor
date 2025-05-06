package com.example.processing;

public interface ProcessingStrategy {
    ProcessResult processStep(String input);
}