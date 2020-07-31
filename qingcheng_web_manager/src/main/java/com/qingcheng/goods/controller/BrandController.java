package com.qingcheng.goods.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.qingcheng.pojo.goods.Brand;
import com.qingcheng.service.goods.BrandService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author houruihao
 * @date 2020-07-30 21:07
 * @description
 */
@RestController
@RequestMapping("/brand")
public class BrandController {

    @Reference
    private BrandService brandService;

    /**
     * 查询所有品牌
     * @return 品牌列表
     */
    @RequestMapping("/findAll")
    public List<Brand> findAllGoods(){
        List<Brand> brands = brandService.findAll();
        return brands;
    }
}
