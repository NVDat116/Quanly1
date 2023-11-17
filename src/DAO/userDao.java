package DAO;

import model.user;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class userDao extends dao{
    PreparedStatement prt = null;
    ResultSet resultSet = null;

    public boolean addUser(String a1,String a2,String a3,String a4,String a5){
        try {
            String query = "INSERT INTO usertbl (firstname, midname, lastname, username, password) VALUES (?, ?, ?, ?, ?)";
            prt = con.prepareStatement(query);
            prt.setString(1, a1);
            prt.setString(2, a2);
            prt.setString(3, a3);
            prt.setString(4, a4);
            prt.setString(5, a5);

            prt.executeUpdate();
            System.out.println("Dữ liệu đã được chèn thành công!");
        }catch (Exception ex){
            ex.printStackTrace();
        }

        return true;
    }
    public ArrayList<user> getUser(){
        ArrayList<user> list = new ArrayList<>();

        try {
            String query = "SELECT * FROM usertbl";
            prt = con.prepareStatement(query);
            resultSet = prt.executeQuery();
            while (resultSet.next()){
                user us = new user();
                us.setId(resultSet.getString(1));
                us.setFirstName(resultSet.getString(2));
                us.setMidName(resultSet.getString(3));
                us.setLastName(resultSet.getString(4));
                us.setUserName(resultSet.getString(5));
                us.setPassWord(resultSet.getString(6));

                list.add(us);
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return list;
    }

    public boolean delUser(String id){
        try {
            String idx =id;
            String query = "DELETE FROM usertbl WHERE iduser = ?";
            prt = con.prepareStatement(query);
            prt.setString(1,idx);
            int rowDeleted = prt.executeUpdate();
            if(rowDeleted>0){
                System.out.printf("Xoa thanh cong!\n");
            }else return false;

        }catch (Exception ex){
            ex.printStackTrace();
        }
        return true;
    }

}
