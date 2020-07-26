package com.github.cc3002.citricliquid.gui;

import com.github.cc3002.citricliquid.controller.GameController;
import com.github.cc3002.citricliquid.controller.PlayerController;
import com.github.cc3002.citricliquid.gameFlux.StartTurnState;
import com.github.cc3002.citricliquid.gui.nodes.BoardNode;
import com.github.cc3002.citricliquid.gui.nodes.LabelBuilder;
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
    private int indDelta = 20;

    private Hashtable<Integer, int[]> panelPosition = new Hashtable<>();
    private ArrayList<BoardNode> playersNodes = new ArrayList<>();
    private ArrayList<Integer> currentPanel = new ArrayList<>();


    public static void main(String[] args) {
        launch(args);
    }



    @Override
    public void start(Stage primaryStage) throws FileNotFoundException, GameController.PlayersAndHomePanelsDontMatchException, PlayerController.NoPlayersException {

        primaryStage.setTitle("Game");
        primaryStage.setResizable(false);
        // root and scene.
        Group root = new Group();
        Scene scene = new Scene(root, 1200, 600);

        // Create board.
        setUpBoard(root);

        // Create players
        setUpPlayers(root);

        // Initiate game
        controller.initiateGame();

        // Player's info label.
        Label playersInfoLabel = setUpInfoLabel(root);
        setUpInfoTimer(playersInfoLabel);

        // Game's info label.
        Label gameInfo = setUpGameInfoLabel(root);
        setUpGameInfoTimer(gameInfo);

        // State info label.
        Label stateName = setUpStateLabel(root);
        updateStateTimer(stateName);

        // Stop or not on home panel button.
        setUpStopOnHomePanelButton(root);

        // Roll button
        setupRollButton(root);

        // Position timer.
        updatePositionTimer();

        primaryStage.setScene(scene);
        primaryStage.show();
    }






    // Setters of images and labels

    /**
     * Setter of the state label.
     * @param root Group.
     * @return Label.
     */
    private Label setUpStateLabel(Group root) {
        Label stateName = new Label();
        stateName.setFont(new Font(fontSize));
        stateName.setLayoutX(50);
        stateName.setLayoutY(50);
        root.getChildren().add(stateName);
        return stateName;
    }

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
     * @param root Group
     * @throws FileNotFoundException e
     */
    private void setUpPlayers(Group root) throws FileNotFoundException, GameController.PlayersAndHomePanelsDontMatchException {
        // Create players. The order of the creation is the order in which the view receive the players information.
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
            // Players image nodes.
            BoardNode peat = new BoardNode(hDivision + i * 100, 100,
                    100, 100, RESOURCE_PATH + names.get(i) + ".png");
            // Add nodes to the node dictionary.
            playersNodes.add(peat);

            // Put node.
            root.getChildren().add(peat.getNode());
        }

        // Randomly assign home panels.
        controller.assignHomePanels();
        // Put players on theirs home panel (not in the view).
        controller.putPlayersOnHomePanel();

        // Update the current position on the view.
        //currentPanel = controller.getPlayersPosition();
        //updatePlayersPosition();
    }

    /**
     * Put the players image on the current panel.
     */
    private void updatePlayersPosition() {
        currentPanel = controller.getPlayersPosition();
        int size = playersNodes.size();
        for (int i = 0; i < size; i++) {
            int ind = currentPanel.get(i);
            int[] position = panelPosition.get(ind);
            playersNodes.get(i).updatePosition(position[0], position[1]);
        }
    }

    /**
     * Label of the players info.
     * @param root Group
     */
    private Label setUpInfoLabel(Group root) {
        Label playerInfo = new Label();
        playerInfo.setFont(new Font(fontSize));
        playerInfo.setLayoutX(50);
        playerInfo.setLayoutY(250);
        root.getChildren().add(playerInfo);
        return playerInfo;
    }

    /**
     * Create panels one by one.
     * @param root Group.
     * @throws FileNotFoundException e
     */
    private void setUpBoard(Group root) throws FileNotFoundException {

        // Home panel 0:
        controller.createHomePanel(0);
        root.getChildren().add(new BoardNode(hDivision, 100, 100, 100,
                RESOURCE_PATH + "blueSqr.png").getNode());
        panelPosition.put(0, new int[]{hDivision, 100});
        root.getChildren().add(new LabelBuilder("Home Panel 0", hDivision, 100 - indDelta).build());

        // Home panel 4.
        controller.createHomePanel(4);
        root.getChildren().add(new BoardNode(hDivision + 600, 100, 100, 100,
                RESOURCE_PATH + "blueSqr.png").getNode());
        panelPosition.put(4, new int[]{hDivision + 600, 100});
        root.getChildren().add(new LabelBuilder("Home Panel 4", hDivision + 600, 100 - indDelta).build());

        // Home panel 7:
        controller.createHomePanel(7);
        root.getChildren().add(new BoardNode(hDivision, 400, 100, 100,
                RESOURCE_PATH + "blueSqr.png").getNode());
        panelPosition.put(7, new int[]{hDivision, 400});
        root.getChildren().add(new LabelBuilder("Home Panel 7", hDivision, 400 - indDelta).build());

        // Home panel 11:
        controller.createHomePanel(11);
        root.getChildren().add(new BoardNode(hDivision + 600, 400, 100, 100,
                RESOURCE_PATH + "blueSqr.png").getNode());
        panelPosition.put(11, new int[]{hDivision + 600, 400});
        root.getChildren().add(new LabelBuilder("Home Panel 11", hDivision + 600, 400 - indDelta).build());

        // Bonus panel 1:
        controller.createBonusPanel(1);
        root.getChildren().add(new BoardNode(hDivision + 150, 100, 100, 100,
                RESOURCE_PATH + "blueSqr.png").getNode());
        panelPosition.put(1, new int[]{hDivision + 150, 100});
        root.getChildren().add(new LabelBuilder("Bonus Panel 1", hDivision + 150, 100 - indDelta).build());

        // Bonus panel 10:
        controller.createBonusPanel(10);
        root.getChildren().add(new BoardNode(hDivision + 450, 400, 100, 100,
                RESOURCE_PATH + "blueSqr.png").getNode());
        panelPosition.put(10, new int[]{hDivision + 450, 400});
        root.getChildren().add(new LabelBuilder("Bonus Panel 10", hDivision + 450, 400 - indDelta).build());

        // Boss panel 2:
        controller.createBossPanel(2);
        root.getChildren().add(new BoardNode(hDivision + 300, 100, 100, 100,
                RESOURCE_PATH + "blueSqr.png").getNode());
        panelPosition.put(2, new int[]{hDivision + 300, 100});
        root.getChildren().add(new LabelBuilder("Boss Panel 2", hDivision + 300, 100 - indDelta).build());

        // Boss panel 9:
        controller.createBossPanel(9);
        root.getChildren().add(new BoardNode(hDivision + 300, 400, 100, 100,
                RESOURCE_PATH + "blueSqr.png").getNode());
        panelPosition.put(9, new int[]{hDivision + 300, 400});
        root.getChildren().add(new LabelBuilder("Boss Panel 9", hDivision + 300, 400 - indDelta).build());

        // Drop panel 3:
        controller.createDropPanel(3);
        root.getChildren().add(new BoardNode(hDivision + 450, 100, 100, 100,
                RESOURCE_PATH + "blueSqr.png").getNode());
        panelPosition.put(3, new int[]{hDivision + 450, 100});
        root.getChildren().add(new LabelBuilder("Drop Panel 3", hDivision + 450, 100 - indDelta).build());

        // Drop panel 8:
        controller.createDropPanel(8);
        root.getChildren().add(new BoardNode(hDivision + 150, 400, 100, 100,
                RESOURCE_PATH + "blueSqr.png").getNode());
        panelPosition.put(8, new int[]{hDivision + 150, 400});
        root.getChildren().add(new LabelBuilder("Drop Panel 8", hDivision + 150, 400 - indDelta).build());

        // Encounter panel 5:
        controller.createEncounterPanel(5);
        root.getChildren().add(new BoardNode(hDivision, 250, 100, 100,
                RESOURCE_PATH + "blueSqr.png").getNode());
        panelPosition.put(5, new int[]{hDivision, 250});
        root.getChildren().add(new LabelBuilder("Encounter Panel 5", hDivision, 250 - indDelta).build());

        // Encounter panel 6:
        controller.createEncounterPanel(6);
        root.getChildren().add(new BoardNode(hDivision + 600, 250, 100, 100,
                RESOURCE_PATH + "blueSqr.png").getNode());
        panelPosition.put(6, new int[]{hDivision + 600, 250});
        root.getChildren().add(new LabelBuilder("Encounter Panel 6", hDivision + 600, 250 - indDelta).build());

        // Connect panels.
        controller.assignNextPanelsWithKey(0, 1);
        controller.assignNextPanelsWithKey(1, 2);

        controller.assignNextPanelsWithKey(2, 3);
        controller.assignNextPanelsWithKey(3, 4);

        controller.assignNextPanelsWithKey(4, 6);
        controller.assignNextPanelsWithKey(6, 11);

        controller.assignNextPanelsWithKey(11, 10);
        controller.assignNextPanelsWithKey(10, 9);
        controller.assignNextPanelsWithKey(9, 8);
        controller.assignNextPanelsWithKey(8, 7);

        controller.assignNextPanelsWithKey(7, 5);
        controller.assignNextPanelsWithKey(5, 0);
    }

    // Timers

    /**
     * Timer of the state name.
     * @param stateLabel Label.
     */
    private void updateStateTimer(Label stateLabel) {
        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                stateLabel.setText(controller.getStateName());
            }
        };
        timer.start();
    }

    /**
     * Timer that updates position of the players.
     */
    private void updatePositionTimer() {
        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                updatePlayersPosition();
            }
        };
        timer.start();
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
        button.setLayoutY(450);
        button.setFocusTraversable(false);
        button.setOnAction(event -> {
            controller.rollTurnOwnerDice();
            button.setText("Roll: " + controller.getTurnOwner().getRoll());
            controller.setState(new StartTurnState());
        });

        root.getChildren().add(button);
    }

    /**
     * Setter of the stop or not in the home panel button.
     * @param root Group.
     */
    private void setUpStopOnHomePanelButton(Group root) {
        Button yesButton = new Button("Yes");
        yesButton.setLayoutX(200);
        yesButton.setLayoutY(50);
        yesButton.setOnAction(event -> controller.setTryToContinue(true));
        Button noButton = new Button("No");
        noButton.setLayoutX(250);
        noButton.setLayoutY(50);
        noButton.setOnAction(event -> controller.setTryToContinue(false));
        root.getChildren().add(yesButton);
        root.getChildren().add(noButton);
    }


}
