/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coffee.dao;
import coffee.entity.*;
import coffee.dao.*;
import coffee.utils.Jdbc;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author nguye
 */
public class ChiNhanhDAO extends CoffeeDAO<ChiNhanh,String>{
    String INSERT_SQL = "INSERT INTO ChiNhanh (MaCN,DiaDiem) VALUES(?,?)";
    String UPDATE_SQL = "UPDATE ChiNhanh SET DiaDiem = ? WHERE MaCN = ?";
    String DELETE_SQL = "DELETE FROM ChiNhanh WHERE MaCN = ?";
    String SELECT_ALL_SQL = "SELECT * FROM ChiNhanh";
    String SELECT_BY_ID_SQL = "SELECT * FROM ChiNhanh WHERE MaCN = ?";
    @Override
    public void insert(ChiNhanh entity) {
        Jdbc.update(INSERT_SQL,entity.getMaCN(),entity.getDiaDiem());
    }

    @Override
    public void update(ChiNhanh entity) {
        Jdbc.update(UPDATE_SQL,entity.getDiaDiem(),entity.getMaCN());
    }

    @Override
    public void delete(String id) {
        Jdbc.update(DELETE_SQL,id);
    }

    @Override
    public ChiNhanh selectById(String id) {
        List<ChiNhanh> list = this.selectBySql(SELECT_BY_ID_SQL,id);
        if(list.isEmpty()){
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<ChiNhanh> selectAll() {
        return this.selectBySql(SELECT_ALL_SQL);
    }

    @Override
    protected List<ChiNhanh> selectBySql(String sql, Object... args) {
        // dua ra list chi nhanh
        List<ChiNhanh> list = new ArrayList<ChiNhanh>();
        try{
            // tao rs container ban ghi
            ResultSet rs = Jdbc.query(sql, args);
            while(rs.next()){
                ChiNhanh entity = new ChiNhanh();
                entity.setMaCN(rs.getString("MaCN"));
                entity.setDiaDiem(rs.getString("DiaDiem"));
                list.add(entity);
            }
            rs.getStatement().getConnection().close();
            return list;
        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }
    
}
