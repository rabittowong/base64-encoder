package com.example.base64.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Base64;

public class Base64Decoder {
    private static final Logger log = LoggerFactory.getLogger(Base64Decoder.class);

    public static String decode(String encoded) {
        log.info("start decoding text: {}", encoded);
        byte[] decoded = Base64.getDecoder().decode(encoded);
        return new String(decoded);
    }
}
