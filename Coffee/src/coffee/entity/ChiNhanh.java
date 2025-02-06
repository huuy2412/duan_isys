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
public class ChiNhanh {
    private String maCN;
    private String diaDiem;

    public ChiNhanh() {
    }

    public ChiNhanh(String maCN, String diaDiem) {
        this.maCN = maCN;
        this.diaDiem = diaDiem;
    }

    public String getMaCN() {
        return maCN;
    }

    public void setMaCN(String maCN) {
        this.maCN = maCN;
    }

    public String getDiaDiem() {
        return diaDiem;
    }

    public void setDiaDiem(String diaDiem) {
        this.diaDiem = diaDiem;
    }
    
}
