package com.gerald.mybatis;

import java.io.IOException;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args ) throws IOException {
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis.xml"), "development");
        try(SqlSession session = sessionFactory.openSession()) {
            Blog blog = (Blog)session.selectOne("com.gerald.mybatis.BlogMapper.selectBlog", 1);
            
            System.out.println("id = " + blog.getId() + ", name = " + blog.getName() + ", context = " + blog.getContext());
        }   
    }
}
