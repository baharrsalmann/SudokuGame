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
        int rowCounter = 0;
        BackTrackingSudokuSolver mySolver = new BackTrackingSudokuSolver();
        SudokuBoard readBoard = new SudokuBoard(mySolver);
        try {
            this.fileReader = new FileReader(new File(filePath));
            this.bufferedReader = new BufferedReader(fileReader);
            String currentLine;
            while ((currentLine = bufferedReader.readLine()) != null) {
                String[] parts = currentLine.split(",");
                int columnCounter = 0;

                for (String part : parts) {
                    int partValue = Integer.parseInt(part.trim());
                    readBoard.setPoint(rowCounter, columnCounter, partValue);
                    columnCounter++;
                }
                rowCounter++;
            }
            bufferedReader.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return readBoard;

    }

    @Override
    public void write(String name, SudokuBoard obj) {
        String filePath = directoryPath + "\\" + name + ".txt";

        try {

            this.fileWriter = new FileWriter(filePath, false);
            this.bufferedWriter = new BufferedWriter(fileWriter);
            StringBuilder content = new StringBuilder();
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 8; j++) {
                    content.append(obj.getPoint(i, j));
                    content.append(",");
                }
                content.append(obj.getPoint(i,8));
                content.append("\n");
            }

            bufferedWriter.write(content.toString());
            bufferedWriter.close();

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