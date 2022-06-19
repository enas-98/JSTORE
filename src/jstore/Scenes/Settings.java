/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jstore.Scenes;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import jstore.INT;
import jstore.Scenes.Form.Form;
import jstore.Scenes.Lock.Lock;
import jstore.Scenes.navBar.NavBar;

/**
 *
 * @author anas
 */
public class Settings {

    private static String USER = "";
    public Scene scene = null;

    public StackPane secondary_layout = null;
    NavBar navbar = null;
    ImageView background = null;
   Lock lock = null;
    Form form = null;
    VBox primary_layout = null;
    // Label title = null;

    public Settings(INT i) throws FileNotFoundException, SQLException {
        /*---------------init-------------------------*/
        form = new Form();

        primary_layout = new VBox(10);

        navbar = new NavBar(i);
        background = new ImageView(new Image(new FileInputStream(new File("src/media/Home.jpg"))));
        secondary_layout = new StackPane(background,  navbar,primary_layout);
        if(!jstore.Jstore.flag)
        {
          lock = new Lock();
            secondary_layout.getChildren().add(lock);
            StackPane.setMargin(lock, new Insets(50, 0, 0, 0));
              
        }
        StackPane.setMargin(primary_layout, new Insets(50, 0, 0, 0));
  
        /*---------------init-------------------------*/
 /*---------------props-------------------------*/
        primary_layout.getChildren().addAll(form);
        primary_layout.setAlignment(Pos.CENTER);
        background.setOpacity(0.4);
        StackPane.setAlignment(primary_layout, Pos.CENTER);
        /*---------------props-------------------------*/
        scene = new Scene(secondary_layout, 800, 600);
        scene.getStylesheets().add("Styles/style.css");
        navbar.setAlignment(Pos.TOP_CENTER);
        
    }

    public void setUSER(String USER) {
        this.USER = USER;
    }

    public String getUSER() {
        return USER;
    }

    public void changeTitle() {
        //title.setText("Hello "+ USER);
    }

    public void changeTitle(String USER) {
        //title.setText("Hello "+ USER);
    }
}
// if(!Jstore.flag)
//        {
//            rectangle = new Rectangle();
//            secondary_layout = new StackPane(background, navbar, form,rectangle);
//            rectangle.setHeight(secondary_layout.getHeight());
//            rectangle.setWidth(secondary_layout.getWidth());
//            rectangle.getStyleClass().add("rectangle");
//        }else
//        {
//          secondary_layout = new StackPane(background, navbar, form);
//        }
//       
