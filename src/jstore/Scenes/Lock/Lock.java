/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jstore.Scenes.Lock;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;

/**
 *
 * @author anas
 */
public class Lock extends StackPane{
    Rectangle rectangle = null;
    Label mes = null;
    public Lock(){
        mes = new Label("Please Sign In To edit settings...");
        mes.setFont(new Font("Bold", 30));
        setAlignment(mes, Pos.CENTER);
        rectangle = new Rectangle(100,100,Color.GREY);
       
        rectangle.widthProperty().bind(widthProperty());
        rectangle.heightProperty().bind(heightProperty());
        rectangle.setOpacity(0.8);
        getChildren().addAll(rectangle,mes);
    }
    
}
