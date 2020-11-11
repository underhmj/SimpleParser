package Configs;

import java.util.ArrayList;

public class FinderConfigs {
    public static class Builder {
        private ArrayList<String> folderFilterIncludeList = new ArrayList<String>();
        private ArrayList<String> folderFilterExcludeList = new ArrayList<String>();
        private Integer folderMinLength;
        private Integer folderMaxLength;
        private ArrayList<String> fileFilterIncludeList = new ArrayList<String>();
        private ArrayList<String> fileFilterExcludeList = new ArrayList<String>();
        private Integer fileMinLength;
        private Integer fileMaxLength;

        public Builder() {}

        public Builder addFolderFilterInclude(String stringToInclude) {
            this.folderFilterIncludeList.add(stringToInclude);
            return this;
        }

        public Builder addFolderFilterExclude(String stringToExclude) {
            this.folderFilterExcludeList.add(stringToExclude);
            return this;
        }

        public Builder setFolderMinLength(Integer folderMinLength) {
            this.folderMinLength = folderMinLength;
            return this;
        }

        public Builder setFolderMaxLength(Integer folderMaxLength) {
            this.folderMaxLength = folderMaxLength;
            return this;
        }

        public Builder addFileFilterInclude(String stringToInclude) {
            this.fileFilterIncludeList.add(stringToInclude);
            return this;
        }

        public Builder addFileFilterExclude(String stringToExclude) {
            this.fileFilterExcludeList.add(stringToExclude);
            return this;
        }

        public Builder setFileMinLength(Integer fileMinLength) {
            this.fileMinLength = fileMinLength;
            return this;
        }

        public Builder setFileMaxLength(Integer fileMaxLength) {
            this.fileMaxLength = fileMaxLength;
            return this;
        }

        public FinderConfigs build() {
            FinderConfigs finderConfigs = new FinderConfigs();
            finderConfigs.folderFilterIncludeList = this.folderFilterIncludeList;
            finderConfigs.folderFilterExcludeList = this.folderFilterExcludeList;
            finderConfigs.folderMinLength = this.folderMinLength;
            finderConfigs.folderMaxLength = this.folderMaxLength;
            finderConfigs.fileFilterIncludeList = this.fileFilterIncludeList;
            finderConfigs.fileFilterExcludeList = this.fileFilterExcludeList;
            finderConfigs.fileMinLength = this.fileMinLength;
            finderConfigs.fileMaxLength = this.fileMaxLength;
            return finderConfigs;
        }
    }

    private ArrayList<String> folderFilterIncludeList = new ArrayList<String>();
    private ArrayList<String> folderFilterExcludeList = new ArrayList<String>();
    private Integer folderMinLength;
    private Integer folderMaxLength;
    private ArrayList<String> fileFilterIncludeList = new ArrayList<String>();
    private ArrayList<String> fileFilterExcludeList = new ArrayList<String>();
    private Integer fileMinLength;
    private Integer fileMaxLength;

    private FinderConfigs() {}

    public ArrayList<String> getFolderFilterIncludeList() {
        return folderFilterIncludeList;
    }

    public ArrayList<String> getFolderFilterExcludeList() {
        return folderFilterExcludeList;
    }

    public Integer getFolderMinLength() {
        return folderMinLength;
    }

    public Integer getFolderMaxLength() {
        return folderMaxLength;
    }

    public ArrayList<String> getFileFilterIncludeList() {
        return fileFilterIncludeList;
    }

    public ArrayList<String> getFileFilterExcludeList() {
        return fileFilterExcludeList;
    }

    public Integer getFileMinLength() {
        return fileMinLength;
    }

    public Integer getFileMaxLength() {
        return fileMaxLength;
    }
}
