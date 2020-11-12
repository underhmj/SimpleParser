package StandardConfiguration;

import Configs.FinderConfigs;
import Configs.ParserConfigs;

import java.io.File;

public class StandardConfiguration {
    public static final ParserConfigs FOLDER_FILE_LEFT_PARSER_CONFIGS = new ParserConfigs.Builder()
            .setPathToRead(new File("." + File.separator))
            .setPathToWrite(new File("." + File.separator + "Summary"))
            .setDelimiter(":")
            .setNumberOfItems(2)
            .setItemToGrab(1)
            .setFinderConfigs(new FinderConfigs.Builder()
                    .addFolderFilterInclude("Third")
                    .addFolderFilterInclude("First")
                    .addFolderFilterExclude("Bad")
                    .addFileFilterInclude("Up")
                    .addFileFilterInclude("left")
                    .build())
            .build();
    public static final ParserConfigs FOLDER_FILE_RIGHT_PARSER_CONFIGS = new ParserConfigs.Builder()
            .setPathToRead(new File("." + File.separator))
            .setPathToWrite(new File("." + File.separator + "Summary"))
            .setDelimiter(":")
            .setNumberOfItems(2)
            .setItemToGrab(2)
            .setFinderConfigs(new FinderConfigs.Builder()
                    .addFolderFilterInclude("Second")
                    .addFolderFilterInclude("First")
                    .addFolderFilterExclude("Bad")
                    .addFileFilterInclude("down")
                    .addFileFilterInclude("Right")
                    .build())
            .build();
    public static final ParserConfigs FILE_LEFT_PARSER_CONFIGS = new ParserConfigs.Builder()
            .setPathToRead(new File("." + File.separator))
            .setPathToWrite(new File("." + File.separator + "Summary"))
            .setDelimiter(":")
            .setNumberOfItems(2)
            .setItemToGrab(1)
            .setFinderConfigs(new FinderConfigs.Builder()
                    .addFolderFilterInclude("One")
                    .addFolderFilterInclude("First")
                    .addFileFilterInclude("Down")
                    .addFileFilterInclude("left")
                    .build())
            .build();
    public static final ParserConfigs FILE_RIGHT_PARSER_CONFIGS = new ParserConfigs.Builder()
            .setPathToRead(new File("." + File.separator))
            .setPathToWrite(new File("." + File.separator + "Summary"))
            .setDelimiter(":")
            .setNumberOfItems(2)
            .setItemToGrab(2)
            .setFinderConfigs(new FinderConfigs.Builder()
                    .addFolderFilterInclude("Third")
                    .addFolderFilterInclude("One")
                    .addFileFilterInclude("Up")
                    .addFileFilterInclude("right")
                    .build())
            .build();
}
