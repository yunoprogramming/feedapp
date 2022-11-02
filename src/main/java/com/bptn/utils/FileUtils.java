package com.bptn.utils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import java.io.FileNotFoundException;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

public class FileUtils {

    private static final Logger logger = LoggerFactory.getLogger(FileUtils.class);

    public static void main(String[] args) throws IOException {

        String home = System.getProperty("user.home");

        String fileName = "test.txt";

        Path p = Paths.get(home + "/" + fileName);

        // check if file exists
        logger.debug("Check if the test.txt file exists: " + Files.exists(p));

        // check if file exists with exception handling
        try {
            if (!Files.exists(p)) {
                throw new FileNotFoundException();
            }
        } catch (FileNotFoundException e) {
            logger.debug("File doesn't exists!");
        }

        // create file if it doesn't exist
        if (!Files.exists(p)) {
            Files.createFile(p);
            logger.debug("File Created!");
        }

        // write to the file
        try (FileWriter writer = new FileWriter(new File(p.toUri()))) {

            for (int i = 0; i < 10; i++) {
                writer.write("Yuno loves Coding\n");
            }

            System.out.println("File Written Successfully");
        }

        // Read the file
        Scanner scanner = new Scanner(new File(p.toUri()));

        while (scanner.hasNextLine()) {
            String str = scanner.nextLine();
            logger.debug(str);
        }

        // delete the file
        Files.deleteIfExists(p);

    }

}
