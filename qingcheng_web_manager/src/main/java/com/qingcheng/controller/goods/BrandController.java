package com.qingcheng.controller.goods;

import com.alibaba.dubbo.config.annotation.Reference;
import com.qingcheng.entity.PageResult;
import com.qingcheng.entity.Result;
import com.qingcheng.pojo.goods.Brand;
import com.qingcheng.service.goods.BrandService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author houruihao
 * @date 2020-07-30 21:07
 * @description 品牌管理持久层接口
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

    /**
     * 进行品牌的分页查询
     * @return PageResult自定义对象
     */
    @RequestMapping("/findPage")
    public PageResult<Brand> findPage(int page,int pageSize){
        return brandService.findPage(page,pageSize);
    }

    /**
     * 根据条件查询品牌(条件不确定)
     * @param caseMap 条件 map(名字或/和首字母)
     * @return 品牌list
     */
    @PostMapping("/findByCases")
    public List<Brand> findByCases( @RequestBody Map<String,Object> caseMap){
        List<Brand> brands = brandService.findByCases(caseMap);
        return brands;
    }

    /**
     * 根据条件查询，且为分页查询
     * @param caseMap 条件 map(名字或/和首字母)
     * @param page 页数（第几页）
     * @param pageSize 每页数据条数
     * @return PageResult自定义对象
     */
    @PostMapping("/findPageByCases")
    public PageResult<Brand> findPageByCases( @RequestBody Map<String,Object> caseMap,int page,int pageSize){
        PageResult<Brand> brandPageResult = brandService.findPageByCases(caseMap, page, pageSize);
        return brandPageResult;
    }

    /**
     * 根据id查询品牌
     * @param id
     * @return 品牌brand
     */
    @GetMapping("/findById")
    public Brand findById(int id){
        return brandService.findById(id);
    }

    /**
     * 新增品牌
     * @param brand
     */
    @PostMapping("/addBrand")
    public Result addBrand(@RequestBody Brand brand){
        brandService.addBrand(brand);
        return new Result();
    }

    /**
     * 更新品牌
     * @param brand
     */
    @PostMapping("/updateBrand")
    public Result updateBrand( @RequestBody Brand brand){
        brandService.updateBrand(brand);
        return new Result();
    }

    /**
     * 删除品牌
     * @param id
     */
    @RequestMapping("/deleteBrandById")
    public Result deleteBrandById(int id){
        brandService.deleteBrandById(id);
        return new Result();
    }
}
