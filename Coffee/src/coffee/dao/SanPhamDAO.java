/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coffee.dao;
import  coffee.entity.*;
import coffee.utils.Jdbc;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author nguye
 */
public class SanPhamDAO extends CoffeeDAO<SanPham,String>{
   String INSERT_SQL = "INSERT INTO SanPham (MaSP,TenSP,MoTa,DonGia) VALUES (?,?,?,?)";
   String UPDATE_SQL = "UPDATE SanPham SET TenSP = ?, MoTa = ?, DonGia = ? WHERE MaSP = ?";
   String DELETE_SQL = "DELETE FROM SanPham WHERE MaSP = ?";
   String SELECT_ALL_SQL = "SELECT * FROM SanPham";
   String SELECT_BY_ID_SQL = "SELECT * FROM SanPham WHERE MaSP = ?";
    @Override
    public void insert(SanPham entity) {
        Jdbc.update(INSERT_SQL,entity.getMaSP(),entity.getTenSP(),entity.getMoTa(),entity.getDonGia());
    }

    @Override
    public void update(SanPham entity) {
        Jdbc.update(UPDATE_SQL,entity.getTenSP(),entity.getMoTa(),entity.getDonGia(),entity.getMaSP());
    }

    @Override
    public void delete(String id) {
        Jdbc.update(DELETE_SQL,id);
    }

    @Override
    public SanPham selectById(String id) {
        List<SanPham> list = this.selectBySql(SELECT_BY_ID_SQL,id);
        if(list.isEmpty()){
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<SanPham> selectAll() {
        return this.selectBySql(SELECT_ALL_SQL);
    }

    @Override
    protected List<SanPham> selectBySql(String sql, Object... args) {
        List<SanPham> list = new ArrayList<SanPham>();
        try{
            ResultSet rs = Jdbc.query(sql, args);
            while(rs.next()){
                SanPham entity = new SanPham();
                entity.setMaSP(rs.getString("MaSP"));
                entity.setTenSP(rs.getString("TenSP"));
                entity.setMoTa(rs.getString("MoTa"));
                entity.setDonGia(rs.getDouble("DonGia"));
                list.add(entity);
            }
            rs.getStatement().getConnection().close();
            return list;
        }catch(Exception ex){
            throw new RuntimeException(ex);
        }
    }
    public List<SanPham> selectByKeyWord(String keyword){
        String sql = "SELECT * FROM SanPham WHERE TenSP LIKE ?";
        return this.selectBySql(sql,"%"+keyword+"%");
    }
}
