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
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
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
public class SignUp {

    public Scene scene = null;
    public Button submit = null;
    TextField email = null;
    TextField user_name = null;
    PasswordField password = null;
    VBox primary_layout = null;
    HBox gender_hbox = null;
    ToggleGroup gender_toggle = null;
    Slider age = null;
    Label gender_label = null;
    RadioButton male = null;
    RadioButton female = null;
    StackPane secondary_layout = null;
    ImageView background = null;
    public NavBar navbar;
    INT i = null;
    public SignUp(INT i) throws FileNotFoundException {
        /*-----------init--------------------*/
        navbar = new NavBar(i);
        submit = new Button("SigUp");
        email = new TextField();
        user_name = new TextField();
        password = new PasswordField();
        gender_hbox = new HBox();
        gender_toggle = new ToggleGroup();
        male = new RadioButton("male");
        female = new RadioButton("female");
        gender_label = new Label("Gender");
        age = new Slider(8, 100, 20);

        background = new ImageView(new Image(new FileInputStream(new File("src/media/Home.jpg"))));
        primary_layout = new VBox(10);

        secondary_layout = new StackPane(background, navbar, primary_layout);
        scene = new Scene(secondary_layout, 800, 600);
        animate();
        /*-----------init--------------------*/

 /*-----------props-------------------*/
        email.setPromptText("Email Address");
        password.setPromptText("Password");
        user_name.setPromptText("user name");
        primary_layout.setSpacing(50);
        primary_layout.setAlignment(Pos.CENTER);
        navbar.setAlignment(Pos.TOP_CENTER);
        primary_layout.getChildren().addAll(user_name, email, password, age, gender_hbox, submit);
        gender_hbox.getChildren().addAll(gender_label, male, female);
        male.setToggleGroup(gender_toggle);
        male.setSelected(true);
        female.setToggleGroup(gender_toggle);
        primary_layout.setVgrow(submit, Priority.ALWAYS);
        primary_layout.setVgrow(email, Priority.ALWAYS);
        primary_layout.setVgrow(user_name, Priority.ALWAYS);
        primary_layout.setVgrow(password, Priority.ALWAYS);
        primary_layout.setVgrow(gender_hbox, Priority.ALWAYS);
        primary_layout.setVgrow(age, Priority.ALWAYS);
        primary_layout.setVgrow(gender_hbox, Priority.ALWAYS);
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
         user_name.setMaxWidth(700);
        user_name.setMinHeight(25);
        user_name.setMaxHeight(50);
        email.setMaxHeight(50);
        email.setMaxWidth(700);
        email.setMinHeight(25);
        age.setShowTickLabels(true);
        age.setShowTickMarks(true);
        age.setMinSize(250, 25);
        age.setMaxSize(700, 50);
        gender_hbox.setAlignment(Pos.CENTER);
        //gender_hbox.setPadding(new Insets(100,10,10,100));
        gender_label.setAlignment(Pos.CENTER_LEFT);
        gender_label.setPadding(new Insets(25, 10, 25, 50));
        male.setPadding(new Insets(25, 10, 25, 10));
        female.setPadding(new Insets(25, 100, 25, 10));
        gender_hbox.setMinHeight(25);
        gender_hbox.setMaxHeight(50);
        gender_hbox.setMaxWidth(700);

        submit.getStyleClass().add("shiny-orange");

        background.setOpacity(0.4);
        StackPane.setAlignment(navbar, Pos.TOP_LEFT);
        scene.getStylesheets().add("Styles/style.css");
        submit.setOnAction((e)->{
            i.SignUp(getUserName(), getPassword(), getEmail(), getGender(), getAge());
        });

    }
    
    public String getUserName() {
        //System.out.println(user_name.getText());
        return user_name.getText();
        
    }
    public String getEmail(){
       // System.out.println(email.getText());
    return email.getText();
    }
    public String getPassword(){
        //System.out.println(password.getText());
    return password.getText();
    }
    
    public String getGender(){
         String res;
        if(male.isSelected())
         res= "male";
           // return "male";
        else res ="female";
       // System.out.println(res);
//return "female";
                return res;
    }
    
    public int getAge(){
        int ageres = (int)age.getValue();
        //System.out.println(ageres);
        return ageres;
    }

    public void animate() {
        FadeTransition ft = new FadeTransition(Duration.millis(3000), navbar);
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

