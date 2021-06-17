package com.vladimirsimek.javafxcanvas;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.Pane;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.stage.Stage;
import javafx.scene.canvas.Canvas;
import javafx.scene.paint.Color;

import java.io.IOException;

public class Window extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        var root = new Pane();
        var canvas = new Canvas(300, 300);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        doDrawing(gc);
        root.getChildren().add(canvas);
        Scene scene = new Scene(root, 300, 250, Color.WHITESMOKE);
        scene.setOnKeyPressed(e -> Controller.move(gc, canvas, e));
        primaryStage.setScene(scene);
        primaryStage.setFullScreenExitKeyCombination(KeyCombination.NO_MATCH);
        primaryStage.setFullScreen(false);
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    public static int x = 50, y = 50;
    private void doDrawing(GraphicsContext gc) {

        var stops1 = new Stop[]{new Stop(0.2, Color.BLUE),
                new Stop(0.5, Color.RED), new Stop(0.8, Color.GOLD)};

        var lg1 = new LinearGradient(0.8, 0.8, 0, 0, true,
                CycleMethod.NO_CYCLE, stops1);

        gc.setFill(lg1);
        gc.fillRect(x, y, 200, 200);
    }

}