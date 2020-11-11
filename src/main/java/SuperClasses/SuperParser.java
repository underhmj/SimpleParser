package SuperClasses;

import Configs.ParserConfigs;
import org.apache.log4j.Logger;

import java.io.File;


public abstract class SuperParser {
    private final ParserConfigs parserConfigs;
    static Logger logger = Logger.getLogger(SuperParser.class);

    public SuperParser(ParserConfigs parserConfigs)  {
        this.parserConfigs = parserConfigs;
    }
    public void parse() {

    }

    /*
    Override this method in each parser to identify how to find the proper files
     */
    protected abstract File[] findFilesToParse(ParserConfigs parserConfigs);
}
