/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.MatHang;
import Model.NhanVien;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

/**
 *
 * @author DELL
 */
public class MatHangController extends KetNoi{
    public ArrayList<MatHang> docdsmathang() {
        ArrayList<MatHang> arrmh = new ArrayList<MatHang>();
        try {
            String sql = "SELECT * FROM mathang";
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                MatHang mh = new MatHang();
                mh.setMaMH(rs.getString(1));
                mh.setTenMH(rs.getString(2));
                mh.setDonViTinh(rs.getString(3));
                mh.setNhaSX(rs.getString(4));
                mh.setChatLieu(rs.getString(5));
                arrmh.add(mh);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return arrmh;
    }
    public int themMH(MatHang mh) {
    try {
        String sql = "INSERT INTO mathang(mamathang, tenmathang, donvitinh, nhasx, chatlieu, anh) VALUES (?, ?, ?, ?, ?, ?)";
        PreparedStatement preStatement = con.prepareStatement(sql);
        preStatement.setString(1, mh.getMaMH());
        preStatement.setString(2, mh.getTenMH());
        preStatement.setString(3, mh.getDonViTinh());
        preStatement.setString(4, mh.getNhaSX());
        preStatement.setString(5, mh.getChatLieu());
        preStatement.setString(6, mh.getAnh());  // Lưu đường dẫn ảnh vào cơ sở dữ liệu
        return preStatement.executeUpdate();
    } catch (Exception ex) {
        ex.printStackTrace();
    }
    return -1;
}
     public boolean demMH(String maMH) {
    try {
        String query = "SELECT COUNT(*) AS ck FROM mathang WHERE mamathang = ?";
        PreparedStatement preStatement = con.prepareStatement(query);
        preStatement.setString(1, maMH);
        ResultSet rs = preStatement.executeQuery();
        if (rs.next()) {
            return rs.getInt("ck") > 0;  // Trả về true nếu mã mặt hàng tồn tại
        }
    } catch (SQLException ex) {
        ex.printStackTrace();
    }
    return false; 
}
    public int capnhatMH(MatHang mh) {
        try {
            String sql = "update mathang set tenmathang=?,donvitinh=?, nhasx=?, chatlieu=?, anh=? where mamathang=?";
            PreparedStatement preStatement = con.prepareStatement(sql);
            preStatement.setString(6, mh.getMaMH());
            preStatement.setString(1, mh.getTenMH());
            preStatement.setString(2, mh.getDonViTinh());
            preStatement.setString(3, mh.getNhaSX());
            preStatement.setString(4, mh.getChatLieu());
            preStatement.setString(5, mh.getAnh());
            return preStatement.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return -1;
    }
    public boolean xoaMH(String mamh) {
        String sql = "DELETE FROM mathang WHERE mamathang = ?";
        try (PreparedStatement pstm = con.prepareStatement(sql)) {
            pstm.setString(1, mamh);
            return pstm.executeUpdate() > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }
    

}
