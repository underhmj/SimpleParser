package Configs;

import java.io.File;

public class ParserConfigs {
    public static class Builder {
        private File pathToRead;
        private File pathToWrite;
        private FinderConfigs finderConfigs;
        private String delimiter;

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

        public ParserConfigs build() {
            ParserConfigs parserConfigs = new ParserConfigs();
            parserConfigs.pathToRead = this.pathToRead;
            parserConfigs.pathToWrite = this.pathToWrite;
            parserConfigs.finderConfigs = this.finderConfigs;
            parserConfigs.delimiter = this.delimiter;
            return parserConfigs;
        }
    }

    private File pathToRead;
    private File pathToWrite;
    private FinderConfigs finderConfigs;
    private String delimiter;

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
}
