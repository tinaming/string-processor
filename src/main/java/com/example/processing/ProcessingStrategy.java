package com.example.processing;

/**
 * Defines the contract for string processing strategies.
 * Implementations of this interface should provide specific logic
 * for transforming input strings.
 */
public interface ProcessingStrategy {
    /**
     * Processes the input string according to the specific strategy.
     *
     * @param input The string to be processed
     * @return ProcessResult containing the transformed string
     */
    ProcessResult processStep(String input);
}