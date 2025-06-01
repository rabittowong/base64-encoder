package com.example.base64.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Base64;

public class Base64Encoder {

    private static final Logger log = LoggerFactory.getLogger(Base64Encoder.class);

    public static String encode(String plain) {

        log.info("start encoding text: {}", plain);
        byte[] encoded = Base64.getEncoder().encode(plain.getBytes());
        return new String(encoded);
    }
}
