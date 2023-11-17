package DAO;

import java.sql.Connection;
import java.sql.DriverManager;

public class dao {
    public static Connection con = null;
        public dao(){
            if(con==null){
                String dbUrl = "jdbc:mysql://localhost:3306/quanly?autoReconnect=true&useSSL=false";
                String dbClass = "com.mysql.cj.jdbc.Driver";
                try {
                    Class.forName(dbClass);
                    con= DriverManager.getConnection(dbUrl,"root","vandat09");
                    System.out.printf("Success!\n");
                }catch (Exception ex){
                    System.out.printf("False!\n");
                    ex.printStackTrace();
                }
            }

        }
}

