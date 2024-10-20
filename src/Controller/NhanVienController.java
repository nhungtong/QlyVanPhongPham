/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.NhanVien;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author DELL
 */
public class NhanVienController extends KetNoi {

    public NhanVien dangnhap(String tenDangNhap, String matKhau) {
        NhanVien nv = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            String sql = "SELECT * FROM nhavien WHERE manv=? AND pass=?";
            ps = this.con.prepareStatement(sql);
            ps.setString(1, tenDangNhap);
            ps.setString(2, matKhau);
            rs = ps.executeQuery();
            if (rs.next()) {
                nv = new NhanVien();
                nv.setMaNV(rs.getString("manv"));
                nv.setTenNV(rs.getString("tennv"));
                nv.setDienthoai(rs.getInt("dienthoai"));
                nv.setPass(rs.getString("pass"));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return nv;
    }

    public ArrayList<NhanVien> docdsnhanvien() {
        ArrayList<NhanVien> arrnv = new ArrayList<NhanVien>();
        try {
            String sql = "SELECT * FROM nhavien";
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                NhanVien nv = new NhanVien();
                nv.setMaNV(rs.getString(1));
                nv.setTenNV(rs.getString(2));
                nv.setDienthoai(rs.getInt(3));
                nv.setPass(rs.getString(4));
                arrnv.add(nv);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return arrnv;
    }

    public int themNV(NhanVien nv) {
        try {
            String sql = "insert into nhavien values(?,?,?,?)";
            PreparedStatement preStatement = con.prepareStatement(sql);
            preStatement.setString(1, nv.getMaNV());
            preStatement.setString(2, nv.getTenNV());
            preStatement.setInt(3, nv.getDienthoai());
            preStatement.setString(4, nv.getPass());
            return preStatement.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return -1;
    }

    public int capnhatNV(NhanVien nv) {
        try {
            String sql = "update nhavien set tennv=?,dienthoai=?, pass=? where manv=?";
            PreparedStatement preStatement = con.prepareStatement(sql);
            preStatement.setString(1, nv.getTenNV());
            preStatement.setInt(2, nv.getDienthoai());
            preStatement.setString(3, nv.getPass());
            preStatement.setString(4, nv.getMaNV());
            return preStatement.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();

        }
        return -1;
    }

    public boolean xoaNV(String manv) {
        String sql = "DELETE FROM nhavien WHERE manv = ?";
        try (PreparedStatement pstm = con.prepareStatement(sql)) {
            pstm.setString(1, manv);
            return pstm.executeUpdate() > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    public ArrayList<NhanVien> timtheomanv(String manv) {
        ArrayList<NhanVien> dsnv = new ArrayList<NhanVien>();
        try {
            String sql = "SELECT * FROM nhavien WHERE manv = ?";
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setString(1, manv);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                NhanVien nv = new NhanVien();
                nv.setMaNV(rs.getString(1));
                nv.setTenNV(rs.getString(2));
                nv.setDienthoai(rs.getInt(3));
                nv.setPass(rs.getString(4));
                dsnv.add(nv);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return dsnv;
    }

    public ArrayList<NhanVien> timtheotennv(String tennv) {
        ArrayList<NhanVien> dsnv = new ArrayList<NhanVien>();
        try {
            String sql = "SELECT * FROM nhavien WHERE tennv = ?";
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setString(1, tennv);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                NhanVien nv = new NhanVien();
                nv.setMaNV(rs.getString(1));
                nv.setTenNV(rs.getString(2));
                nv.setDienthoai(rs.getInt(3));
                nv.setPass(rs.getString(4));
                dsnv.add(nv);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return dsnv;
    }
}
