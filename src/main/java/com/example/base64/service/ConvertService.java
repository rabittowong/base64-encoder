package com.example.base64.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;

@Service
public class ConvertService {

    public String convertZipToBase64(MultipartFile file) throws IOException {

        byte[] fileBytes = file.getBytes();
        return Base64.getEncoder().encodeToString(fileBytes);
    }

    public byte[] convertBase64ToZip(String base64String) {

        return Base64.getDecoder().decode(base64String);
    }
}
