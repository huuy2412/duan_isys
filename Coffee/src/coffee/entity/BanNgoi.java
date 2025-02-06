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
public class BanNgoi {
    private String maBN;
    private String moTa;

    public BanNgoi() {
    }
@Override
public String toString(){
    return this.maBN;
    // lấy tên để hiển thị trong JComboBox
}
//@Override
//public boolean equals(Object obj){
//    BanNgoi other = (BanNgoi) obj;
//    // lấy mã để so sánh 2 chuyên đề
//    return other.getMaBN().equals(this.getMaBN());
//}
    public BanNgoi(String maBN, String moTa) {
        this.maBN = maBN;
        this.moTa = moTa;
    }

    public String getMaBN() {
        return maBN;
    }

    public void setMaBN(String maBN) {
        this.maBN = maBN;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }
    
}
