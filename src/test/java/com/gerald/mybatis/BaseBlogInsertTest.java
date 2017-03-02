package com.gerald.mybatis;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.gerald.mybatis.dao.BlogMapper;
import com.gerald.mybatis.pojo.Blog;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(App.class)
public class BaseBlogInsertTest {
    @Autowired
    private BlogMapper blogMapper;
    
    @Test
    @Transactional
    @Commit
    public void insert() {
        Blog blog = new Blog();
//        blog.set
    }
}
