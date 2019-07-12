package com.ryan.service;

import com.ryan.entity.Category;

import java.util.List;

/**
 * Created by Administrator on 2019:07:11
 *
 * @Author : Lilanzhou
 * 功能 :
 */
public interface CategoryService {
    public int add(Category category);
    public Category getCategory(Integer prodId);
    public List<Category> getAllCategoryList();
    public int delete(Integer id);
    public int deleteByProdId(Integer pid);

}
