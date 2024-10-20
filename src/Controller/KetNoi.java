/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author DELL
 */
public class KetNoi {
    protected Connection con = null;
    public KetNoi() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/qlvpp"; // Đường dẫn vào Data Base
            this.con = DriverManager.getConnection(url, "root", ""); // Kết nối
        }catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    public ResultSet ExecuteQData(String query) throws SQLException {
        Statement stmt = con.createStatement();
        return stmt.executeQuery(query);
    }

    public void ExecuteUpdate(String query) throws SQLException {
        Statement stmt = con.createStatement();
        stmt.executeUpdate(query);
    }

    public void close() {
        try {
            if (con != null) {
                con.close();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
