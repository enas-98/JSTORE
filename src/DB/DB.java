/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import jstore.Jstore;

/**
 *
 * @author anas
 */
public class DB {

    private static Connection con;
    private static Statement stat;
    private static PreparedStatement Pstat;
    public static ResultSet rs = null;
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/db";
    static final String USER = "root";
    static final String PASS = "";
    private static ArrayList<Savepoint> sp = null;
        private ResultSet P_rs = null;

    public DB() throws ClassNotFoundException, SQLException {
        connect();
        sp = new ArrayList<>();
    }

    public void connect() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        System.out.println("Connecting to database...");
        con = DriverManager.getConnection(DB_URL, USER, PASS);
        con.setAutoCommit(false);
    }
    public boolean signIn(String Email ,String password) throws SQLException, Exception, Exception {
      if (con == null) {
            throw new Exception("connection is down now");
        }
        
      String sql = "SELECT * FROM users WHERE email = ? AND password = ?";
        Pstat = con.prepareStatement(sql);
        Pstat.setString(1, Email);
        Pstat.setString(2, password);
        rs = Pstat.executeQuery();
         if(rs == null){
        throw new Exception("check your email or password");
        }
        rs.last();
        int size = rs.getRow();
        Jstore.U_id = rs.getInt("id");
        System.out.println(size);
        return size == 1 ? true : false;
       }

    public int addUser(String username, String password, int age, String email, String gender) throws Exception {
        if (con == null) {
            throw new Exception("connection is down now");
        }
        Pstat = con.prepareStatement("INSERT INTO users (username, password, Age, email, Gender) VALUES (?,?,?,?,?)");
        Pstat.setString(1, username);
        Pstat.setString(2, password);
        Pstat.setInt(3, age);
        Pstat.setString(4, email);
        Pstat.setString(5, gender);
        int rows = Pstat.executeUpdate();
        signIn(email, password);
        commit();
        return rows;
    }

    public boolean deleteUser(int id) throws SQLException, Exception {

        if (con == null) {
            throw new Exception("connection is down now");
        }
        Pstat = con.prepareStatement("DELETE FROM users WHERE id = ? ");
        Pstat.setInt(1, id);
        Pstat.execute();
        return true;
    }

    public int updateUser(int id, String columnName, String value, String dataType) throws SQLException, Exception {

        if (con == null) {
            throw new Exception("connection is down now");
        }
        Pstat = con.prepareStatement("UPDATE users SET `" + columnName + "` = ? WHERE id = ? ");
        if (dataType.equals("String")) {
            Pstat.setString(1, value);
        } else if (dataType.equals("int")) {
            Pstat.setInt(1, Integer.valueOf(value));
        }
        Pstat.setInt(2, id);
        return Pstat.executeUpdate();
    }

    public void setNewSavePoint() throws SQLException, Exception {
        if (con == null) {
            throw new Exception("connection is down now");
        }
        sp.add(con.setSavepoint((new Date()).toString()));
    }

    private Savepoint getSavePointById(int index) throws Exception {
        if (con == null) {
            throw new Exception("connection is down now");
        }
        return sp.get(index);
    }

    private Savepoint getSavePointByName(String Name) throws Exception {
        if (con == null) {
            throw new Exception("connection is down now");
        }
        for (Savepoint fsp : sp) {
            if (fsp.getSavepointName().equalsIgnoreCase(Name)) {
                return fsp;
            }
        }
        return con.setSavepoint();
    }

    public void rollbackById(int index) throws Exception {
        if (con == null) {
            throw new Exception("connection is down now");
        }
        con.rollback(getSavePointById(index - 1));
    }

    public void rollbackByName(String name) throws Exception {
         if (con == null) {
            throw new Exception("connection is down now");
        }
        con.rollback(getSavePointByName(name));
    }

    public void showSavePoints() throws Exception {
         if (con == null) {
            throw new Exception("connection is down now");
        }
        for (int i = 0; i < sp.size(); i++) {
            System.out.println((i + 1) + "- " + sp.get(i).getSavepointName());
        }
    }

    public void showUsers() throws SQLException, Exception {
         if (con == null) {
            throw new Exception("connection is down now");
        }
        String sql = "SELECT * FROM users";
        stat = con.createStatement();
        rs = stat.executeQuery(sql);
        printRs(rs);

    }
    private void getProducts() throws Exception{
     if (con == null) {
            throw new Exception("connection is down now");
        }
        String sql = "SELECT * FROM Products";
        stat = con.createStatement();
        P_rs = stat.executeQuery(sql);
    }

    private static void printRs(ResultSet rs) throws SQLException {
//Ensure we start with first row
        rs.beforeFirst();
        while (rs.next()) {
//Retrieve by column name
            int id = rs.getInt("id");
            int age = rs.getInt("age");
            String username = rs.getString("username");
            String password = rs.getString("password");
//Display values
            System.out.print("ID: " + id);
            System.out.print(", Age: " + age);
            System.out.print(", username: " + username);
            System.out.println(", password: " + password);
        }
    }

    public void close() throws SQLException {
        if (stat != null) {
            stat.close();
        }
        if (con != null) {
            con.close();
        }
    }

    public void commit() throws SQLException {
        con.commit();
    }

    public void search(String val) throws SQLException, Exception {
         if (con == null) {
            throw new Exception("connection is down now");
        }
        String sql = "SELECT * FROM users";
        stat = con.createStatement();
        rs = stat.executeQuery(sql);
        while (rs.next()) {
            if (checkVal(rs, val)) {
                printRSrecord(rs);
            }
        }
    }

    private void printRSrecord(ResultSet rs) throws SQLException {
        
        int id = rs.getInt("id");
        int age = rs.getInt("age");
        String username = rs.getString("username");
        String password = rs.getString("password");
//Display values
        System.out.print("ID: " + id);
        System.out.print(", Age: " + age);
        System.out.print(", username: " + username);
        System.out.println(", password: " + password);

    }

    private boolean checkVal(ResultSet rs, String val) throws SQLException {
        return rs.getString("username").contains(val) || rs.getString("password").contains(val) || rs.getString("email").contains(val);
    }
    public ResultSet getProductsRS() throws Exception{
        getProducts();
    return P_rs;
    }

    public boolean addToWishList(int U_id , int p_id) throws Exception {
         if (con == null) {
            throw new Exception("connection is down now");
        }
          Pstat = con.prepareStatement("INSERT INTO wishlist (u_id,p_id) VALUES (?,?)");
        Pstat.setInt(1, U_id);
        Pstat.setInt(2, p_id);
        
        int rows = Pstat.executeUpdate();
commit();
        return rows == 1 ? true : false;
      }
}
