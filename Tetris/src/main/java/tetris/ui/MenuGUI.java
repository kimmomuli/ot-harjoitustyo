package tetris.ui;

import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.shape.Line;

/**
 * GUI Menu
 * @author kimmo
 */
public class MenuGUI {
    
    /**
     * Create GUI which is Menu
     * @param primaryStage Stage, which is get from Tetris class
     */
    public static void startMenu(Stage primaryStage) {
        Pane screen = new Pane();
        addTetrisHeader(screen);
        Button quitBtn = createQuitButton();
        screen.getChildren().add(quitBtn);
        Button startBtn = createStartButton();
        screen.getChildren().add(startBtn);
        addGuideText(screen);
        addGuideKeys(screen);
        Scene scene = new Scene(screen);
        primaryStage.setTitle("Tetris");
        primaryStage.setScene(scene);
        primaryStage.show();
        startBtn.setOnAction((ActionEvent event) -> {
            screen.getChildren().clear();
            GameGUI.startTetris(primaryStage, screen, scene);
        });
        quitBtn.setOnAction((ActionEvent event) -> {
            System.exit(0);
        });
    } 
    
    /**
     * Create quit button
     * @return quit button
     */
    public static Button createQuitButton() {
        Button quitButton = new Button();
        quitButton.setLayoutX(40);
        quitButton.setLayoutY(150);
        quitButton.setText("QUIT");
        quitButton.setStyle("-fx-font-size: 4em; -fx-background-color: red");
        return quitButton;
    }
    
    /**
     * Create start button
     * @return start button
     */
    public static Button createStartButton() {
        Button startBtn = new Button();
        startBtn.setText("START");
        startBtn.setLayoutX(285);
        startBtn.setLayoutY(150);
        startBtn.setStyle("-fx-font-size: 4em; -fx-background-color: #00ff00");
        return startBtn;
    }
    
    /**
     * Add big text header and set size 500 x 650 and draw two lines
     * @param screen
     */
    public static void addTetrisHeader(Pane screen) {
        screen.setPrefSize(500, 650);
        screen.setStyle("-fx-background-color: grey;");
        Text title = new Text(28, 120, "TETRIS");
        title.setFill(Color.BLACK);
        title.setStyle("-fx-font-size: 10em;");
        screen.getChildren().add(title);
        screen.getChildren().add(new Line(0, 130, 500, 130));
        screen.getChildren().add(new Line(0, 245, 500, 245));
    }
    
    /**
     * Add text how to get points and add one more line
     * @param screen 
     */
    public static void addGuideText(Pane screen) {
        Text guideText1 = new Text(180, 290, "Points");
        guideText1.setStyle("-fx-font-size: 4em;");
        
        Text pointsText1 = new Text(160, 320, "One row 100p");
        pointsText1.setStyle("-fx-font-size: 2em;");
        Text pointsText2 = new Text(160, 350, "Two row 200p");
        pointsText2.setStyle("-fx-font-size: 2em;");
        Text pointsText3 = new Text(155, 380, "Three row 400p");
        pointsText3.setStyle("-fx-font-size: 2em;");
        Text pointsText4 = new Text(160, 410, "Four row 800p");
        pointsText4.setStyle("-fx-font-size: 2em;");
        screen.getChildren().addAll(guideText1, pointsText1, pointsText2, pointsText3, pointsText4);
        screen.getChildren().add(new Line(0, 420, 500, 420));
    }
    
    /**
     * Add how to move tetromino in tetris
     * @param screen
     */
    public static void addGuideKeys(Pane screen) {
        Text guideText1 = new Text(185, 465, "Keys");
        guideText1.setStyle("-fx-font-size: 4em;");
        
        Text keysText1 = new Text(180, 500, "Q = quit");
        keysText1.setStyle("-fx-font-size: 2em;");
        Text keysText2 = new Text(150, 530, "Left = left arrow");
        keysText2.setStyle("-fx-font-size: 2em;");
        Text keysText3 = new Text(140, 560, "Right = right arrow");
        keysText3.setStyle("-fx-font-size: 2em;");
        Text keysText4 = new Text(140, 590, "Rotate = up arrow");
        keysText4.setStyle("-fx-font-size: 2em;");
        screen.getChildren().addAll(guideText1, keysText1, keysText2, keysText3, keysText4);
    }
}
