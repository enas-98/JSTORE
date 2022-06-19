/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jstore;

import DB.Control;
import DB.DB;
import java.io.FileNotFoundException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import jstore.Scenes.About;
import jstore.Scenes.Home;
import jstore.Scenes.Products;
import jstore.Scenes.Settings;
import jstore.Scenes.SignUp;
import jstore.Scenes.WishList;

/**
 *
 * @author anas
 */
public class Jstore extends Application implements INT{
    Home home = null;
    SignUp signup = null;
    Products product = null;
    Settings setting = null;
    About about = null;
    WishList wl = null;
    public static boolean flag = false;
    public static Stage stage = null;
    public static int U_id = 0;
    Thread t = null;
    Control DBcontrol = null;
    DB db = null;
    @Override
    public void start(Stage primaryStage)  {
        try {
        db = new DB();
        stage  = primaryStage;
        home = new Home(this);
        stage.setScene(home.scene); 
        stage.show();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Jstore.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            try {
                stage  = primaryStage;
                home = new Home(this);
            } catch (FileNotFoundException ex1) {
                Logger.getLogger(Jstore.class.getName()).log(Level.SEVERE, null, ex1);
            }
        stage.setScene(home.scene); 
        stage.show();
        
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Jstore.class.getName()).log(Level.SEVERE, null, ex);
        }
      
   }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void toProduts(ResultSet rs) {
        try {
            System.out.println("6");
            product = new Products(this, rs);
            System.out.println("7");
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
                System.out.println("9");
        }
         catch (SQLException ex) {
            Logger.getLogger(Jstore.class.getName()).log(Level.SEVERE, null, ex);
        }
        stage.setScene(product.scene);
    }
    @Override
    public void toSettings(){
        try {
            setting = new Settings(this);
        } catch (FileNotFoundException ex) {
        
        } catch (SQLException ex) {
            Logger.getLogger(Jstore.class.getName()).log(Level.SEVERE, null, ex);
        }
        stage.setScene(setting.scene);
    }
    
    @Override
    public void toHome(){
        if(!flag)
            stage.setScene(home.scene);
        else 
            stage.setScene(product.scene);
    }

    @Override
    public boolean addToWishList(int p_id) {
        try {
            return db.addToWishList(U_id,p_id);
        } catch (Exception ex) {
            ex.getStackTrace();
        }
        return false;
    }

    @Override
    public void SignIn(String email, String password) throws NullPointerException{
     try { 
               System.out.println("1");
                if(db.signIn(email, password))
                { System.out.println("2");
                    flag = true;
                toProduts(db.getProductsRS());
                    
                }else{
                    System.out.println("4");
                       Alert alertInformation = new Alert(Alert.AlertType.ERROR);
            alertInformation.setTitle("sign in faild");
            alertInformation.setHeaderText("check ur sign in values");
            alertInformation.setContentText("your email or password is wrong.");
            alertInformation.showAndWait();
                }
     } catch (ClassNotFoundException ex) {
                  ex.printStackTrace();
             } catch (SQLException ex) {
                  Alert alertInformation = new Alert(Alert.AlertType.ERROR);
            alertInformation.setTitle("sign in faild");
            alertInformation.setHeaderText("Error");
            alertInformation.setContentText(ex.getMessage());
            alertInformation.showAndWait();
           
            
        
             } catch (NullPointerException ex) {
             Alert alertInformation = new Alert(Alert.AlertType.ERROR);
            alertInformation.setTitle("sign in faild");
            alertInformation.setHeaderText("check ur Server connection");
            alertInformation.setContentText("you may not connected with the nework");
            alertInformation.showAndWait();
             } catch (Exception ex) {
            
           Alert alertInformation = new Alert(Alert.AlertType.ERROR);
            alertInformation.setTitle("sign in faild");
            alertInformation.setHeaderText("Error");
            alertInformation.setContentText(ex.getMessage());
            alertInformation.showAndWait();
           
              }
    }

    @Override
    public void toWL() {
       
            wl = new WishList(this);
       
        stage.setScene(wl.scene);
      }
    

    @Override
    public void toAbout() {
    
            about = new About(this);
       
        stage.setScene(about.scene);
    }

    @Override
    public void toSignUp() {
        
        try {
            signup = new  SignUp(this);
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Jstore.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        stage.setScene(signup.scene);
    }

    @Override
    public void toLogOut() {
        flag = false;
        try {
            home = new Home(this);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Jstore.class.getName()).log(Level.SEVERE, null, ex);
        }
        stage.setScene(home.scene);
    }

    @Override
    public void SignUp(String username, String password, String email, String gender, int age) {
        try {
            db.addUser(username, password, age, email, gender);
            flag = true;
            toProduts(db.getProductsRS());
        } catch (Exception ex) {
            
        }
    }

  
}
