/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jstore.Scenes.Line;

import javafx.scene.shape.HLineTo;

import javafx.scene.shape.MoveTo;

/**
 *
 * @author anas
 */
public class Line extends javafx.scene.shape.Line{
    public Line(){
        setStartX(0);
        setEndX(500);
       
     
        maxWidth(Double.MAX_VALUE);
    }
    
}
