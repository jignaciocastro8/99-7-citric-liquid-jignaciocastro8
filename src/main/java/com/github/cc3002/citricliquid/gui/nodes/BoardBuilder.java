package com.github.cc3002.citricliquid.gui.nodes;

import com.github.cc3002.citricjuice.model.board.HomePanel;
import com.github.cc3002.citricliquid.controller.GameController;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.control.Label;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class BoardBuilder {

    private static final String RESOURCE_PATH = "src/main/java/com/github/cc3002/citricliquid/gui/resources/";

    private Node root;
    private ArrayList<String> names;
    private ArrayList<Node> nodes;

    private float panelHeight = 100;
    private float panelWidth = 100;

    public BoardBuilder(Node root) {
        this.root = root;
    }

    /**
     * Setter of the names to put over the home panels.
     * @param playersName String array.
     * @return this.
     */
    public BoardBuilder setPlayers(ArrayList<String> playersName) {
        this.names = playersName;
        return this;
    }



    private void createNodes(Group root) {
        for (Node node : this.nodes) {
            root.getChildren().add(node);
        }
    }


    public void createBoard() {

    }
}
