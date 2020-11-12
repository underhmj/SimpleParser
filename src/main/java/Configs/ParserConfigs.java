package Configs;

import java.io.File;

public class ParserConfigs {
    public static class Builder {
        private File pathToRead;
        private File pathToWrite;
        private FinderConfigs finderConfigs;
        private String delimiter;
        private Integer numberOfItems;
        private Integer itemToGrab;

        public Builder() {}

        public Builder setPathToRead(File pathToRead) {
            this.pathToRead = pathToRead;
            return this;
        }

        public Builder setPathToWrite(File pathToWrite) {
            this.pathToWrite = pathToWrite;
            return this;
        }

        public Builder setFinderConfigs(FinderConfigs finderConfigs) {
            this.finderConfigs = finderConfigs;
            return this;
        }

        public Builder setDelimiter(String delimiter) {
            this.delimiter = delimiter;
            return this;
        }

        public Builder setNumberOfItems(Integer numberOfItems) {
            this.numberOfItems = numberOfItems;
            return this;
        }

        public Builder setItemToGrab(Integer itemToGrab) {
            this.itemToGrab = itemToGrab;
            return this;
        }

        public ParserConfigs build() {
            ParserConfigs parserConfigs = new ParserConfigs();
            parserConfigs.pathToRead = this.pathToRead;
            parserConfigs.pathToWrite = this.pathToWrite;
            parserConfigs.finderConfigs = this.finderConfigs;
            parserConfigs.delimiter = this.delimiter;
            parserConfigs.numberOfItems = this.numberOfItems;
            parserConfigs.itemToGrab = this.itemToGrab;
            return parserConfigs;
        }
    }

    private File pathToRead;
    private File pathToWrite;
    private FinderConfigs finderConfigs;
    private String delimiter;
    private Integer numberOfItems;
    private Integer itemToGrab;

    private ParserConfigs() {}

    public File getPathToRead() {
        return pathToRead;
    }

    public File getPathToWrite() {
        return pathToWrite;
    }

    public FinderConfigs getFinderConfigs() {
        return finderConfigs;
    }

    public String getDelimiter() {
        return delimiter;
    }

    public Integer getNumberOfItems() {
        return numberOfItems;
    }

    public Integer getItemToGrab() {
        return itemToGrab;
    }
}
