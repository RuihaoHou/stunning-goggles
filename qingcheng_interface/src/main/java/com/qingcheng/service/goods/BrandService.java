package com.qingcheng.service.goods;

import com.qingcheng.pojo.goods.Brand;

import java.util.List;

/**
 * @author houruihao
 * @date 2020-07-30 21:01
 * @description
 */
public interface BrandService {
    /**
     * 查询所有品牌
     * @return 品牌列表
     */
    public List<Brand> findAll();
}
