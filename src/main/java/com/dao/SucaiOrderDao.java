package com.dao;

import com.entity.SucaiOrderEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.SucaiOrderView;

/**
 * 素材订单 Dao 接口
 *
 * @author 
 */
public interface SucaiOrderDao extends BaseMapper<SucaiOrderEntity> {

   List<SucaiOrderView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
