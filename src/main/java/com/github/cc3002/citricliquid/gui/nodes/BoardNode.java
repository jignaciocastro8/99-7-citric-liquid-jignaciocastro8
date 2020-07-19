package com.github.cc3002.citricliquid.gui.nodes;

import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * This class represents an image on the board: panel, arrows connecting panels,..
 */

public class BoardNode {

    private ImageView img;
    private int hPos;
    private int vPos;
    private double imgHeight;
    private double imgWidth;

    public BoardNode(int hPos, int vPos, double imgHeight, double imgWidth, String imgPath) throws FileNotFoundException {
        this.hPos = hPos;
        this.vPos = vPos;
        this.imgHeight = imgHeight;
        this.imgWidth = imgWidth;
        this.addImg(imgPath);
    }

    private void addImg(String imgPath) throws FileNotFoundException {
        FileInputStream spriteImage = new FileInputStream(imgPath);
        this.img = new ImageView(new Image(spriteImage));
        this.img.setX(hPos);
        this.img.setY(vPos);
        this.img.setFitWidth(this.imgWidth);
        this.img.setFitHeight(this.imgHeight);
    }

    /**
     * Getter of the actual node.
     * @return Img.
     */
    public ImageView getNode() {
        return this.img;
    }
}
