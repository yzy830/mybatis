package com.gerald.mybatis.dao.modify;

import java.util.List;

import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.jdbc.SQL;

import com.gerald.mybatis.pojo.Goods;

public interface GoodsMapper {
    @Options(keyProperty = "id", useGeneratedKeys = true)
    @InsertProvider(type = SqlProvider.class, method = "insertSql")
    void insert(Goods goods);
    
    void batchInsert(Goods... goods);
    
    class SqlProvider {
        public String insertSql() {
            return "insert into goods (goods_name, price) values (#{goodsName}, #{price})";
        }
        
        public String batchInsert(@Param("goodsList") Goods...goods) {
            return new SQL() {{
                INSERT_INTO("goods");
                INTO_COLUMNS("goods_name", "price");
                for(int i = 0; i < goods.length; ++i) {
                    INTO_VALUES(String.format("#{goodsList[%d].goodsName}", i), String.format("#{goodsList[%d].price}", i));
                }
            }}.toString();
        }
    }
}
