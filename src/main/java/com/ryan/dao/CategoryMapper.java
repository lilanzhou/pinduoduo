package com.ryan.dao;

import com.ryan.entity.Category;

import java.util.List;

public interface CategoryMapper {
    int deleteByPrimaryKey(Integer id);
    int deleteByProdId(Integer id);
    int insert(Category record);

    int insertSelective(Category record);

    Category selectByProdId(Integer id);
    List<Category> getAllCategory();
    int updateByPrimaryKeySelective(Category record);

    int updateByPrimaryKey(Category record);
}