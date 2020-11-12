package POJOs;

import java.util.ArrayList;

public class ParserResult {
    private final String newLine = System.lineSeparator();
    private String fileName;
    private ArrayList<String> listOfParsedStrings = new ArrayList<>();

    public ParserResult() {

    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public void addToListOfParsedStrings(String stringToAdd) {
        this.listOfParsedStrings.add(stringToAdd);
    }

    public ArrayList<String> getListOfParsedStrings() {
        return listOfParsedStrings;
    }

    public void setListOfParsedStrings(ArrayList<String> listOfParsedStrings) {
        this.listOfParsedStrings = listOfParsedStrings;
    }

    private String printAllFoundStrings() {
        StringBuilder foundStrings = new StringBuilder();
        for (String str : listOfParsedStrings) {
            foundStrings.append(newLine);
            foundStrings.append(str);
        }
        return foundStrings.toString();
    }

    @Override
    public String toString() {
        return fileName + printAllFoundStrings();
    }
}
