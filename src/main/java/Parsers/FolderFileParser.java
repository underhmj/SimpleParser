package Parsers;

import Configs.ParserConfigs;
import SuperClasses.SuperParser;
import Utilities.FinderUtil;
import org.apache.log4j.Logger;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;

public class FolderFileParser extends SuperParser {

    static Logger logger = Logger.getLogger(FolderFileParser.class);

    public FolderFileParser(String arg, ParserConfigs parserConfigs) {
        super(arg, parserConfigs);
    }

    @Override
    protected File[] findFilesToParse(ParserConfigs parserConfigs) {
        ArrayList<File> foundFiles = new ArrayList<>();
        File[] foldersToLookIn = FinderUtil.folderFinder(parserConfigs.getPathToRead(), parserConfigs.getFinderConfigs());
        if (foldersToLookIn.length == 0) {
            logger.debug("No folders were found at the read location: " + parserConfigs.getPathToRead().getAbsolutePath());
        }
        for (File folder : foldersToLookIn) {
            File[] files = FinderUtil.fileFinder(folder, parserConfigs.getFinderConfigs());
            if (files.length == 0) {
                logger.debug("No files were found in the folder: " + folder.getName());
            }
            Collections.addAll(foundFiles, files);
        }
        return foundFiles.toArray(new File[0]);
    }
}
