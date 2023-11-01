package com.example.kpo_javafx.Service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import java.io.FileWriter;
import java.io.IOException;

public class PriceService {
    final static Logger logger = LogManager.getLogger(PriceService.class);
    public static void writePrice (int a) throws IOException {
        FileWriter writer;
        {
            try {
                writer = new FileWriter("notes.txt",false);
            } catch (IOException e) {
                logger.error("An error occurred",e);
                throw new RuntimeException(e);
            }
        }
        writer.write("К оплате: " + a + "$");
        logger.info("The total price was successfully written to the file.");
        writer.flush();
    }
}

