package com.gerald.mybatis.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import com.gerald.mybatis.pojo.Blog;

public interface BlogMapper {
    @Select("select * from blog where id = #{id}")
    Blog selectBlog(Long id);
    
    @Insert("insert into blog (authName, age) values (#{authName}, #{age})")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    void insert(Blog blog);
    
    @Select("select 1 from blog where id = #{id} for update")
    Long lock(Long id);
}
