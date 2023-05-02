package fbenavides.pom.utilities;

import java.nio.charset.StandardCharsets;

public class ManejoEncodingUFT8 {


    public static String fixEncoding(String text){
        byte[] utf8Bytes = text.getBytes(StandardCharsets.ISO_8859_1);
        return new String(utf8Bytes, StandardCharsets.UTF_8);
    }
}