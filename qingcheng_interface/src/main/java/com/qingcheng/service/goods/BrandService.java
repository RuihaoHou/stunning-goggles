package com.qingcheng.service.goods;

import com.qingcheng.entity.PageResult;
import com.qingcheng.pojo.goods.Brand;

import java.util.List;
import java.util.Map;

/**
 * @author houruihao
 * @date 2020-07-30 21:01
 * @description 品牌管理服务接口
 */
public interface BrandService {
    /**
     * 查询所有品牌
     * @return 品牌列表
     */
    public List<Brand> findAll();

    /**
     * 进行品牌的分页查询
     * @param page 页数（第几页）
     * @param pageSize 每页数据条数
     * @return PageResult自定义对象
     */
    public PageResult<Brand> findPage(int page,int pageSize);

    /**
     * 根据条件查询品牌
     * @param caseMap 条件 map(名字或/和首字母)
     * @return 品牌list
     */
    public List<Brand> findByCases(Map<String,Object> caseMap);

    /**
     * 根据条件查询，且为分页查询
     * @param caseMap 条件 map(名字或/和首字母)
     * @param page 页数（第几页）
     * @param pageSize 每页数据条数
     * @return PageResult自定义对象
     */
    public PageResult<Brand> findPageByCases(Map<String,Object> caseMap,int page,int pageSize);

    /**
     * 根据id查询品牌
     * @param id
     * @return 品牌brand
     */
    public Brand findById(int id);

    /**
     * 新增品牌
     * @param brand
     */
    public void addBrand(Brand brand);

    /**
     * 更新品牌
     * @param brand
     */
    public void updateBrand(Brand brand);

    /**
     * 删除品牌
     * @param id
     */
    public void deleteBrandById(int id);
}
