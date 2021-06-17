package com.vladimirsimek.javafxcanvas;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;

import javafx.scene.input.KeyEvent;

import java.security.Key;

public class Controller {
    public static void move(GraphicsContext gc, Canvas canvas, KeyEvent e) {

        gc.clearRect(0,0,canvas.getWidth(), canvas.getHeight());
        KeyCode keyCode = e.getCode();
        if(keyCode == KeyCode.A) {
            Window.x--;
        } else if (keyCode == KeyCode.D) {
            Window.x++;
        }else if (keyCode == KeyCode.W) {
            Window.y--;
        }else if (keyCode == KeyCode.S) {
            Window.y++;
        }




        var stops1 = new Stop[]{new Stop(0.2, Color.BLUE),
                new Stop(0.5, Color.RED), new Stop(0.8, Color.GOLD)};

        var lg1 = new LinearGradient(0.8, 0.8, 0, 0, true,
                CycleMethod.NO_CYCLE, stops1);

        gc.setFill(lg1);
        gc.fillRect(Window.x, Window.y, 200, 200);
    }
}
