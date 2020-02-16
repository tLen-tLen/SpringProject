package org.example.DAO;

import org.example.models.Animal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Component
public class AnimalDAO {
    @Autowired
    JdbcTemplate template;

    public void setTemplate(JdbcTemplate template) {
        this.template = template;
    }
    public int insert(Animal a){
        String sql= "INSERT INTO Animal(name,age) values('" +a.getName() + "', '"+a.getAge()+"')";
        return template.update(sql);
    }
    public int update(Animal a){
        String sql="UPDATE Animal SET name='"+a.getName()+"', age='" +a.getAge()+ "' WHERE id="+a.getId() + "";
        return template.update(sql);
    }
    public int delete(int id){
        String sql="DELETE FROM Animal WHERE id=" + id + "";
        return template.update(sql);
    }
    public Animal getById(int id){
        String sql="SELECT * FROM Animal WHERE id=?";
        return template.queryForObject(sql, new Object[]{id},new BeanPropertyRowMapper<Animal>(Animal.class));
    }
    public List<Animal> getAnimals(){
        String sql= "SELECT Id, Name, Age FROM Animal";
        List<Animal> list = template.query(sql,new AnimalRowMapper());
        return list;
    }

    public class AnimalResultSetExtractor implements ResultSetExtractor {
        @Override
        public Object extractData(ResultSet rs) throws SQLException {
            Animal animal = new Animal();
            animal.setId(rs.getInt(1));
            animal.setName(rs.getString(2));
            animal.setAge(rs.getInt(3));
            return animal;
        }
    }

    public class AnimalRowMapper implements RowMapper {

        @Override
        public Object mapRow(ResultSet rs, int line) throws SQLException {
            AnimalResultSetExtractor extractor = new AnimalResultSetExtractor();
            return extractor.extractData(rs);
        }

    }
}
