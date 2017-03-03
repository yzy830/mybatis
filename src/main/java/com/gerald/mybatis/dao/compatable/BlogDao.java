package com.gerald.mybatis.dao.compatable;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;

import com.gerald.mybatis.pojo.Blog;

@Repository
public class BlogDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    public Blog select(Long id) {
        String sql = "select * from blog where id = ?";
        
        return jdbcTemplate.queryForObject(sql, BeanPropertyRowMapper.newInstance(Blog.class), id);
    }
    
    public Long insert(Blog blog) {
        String sql = "insert into blog (authName, age) values (?,?)";
        
        GeneratedKeyHolder h = new GeneratedKeyHolder();
        
        jdbcTemplate.update(new PreparedStatementCreator () {

            @Override
            public PreparedStatement createPreparedStatement(Connection con)
                    throws SQLException {
                PreparedStatement s = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
                s.setString(1, blog.getAuthName());
                s.setByte(2, blog.getAge());
                
                return s;
            }
            
        }, h);
        
        return h.getKey().longValue();
    }
    
    public void lock(Long id) {
        String sql = "select 1 from blog where id = ? for update";
        
        jdbcTemplate.queryForObject(sql, Integer.class, id);
    }
}
