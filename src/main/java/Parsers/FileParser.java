package Parsers;

import Configs.ParserConfigs;
import SuperClasses.SuperParser;
import org.apache.log4j.Logger;

import java.io.File;

public class FileParser extends SuperParser {

    static Logger logger = Logger.getLogger(FileParser.class);

    public FileParser(ParserConfigs parserConfigs) {
        super(parserConfigs);
    }

    @Override
    protected File[] findFilesToParse(ParserConfigs parserConfigs) {
        return new File[0];

    }
}
