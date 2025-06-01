package com.example.base64.controller;

import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.web.servlet.MockMvc;

import java.io.File;
import java.nio.charset.StandardCharsets;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.multipart;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest
public class ConvertControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testZipToBase64_shouldReturnCorrectResult_whenInvoked() throws Exception {

        File file = new File("src/test/resources/plain_file.zip");
        byte[] fileByte = FileUtils.readFileToByteArray(file);
        MockMultipartFile multipartFile = new MockMultipartFile("file", "plain_file.zip", MediaType.MULTIPART_FORM_DATA_VALUE, fileByte);

        mockMvc.perform(multipart("/convert/zip-to-base64").file(multipartFile)
                        .contentType(MediaType.MULTIPART_FORM_DATA_VALUE))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.TEXT_PLAIN_VALUE + ";charset=" + StandardCharsets.UTF_8))
                .andExpect(content().string("UEsDBAoAAAAAAA90wVo5o09BKwAAACsAAAAOAAAAcGxhaW5fZmlsZS50eHRUaGUgcXVpY2sgYnJvd24gZm94IGp1bXBzIG92ZXIgdGhlIGxhenkgZG9nUEsBAj8ACgAAAAAAD3TBWjmjT0ErAAAAKwAAAA4AJAAAAAAAAAAgAAAAAAAAAHBsYWluX2ZpbGUudHh0CgAgAAAAAAABABgAELre8r7S2wEAAAAAAAAAAAAAAAAAAAAAUEsFBgAAAAABAAEAYAAAAFcAAAAAAA=="));
    }

    @Test
    public void testBase64ToZip_shouldReturnCorrectResult_whenInvoked() throws Exception {

        File file = new File("src/test/resources/plain_file.zip");
        byte[] fileByte = FileUtils.readFileToByteArray(file);

        mockMvc.perform(post("/convert/base64-to-zip").contentType(MediaType.TEXT_PLAIN_VALUE)
                        .content("UEsDBAoAAAAAAA90wVo5o09BKwAAACsAAAAOAAAAcGxhaW5fZmlsZS50eHRUaGUgcXVpY2sgYnJvd24gZm94IGp1bXBzIG92ZXIgdGhlIGxhenkgZG9nUEsBAj8ACgAAAAAAD3TBWjmjT0ErAAAAKwAAAA4AJAAAAAAAAAAgAAAAAAAAAHBsYWluX2ZpbGUudHh0CgAgAAAAAAABABgAELre8r7S2wEAAAAAAAAAAAAAAAAAAAAAUEsFBgAAAAABAAEAYAAAAFcAAAAAAA=="))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_OCTET_STREAM_VALUE))
                .andExpect(content().bytes(fileByte));
    }
}
