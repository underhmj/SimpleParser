package Utilities;

import Configs.FinderConfigs;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FinderUtilTest {
    private File sampleToRunFolder = new File("src" + File.separator + "test" + File.separator + "java" +
            File.separator + "SampleToRun");

    @Test
    void testFileFinder_includes() {
        File sampleFolder = sampleToRunFolder;
        File[] files = FinderUtil.fileFinder(sampleFolder, new FinderConfigs.Builder()
                .addFileFilterInclude("left")
                .addFileFilterInclude("down")
                .build());
        ArrayList<File> fileList = new ArrayList<>();
        Collections.addAll(fileList, files);

        assertTrue(fileList.contains(new File(sampleToRunFolder + File.separator + "Down.txt")));
        assertTrue(fileList.contains(new File(sampleToRunFolder + File.separator + "Left.txt")));
        assertTrue(fileList.contains(new File(sampleToRunFolder + File.separator + "LeftDown.txt")));
        assertTrue(fileList.contains(new File(sampleToRunFolder + File.separator + "LeftRight.txt")));
        assertTrue(fileList.contains(new File(sampleToRunFolder + File.separator + "RightDown.txt")));
        assertTrue(fileList.contains(new File(sampleToRunFolder + File.separator + "UpDown.txt")));
        assertEquals(6, fileList.size());
    }

    @Test
    void testFileFinder_excludes() {
        File sampleFolder = sampleToRunFolder;
        File[] files = FinderUtil.fileFinder(sampleFolder, new FinderConfigs.Builder()
                .addFileFilterExclude("left")
                .addFileFilterExclude("down")
                .build());
        ArrayList<File> fileList = new ArrayList<>();
        Collections.addAll(fileList, files);

        assertTrue(fileList.contains(new File(sampleToRunFolder + File.separator + "Right.txt")));
        assertTrue(fileList.contains(new File(sampleToRunFolder + File.separator + "Up.txt")));
        assertTrue(fileList.contains(new File(sampleToRunFolder + File.separator + "PutJarHere.txt")));
        assertEquals(3, fileList.size());
    }

    @Test
    void testFileFinder_minLength() {
        File sampleFolder = sampleToRunFolder;
        File[] files = FinderUtil.fileFinder(sampleFolder, new FinderConfigs.Builder()
                .setFileMinLength(9)
                .build());
        ArrayList<File> fileList = new ArrayList<>();
        Collections.addAll(fileList, files);

        assertTrue(fileList.contains(new File(sampleToRunFolder + File.separator + "LeftDown.txt")));
        assertTrue(fileList.contains(new File(sampleToRunFolder + File.separator + "LeftRight.txt")));
        assertTrue(fileList.contains(new File(sampleToRunFolder + File.separator + "PutJarHere.txt")));
        assertTrue(fileList.contains(new File(sampleToRunFolder + File.separator + "Right.txt")));
        assertTrue(fileList.contains(new File(sampleToRunFolder + File.separator + "RightDown.txt")));
        assertTrue(fileList.contains(new File(sampleToRunFolder + File.separator + "UpDown.txt")));
        assertEquals(6, fileList.size());
    }

    @Test
    void testFileFinder_maxLength() {
        File sampleFolder = sampleToRunFolder;
        File[] files = FinderUtil.fileFinder(sampleFolder, new FinderConfigs.Builder()
                .setFileMaxLength(8)
                .build());
        ArrayList<File> fileList = new ArrayList<>();
        Collections.addAll(fileList, files);

        assertTrue(fileList.contains(new File(sampleToRunFolder + File.separator + "Left.txt")));
        assertTrue(fileList.contains(new File(sampleToRunFolder + File.separator + "Down.txt")));
        assertTrue(fileList.contains(new File(sampleToRunFolder + File.separator + "Up.txt")));
        assertEquals(3, fileList.size());
    }

    @Test
    void testFileFinder_combination() {
        File sampleFolder = sampleToRunFolder;
        File[] files = FinderUtil.fileFinder(sampleFolder, new FinderConfigs.Builder()
                .addFileFilterInclude("Down")
                .addFileFilterInclude("Right")
                .addFileFilterExclude("Left")
                .setFileMaxLength(12)
                .setFileMinLength(9)
                .build());
        ArrayList<File> fileList = new ArrayList<>();
        Collections.addAll(fileList, files);

        assertTrue(fileList.contains(new File(sampleToRunFolder + File.separator + "Right.txt")));
        assertTrue(fileList.contains(new File(sampleToRunFolder + File.separator + "UpDown.txt")));
        assertEquals(2, fileList.size());
    }

    @Test
    void testFolderFinder_includes() {
        File sampleFolder = sampleToRunFolder;
        File[] files = FinderUtil.folderFinder(sampleFolder, new FinderConfigs.Builder()
                .addFolderFilterInclude("First")
                .addFolderFilterInclude("Third")
                .build());
        ArrayList<File> fileList = new ArrayList<>();
        Collections.addAll(fileList, files);

        assertTrue(fileList.contains(new File(sampleToRunFolder + File.separator + "FirstFolder")));
        assertTrue(fileList.contains(new File(sampleToRunFolder + File.separator + "ThirdFolder")));
        assertEquals(2, fileList.size());
    }

    @Test
    void testFolderFinder_excludes() {
        File sampleFolder = sampleToRunFolder;
        File[] files = FinderUtil.folderFinder(sampleFolder, new FinderConfigs.Builder()
                .addFolderFilterExclude("FOLDER")
                .build());
        ArrayList<File> fileList = new ArrayList<>();
        Collections.addAll(fileList, files);

        assertTrue(fileList.contains(new File(sampleToRunFolder + File.separator + "OneMore")));
        assertEquals(1, fileList.size());
    }

    @Test
    void testFolderFinder_minLength() {
        File sampleFolder = sampleToRunFolder;
        File[] files = FinderUtil.folderFinder(sampleFolder, new FinderConfigs.Builder()
                .setFolderMinLength(11)
                .build());
        ArrayList<File> fileList = new ArrayList<>();
        Collections.addAll(fileList, files);

        assertTrue(fileList.contains(new File(sampleToRunFolder + File.separator + "FirstFolder")));
        assertTrue(fileList.contains(new File(sampleToRunFolder + File.separator + "SecondFolder")));
        assertTrue(fileList.contains(new File(sampleToRunFolder + File.separator + "ThirdFolder")));
        assertEquals(3, fileList.size());
    }

    @Test
    void testFolderFinder_maxLength() {
        File sampleFolder = sampleToRunFolder;
        File[] files = FinderUtil.folderFinder(sampleFolder, new FinderConfigs.Builder()
                .setFolderMaxLength(10)
                .build());
        ArrayList<File> fileList = new ArrayList<>();
        Collections.addAll(fileList, files);

        assertTrue(fileList.contains(new File(sampleToRunFolder + File.separator + "OneMore")));
        assertEquals(1, fileList.size());
    }

    @Test
    void testFolderFinder_combination() {
        File sampleFolder = sampleToRunFolder;
        File[] files = FinderUtil.folderFinder(sampleFolder, new FinderConfigs.Builder()
                .addFolderFilterInclude("Folder")
                .addFolderFilterExclude("First")
                .setFolderMaxLength(11)
                .setFolderMinLength(3)
                .build());
        ArrayList<File> fileList = new ArrayList<>();
        Collections.addAll(fileList, files);

        assertTrue(fileList.contains(new File(sampleToRunFolder + File.separator + "ThirdFolder")));
        assertEquals(1, fileList.size());
    }
}
