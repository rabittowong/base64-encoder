package com.example.base64.util;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Base64EncoderTest {
    @Test
    public void testEncode() throws Exception {
        String plain = "The quick brown fox jumps over the lazy dog";
        String encoded = Base64Encoder.encode(plain);
        assertThat(encoded).isEqualTo("VGhlIHF1aWNrIGJyb3duIGZveCBqdW1wcyBvdmVyIHRoZSBsYXp5IGRvZw==");
    }
}
