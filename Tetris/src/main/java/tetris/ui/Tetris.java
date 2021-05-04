package tetris.ui;

import javafx.application.Application;
import javafx.stage.Stage;

/**
 * Start javaFX
 * @author kimmo
 */
public class Tetris extends Application {
    
    /**
     * Create Stage and go with it to menu
     * @param primaryStage
     */
    @Override
    public void start(Stage primaryStage) {
        MenuGUI.startMenu(primaryStage);
    }
    
    /**
     * Start Application
     * @param args
     */
    public static void main(String[] args) {
        launch(args);
    }
}

