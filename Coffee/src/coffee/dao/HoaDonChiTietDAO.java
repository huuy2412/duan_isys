/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coffee.dao;

import coffee.entity.HoaDonChiTiet;
import coffee.entity.HoaDonChiTiet;
import coffee.utils.Jdbc;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author nguye
 */
public class HoaDonChiTietDAO extends CoffeeDAO<HoaDonChiTiet, String> {
   String INSERT_SQL = "INSERT INTO HoaDonChiTiet (MaHD,SoLuong,MaSP,MaBN) VALUES(?,?,?,?)";
   String UPDATE_SQL = "UPDATE HoaDonChiTiet SET SoLuong = ?, MaSP = ?, MaBN = ? WHERE MaHD = ?";
   String DELETE_SQL = "DELETE FROM HoaDonChiTiet WHERE MaHD = ?";
   String SELECT_ALL_SQL = "SELECT * FROM HoaDonChiTiet";
   String SELECT_BY_ID_SQL = "SELECT * FROM HoaDonChiTiet WHERE MaHD = ?";
    @Override
    public void insert(HoaDonChiTiet entity) {
        Jdbc.update(INSERT_SQL,entity.getMaHD()
                              ,entity.getSoLuong()
                              ,entity.getMaSP()
                              ,entity.getMaBN());
    }

    @Override
    public void update(HoaDonChiTiet entity) {
        Jdbc.update(UPDATE_SQL,entity.getSoLuong()
                              ,entity.getMaSP()
                              ,entity.getMaBN()
                              ,entity.getMaHD());
    }

    @Override
    public void delete(String id) {
        Jdbc.update(DELETE_SQL,id);
    }

    @Override
    public HoaDonChiTiet selectById(String id) {
        List<HoaDonChiTiet> list = this.selectBySql(SELECT_BY_ID_SQL,id);
        if(list.isEmpty()){
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<HoaDonChiTiet> selectAll() {
        return this.selectBySql(SELECT_ALL_SQL);
    }

    @Override
    protected List<HoaDonChiTiet> selectBySql(String sql, Object... args) {
        List<HoaDonChiTiet> list = new ArrayList<>();
        try{
            ResultSet rs = Jdbc.query(sql, args);
            while(rs.next()){
                HoaDonChiTiet entity = new HoaDonChiTiet();
                entity.setMaHD(rs.getString("MaHD"));
                entity.setSoLuong(rs.getInt("SoLuong"));
                entity.setMaSP(rs.getString("MaSP"));
                entity.setMaBN(rs.getString("MaBN"));
                list.add(entity);
            }
            rs.getStatement().getConnection().close();
            return list;
        }catch(Exception ex){
            throw new RuntimeException();
        }
    }
    
}
