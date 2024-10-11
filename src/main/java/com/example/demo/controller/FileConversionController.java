package com.example.demo.controller;

import com.example.demo.service.FileConversionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/convert")
public class FileConversionController {

    @Autowired
    private FileConversionService fileConversionService;

    @PostMapping("/zip-to-base64")
    public ResponseEntity<String> zipToBase64(@RequestParam("file") MultipartFile file) {
        try {
            String base64String = fileConversionService.convertZipToBase64(file);
            return ResponseEntity.ok(base64String);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error converting Zip to Base64: " + e.getMessage());
        }
    }

    @PostMapping("/base64-to-zip")
    public ResponseEntity<byte[]> base64ToZip(@RequestBody String base64String) {
        try {
            byte[] zipFile = fileConversionService.convertBase64ToZip(base64String);
            return ResponseEntity.ok()
                    .header("Content-Disposition", "attachment; filename=\"converted.zip\"")
                    .body(zipFile);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
}
