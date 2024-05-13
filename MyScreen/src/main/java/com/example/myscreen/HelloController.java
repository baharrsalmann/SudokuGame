package com.example.myscreen;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import org.example.SudokuBoard;
import org.example.DiffLevel;
import org.example.BackTrackingSudokuSolver;
import org.example.DifficultyController;

public class HelloController {
    @FXML
    private Label welcomeText;

    @FXML
    public GridPane boardGrid;
    public static SudokuBoard currentBoard;
    public static SudokuBoard copyBoard;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

    @FXML
    public void selectLevel(DiffLevel currentLevel) throws CloneNotSupportedException {
        BackTrackingSudokuSolver currentSolver = new BackTrackingSudokuSolver();
        currentBoard = new SudokuBoard(currentSolver);
        currentBoard.solveGame();
        copyBoard = currentBoard.clone();

        DifficultyController diffController = new DifficultyController(currentLevel);
        diffController.createLevel(copyBoard);
    }

    @FXML
    public void easyLevel() throws CloneNotSupportedException {
        selectLevel(DiffLevel.easy);
        showBoard();
    }

    @FXML
    public void mediumLevel() throws CloneNotSupportedException {
        selectLevel(DiffLevel.medium);
        showBoard();
    }

    @FXML
    public void hardLevel() throws CloneNotSupportedException {
        selectLevel(DiffLevel.hard);
        showBoard();
    }

    @FXML
    public void showBoard() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                TextField fieldText;
                if (copyBoard.getPoint(i,j) == 0) {
                    fieldText = new TextField();
                }
                else {
                    fieldText = new TextField(Integer.toString(copyBoard.getPoint(i,j)));
                }

                boardGrid.add(fieldText,i,j);
            }
        }
    }
}