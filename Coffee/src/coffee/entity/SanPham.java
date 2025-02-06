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
public class SanPham {
    private String maSP;
    private String tenSP;
    private String moTa;
    private Double donGia;
@Override
public String toString(){
    // lấy mã bàn ngồi hiển thị lên combobox
    return this.maSP + " (" + this.tenSP + ")";
}
    public SanPham() {
    }

    public SanPham(String maSP, String tenSP, String moTa, Double donGia) {
        this.maSP = maSP;
        this.tenSP = tenSP;
        this.moTa = moTa;
        this.donGia = donGia;
    }

    public String getMaSP() {
        return maSP;
    }

    public void setMaSP(String maSP) {
        this.maSP = maSP;
    }

    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public Double getDonGia() {
        return donGia;
    }

    public void setDonGia(Double donGia) {
        this.donGia = donGia;
    }
    
}
