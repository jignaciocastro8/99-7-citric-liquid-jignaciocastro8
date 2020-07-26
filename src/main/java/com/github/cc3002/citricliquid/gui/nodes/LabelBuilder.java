package com.github.cc3002.citricliquid.gui.nodes;

import javafx.scene.control.Label;

public class LabelBuilder {
    private String text;
    private int hPos;
    private int vPos;

    public LabelBuilder(String text, int hPos, int vPos) {
        this.text = text;
        this.hPos = hPos;
        this.vPos = vPos;
    }

    public LabelBuilder setText(String text) {
        this.text = text;
        return this;
    }

    public LabelBuilder setPos(int hPos, int vPos) {
        this.hPos = hPos;
        this.vPos = vPos;
        return this;
    }

    public Label build() {
        Label label = new Label(this.text);
        label.setLayoutX(this.hPos);
        label.setLayoutY(this.vPos);
        return label;
    }
}
