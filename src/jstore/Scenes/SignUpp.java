/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jstore.Scenes;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
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
import jstore.Scenes.navBar.NavBar;
import jstore.Scenes.navBar.Scenes;

/**
 *
 * @author anas
 */
public class SignUpp {
  public  Scene scene = null;
    public Button submit = null;
     TextField email = null;
    PasswordField password = null;
    VBox primary_layout = null;
    StackPane secondary_layout = null;
    ImageView background = null;
     public NavBar navbar;
    public SignUpp(INT i) throws FileNotFoundException{
        /*-----------init--------------------*/
        navbar = new NavBar(i);
        submit = new Button("SigUp");
        email = new TextField();
        password = new PasswordField();
        background = new ImageView(new Image(new FileInputStream(new File("src/media/Home.jpg"))));
        primary_layout = new VBox();
        secondary_layout = new StackPane(background ,navbar ,primary_layout);
        scene = new Scene(secondary_layout,800,600);
        animate();
        /*-----------init--------------------*/
      
        /*-----------props-------------------*/
        email.setPromptText("Email Address");
        password.setPromptText("Password");
        primary_layout.setSpacing(50);
        primary_layout.setAlignment(Pos.CENTER);
        navbar.setAlignment(Pos.TOP_CENTER);
        primary_layout.getChildren().addAll(email ,password ,submit );
        primary_layout.setVgrow(submit, Priority.ALWAYS);
        primary_layout.setVgrow(email, Priority.ALWAYS);
        primary_layout.setVgrow(password, Priority.ALWAYS);
        StackPane.setMargin(primary_layout, new Insets(100, 10, 100, 10));
        navbar.control(Scenes.SIGNUP);
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
       
       submit.getStyleClass().add("shiny-orange");

       
           background.setOpacity(0.4);
     StackPane.setAlignment(navbar, Pos.TOP_LEFT);
       scene.getStylesheets().add("Styles/style.css");
         
       
      
   
    }
    public void animate() {
        FadeTransition ft = new FadeTransition(Duration.millis(3000), primary_layout);
        ft.setFromValue(0.0);
        ft.setToValue(1.0);
       
        TranslateTransition trans = new TranslateTransition(Duration.seconds(3), primary_layout);
        trans.setFromY(scene.getHeight());
        trans.setToY(-1.0 * primary_layout.getLayoutBounds().getHeight());
        trans.setAutoReverse(false);
         ft.play();
        trans.play();

    }
}
