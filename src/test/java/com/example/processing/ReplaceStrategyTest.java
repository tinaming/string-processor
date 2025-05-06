package com.example.processing;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ReplaceStrategyTest {
    private final ReplaceStrategy strategy = new ReplaceStrategy();

    @Test
    void processStep_replaceTripleC_withB() {
        ProcessResult result = strategy.processStep("ccc");
        assertEquals("b", result.transformed());
    }

    @Test
    void processStep_replaceQuadrupleB_withA() {
        ProcessResult result = strategy.processStep("bbbb");
        assertEquals("a", result.transformed());
    }
    @Test
    void processStep_replaceQuadrupleNum() {
        ProcessResult result = strategy.processStep("222");
        assertEquals("1", result.transformed());
    }

    @Test
    void processStep_replaceTripleA_withNothing() {
        ProcessResult result = strategy.processStep("aaa");
        assertEquals("z", result.transformed());
        result = strategy.processStep("AAA");
        assertEquals("Z", result.transformed());
    }

    @Test
    void processStep_emptyInput() {
        ProcessResult result = strategy.processStep("");
        assertEquals("", result.transformed());
    }
}