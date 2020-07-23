package com.github.cc3002.citricliquid.gui;

import com.github.cc3002.citricliquid.controller.GameController;
import com.github.cc3002.citricliquid.gui.nodes.BoardNode;
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

    // Esto se puede hacer array. ###################3333
    private Hashtable<Integer, int[]> panelPosition = new Hashtable<>();
    // ##############################
    private ArrayList<BoardNode> playersNodes = new ArrayList<>();
    private ArrayList<Integer> currentPanel = new ArrayList<>();

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
        ArrayList<String> names = new ArrayList<>();
        controller.createSuguri();
        names.add("Suguri");
        controller.createMarc();
        names.add("Marc");
        controller.createKai();
        names.add("Kai");
        controller.createPeat();
        names.add("Peat");
        // Put images.
        for (int i = 0; i < names.size(); i++) {
            // Players image movable nodes.
            BoardNode peat = new BoardNode(hDivision + i * 100, 100,
                    100, 100, RESOURCE_PATH + names.get(i) + ".png");
            // Add nodes to the node dictionary.
            ArrayList<BoardNode> arr = new ArrayList<>();
            playersNodes.add(peat);
            /*
            var peat = new MovableNodeBuilder(scene).setImagePath(RESOURCE_PATH + names.get(i) + ".png")
                    .setPosition(hDivision + i * 100, 100)
                    .setSize(100, 100)
                    .build();

             */
            //playersNodes.add(peat); GENERA ERROR.

            // Put node.
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

    /**
     * Create panels one by one.
     * @param root Group.
     * @throws FileNotFoundException e
     * @throws GameController.PlayersAndHomePanelsDontMatchException e
     */
    private void setUpBoard(Group root) throws FileNotFoundException, GameController.PlayersAndHomePanelsDontMatchException {

        // Home panel 0:
        controller.createHomePanel(0);
        root.getChildren().add(new BoardNode(hDivision, 100, 100, 100,
                RESOURCE_PATH + "blueSqr.png").getNode());
        panelPosition.put(0, new int[]{hDivision, 100});
        // Home panel 4.
        controller.createHomePanel(4);
        root.getChildren().add(new BoardNode(hDivision + 600, 100, 100, 100,
                RESOURCE_PATH + "blueSqr.png").getNode());
        panelPosition.put(4, new int[]{hDivision + 600, 100});
        // Home panel 7:
        controller.createHomePanel(7);
        root.getChildren().add(new BoardNode(hDivision, 400, 100, 100,
                RESOURCE_PATH + "blueSqr.png").getNode());
        panelPosition.put(7, new int[]{hDivision, 400});
        // Home panel 11:
        controller.createHomePanel(11);
        root.getChildren().add(new BoardNode(hDivision + 600, 400, 100, 100,
                RESOURCE_PATH + "blueSqr.png").getNode());
        panelPosition.put(7, new int[]{hDivision + 600, 400});

        // Bonus panel 1:
        controller.createBonusPanel(1);
        root.getChildren().add(new BoardNode(hDivision + 150, 100, 100, 100,
                RESOURCE_PATH + "blueSqr.png").getNode());
        panelPosition.put(1, new int[]{hDivision + 150, 100});
        // Bonus panel 10:
        controller.createBonusPanel(10);
        root.getChildren().add(new BoardNode(hDivision + 450, 400, 100, 100,
                RESOURCE_PATH + "blueSqr.png").getNode());
        panelPosition.put(10, new int[]{hDivision + 450, 400});
        // Boss panel 2:
        controller.createBossPanel(2);
        root.getChildren().add(new BoardNode(hDivision + 300, 100, 100, 100,
                RESOURCE_PATH + "blueSqr.png").getNode());
        panelPosition.put(2, new int[]{hDivision + 300, 100});
        // Boss panel 9:
        controller.createBossPanel(9);
        root.getChildren().add(new BoardNode(hDivision + 300, 400, 100, 100,
                RESOURCE_PATH + "blueSqr.png").getNode());
        panelPosition.put(9, new int[]{hDivision + 300, 400});
        // Drop panel 3:
        controller.createDropPanel(3);
        root.getChildren().add(new BoardNode(hDivision + 450, 100, 100, 100,
                RESOURCE_PATH + "blueSqr.png").getNode());
        panelPosition.put(3, new int[]{hDivision + 450, 100});
        // Drop panel 8:
        controller.createDropPanel(8);
        root.getChildren().add(new BoardNode(hDivision + 150, 400, 100, 100,
                RESOURCE_PATH + "blueSqr.png").getNode());
        panelPosition.put(8, new int[]{hDivision + 150, 400});
        // Encounter panel 5:
        controller.createEncounterPanel(5);
        root.getChildren().add(new BoardNode(hDivision + 150, 250, 100, 100,
                RESOURCE_PATH + "blueSqr.png").getNode());
        panelPosition.put(5, new int[]{hDivision + 150, 250});
        // Encounter panel 6:
        controller.createEncounterPanel(6);
        root.getChildren().add(new BoardNode(hDivision + 450, 250, 100, 100,
                RESOURCE_PATH + "blueSqr.png").getNode());
        panelPosition.put(6, new int[]{hDivision + 450, 250});




    }

    // Timers

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

    // ESTO TIRA ERROR...
    private void updatePosition() {
        updatePanelDic();
        int size = currentPanel.size();
        for (int i = 0; i < size; i++) {
            int newPanel = currentPanel.get(i);
            int[] newPosition = panelPosition.get(newPanel);
            playersNodes.get(i).updatePosition(newPosition[0], newPosition[1]);
        }

    }

    /**
     * Use the controller to update the array of current panels of the players.
     */
    private void updatePanelDic() {
      currentPanel = controller.getPlayersPosition();
    }

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
