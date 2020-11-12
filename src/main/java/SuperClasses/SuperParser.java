package SuperClasses;

import Configs.ParserConfigs;
import POJOs.ParserResult;
import Utilities.ReaderUtil;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.util.Date;


public abstract class SuperParser {
    private final String arg;
    private final ParserConfigs parserConfigs;
    static Logger logger = Logger.getLogger(SuperParser.class);

    public SuperParser(String arg, ParserConfigs parserConfigs) {
        this.arg = arg;
        this.parserConfigs = parserConfigs;
    }

    public void parse() {
        File[] filesToParse = findFilesToParse(parserConfigs);
        ParserResult parserResult = new ParserResult();
        for (File fileToParse : filesToParse) {
            BufferedReader reader = new ReaderUtil(fileToParse).getReader();
            if (reader == null) {
                logger.warn("Unexpectedly, this file no longer exists, but was picked up in the original scan: " +
                        fileToParse.getName());
                return;
            }
            String textLine = null;
            try {
                while ((textLine = reader.readLine()) != null) {
                    if (textLine.contains(parserConfigs.getDelimiter())) {
                        String[] split = textLine.split(parserConfigs.getDelimiter(), parserConfigs.getNumberOfItems());
                        if (split.length == parserConfigs.getNumberOfItems() &&
                                !split[parserConfigs.getItemToGrab() - 1].isEmpty()) {
                            parserResult.addToListOfParsedStrings(split[parserConfigs.getItemToGrab() - 1].trim());
                        }

                    }
                }
            } catch (IOException e) {
                logger.error(e.getMessage());
            }
            parserResult.setFileName(arg + "-" + new Date() + ".txt");
        }
        try {
            File writeFile = new File(parserConfigs.getPathToWrite() + File.separator + parserResult.getFileName());
            FileUtils.write(writeFile, parserResult.toString(), (String) null);
        } catch (IOException e) {
            logger.error(e.getMessage());
        }
    }

    /*
    Override this method in each parser to identify how to find the proper files
     */
    protected abstract File[] findFilesToParse(ParserConfigs parserConfigs);
}
