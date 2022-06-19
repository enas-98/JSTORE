/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jstore.Scenes;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import jstore.INT;
import jstore.Jstore;
import jstore.Scenes.Line.Line;
import jstore.Scenes.navBar.NavBar;
import jstore.Scenes.product.Product;

/**
 *
 * @author anas
 */
public class Products {
    public Scene scene = null;
    public StackPane secondary_layout = null;
    public VBox primary_Layout = null;
    ImageView background = null;
    public NavBar navbar = null;
    Product[] Items = null;
    ScrollPane sp = null;
    Button logout = null;
    public Products(INT i,ResultSet rs) throws FileNotFoundException, FileNotFoundException, SQLException{
        /*-----------init---------------------------*/
        rs.last();
        logout = new Button("LogOut");
        background = new ImageView(new Image(new FileInputStream(new File("src/media/home.jpg")))); 
        navbar = new NavBar(i);
        Items  = new Product[rs.getRow()];
        rs.beforeFirst();
        primary_Layout = new VBox(8);
         primary_Layout.getChildren().add(new Line());
       while(rs.next())
       {
           Items[rs.getRow()-1] = new Product(i,rs.getInt("id"), rs.getString("name"), rs.getString("quantity"), rs.getString("price"), rs.getString("details"), rs.getString("url"));
          
           primary_Layout.getChildren().add( Items[rs.getRow()-1] );
           VBox.setVgrow( Items[rs.getRow()-1], Priority.ALWAYS);
           
           Items[rs.getRow()-1].setAlignment(Pos.CENTER);
        primary_Layout.getChildren().add(new Line());
       }
       primary_Layout.setAlignment(Pos.CENTER);
       sp = new ScrollPane(primary_Layout);
        sp.setFitToHeight(false);
      sp.getStyleClass().add("scroll-pane"); 
     secondary_layout = new StackPane(background ,navbar,sp,logout);
     StackPane.setAlignment(logout, Pos.BOTTOM_RIGHT);
         secondary_layout.setMargin(sp,new Insets(50, 0, 0, 0));
      primary_Layout.setMaxWidth(Double.MAX_VALUE);
      sp.setFitToWidth(true);
       
        background.setOpacity(0.4);
        scene = new Scene(secondary_layout, 800, 600);
//        StackPane.setAlignment(navbar, Pos.CENTER);
        StackPane.setAlignment(primary_Layout, Pos.CENTER);
       /*-----------init---------------------------*/
       
       /*-----------props---------------------------*/
       background.fitWidthProperty().bind(secondary_layout.widthProperty());
       background.fitHeightProperty().bind(secondary_layout.heightProperty());
       scene.getStylesheets().add("Styles/style.css");
        logout.getStyleClass().add("flat");
       /*-----------props---------------------------*/
         StackPane.setAlignment(sp, Pos.CENTER);
          logout.setOnAction((e)->{
            i.toLogOut();
              
          
          });
    }
    
}
