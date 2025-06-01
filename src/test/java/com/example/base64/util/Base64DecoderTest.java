package com.example.base64.util;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Base64DecoderTest {
    @Test
    public void testDecode() throws Exception {
        String encoded = "VGhlIHF1aWNrIGJyb3duIGZveCBqdW1wcyBvdmVyIHRoZSBsYXp5IGRvZw==";
        String decoded = Base64Decoder.decode(encoded);
        assertThat(decoded).isEqualTo("The quick brown fox jumps over the lazy dog");
    }
}
