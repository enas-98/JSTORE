/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import jstore.INT;

/**
 *
 * @author anas
 */
public class Control implements Runnable{
INT i = null;
DB db = null;
public Control(INT i){
    this.i = i;
    
}
    @Override
    public void run() {
    try {
        db = new DB();
    } catch (ClassNotFoundException ex) {
     } catch (SQLException ex) {
    }
  
//        System.out.println("Thread started .....");  
    
    }
    public void checkSignIn(String email, String password){
        System.out.println("2");
        try { 
               
                if(db.signIn(email, password))
                { System.out.println("3");
                i.toProduts(db.getProductsRS());
                    System.out.println("4");
                }
               
                else System.out.println("faild");
            } catch (ClassNotFoundException ex) {
                System.out.println("class");
             } catch (SQLException ex) {
                 System.out.println("sql");
             } catch (Exception ex) {
              ex.printStackTrace();
              }
    }
    
}
