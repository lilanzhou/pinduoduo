package com.ryan.controller;

import com.ryan.entity.Category;
import com.ryan.entity.Product;
import com.ryan.service.CategoryService;
import com.ryan.service.ProductService;
import com.ryan.utils.QiniuyunUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.util.HtmlUtils;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by Administrator on 2019:07:10
 *
 * @Author : Lilanzhou
 * 功能 :
 */
@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    QiniuyunUtils qiniuyunUtils;

    @Autowired
    ProductService productService;

    @Autowired
    CategoryService categoryService;


  @RequestMapping("/add")
  public void add(HttpServletRequest request,@RequestParam(value = "file") MultipartFile file,
  @RequestParam(value = "picture") MultipartFile picture){
      if (file.isEmpty()) {
          System.out.println("商品未上传图片");
      }
      if (picture.isEmpty()) {
          System.out.println("分类图片未上传");
      }
      String goodsDetails= request.getParameter("content");//商品详情
      String goodsDetail = HtmlUtils.htmlEscape(goodsDetails);
      String category = request.getParameter("category");//分类
      String productName = request.getParameter("productName");//商品名称
      String price = request.getParameter("price");//价格
      String describe = request.getParameter("describe");//描述
      String stock = request.getParameter("totalSale");//发行总数

      String fileName = file.getOriginalFilename();  // 文件名
      String pictureOriginalFilename = picture.getOriginalFilename();
      String suffixName = fileName.substring(fileName.lastIndexOf("."));  // 后缀名
      String substring = pictureOriginalFilename.substring(pictureOriginalFilename.lastIndexOf("."));
      String filePath = "D://upload-images//"; // 上传后的路径
      fileName = UUID.randomUUID() + suffixName; // 新文件名
      pictureOriginalFilename=UUID.randomUUID()+substring;
      File dest0 = new File(filePath + pictureOriginalFilename);
      File dest = new File(filePath + fileName);

      if (!dest.getParentFile().exists()) {
          dest.getParentFile().mkdirs();
      }
      if (!dest0.getParentFile().exists()) {
          dest0.getParentFile().mkdirs();
      }
      try {
          file.transferTo(dest);
          picture.transferTo(dest0);
      } catch (IOException e) {
          e.printStackTrace();
      }
      String filePath1=filePath+fileName;
      String f=filePath+pictureOriginalFilename;
      qiniuyunUtils.upload(filePath1,fileName);//存到七牛云
      qiniuyunUtils.upload(f,pictureOriginalFilename);
      //从七牛云上读取图片
      String filename =qiniuyunUtils.getDomainName()+fileName;
      String categoryPic= qiniuyunUtils.getDomainName()+pictureOriginalFilename;
      Product product=new Product();
      product.setImages(filename);
      product.setName(productName);
      product.setInventory(200);
      product.setTotalSales(Integer.valueOf(stock));
      product.setPrice(Integer.valueOf(price));
      try {
          Date date = new Date();
          SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd :hh:mm:ss");
          String format = dateFormat.format(date);
          Date date1 = dateFormat.parse(format);
          product.setReleaseTime(date1);
      } catch (ParseException e) {
          e.printStackTrace();
      }

      productService.insert(product);

      Category categories=new Category();
      categories.setName(category);
      categories.setPicture(categoryPic);
      categories.setQuantiy(Integer.valueOf(stock));
      categories.setProdId(1);
      try {
          Date date = new Date();
          SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd :hh:mm:ss");
          String format = dateFormat.format(date);
          Date date1 = dateFormat.parse(format);
          categories.setCreateTime(date1);
      } catch (ParseException e) {
          e.printStackTrace();
      }
      categoryService.add(categories);

  }

    @RequestMapping("/add.html")
    public String addProduct(){
        return "product/add";
    }
    @RequestMapping("/list.html")
    public String ProductList(Model model){
        List<Product> productList = productService.showProduct();
        List<Map<String,Object>> mapList=new ArrayList<>();

        for (Product product:productList
             ) {
            Map<String,Object> map=new HashMap<>();
            map.put("product",product);
            Category category = categoryService.getCategory(product.getProdId());
            if(category!=null) {
                map.put("category",category.getName());
            }else {
                map.put("category","未分类");
            }
            mapList.add(map);
        }
        model.addAttribute("products",mapList);
        return "product/list";
    }
    @RequestMapping("/category.html")
    public String categoryProduct(Model model){
        List<Category> allCategoryList = categoryService.getAllCategoryList();
        model.addAttribute("category",allCategoryList);
        return "product/category";
    }

    @RequestMapping("/delete/{pid}")
    public String deleteProductById(Model model,@PathVariable(value = "pid") int pid){
        Category category = categoryService.getCategory(pid);
        if(category==null){
        productService.delete(pid);
        }else {
            categoryService.deleteByProdId(pid);
            productService.delete(pid);
        }
        return "product/list";
    }

    @RequestMapping("/category/delete/{cid}")
    public String deleteCategoryById(Model model,@PathVariable(value = "cid") int cid){
        int i = categoryService.delete(cid);
        if(i==1){
            System.out.println("删除成功");
        }
        return "product/category";
    }

}
