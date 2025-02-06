/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coffee.entity;

import java.util.Date;

/**
 *
 * @author nguye
 */
public class HoaDon {
    private String maHD;
    private Date ngayMua;
    private String maNV;

    public HoaDon() {
    }

    public HoaDon(String maHD, Date ngayMua, String maNV) {
        this.maHD = maHD;
        this.ngayMua = ngayMua;
        this.maNV = maNV;
    }

    public String getMaHD() {
        return maHD;
    }

    public void setMaHD(String maHD) {
        this.maHD = maHD;
    }

    public Date getNgayMua() {
        return ngayMua;
    }

    public void setNgayMua(Date ngayMua) {
        this.ngayMua = ngayMua;
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }
    
}
