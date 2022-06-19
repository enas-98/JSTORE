/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jstore;

import java.sql.ResultSet;

/**
 *
 * @author anas
 */
public interface INT {
    public void toProduts(ResultSet rs);
    public void toSettings();
    public void toHome();
    public void toLogOut();
    public void toWL();
    public void toAbout();
    public void toSignUp();
    public void SignUp(String username ,String password ,String email ,String gender ,int age);
    public boolean addToWishList(int p_id);
    public void SignIn(String email, String password);
}
