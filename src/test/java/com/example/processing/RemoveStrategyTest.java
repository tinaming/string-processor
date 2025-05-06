package com.example.processing;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class RemoveStrategyTest {
    private final RemoveStrategy strategy = new RemoveStrategy();

    @Test
    void processStep_noConsecutiveChars_returnsSame() {
        ProcessResult result = strategy.processStep("abbc");
        assertEquals("abbc", result.getTransformed());
        assertTrue(result.getExplanations().isEmpty());
    }

    @Test
    void processStep_singleTriple_removesThem() {
        ProcessResult result = strategy.processStep("aaabbb");
        assertEquals("", result.getTransformed());
    }

    @Test
    void processStep_overlappingRuns() {
        ProcessResult result = strategy.processStep("abcccbbaa");
        assertEquals("", result.getTransformed());
    }

    @Test
    void processStep_emptyInput() {
        ProcessResult result = strategy.processStep("");
        assertEquals("", result.getTransformed());
    }
}