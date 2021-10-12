package com.textanalysis;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class WordsHandlerTest {

    @Test
    void getStatsAsJsonTest() {
        WordsHandler wH = WordsHandler.useString("Äpple Päron Äpple");
        String expect = "{\"Äpple\":2,\"Päron\":1}";
        assertEquals(expect, wH.getStatsAsJson());
    }
}