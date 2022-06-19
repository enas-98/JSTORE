/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jstore.Scenes.navBar;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import jstore.INT;
import jstore.Jstore;

/**
 *
 * @author anas
 */
public class NavBar extends HBox{
   public Button home = null;
   public Button settings = null;
   public Button about = null;
   public Button SignUp = null;
   public Button WishList = null;
   
   INT i = null;
    public NavBar(INT i){
       
        if(Jstore.flag){
            this.i = i;
      /*-----------init--------------------*/
        home = new Button("Home");
        settings = new Button("Settings");
        about = new Button("About");
        WishList = new Button("WishList");
        /*-----------init--------------------*/
       
        home.setMinHeight(10);
        home.setMaxHeight(50);
        home.setMinWidth(10);
        home.setMaxWidth(500);
        WishList.setMinHeight(10);
        WishList.setMaxHeight(50);
        WishList.setMinWidth(10);
        WishList.setMaxWidth(500);
        settings.setMinHeight(10);
        settings.setMaxHeight(50);
        settings.setMinWidth(10);
        settings.setMaxWidth(500);
        about.setMinHeight(10);
        about.setMaxHeight(50);
        about.setMinWidth(10);
        about.setMaxWidth(500);
       
        
        getChildren().addAll(home ,WishList, settings ,about );
//      
        
         setHgrow(home, Priority.ALWAYS);
         setHgrow(WishList, Priority.ALWAYS);
         setHgrow(settings, Priority.ALWAYS);
         setHgrow(about, Priority.ALWAYS);
         home.getStyleClass().add("flat");
         WishList.getStyleClass().add("flat");
         settings.getStyleClass().add("flat");
         about.getStyleClass().add("flat");
         home.setOpacity(0.8);
         WishList.setOpacity(0.8);
         settings.setOpacity(0.8);
         about.setOpacity(0.8);
         
           settings.setOnAction((e)->{
               i.toSettings();
    });
           home.setOnAction((e)->{
               i.toHome();
    });
           WishList.setOnAction((e)->{
               i.toWL();
    });
           about.setOnAction((e)->{
               i.toAbout();
    });
        }
        /*-------------condition----------------*/
        else
        
        
        {
           this.i = i;
      /*-----------init--------------------*/
        home = new Button("Home");
        settings = new Button("Settings");
        about = new Button("About");
        SignUp = new Button("SignUp");
        /*-----------init--------------------*/
       
        home.setMinHeight(10);
        home.setMaxHeight(50);
        home.setMinWidth(10);
        home.setMaxWidth(500);
        SignUp.setMinHeight(10);
        SignUp.setMaxHeight(50);
        SignUp.setMinWidth(10);
        SignUp.setMaxWidth(500);
        settings.setMinHeight(10);
        settings.setMaxHeight(50);
        settings.setMinWidth(10);
        settings.setMaxWidth(500);
        about.setMinHeight(10);
        about.setMaxHeight(50);
        about.setMinWidth(10);
        about.setMaxWidth(500);
       
        
        getChildren().addAll(home ,SignUp, settings ,about );
//      
        
         setHgrow(home, Priority.ALWAYS);
         setHgrow(SignUp, Priority.ALWAYS);
         setHgrow(settings, Priority.ALWAYS);
         setHgrow(about, Priority.ALWAYS);
         home.getStyleClass().add("flat");
         SignUp.getStyleClass().add("flat");
         settings.getStyleClass().add("flat");
         about.getStyleClass().add("flat");
         home.setOpacity(0.8);
         SignUp.setOpacity(0.8);
         settings.setOpacity(0.8);
         about.setOpacity(0.8);
         
           settings.setOnAction((e)->{
               i.toSettings();
    });
           home.setOnAction((e)->{
               i.toHome();
    });
           SignUp.setOnAction((e)->{
               i.toSignUp();
    });
           about.setOnAction((e)->{
               i.toAbout();
    });
        }
           
        }
    public void control(Scenes scene){
            switch(scene){
                case HOME :
                    home.getStyleClass().add("selectedFlat");
                    home.disableProperty().set(true);
                    break;
                case SIGNUP :
                     SignUp.getStyleClass().add("selectedFlat");
                    SignUp.disableProperty().set(true);
                    break;
            
            }
    
    }
  
    
}
