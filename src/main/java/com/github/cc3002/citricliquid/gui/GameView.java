package com.github.cc3002.citricliquid.gui;

import com.github.cc3002.citricliquid.controller.GameController;
import com.github.cc3002.citricliquid.gui.nodes.BoardNode;
import com.github.cc3002.citricliquid.gui.nodes.MovableNode;
import com.github.cc3002.citricliquid.gui.nodes.MovableNodeBuilder;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.FileNotFoundException;
import java.util.*;

public class GameView extends Application {

    private GameController controller = new GameController();

    private static final String RESOURCE_PATH = "src/main/java/com/github/cc3002/citricliquid/gui/resources/";

    private int hDivision = 450;
    private double fontSize = 15;

    private ArrayList<MovableNode> playersNodes;

    public static void main(String[] args) {
        launch(args);
    }



    @Override
    public void start(Stage primaryStage) throws FileNotFoundException, GameController.PlayersAndHomePanelsDontMatchException {

        primaryStage.setTitle("Game");
        primaryStage.setResizable(false);
        // root and scene.
        Group root = new Group();
        Scene scene = new Scene(root, 1200, 600);

        // Create board.
        setUpBoard(root);

        // Create players
        setUpPlayers(scene, root);

        // Player's info label.
        Label playersInfoLabel = setUpInfoLabel(root);
        setUpInfoTimer(playersInfoLabel);

        // Game's info label.
        Label gameInfo = setUpGameInfoLabel(root);
        setUpGameInfoTimer(gameInfo);

        // Roll button
        setupRollButton(root);

        // Initiate game
        controller.initiateGame();

        // Position timer.
        startPositionTimer();

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * Timer that updates position of the players.
     */
    private void startPositionTimer() {
        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                updatePosition();
            }
        };
        timer.start();
    }

    /**
     * Modifies position of nodes that represent the image of the players on the game.
     */
    private void updatePosition() {
        /*
        for (MovableNode node : playersNodes) {
            node.getNode().setX();
            node.getNode().setY();
        }

         */
        // AQUÍ QUEDÉ: 21-07
    }


    // Setters of images and labels

    /**
     * Setter of the game info label. Creates a label, the timer is in charge of the updating.
     * @param root Group.
     * @return Label.
     */
    private Label setUpGameInfoLabel(Group root) {
        Label gameInfo = new Label();
        gameInfo.setFont(new Font(fontSize));
        gameInfo.setLayoutX(50);
        gameInfo.setLayoutY(100);
        root.getChildren().add(gameInfo);
        return gameInfo;
    }

    /**
     * Creates and puts images of the players.
     * @param scene Scene
     * @param root Group
     * @throws FileNotFoundException e
     */
    private void setUpPlayers(Scene scene, Group root) throws FileNotFoundException, GameController.PlayersAndHomePanelsDontMatchException {
        // Create players
        List<String> names = Arrays.asList("Peat", "Suguri", "Marc", "Kai");
        controller.createSuguri();
        controller.createMarc();
        controller.createKai();
        controller.createPeat();
        // Put images.
        for (int i = 0; i < names.size(); i++) {
            var peat = new MovableNodeBuilder(scene).setImagePath(RESOURCE_PATH + names.get(i) + ".png")
                    .setPosition(hDivision + i * 100, 100)
                    .setSize(100, 100)
                    .build();
            //playersNodes.add(peat); GENERA ERROR.
            root.getChildren().add(peat.getNode());
        }

        // Randomly assign home panels.
        controller.assignHomePanels();
        // Put players on theirs home panel (not in the view).
        controller.putPlayersOnHomePanel();
    }

    /**
     * Label of the players info.
     * @param root Group
     */
    private Label setUpInfoLabel(Group root) {
        Label playerInfo = new Label();
        playerInfo.setFont(new Font(fontSize));
        playerInfo.setLayoutX(50);
        playerInfo.setLayoutY(200);
        //StringBuilder sb = controller.getPlayersInfo();
        root.getChildren().add(playerInfo);
        return playerInfo;
    }
    /*
    Setter of the images of the panels.
     */
    private void setUpBoard(Group root) throws FileNotFoundException, GameController.PlayersAndHomePanelsDontMatchException {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(100);
        list.add(400);
        // Two large lines.
        for (int i = 0; i < 5; i++) {
            for (int n : list){
                root.getChildren().add(new BoardNode(hDivision + i * 150, n, 100, 100,
                        RESOURCE_PATH + "blueSqr.png").getNode());
            }
        }
        // One short and central line.
        for (int i = 0; i < 2; i++) {
            root.getChildren().add(new BoardNode(hDivision + 150 + i * 300, 250, 100, 100,
                    RESOURCE_PATH + "blueSqr.png").getNode());
        }
        // Create home panels.
        controller.createHomePanel(0);
        controller.createBonusPanel(1);
        controller.createBossPanel(2);
        controller.createDropPanel(3);
        controller.createHomePanel(4);
        controller.createEncounterPanel(5);
        controller.createEncounterPanel(6);
        controller.createHomePanel(7);
        controller.createDropPanel(8);
        controller.createBossPanel(9);
        controller.createBonusPanel(10);
        controller.createHomePanel(11);
    }

    // Timers

    /**
     * Info label timer. Updates the player's information.
     * @param label Label
     */
    private void setUpInfoTimer(Label label) {
        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                StringBuilder sb = controller.getPlayersInfo();
                label.setText(sb.toString());
            }
        };
        timer.start();
    }

    /**
     * Updates the game information.
     * @param label Label.
     */
    private void setUpGameInfoTimer(Label label) {
        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                StringBuilder sb = controller.getGameInfo();
                label.setText(sb.toString());
            }
        };
        timer.start();
    }


    // Buttons

    /**
     * Roll button.
     * @param root Group.
     */
    private void setupRollButton(Group root) {
        Button button = new Button("Roll: No roll yet");
        button.setLayoutX(50);
        button.setLayoutY(400);
        button.setFocusTraversable(false);
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                int roll = controller.rollTurnOwnerDice();
                button.setText("Roll: " + roll);
            }
        });

        root.getChildren().add(button);
    }


}
