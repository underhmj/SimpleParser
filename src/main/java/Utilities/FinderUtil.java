package Utilities;

import Configs.FinderConfigs;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class FinderUtil {
    public static File[] folderFinder(File directoryToSearchIn, FinderConfigs finderConfigs) {
         return Arrays.stream(Objects.requireNonNull(directoryToSearchIn.listFiles()))
                 .filter(File::isDirectory)
                 .filter(file -> finderConfigs.getFolderFilterIncludeList().size() == 0 ? file.exists() :
                        checkForContainingString(file, finderConfigs.getFolderFilterIncludeList()))
                 .filter(file -> finderConfigs.getFolderFilterExcludeList().size() == 0 ? file.exists() :
                         !checkForContainingString(file, finderConfigs.getFolderFilterExcludeList()))
                 .filter(file -> finderConfigs.getFolderMinLength() == null ? file.exists() :
                         file.getName().length() >= finderConfigs.getFolderMinLength())
                 .filter(file -> finderConfigs.getFolderMaxLength() == null ? file.exists() :
                         file.getName().length() <= finderConfigs.getFolderMaxLength())
                 .toArray(File[]::new);
    }

    public static File[] fileFinder(File directoryToSearchIn, FinderConfigs finderConfigs) {
        return Arrays.stream(Objects.requireNonNull(directoryToSearchIn.listFiles()))
                .filter(File::isFile)
                .filter(file -> finderConfigs.getFileFilterIncludeList().size() == 0 ? file.exists() :
                        checkForContainingString(file, finderConfigs.getFileFilterIncludeList()))
                .filter(file -> finderConfigs.getFileFilterExcludeList().size() == 0 ? file.exists() :
                        !checkForContainingString(file, finderConfigs.getFileFilterExcludeList()))
                .filter(file -> finderConfigs.getFileMinLength() == null ? file.exists() :
                        file.getName().length() >= finderConfigs.getFileMinLength())
                .filter(file -> finderConfigs.getFileMaxLength() == null ? file.exists() :
                        file.getName().length() <= finderConfigs.getFileMaxLength())
                .toArray(File[]::new);
    }

    private static boolean checkForContainingString(File file, ArrayList<String> stringToLookForList) {
        for (String stringToLookFor : stringToLookForList) {
            if (file.getName().toUpperCase().contains(stringToLookFor.toUpperCase())) {
                return true;
            }
        }
        return false;
    }
}
