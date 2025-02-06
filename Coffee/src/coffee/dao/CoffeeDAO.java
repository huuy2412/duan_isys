/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coffee.dao;
import java.util.List;

/**
 *
 * @author nguye
 */
abstract public class CoffeeDAO<EntityType,KeyType> {
    abstract public void insert(EntityType entity);
    // dua toi mot entity toi day vao csdl cho anh
    abstract public void update(EntityType entity);
    abstract public void delete(KeyType id);
    abstract public EntityType selectById(KeyType id);
    abstract public List<EntityType> selectAll();
    abstract protected List<EntityType> selectBySql(String sql,Object ... args);
}
