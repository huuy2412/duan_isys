/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coffee.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author nguye
 */
public class Jdbc{    
    private static String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private static String dburl  = "jdbc:sqlserver://localhost:1433;databaseName=QuanLyChiNhanhCafe";
    private static String user   = "sa";
    private static String pass   = "0520";
    static{
        try{
            Class.forName(driver);
        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }
    public static PreparedStatement getStmt(String sql,Object ... args) throws SQLException{
        Connection conn = DriverManager.getConnection(dburl,user, pass);
        PreparedStatement stmt;
        if(sql.trim().startsWith("{")){
            stmt = conn.prepareCall(sql);
        }
        else{
            stmt = conn.prepareStatement(sql);
        }
        for(int i=0;i<args.length;i++){
            stmt.setObject(i+1,args[i]);
        }
        return stmt;
    }
    public static ResultSet query(String sql,Object ... args) {
        try{
            PreparedStatement stmt = Jdbc.getStmt(sql, args);
            return stmt.executeQuery();
        }catch(Exception e){
            throw new RuntimeException(e);
        }
        
    }
    public static Object value(String sql, Object ... args){
        try{
            ResultSet rs = Jdbc.query(sql, args);
            if(rs.next()){
                return rs.getObject(0);
            }
            rs.getStatement().getConnection().close();
            return null;
        }catch(Exception ex){
            throw new RuntimeException(ex);
        }
    }
    public static int update(String sql, Object ... args){
        try{
            PreparedStatement stmt = Jdbc.getStmt(sql, args);
            try{
                return stmt.executeUpdate();
            }finally{
                stmt.getConnection().close();
            }
        }
        catch(Exception ex){
            throw new RuntimeException(ex);
        }
    }
}
