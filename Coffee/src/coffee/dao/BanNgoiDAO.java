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
/**
 * String INSERT_SQL = "";
   String UPDATE_SQL = "";
   String DELETE_SQL = "";
   String SELECT_ALL_SQL = "";
   String SELECT_BY_ID_SQL = "";
 * 
 * */
public class BanNgoiDAO extends CoffeeDAO<BanNgoi, String>{
    String INSERT_SQL = "INSERT INTO BanNgoi (MaBN,MoTa) VALUES(?,?)";
    String UPDATE_SQL = "UPDATE BanNgoi SET MoTa = ? WHERE MaBN = ?";
    String DELETE_SQL = "DELETE FROM BanNgoi WHERE MaBN = ?";
    String SELECT_ALL_SQL = "SELECT * FROM BanNgoi";
    String SELECT_BY_ID_SQL = "SELECT * FROM BanNgoi WHERE MaBN = ?";
    @Override
    public void insert(BanNgoi entity) {
        Jdbc.update(INSERT_SQL,entity.getMaBN(),entity.getMoTa());
    }

    @Override
    public void update(BanNgoi entity) {
        Jdbc.update(UPDATE_SQL,entity.getMoTa(),entity.getMaBN());
    }
    

    @Override
    public void delete(String id) {
        Jdbc.update(DELETE_SQL,id);
    }

    @Override
    public BanNgoi selectById(String id) {
        List<BanNgoi> list = this.selectBySql(SELECT_BY_ID_SQL,id);
        if(list.isEmpty()){
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<BanNgoi> selectAll(){
        return this.selectBySql(SELECT_ALL_SQL);
    }

    @Override
    protected List<BanNgoi> selectBySql(String sql, Object... args) {
        List<BanNgoi> list = new ArrayList<BanNgoi>();
        try{
            ResultSet rs = Jdbc.query(sql, args);
            while(rs.next()){
                BanNgoi entity = new BanNgoi();
                entity.setMaBN(rs.getString("MaBN"));
                entity.setMoTa(rs.getString("MoTa"));
                list.add(entity);
            }
            rs.getStatement().getConnection().close();
            return list;
        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }
    
}
