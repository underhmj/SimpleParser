package Parsers;

import Configs.ParserConfigs;
import SuperClasses.SuperParser;
import org.apache.log4j.Logger;

import java.io.File;

public class FolderFileParser extends SuperParser {

    static Logger logger = Logger.getLogger(FolderFileParser.class);

    public FolderFileParser(ParserConfigs parserConfigs) {
        super(parserConfigs);
    }

    @Override
    protected File[] findFilesToParse(ParserConfigs parserConfigs) {
        return new File[0];
    }
}
