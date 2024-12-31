/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banking.system; 
import java.sql.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Ramesh
 */
public class javaconnect 
{
    public static Connection connectdb() throws SQLException
    {
        Connection con = null;
        try
        {
            con =DriverManager.getConnection("jdbc:mysql://localhost:3306/banking","root","");
            return con;
        }catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
        return null;
    }
    
}
    

