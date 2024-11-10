package org.example.view;

import org.example.controller.GameController;
import org.example.controller.StartController;
import org.example.models.Board;
import org.example.models.Game;

import javax.swing.*;
import java.awt.*;

public class GameFrame extends JFrame {

    public void initializeFrame() {
        setTitle("Minesweeper");
        setSize(800, 600);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    public void initializeBoardPanel(Board board) {
        BoardPanel boardPanel = new BoardPanel(board);
        JPanel boardContainer = new JPanel();
        boardContainer.setLayout(new BorderLayout());
        boardContainer.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        boardContainer.add(boardPanel, BorderLayout.CENTER);
        setLayout(new BorderLayout());
        add(boardContainer, BorderLayout.CENTER);
    }

    public void showGameOverDialog() {
        Object[] options = {"Start New Game", "Exit Game"};

        int choice = JOptionPane.showOptionDialog(
            null,
                "What would you like to do?",
                "Game Over",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[0]
        );
        if(choice == JOptionPane.YES_OPTION){
            GameController gameController = new GameController();
            gameController.startNewGame();
        } else if (choice == JOptionPane.NO_OPTION) {
            GameController gameController = new GameController();
            gameController.exitGameWindow();
        }
    }
}
