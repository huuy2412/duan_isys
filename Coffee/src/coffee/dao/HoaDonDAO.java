/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coffee.dao;
import coffee.entity.*;
import coffee.utils.Jdbc;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author nguye
 */
public class HoaDonDAO extends CoffeeDAO<HoaDon,String>{
   String INSERT_SQL = "INSERT INTO HoaDon (MaHD,MaNV) VALUES (?,?)";
   String UPDATE_SQL = "";
   String DELETE_SQL = "DELETE FROM HoaDon WHERE MaHD = ?";
   String SELECT_ALL_SQL = "SELECT * FROM HoaDon";
   String SELECT_BY_ID_SQL = "SELECT * FROM HoaDon WHERE MaHD = ?";
    @Override
    public void insert(HoaDon entity) {
        Jdbc.update(INSERT_SQL,entity.getMaHD(),entity.getMaNV());
    }

    @Override
    public void update(HoaDon entity) {
    }

    @Override
    public void delete(String id) {
        Jdbc.update(DELETE_SQL,id);
    }

    @Override
    public HoaDon selectById(String id) {
        List<HoaDon> list = this.selectBySql(SELECT_BY_ID_SQL,id);
        if(list.isEmpty()){
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<HoaDon> selectAll() {
        return this.selectBySql(SELECT_ALL_SQL);
    }

    @Override
    protected List<HoaDon> selectBySql(String sql, Object... args) {
        List<HoaDon> list = new ArrayList<HoaDon>();
        try{
            ResultSet rs = Jdbc.query(sql, args);
            while(rs.next()){
                HoaDon entity = new HoaDon();
                entity.setMaHD(rs.getString("MaHD"));
                entity.setNgayMua(rs.getDate("NgayMua"));
                entity.setMaNV(rs.getString("MaNV"));
                list.add(entity);
            }
            rs.getStatement().getConnection().close();
            return list;
        }catch(Exception ex){
            throw new RuntimeException(ex);
        }
        
    }
    public List<HoaDon> selectByKeyword(String keyword){
        String sql = "SELECT * FROM HoaDon WHERE MaHD LIKE ?";
        return this.selectBySql(sql,"%"+keyword+"%");
    }
    
}
