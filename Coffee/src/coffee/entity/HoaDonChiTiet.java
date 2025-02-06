/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coffee.entity;

/**
 *
 * @author nguye
 */
public class HoaDonChiTiet {
    private String maHD;
    private int soLuong;
    private String maSP;
    private String maBN;

    public HoaDonChiTiet() {
    }

    public HoaDonChiTiet(String maHD, int soLuong, String maSP, String maBN) {
        this.maHD = maHD;
        this.soLuong = soLuong;
        this.maSP = maSP;
        this.maBN = maBN;
    }

    public String getMaHD() {
        return maHD;
    }

    public void setMaHD(String maHD) {
        this.maHD = maHD;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public String getMaSP() {
        return maSP;
    }

    public void setMaSP(String maSP) {
        this.maSP = maSP;
    }

    public String getMaBN() {
        return maBN;
    }

    public void setMaBN(String maBN) {
        this.maBN = maBN;
    }
    
}
