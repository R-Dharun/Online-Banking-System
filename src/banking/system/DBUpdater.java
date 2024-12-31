/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banking.system;

import java.sql.*;
import java.sql.DriverManager;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import static jdk.nashorn.internal.runtime.Debug.id;

/**
 *
 * @author Ramesh
 */
public class DBUpdater {
    String conString="jdbc:mysql://localhost:3306/banking";
    String username="root";
    String password = "";
    public Boolean add(String N,String A,String G,String E,String P,String DOB,String PROOF,String ACC,String USER,String PASS)
    {
        //String sql = "INSERT INTO iregisternow(ID,Name,Address,Gender,Email,Phone,DateofBirth,ProofType,AccountNo,Username,Password) VALUES('"+D+"','"+N+"','"+A+"','"+G+"','"+E+"','"+P+"','"+DOB+"','"+PROOF+"','"+ACC+"','"+USER+"','"+PASS+"')";
        try
        {
            Connection conn = DriverManager.getConnection(conString,username,password );
            String sql = "INSERT INTO iregisternow(Name,Address,Gender,Email,Phone,DateofBirth,ProofType,AccountNo,Username,Password) VALUES('"+N+"','"+A+"','"+G+"','"+E+"','"+P+"','"+DOB+"','"+PROOF+"','"+ACC+"','"+USER+"','"+PASS+"')";
            PreparedStatement s =conn.prepareStatement(sql);
            s.executeUpdate();
            return true;
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return false;
    }
    public DefaultTableModel getData()
    {
        DefaultTableModel dm = new DefaultTableModel();
        dm.addColumn("ID");
        dm.addColumn("Name");
        dm.addColumn("Address");
        dm.addColumn("Gender");
        dm.addColumn("Email");
        dm.addColumn("Phone");
        dm.addColumn("DateofBirth");
        dm.addColumn("ProofType");
        dm.addColumn("AccountNo");
        dm.addColumn("Username");
        dm.addColumn("Password");
        
        String sql = "SELECT * FROM iregisternow";
        try
        {
            Connection conn=DriverManager.getConnection(conString,username,password);
            Statement s =conn.prepareStatement(sql);
            ResultSet rs = s.executeQuery(sql);
            while (rs.next())
            {
                String id = rs.getString(1);
                String N = rs.getString(2);
                String A = rs.getString(3);
                String G = rs.getString(4);
                String E = rs.getString(5);
                String P = rs.getString(6);
                String DOB = rs.getString(7);
                String PROOF = rs.getString(8);
                String ACC = rs.getString(9);
                String USER = rs.getString(10);
                String PASS = rs.getString(11);
                
                dm.addRow(new String[]{id,N,A,G,E,P,DOB,PROOF,ACC,USER,PASS});
                
            }
            return dm;
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }
    public Boolean passwordupdate(String id,String USER,String PASS,String PASSUP)
    {
         String sql ="UPDATE iregisternow SET Password='"+PASS+"' WHERE ID='"+id+"'";
        try
        {
            Connection conn = DriverManager.getConnection(conString,username,password);
            Statement s = conn.prepareStatement(sql);
            s.executeQuery(sql);
            return true;    
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return false;
        }
    }
    
    public Boolean update(String id,String N,String A,String G,String E,String P,String DOB,String PROOF,String ACC,String USER,String PASS)
    {
        String sql ="UPDATE iregisternow SET Name='"+N+"',Address='"+A+"',Gender='"+G+"',Email='"+E+"',Phone='"+P+"',DateofBirth='"+DOB+"',ProofType='"+PROOF+"',AccountNo='"+ACC+"',Username='"+USER+"',Password='"+PASS+"' WHERE ID='"+id+"'";
        try
        {
            Connection conn = DriverManager.getConnection(conString,username,password);
            
            Statement s =conn.prepareStatement(sql);
            s.executeUpdate(sql);
            return true;
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return false;
        }
    }
    //DELETION
    public Boolean delete(String id)
    {
        String sql = "DELETE FROM iregisternow WHERE ID = '"+id+"'";
        try
        {
            Connection conn=DriverManager.getConnection(conString,username,password);
            Statement s =conn.prepareStatement(sql);
            s.executeUpdate(sql);
            return true;
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return false;
        }
        
    }
    
}
