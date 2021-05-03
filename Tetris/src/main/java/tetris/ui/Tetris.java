package tetris.ui;

import javafx.application.Application;
import javafx.stage.Stage;

public class Tetris extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        MenuGUI.startMenu(primaryStage);
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}

