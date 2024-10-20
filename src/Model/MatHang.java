/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author DELL
 */
public class MatHang {
    private String maMH;
    private String tenMH;
    private String donViTinh;
    private String nhaSX;
    private String chatLieu;
    private String anh;

     public MatHang()
    {
        
    }
    public MatHang(String maMH, String tenMH, String donViTinh, String nhaSX, String chatLieu, String anh) {
        this.maMH = maMH;
        this.tenMH = tenMH;
        this.donViTinh = donViTinh;
        this.nhaSX = nhaSX;
        this.chatLieu = chatLieu;
        this.anh = anh;
    }

    public String getMaMH() {
        return maMH;
    }

    public void setMaMH(String maMH) {
        this.maMH = maMH;
    }

    public String getTenMH() {
        return tenMH;
    }

    public void setTenMH(String tenMH) {
        this.tenMH = tenMH;
    }

    public String getDonViTinh() {
        return donViTinh;
    }

    public void setDonViTinh(String donViTinh) {
        this.donViTinh = donViTinh;
    }

    public String getNhaSX() {
        return nhaSX;
    }

    public void setNhaSX(String nhaSX) {
        this.nhaSX = nhaSX;
    }

    public String getChatLieu() {
        return chatLieu;
    }

    public void setChatLieu(String chatLieu) {
        this.chatLieu = chatLieu;
    }

    public String getAnh() {
        return anh;
    }

    public void setAnh(String anh) {
        this.anh = anh;
    }
    
}
