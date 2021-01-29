package com.ironhack.classes;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InputTest {

    @Test
    void validIdFormat_ValidInput_True() {
        assertTrue(Input.validIdFormat("100"));
        assertTrue(Input.validIdFormat("10000"));
    }

    @Test
    void validIdFormat_inValidInput_False() {
        assertFalse(Input.validIdFormat("asf"));
        assertFalse(Input.validIdFormat("-10000"));
    }
}