package com.example.processing;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ReplaceStrategyTest {
    private final ReplaceStrategy strategy = new ReplaceStrategy();

    @Test
    void processStep_replaceTripleC_withB() {
        ProcessResult result = strategy.processStep("ccc");
        assertEquals("b", result.getTransformed());
        assertEquals(1, result.getExplanations().size());
        assertEquals("ccc is replaced by b", result.getExplanations().get(0));
    }

    @Test
    void processStep_replaceQuadrupleB_withA() {
        ProcessResult result = strategy.processStep("bbbb");
        assertEquals("a", result.getTransformed());
        assertEquals(1, result.getExplanations().size());
        assertEquals("bbbb is replaced by a", result.getExplanations().get(0));
    }

    @Test
    void processStep_replaceTripleA_withNothing() {
        ProcessResult result = strategy.processStep("aaa");
        assertEquals("", result.getTransformed());
        assertEquals(1, result.getExplanations().size());
        assertEquals("aaa is replaced by nothing", result.getExplanations().get(0));
    }

    @Test
    void processStep_emptyInput() {
        ProcessResult result = strategy.processStep("");
        assertEquals("", result.getTransformed());
        assertTrue(result.getExplanations().isEmpty());
    }
}