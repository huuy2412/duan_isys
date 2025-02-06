/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coffee.entity;

import java.sql.Date;

/**
 *
 * @author nguye
 */
public class NhanVien {
    private String maNV;
    private String hoTen;
    private Boolean gioiTinh;
    private Date ngaySinh;
    private String diaChi;
    private double luong;
    private Boolean vaiTro;
    private String matKhau;
    private String chiNhanh;

    public NhanVien() {
    }

    public NhanVien(String maNV, String hoTen, Boolean gioiTinh, Date ngaySinh, String diaChi, double luong, Boolean vaiTro, String matKhau, String chiNhanh) {
        this.maNV = maNV;
        this.hoTen = hoTen;
        this.gioiTinh = gioiTinh;
        this.ngaySinh = ngaySinh;
        this.diaChi = diaChi;
        this.luong = luong;
        this.vaiTro = vaiTro;
        this.matKhau = matKhau;
        this.chiNhanh = chiNhanh;
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public Boolean getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(Boolean gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public double getLuong() {
        return luong;
    }

    public void setLuong(double luong) {
        this.luong = luong;
    }

    public Boolean getVaiTro() {
        return vaiTro;
    }

    public void setVaiTro(Boolean vaiTro) {
        this.vaiTro = vaiTro;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public String getChiNhanh() {
        return chiNhanh;
    }

    public void setChiNhanh(String chiNhanh) {
        this.chiNhanh = chiNhanh;
    }
    
}
