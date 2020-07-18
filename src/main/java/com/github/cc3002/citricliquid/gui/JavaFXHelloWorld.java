package com.github.cc3002.citricliquid.gui;

import com.github.cc3002.citricjuice.model.board.HomePanel;
import com.github.cc3002.citricjuice.model.board.IPanel;
import com.github.cc3002.citricjuice.model.gameCharacters.IPlayer;
import com.github.cc3002.citricliquid.controller.GameController;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 * @author Ignacio Slater Muñoz.
 * @version 1.0.6-rc.1
 * @since 1.0
 */
public class JavaFXHelloWorld extends Application {
    GameController controller = new GameController();


    public static void main(String[] args) {
        launch(args);
    }

    private void setUp() {
        IPlayer suguri0 = controller.createSuguri();
        IPanel panel0 = controller.createHomePanel(0);
        controller.movePlayerTo(suguri0, 0);

        IPlayer marc0 = controller.createMarc();
        IPanel panel1 = controller.createBossPanel(1);
        controller.movePlayerTo(marc0, 0);
    }


    @Override
    public void start(Stage primaryStage) {
        setUp();
        primaryStage.setTitle("Game");
        primaryStage.setResizable(false);
        // root.
        Group root = new Group();
        // Players names and current panel
        StringBuilder sb = new StringBuilder();
        for (String playerName : controller.getPlayersName()) {
            sb.append("Name: ").append(playerName).append("\n");
        }
        Label label = new Label(sb.toString());
        label.setLayoutX(20);
        label.setLayoutY(40);

        root.getChildren().add(label);
        Scene scene = new Scene(root, 800, 500);

        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
