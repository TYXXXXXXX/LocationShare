package com.example.foodordersystem.mapper.utils;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ImageUtils {

    public static byte[] readImage(String path) throws IOException {
        Path imagePath = Paths.get(path);
        return Files.readAllBytes(imagePath);
    }

//    public static byte[] readImage(InputStream input) throws IOException {
//        try (ByteArrayOutputStream output = new ByteArrayOutputStream()) {
//            byte[] buffer = new byte[1024];
//            int len;
//            while ((len = input.read(buffer)) != -1) {
//                output.write(buffer, 0, len);
//            }
//            return output.toByteArray();
//        }
//    }
}
