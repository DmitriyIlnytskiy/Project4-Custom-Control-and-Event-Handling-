package org.example.hw4_event_handling;

import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

//StackPane handles layering automatically (Rectangle needs to be behind the Label)
public class CustomControl extends StackPane {//source
    private static int counter = 1;//counter
    private final int myId;
    private Label label;
    private Rectangle background;
    private ControlEvent eventHandler;

    public CustomControl(String text) {
        myId = counter++;
        label = new Label(text);
        background = new Rectangle(100, 50, Color.GRAY); // Default size and color
        getChildren().addAll(background, label);

        setOnMouseClicked(event -> {
            if (eventHandler != null) {
                eventHandler.onControlClicked(this);//notifying listener
            }
        });
    }

    public void setEventHandler(ControlEvent eventHandler) {
        this.eventHandler = eventHandler;
    }

    public void setRedBackground() {
        background.setFill(Color.RED);
    }

    public void setGrayBackground() {
        background.setFill(Color.GRAY);
    }

    public static int getCounter() {
        return counter;
    }

    public int getMyId() {
        return myId;
    }

}