package Utilities;

import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class ReaderUtil {
    private final BufferedReader reader;
    static Logger logger = Logger.getLogger(ReaderUtil.class);

    public ReaderUtil(File fileToRead) {
        this.reader = fetchReader(fileToRead);
    }

    private BufferedReader fetchReader(File fileToRead) {
        BufferedReader bufferedReader = null;
        try {
            if (!fileToRead.exists()) {
                logger.warn("Oh fiddlesticks... " + fileToRead.getName() + " was not found.");
                return null;
            }
            if (!fileToRead.isFile()) {
                logger.warn("You provided something that was not a file to the file reader: " + fileToRead.getName());
                return null;
            }
            FileReader fileReader = new FileReader(fileToRead);
            bufferedReader = new BufferedReader(fileReader);
        } catch (FileNotFoundException e) {
            logger.error(e.getMessage());
        }
        return bufferedReader;
    }

    public BufferedReader getReader() {
        return reader;
    }
}
