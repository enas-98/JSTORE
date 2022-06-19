/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jstore.Scenes.Form;

import DB.DB;
import java.sql.SQLException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import jstore.Scenes.Slider.Slider;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import jstore.Jstore;

/**
 *
 * @author anas
 */
public class Form extends HBox {

    VBox L_Form = null;
    TextField username = null;
    TextField email = null;
    PasswordField password = null;

    VBox R_Form = null;
    Slider age = null;
    ComboBox<String> gender = null;
    Button submit = null;

    public Form() throws SQLException {
        /*---------------------INIT----------------------*/

        submit = new Button("Change");
        ObservableList<String> data = FXCollections.observableArrayList();
        data.addAll("Male", "Female");
        gender = new ComboBox<String>(data);
        age = new Slider();
        R_Form = new VBox(age, gender, submit);

        password = new PasswordField();
        email = new TextField();
        username = new TextField();
        L_Form = new VBox(username, email, password);
        /*---------------------INIT----------------------*/

        /*---------------------props----------------------*/
        setSpacing(10);
        getChildren().addAll(L_Form, R_Form);
        L_Form.setSpacing(10);
        R_Form.setSpacing(10);
        R_Form.setAlignment(Pos.CENTER);
        L_Form.setAlignment(Pos.CENTER);
        L_Form.setMargin(username, new Insets(20));
        L_Form.setMargin(password, new Insets(20));
        L_Form.setMargin(email, new Insets(20));
        R_Form.setMargin(age, new Insets(20));
        R_Form.setMargin(gender, new Insets(20));
        R_Form.setMargin(submit, new Insets(20));
//        gender.getItems().addAll("Male", "Female");
        submit.setMaxWidth(200);
        submit.setMaxHeight(40);
        password.setMaxWidth(350);
        password.setMaxHeight(50);
        email.setMaxHeight(500);
        email.setMaxWidth(350);
        username.setMaxHeight(50);
        username.setMaxWidth(350);
        age.setMaxHeight(Double.MAX_VALUE);
        age.setMaxWidth(350);
        gender.setMaxHeight(Double.MAX_VALUE);
        gender.setMaxWidth(350);
        R_Form.setVgrow(submit, Priority.ALWAYS);
        L_Form.setVgrow(email, Priority.ALWAYS);
        L_Form.setVgrow(username, Priority.ALWAYS);
        L_Form.setVgrow(password, Priority.ALWAYS);
        R_Form.setVgrow(age, Priority.ALWAYS);
        setHgrow(L_Form, Priority.ALWAYS);
        setHgrow(R_Form, Priority.ALWAYS);
        R_Form.setVgrow(gender, Priority.ALWAYS);
        L_Form.setMaxHeight(Double.MAX_VALUE);
        L_Form.setMaxWidth(Double.MAX_VALUE);
        R_Form.setMaxHeight(Double.MAX_VALUE);
        R_Form.setMaxWidth(Double.MAX_VALUE);
      if(Jstore.flag)
      {
          email.setText(DB.rs.getString("email"));
         username.setText(DB.rs.getString("username"));
         password.setText(DB.rs.getString("password"));
         gender.setValue(DB.rs.getString("gender"));
         age.setValue(DB.rs.getInt("age"));
      }
         submit.getStyleClass().add("shiny-orange");
         
    }
}
