/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jstore.Scenes.Slider;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Pos;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;

/**
 *
 * @author anas
 */
public class Slider extends HBox{
    javafx.scene.control.Slider slider = null;
    TextField count = null;
    public Slider(){
       slider = new javafx.scene.control.Slider(8, 100, 20);
       
       count = new TextField(slider.getValue()+"");
       getChildren().addAll(slider, count);
        setAlignment(Pos.CENTER);
        setHgrow(slider, Priority.ALWAYS);
        setHgrow(count, Priority.ALWAYS);
        count.setMaxSize(50, 20);
        slider.valueProperty().addListener((e)->{
                      count.textProperty().setValue(
                           String.valueOf((int)slider.valueProperty().get()));
                  });
        count.textProperty().addListener((e)->{
            slider.valueProperty().set((int)(double)(Double.valueOf(count.textProperty().get())));
        });
    }
    public void setValue(int i){
    slider.setValue(i);
    }
    
}
