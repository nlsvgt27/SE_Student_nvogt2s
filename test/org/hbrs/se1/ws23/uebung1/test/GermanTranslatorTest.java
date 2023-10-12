package org.hbrs.se1.ws23.uebung1.test;

import org.hbrs.se1.ws23.uebung1.control.GermanTranslator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GermanTranslatorTest {

    @Test
    void aPositiveTest() {
        GermanTranslator translator = new GermanTranslator();
        assertEquals(translator.translateNumber(1), "eins");
        assertEquals(translator.translateNumber(10), "zehn");
    }

    @Test
    void aNegativTest() {
        GermanTranslator translator = new GermanTranslator();
        assertThrows(IllegalArgumentException.class, () -> translator.translateNumber(-5));
        assertThrows(IllegalArgumentException.class, () -> translator.translateNumber(11));
        assertThrows(IllegalArgumentException.class, () -> translator.translateNumber(0));
        assertThrows(IllegalArgumentException.class, () -> translator.translateNumber(50));
    }
}