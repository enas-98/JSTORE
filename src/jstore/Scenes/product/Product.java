/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jstore.Scenes.product;

import java.io.FileNotFoundException;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import jstore.INT;

/**
 *
 * @author anas
 */
public class Product extends GridPane{
   
    int P_id = 0;
    ImageView P_image = null;
    Label details = null;
    Label price = null;
    Label name = null;
    Label quan = null;
    Button buy = null;
    Button Add = null;
    public Product(INT i,int id,String name,String quan,String price,String details,String url) throws FileNotFoundException{
        
        P_id = id;
        buy = new Button("Buy");
        Add = new Button("Add");
        this.quan = new Label(quan);
        this.name = new Label(name);
        this.price = new Label("price : "+price+"$");
        this.details = new Label("details");
        System.out.println("Downlaoding");
        P_image = new ImageView("http://127.0.0.1/img/p1.jpg");
        P_image.setFitWidth(100);
        P_image.setFitHeight(100);
        System.out.println("downloaded");
        add(this.quan, 0, 1);
        add(this.Add, 0, 2);
        add(this.name, 1, 0);
        add(this.P_image, 1, 1);
        add(this.price, 1, 2);
        add(this.details, 2, 1);
        add(this.buy, 2, 2);
        setAlignment(Pos.CENTER);
       
        this.quan.setMinSize(Double.MIN_VALUE, Double.MIN_VALUE);
        this.Add.setMaxSize(200, 75);
        this.Add.setMinSize(20, 25); 
        this.name.setMinSize(Double.MIN_VALUE, Double.MIN_VALUE);
        this.price.setMinSize(Double.MIN_VALUE, Double.MIN_VALUE);
        this.details.setMinSize(Double.MIN_VALUE, Double.MIN_VALUE);
        this.buy.setMaxSize(200, 75);
        this.buy.setMinSize(20, 25);
        setHgrow(this.quan, Priority.ALWAYS);
        setHgrow(this.Add, Priority.ALWAYS);
        setHgrow(this.name, Priority.ALWAYS);
        setHgrow(this.P_image, Priority.ALWAYS);
        setHgrow(this.price, Priority.ALWAYS);
        setHgrow(this.details, Priority.ALWAYS);
        setHgrow(this.buy, Priority.ALWAYS);
        setVgrow(this.quan, Priority.ALWAYS);
        setVgrow(this.Add, Priority.ALWAYS);
        setVgrow(this.name, Priority.ALWAYS);
        setVgrow(this.P_image, Priority.ALWAYS);
        setVgrow(this.price, Priority.ALWAYS);
        setVgrow(this.details, Priority.ALWAYS);
        setVgrow(this.buy, Priority.ALWAYS);
        setMaxWidth(Double.MAX_VALUE);
        
         setHalignment(this.quan, HPos.CENTER);
         setHalignment(this.P_image, HPos.CENTER);
         setValignment(this.quan, VPos.CENTER);
         setValignment(this.P_image, VPos.CENTER);
        setHalignment(this.Add, HPos.CENTER);
         setValignment(this.Add, VPos.CENTER);
        setHalignment(this.name, HPos.CENTER);
         setValignment(this.name, VPos.CENTER);
         setHalignment(this.price, HPos.CENTER);
         setValignment(this.price, VPos.CENTER);
         setHalignment(this.details, HPos.CENTER);
         setValignment(this.details, VPos.CENTER);
        setHalignment(this.buy, HPos.CENTER);
         setValignment(this.buy, VPos.CENTER);
//        setHgap(5);
//        setVgap(5);
        buy.getStyleClass().add("flat");
        Add.getStyleClass().add("flat");
        this.name.getStyleClass().add("Mylabel");
        this.price.getStyleClass().add("Mylabel");
        this.quan.getStyleClass().add("Mylabel");
        this.details.getStyleClass().add("Mylabel");
        
        buy.setOnAction((e)->{
                Alert alertInformation = new Alert(Alert.AlertType.INFORMATION);
            alertInformation.setTitle("Buy");
            alertInformation.setHeaderText("Buy service not supported yet.");
            alertInformation.setContentText("this service will be supported when syria support visa card =)");
            alertInformation.showAndWait();
        });
        Add.setOnAction((e)->{
            i.addToWishList(P_id);
        });

    }
    
    
     
}
