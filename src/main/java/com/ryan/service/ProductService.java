package com.ryan.service;

import com.ryan.entity.Product;

import java.util.List;

/**
 * Created by Administrator on 2019:07:11
 *
 * @Author : Lilanzhou
 * 功能 :
 */

public interface ProductService {
    public int insert(Product product);
    public List<Product> showProduct();
    public int delete(Integer id);
}
