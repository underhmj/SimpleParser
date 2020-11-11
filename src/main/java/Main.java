import SuperClasses.SuperParser;
import org.apache.log4j.Logger;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Logger logger = Logger.getLogger(Main.class);

        ArrayList<SuperParser> parsers = new ArrayList<>();

        if (args.length == 0) {
            logger.warn("You must provide an argument to run this JAR");
            return;
        }
        for (String argument : args) {
            SuperParser parser = getParserFromArgument(argument);
            if (parser == null) {
                logger.warn("'" + argument + "' is not a valid argument.");
                return;
            }
            parsers.add(parser);
        }
        for (SuperParser parser : parsers) {
            parser.parse();
        }
    }

    private static SuperParser getParserFromArgument(String argument) {
        switch (argument) {
            case "FolderFileLeft":
                return null;
            case "FolderFileRight":
                return null;
            case "FileLeft":
                return null;
            case "FileRight":
                return null;
            default:
                return null;
        }
    }
}
