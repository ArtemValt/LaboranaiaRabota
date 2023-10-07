package com.example.laboranaiarabota;

import java.io.*;
import java.util.Arrays;
import java.util.stream.Collectors;

public class FileWork {

    public static FileLab createFile(String fileName) {
        File newFile = new File("/Users/belousovartem/IdeaProjects/bdcourse/LaboranaiaRabota/" + fileName);
        try {
            boolean newFile1 = newFile.createNewFile();
            return new FileLab(newFile.getPath(), fileName.getBytes());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static boolean writeToFile(FileLab fileLab, String... str) {
        String collect = String.join("\n", str);
        try {
            FileWriter fileWriter = new FileWriter(fileLab.getPath());
            fileWriter.write(collect);
            fileWriter.close();
            return true;
        } catch (IOException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public static String getFileInfo(String path) {
        int ch;
        StringBuilder stringBuilder = new StringBuilder();
        try {
            FileReader fileReader = new FileReader(path);
            while ((ch = fileReader.read()) != -1)
                stringBuilder.append((char) ch);
            fileReader.close();
        } catch (FileNotFoundException e) {
            return null;
        } catch (IOException ignored) {
            return null;
        }
        return stringBuilder.toString();
    }
}
