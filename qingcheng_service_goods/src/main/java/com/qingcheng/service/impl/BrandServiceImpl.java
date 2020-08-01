package com.qingcheng.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.qingcheng.dao.BrandMapper;
import com.qingcheng.entity.PageResult;
import com.qingcheng.pojo.goods.Brand;
import com.qingcheng.service.goods.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;


import java.util.List;
import java.util.Map;

/**
 * @author houruihao
 * @date 2020-07-30 21:04
 * @description 品牌管理服务接口实现类
 */
@Service
public class BrandServiceImpl implements BrandService {

    @Autowired
    private BrandMapper brandMapper;

    @Override
    public List<Brand> findAll() {
        return brandMapper.selectAll();
    }

    @Override
    public PageResult<Brand> findPage(int page, int pageSize) {
        PageHelper.startPage(page,pageSize);
        Page<Brand> pageResult = (Page<Brand>) brandMapper.selectAll();
        PageResult<Brand> brandPageResult = new PageResult<>(pageResult.getTotal(), pageResult.getResult());
        return brandPageResult;
    }

    @Override
    public List<Brand> findByCases(Map<String, Object> caseMap) {
        Example example = createExample(caseMap);
        List<Brand> brands = brandMapper.selectByExample(example);
        return brands;
    }

    @Override
    public PageResult<Brand> findPageByCases(Map<String, Object> caseMap, int page, int pageSize) {
        PageHelper.startPage(page, pageSize);
        Example example = createExample(caseMap);
        Page<Brand> pageResult = (Page<Brand>) brandMapper.selectByExample(example);
        PageResult<Brand> brandPageResult = new PageResult<>(pageResult.getTotal(), pageResult.getResult());
        return brandPageResult;
    }

    @Override
    public Brand findById(int id) {
        return brandMapper.selectByPrimaryKey(id);
    }

    @Override
    public void addBrand(Brand brand) {
        brandMapper.insert(brand);
    }

    @Override
    public void updateBrand(Brand brand) {
        brandMapper.updateByPrimaryKeySelective(brand);
    }

    @Override
    public void deleteBrandById(int id) {
        brandMapper.deleteByPrimaryKey(id);
    }

    /**
     * 封装example获取的过程
     * @param caseMap
     * @return example查询样板
     */
    private Example createExample(Map<String, Object> caseMap) {
        Example example = new Example(Brand.class);
        Example.Criteria criteria = example.createCriteria();
        if (caseMap != null){
            if (caseMap.get("name")!=null && !"".equals(caseMap.get("name"))){
                criteria.andLike("name", "%"+(String) caseMap.get("name")+"%");
            }
            if (caseMap.get("letter")!=null && !"".equals(caseMap.get("letter"))){
                criteria.andEqualTo("letter", (String) caseMap.get("letter"));
            }
        }
        return example;
    }
}
