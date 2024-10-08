package com.example.demo;

import java.io.File;
import java.nio.file.Files;
import java.util.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class DemoApplication {

  private static final Logger log = LoggerFactory.getLogger(DemoApplication.class);

  public static void main(String[] args) throws Exception {

    ConfigurableApplicationContext applicationContext = SpringApplication.run(DemoApplication.class, args);

    File fileIn = new File("payslip.zip");
    File fileEncoded = new File("encoded.txt");
    File fileOut = new File("payslip-out.zip");

    // encode
    byte[] encodedBytes = Base64.getEncoder().encode(Files.readAllBytes(fileIn.toPath()));
    Files.write(fileEncoded.toPath(), encodedBytes);

    // print
    String encodedString = new String(encodedBytes);
    log.info("==========");
    log.info("{}", encodedString);

    // decode
    byte[] decodedBytes = Base64.getDecoder().decode(encodedBytes);
    Files.write(fileOut.toPath(), decodedBytes);

    applicationContext.close();
  }
}
