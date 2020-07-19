package com.github.cc3002.citricliquid.gui;

import com.github.cc3002.citricjuice.model.board.HomePanel;
import com.github.cc3002.citricjuice.model.board.IPanel;
import com.github.cc3002.citricjuice.model.gameCharacters.IPlayer;
import com.github.cc3002.citricliquid.controller.GameController;
import com.github.cc3002.citricliquid.gui.nodes.BoardBuilder;
import com.github.cc3002.citricliquid.gui.nodes.BoardNode;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Enumeration;
import java.util.Hashtable;

public class GameView extends Application {

    private GameController controller = new GameController();

    private ArrayList<Node> boardNodes = new ArrayList<>();

    private Label infoLabel = new Label();



    private static final String RESOURCE_PATH = "src/main/java/com/github/cc3002/citricliquid/gui/resources/";
    private BoardBuilder boardBuilder;


    public static void main(String[] args) {
        launch(args);
    }



    @Override
    public void start(Stage primaryStage) throws FileNotFoundException {

        primaryStage.setTitle("Game");
        primaryStage.setResizable(false);
        // root and scene.
        Group root = new Group();
        Scene scene = new Scene(root, 1000, 600);

        // Set up board nodes.
        controller.createSuguri();
        controller.createMarc();
        boardBuilder.setPlayers(controller.getPlayersName());
        boardBuilder.createHomePanels(controller);
        boardBuilder.createNodes(root);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void setUpTimer() {
        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                int roll = controller.rollTurnOwnerDice();
            }
        };
        timer.start();
    }

    /**
     * Sets the board nodes.
     * @throws FileNotFoundException e.
     */
    private void setUpBoard() throws FileNotFoundException {





        // Create players and home panels.
        controller.setHomePanel(controller.createSuguri(), (HomePanel) controller.createHomePanel(0));
        boardNodes.add(new BoardNode(350, 100, 100, 100, RESOURCE_PATH + "blueSqr.png").getNode());
        boardNodes.add(new BoardNode(350,100,50, 50, RESOURCE_PATH + "yellow.png").getNode());

        controller.setHomePanel(controller.createMarc(), (HomePanel) controller.createHomePanel(1));
        boardNodes.add(new BoardNode(650, 100, 100, 100, RESOURCE_PATH + "blueSqr.png").getNode());
        boardNodes.add(new BoardNode(650,100,50, 50, RESOURCE_PATH + "black.png").getNode());


        controller.assignNextPanelsWithKey(0,1);
        boardNodes.add(new BoardNode(500,100 ,100, 100, RESOURCE_PATH + "rightArrow.png").getNode());

        StringBuilder sb = new StringBuilder();

        for (String name : controller.getPlayersName()) {
            sb.append(name).append("\n");
        }

        this.infoLabel.setText("Players: \n" + sb.toString());

    }


}
