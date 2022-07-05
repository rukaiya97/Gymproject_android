package com.example.arrayadapter;

import android.os.StrictMode;
import android.util.Log;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static  final  String jdbcDriver = "com.mysql.jdbc.Driver";
    private  static  final String dbUrl = "jdbc:mysql://192.168.43.201:3306/mygym_db";
    private  static  final  String dbUsername = "root";
    private  static  final  String dbPassword ="";


    //@SupperList("NewApi")
    public Connection connection(){
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        Connection con = null;

        try {
            Class.forName(jdbcDriver);
            con = DriverManager.getConnection(dbUrl,dbUsername,dbPassword);

        }catch (SQLException se){
            Log.e("Error: ", se.getMessage());
        }catch (ClassNotFoundException c){
            Log.e("Error: ", c.getMessage());
        }catch (Exception e){
            Log.e("Error: ", e.getMessage());
        }
        return con;
    }
}
