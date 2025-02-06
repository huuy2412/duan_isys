/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coffee.dao;
import  coffee.entity.NhanVien;
import  coffee.dao.*;
import coffee.utils.Jdbc;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author nguye
 */
public class NhanVienDAO extends CoffeeDAO<NhanVien,String> {
   String INSERT_SQL = "INSERT INTO NhanVien (MaNV,HoTen,GioiTinh,NgaySinh,DiaChi,Luong,VaiTro,MatKhau,ChiNhanh) VALUES (?,?,?,?,?,?,?,?,?)";
   String UPDATE_SQL = "UPDATE NhanVien SET HoTen = ?, GioiTinh = ?, NgaySinh = ?, DiaChi = ?, Luong = ?, VaiTro = ?, ChiNhanh = ? WHERE MaNV = ?";
   String DELETE_SQL = "DELETE FROM NhanVien WHERE MaNV = ?";
   String SELECT_ALL_SQL = "SELECT * FROM NhanVien";
   String SELECT_BY_ID_SQL = "SELECT * FROM NhanVien WHERE MaNV = ?";
    @Override
    public void insert(NhanVien entity) {
        Jdbc.update(INSERT_SQL,entity.getMaNV()
                              ,entity.getHoTen()
                              ,entity.getGioiTinh()
                              ,entity.getNgaySinh()
                              ,entity.getDiaChi()
                              ,entity.getLuong()
                              ,entity.getVaiTro()
                              ,entity.getMatKhau()
                              ,entity.getChiNhanh()
                              );
    }

    @Override
    public void update(NhanVien entity) {
        Jdbc.update(UPDATE_SQL
                              ,entity.getHoTen()
                              ,entity.getGioiTinh()
                              ,entity.getNgaySinh()
                              ,entity.getDiaChi()
                              ,entity.getLuong()
                              ,entity.getVaiTro()
                              ,entity.getMatKhau()
                              ,entity.getMaNV()
                              ,entity.getChiNhanh()
                              );
    }

    @Override
    public void delete(String id) {
        Jdbc.update(DELETE_SQL,id);
    }

    @Override
    public NhanVien selectById(String id) {
        List<NhanVien> list = this.selectBySql(SELECT_BY_ID_SQL,id);
        if(list.isEmpty()){
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<NhanVien> selectAll() {
        return this.selectBySql(SELECT_ALL_SQL);
    }

    @Override
    protected List<NhanVien> selectBySql(String sql, Object... args) {
        List<NhanVien> list = new ArrayList<NhanVien>();
        try{
            ResultSet rs = Jdbc.query(sql, args);
            while(rs.next()){
                NhanVien entity = new NhanVien();
                entity.setMaNV(rs.getString("MaNV"));
                entity.setHoTen(rs.getString("HoTen"));
                entity.setGioiTinh(rs.getBoolean("GioiTinh"));
                entity.setNgaySinh(rs.getDate("NgaySinh"));
                entity.setDiaChi(rs.getString("DiaChi"));
                entity.setLuong(rs.getDouble("Luong"));
                entity.setVaiTro(rs.getBoolean("VaiTro"));
                entity.setMatKhau(rs.getString("MatKhau"));
                entity.setChiNhanh(rs.getString("ChiNhanh"));
                list.add(entity);
            }
            rs.getStatement().getConnection().close();
            return list;
        }catch(Exception ex){
            throw new RuntimeException(ex);
        }
    }
    
}
