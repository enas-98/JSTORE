/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jstore.Scenes;

import DB.Control;
import DB.DB;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javafx.animation.TranslateTransition;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.util.Duration;
import jstore.INT;
import jstore.Jstore;

import jstore.Scenes.navBar.NavBar;
import jstore.Scenes.navBar.Scenes;

/**
 *
 * @author anas
 */
public class Home {

    public Scene scene = null;
    public Button submit = null;
    TextField email = null;
    PasswordField password = null;
    VBox primary_layout = null;
    public StackPane secondary_layout = null;
    ImageView background = null;
    public NavBar navbar;

    public Home(INT i) throws FileNotFoundException {
        /*-----------init--------------------*/
        navbar = new NavBar(i);
        submit = new Button("SigIn");
        email = new TextField();
        password = new PasswordField();
        background = new ImageView(new Image(new FileInputStream(new File("src/media/Home.jpg"))));
        primary_layout = new VBox();
        secondary_layout = new StackPane(background, navbar, primary_layout);
        scene = new Scene(secondary_layout, 800, 600);
     
        /*-----------init--------------------*/

 /*-----------props-------------------*/
        email.setPromptText("Email Address");
        password.setPromptText("Password");
        primary_layout.setSpacing(50);
        primary_layout.setAlignment(Pos.CENTER);
        navbar.setAlignment(Pos.TOP_CENTER);
        primary_layout.getChildren().addAll(email, password, submit);
        VBox.setVgrow(submit, Priority.ALWAYS);
        primary_layout.setVgrow(email, Priority.ALWAYS);
        primary_layout.setVgrow(password, Priority.ALWAYS);
        StackPane.setMargin(primary_layout, new Insets(100, 10, 100, 10));
        navbar.control(Scenes.HOME);

        /*-----------props-------------------*/
        submit.setMinWidth(50);
        submit.setMaxWidth(200);
        submit.setMaxHeight(40);
        submit.setMinHeight(40);
        password.setMaxWidth(700);
        password.setMinHeight(25);
        password.setMaxHeight(50);
        email.setMaxHeight(50);
        email.setMaxWidth(700);
        email.setMinHeight(25);
        background.fitWidthProperty().bind(secondary_layout.widthProperty());
        background.fitHeightProperty().bind(secondary_layout.heightProperty());
        submit.getStyleClass().add("shiny-orange");
        background.setOpacity(0.4);
        StackPane.setAlignment(navbar, Pos.TOP_CENTER);
        scene.getStylesheets().add("Styles/style.css");

    
    submit.setOnAction((e)->{
try{
      i.SignIn(getEmail(), getPassWord());
}catch(NullPointerException ex){
               Alert alertInformation = new Alert(Alert.AlertType.ERROR);
            alertInformation.setTitle("sign in faild");
            alertInformation.setHeaderText("check ur Server connection");
            alertInformation.setContentText("you may not connected with the nework");
            alertInformation.showAndWait();
        
}           
       });
  
    }

    public String getEmail() {
        return email.getText();
    }

    public String getPassWord() {
        return password.getText();
    }

    public void animate() {
       
        TranslateTransition trans = new TranslateTransition(Duration.seconds(4), secondary_layout);
        trans.setFromX(scene.getWidth());
        trans.setToX(0);
        trans.setAutoReverse(false);
       
        trans.play();

    }
}
