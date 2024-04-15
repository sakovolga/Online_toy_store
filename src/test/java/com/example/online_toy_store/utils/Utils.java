package com.example.online_toy_store.utils;

import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Utils {
    public static String loadJsonFromFile(String filePath) throws IOException {
        return new String(Files.readAllBytes(Paths.get(new ClassPathResource(filePath).getURI())));
    }
}
