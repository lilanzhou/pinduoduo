package com.ryan.dao;

import com.ryan.entity.Product;

import java.util.List;

public interface ProductMapper {
    int deleteByPrimaryKey(Integer prodId);

    int insert(Product record);
     List<Product> getAllProduct();
    int insertSelective(Product record);

    Product selectByPrimaryKey(Integer prodId);

    int updateByPrimaryKeySelective(Product record);

    int updateByPrimaryKey(Product record);
}