package com.wistron.warehousemanagement.util;



import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JdbcUtils {

    private static String driver = null;
    private static String url = null;
    private static String username = null;
    private static String password = null;
    
    static{
        try{
            //get the information of property
            InputStream in = JdbcUtils.class.getClassLoader().getResourceAsStream("db.properties");
            Properties prop = new Properties();
            prop.load(in);
            
            //get the driver
            driver = prop.getProperty("driver");
            //get the database's property
            url = prop.getProperty("url");
            //����摨������
            username = prop.getProperty("username");
            //����摨�撖蕭?
            password = prop.getProperty("password");
            
            //��蝸��摨店嚙�?
            Class.forName(driver);
            
        }catch (Exception e) {
            throw new ExceptionInInitializerError(e);
        }
    }
    
    /**
    * @Method: getConnection
    * @Description: ����摨�撖對蕭?
    
    *
    * @return Connection��摨�撖對蕭?
    * @throws SQLException
    */ 
    public static Connection getConnection() throws SQLException{
        return DriverManager.getConnection(url, username,password);
    }
    
    /**
    * @Method: release
    * @Description: ��韏�蕭?
    *     閬������Connection��摨�撖寡情嚗�提�銵QL�隞斤�tatement撖寡情嚗��霂Ｙ���esultSet撖寡情
    * 
    * @param conn
    * @param st
    * @param rs
    */ 
    public static void release(Connection conn,Statement st,ResultSet rs){
        if(rs!=null){
            try{
                //��摮�霂Ｙ���esultSet撖寡情
                rs.close();
            }catch (Exception e) {
                e.printStackTrace();
            }
            rs = null;
        }
        if(st!=null){
            try{
                //��韐提�銵QL�隞斤�tatement撖寡情
                st.close();
            }catch (Exception e) {
                e.printStackTrace();
            }
        }
        
        if(conn!=null){
            try{
                //��Connection��摨�撖對蕭?
                conn.close();
            }catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

