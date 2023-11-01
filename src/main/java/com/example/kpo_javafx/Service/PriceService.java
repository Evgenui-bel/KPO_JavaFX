package com.example.kpo_javafx.Service;

import java.io.FileWriter;
import java.io.IOException;

public class PriceService {
    public static void writePrice (int a) throws IOException {
        FileWriter writer;
        {
            try {
                writer = new FileWriter("notes.txt",false);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        writer.write("К оплате: " + a + "$");
        writer.flush();
    }
}

