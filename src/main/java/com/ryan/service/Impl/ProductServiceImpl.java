package com.ryan.service.Impl;

import com.ryan.dao.ProductMapper;
import com.ryan.entity.Product;
import com.ryan.service.ProductService;
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
public class ProductServiceImpl implements ProductService{
    @Autowired
    ProductMapper productMapper;
    @Override
    public int insert(Product product) {
        return productMapper.insert(product);
    }

    @Override
    public List<Product> showProduct() {
        return productMapper.getAllProduct();
    }

    @Override
    public int delete(Integer id) {
        return productMapper.deleteByPrimaryKey(id);
    }
}
