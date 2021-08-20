package app.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import app.JDBCConnection;
import app.model.User; 

public class loginDao {
    static Connection conn = null;
    static PreparedStatement prst = null;
    static ResultSet rs = null;
    static ResultSet rsR = null;

    // private User user = new User();

    // User login
    public static int login(User user) throws Exception{

        int result = 1;
        conn = JDBCConnection.getCon();
        String sql = "select * from member where email=? and password=?";

        prst = conn.prepareStatement(sql);
        prst.setString(1, user.getEmail());
        prst.setString(2, user.getPassword());

        rs = prst.executeQuery();

        if(rs.next()){
            result = rs.getInt(1);
        }

        if(result > 0){
            return 1;
        }else{
            System.out.println("Not fond");
            return 0;
        }
    }

    public static boolean register(User user) throws Exception {
        int resultRegister = -1;
        conn = JDBCConnection.getCon(); // Get database connection

        String sqlregister = "select * from member where email=?";
        prst = conn.prepareStatement(sqlregister);

        prst.setString(1, user.getEmail());
        rsR = prst.executeQuery();

        if(rsR.next()){
            resultRegister = rsR.getInt(1);
        }
        
        if(resultRegister > 0){
            return false;
        }else{
            String sql = "insert into member (email, password, fullname, screenname, dateofbrith, gender, status, location) value(?,?,?,?,?,?,?,?)";
        
            prst = conn.prepareStatement(sql);
            prst.setString(1, user.getEmail());
            prst.setString(2, user.getPassword());
            prst.setString(3, user.getFullName());
            prst.setString(4, user.getScreenName());
            prst.setString(5, user.getDateOfBrith());
            prst.setString(6, user.getGender());
            prst.setString(7, user.getStatus());
            prst.setString(8, user.getLocation());

            return prst.executeUpdate() > 0;        
        }
    
    }
}
