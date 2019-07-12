package com.ryan.service.Impl;

import com.ryan.dao.CategoryMapper;
import com.ryan.entity.Category;
import com.ryan.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2019:07:11
 *
 * @Author : Lilanzhou
 * 功能 :
 */
@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    CategoryMapper categoryMapper;
    @Override
    public int add(Category category) {
        return  categoryMapper.insert(category);
    }

    @Override
    public Category getCategory(Integer prodId) {
        return categoryMapper.selectByProdId(prodId);
    }

    @Override
    public List<Category> getAllCategoryList() {
        return categoryMapper.getAllCategory();
    }

    @Override
    public int delete(Integer id) {
        return categoryMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int deleteByProdId(Integer pid) {
        return categoryMapper.deleteByProdId(pid);
    }
}
