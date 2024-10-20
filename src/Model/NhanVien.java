/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author DELL
 */
public class NhanVien {
    private String maNV;
    private String tenNV;
    private int dienthoai;
    private String pass;
    public NhanVien()
    {
        
    }

    public NhanVien(String maNV, String tenNV, int dienthoai, String pass) {
        this.maNV = maNV;
        this.tenNV = tenNV;
        this.dienthoai = dienthoai;
        this.pass = pass;
    } 

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public String getTenNV() {
        return tenNV;
    }

    public void setTenNV(String tenNV) {
        this.tenNV = tenNV;
    }

    public int getDienthoai() {
        return dienthoai;
    }

    public void setDienthoai(int dienthoai) {
        this.dienthoai = dienthoai;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
    
}
