package org.example.hw4_event_handling;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import javafx.scene.text.Font;

import java.util.ArrayList;

//Listener
public class MainApp extends Application implements ControlEvent {
    private Label messageLabel;
    private ArrayList<CustomControl> controls = new ArrayList<>();

    @Override
    public void start(Stage primaryStage) {
        messageLabel = new Label("Click a control.");
        Font font = Font.font("Arial", FontWeight.BOLD, 16);
        messageLabel.setFont(font);

        HBox hbox = new HBox(10);

        final int number_of_controls = 8;

        for (int i = 0; i < number_of_controls; i++) {
            CustomControl control = new CustomControl("Control " + CustomControl.getCounter());//returns Id of previous control
            control.setEventHandler(this);//setting MainApp as a Listener
            controls.add(control);
            hbox.getChildren().add(control);
        }


        VBox root = new VBox(50,messageLabel, hbox);
        root.setAlignment(Pos.TOP_CENTER);
        hbox.setAlignment(Pos.CENTER);

        Scene scene = new Scene(root, 1000, 400);

        primaryStage.setScene(scene);
        primaryStage.setTitle("Custom Controls App");
        primaryStage.show();
    }

    @Override
    public void onControlClicked(CustomControl control) {
        messageLabel.setText("Selected control is Control " + control.getMyId());

        for (CustomControl c : controls) {
            if (c == control) {
                c.setRedBackground();
            } else {
                c.setGrayBackground();
            }
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}