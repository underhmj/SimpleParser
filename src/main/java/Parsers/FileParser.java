package Parsers;

import Configs.ParserConfigs;
import SuperClasses.SuperParser;
import Utilities.FinderUtil;
import org.apache.log4j.Logger;

import java.io.File;

public class FileParser extends SuperParser {

    static Logger logger = Logger.getLogger(FileParser.class);

    public FileParser(String arg, ParserConfigs parserConfigs) {
        super(arg, parserConfigs);
    }

    @Override
    protected File[] findFilesToParse(ParserConfigs parserConfigs) {
        File[] foundFiles = FinderUtil.fileFinder(parserConfigs.getPathToRead(), parserConfigs.getFinderConfigs());
        if (foundFiles.length == 0) {
            logger.debug("There were no files found at the read location: " + parserConfigs.getPathToRead().getAbsolutePath());
        }
        return foundFiles;
    }
}
