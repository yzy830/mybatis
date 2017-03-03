package com.gerald.mybatis.service.compatable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gerald.mybatis.dao.compatable.BlogDao;
import com.gerald.mybatis.dao.compatable.BlogMapper;
import com.gerald.mybatis.pojo.Blog;

@Service
public class BlogServiceImpl implements BlogService {
    @Autowired
    private BlogDao dao;
    
    @Autowired
    private BlogMapper mapper;
    
    /* 
     * 测试混合执行后提交
     */
    @Transactional
    public void mixCommit() {
        Blog b1 = new Blog();
        b1.setAge((byte)12);
        b1.setAuthName("mix commit-1");
        
        Blog b2 = new Blog();
        b2.setAge((byte)13);
        b2.setAuthName("mix commit-2");
        
        Long id1 = dao.insert(b1);
        mapper.insert(b2);
        
        System.out.println("id1 = " + id1 + ", id2 = " + b2.getId());
    }
    
    /* 
     * 测试混合执行后回滚
     */
    @Transactional
    public void mixRollback() {
        Blog b1 = new Blog();
        b1.setAge((byte)12);
        b1.setAuthName("mix commit-1");
        
        Blog b2 = new Blog();
        b2.setAge((byte)13);
        b2.setAuthName("mix commit-2");
        
        Long id1 = dao.insert(b1);
        mapper.insert(b2);
        
        System.out.println("id1 = " + id1 + ", id2 = " + b2.getId() + ", rollback...");
        
        throw new RuntimeException();
    }
    
    /* 
     * 测试混合插入后查询
     */
    @Transactional
    public void mixQuery() {
        Blog b1 = new Blog();
        b1.setAge((byte)12);
        b1.setAuthName("mix query-mapper insert");
        
        Blog b2 = new Blog();
        b2.setAge((byte)13);
        b2.setAuthName("mix query-dao insert");
        
        mapper.insert(b1);
        Blog daoQuery = dao.select(b1.getId());
        System.out.println("dao query, id = " + b1.getId() + ", auth = " + daoQuery.getAuthName());
        
        Long id = dao.insert(b2);
        Blog mapperQuery = mapper.selectBlog(id);
        System.out.println("mapper query, id = " + mapperQuery.getId() + ", auth = " + mapperQuery.getAuthName());
    }

    /* 
     * 测试混合加锁
     */
    @Override
    @Transactional
    public void mixLock1() {
        dao.lock(13L);
        System.out.println("dao lock 13");
        mapper.lock(13L);
        System.out.println("mapper lock 13");
    }

    /* 
     * 测试混合加锁
     */
    @Override
    @Transactional
    public void mixLock2() {
        mapper.lock(13L);
        System.out.println("mapper lock 13");
        dao.lock(13L);
        System.out.println("dao lock 13");
    }
}
