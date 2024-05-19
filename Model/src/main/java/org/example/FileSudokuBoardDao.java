package org.example;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileSudokuBoardDao implements Dao<SudokuBoard>, AutoCloseable, Serializable {

    public String directoryPath;
    public FileWriter fileWriter;
    public  BufferedWriter bufferedWriter;
    public FileReader fileReader;
    public BufferedReader bufferedReader;

    public FileSudokuBoardDao(String directoryPath) {
        this.directoryPath = directoryPath;
    }

    @Override
    public SudokuBoard read(String name) {
        String filePath = directoryPath + "\\" + name + ".txt";
        SudokuBoard readBoard;

        try {
            FileInputStream fis = new FileInputStream(filePath);
            ObjectInputStream ois = new ObjectInputStream(fis);

            readBoard = (SudokuBoard) ois.readObject();
            ois.close();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return readBoard;

    }

    @Override
    public void write(String name, SudokuBoard obj) {
        String filePath = directoryPath + "\\" + name + ".txt";

        try {

            FileOutputStream fos = new FileOutputStream(filePath);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(obj);
            oos.close();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

        @Override
        public List<String> names() {
            List<String> fileNames = new ArrayList<>();
            File directory = new File(directoryPath);
            File[] files = directory.listFiles();
            for (File file : files) {
                if (file.isFile() && file.getName().toLowerCase().endsWith(".txt")) {
                    fileNames.add(file.getName());
                }
            }

            return fileNames;
        }

    @Override
    public void close() throws Exception {
        if (bufferedWriter != null) {
            bufferedWriter.close();
        }

        if (bufferedReader != null) {
            bufferedReader.close();
        }

        if (fileWriter != null) {
            fileWriter.close();
        }

        if (fileReader != null) {
            fileReader.close();
        }


    }
}