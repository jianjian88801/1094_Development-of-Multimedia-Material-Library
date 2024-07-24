
package com.controller;

import java.io.File;
import java.math.BigDecimal;
import java.net.URL;
import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;
import org.springframework.beans.BeanUtils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import com.service.TokenService;
import com.utils.*;
import java.lang.reflect.InvocationTargetException;

import com.service.DictionaryService;
import org.apache.commons.lang3.StringUtils;
import com.annotation.IgnoreAuth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.entity.*;
import com.entity.view.*;
import com.service.*;
import com.utils.PageUtils;
import com.utils.R;
import com.alibaba.fastjson.*;

/**
 * 素材
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/sucai")
public class SucaiController {
    private static final Logger logger = LoggerFactory.getLogger(SucaiController.class);

    @Autowired
    private SucaiService sucaiService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;

    //级联表service
    @Autowired
    private YonghuService yonghuService;



    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永不会进入");
        else if("用户".equals(role))
            params.put("yonghuId",request.getSession().getAttribute("userId"));
        params.put("sucaiDeleteStart",1);params.put("sucaiDeleteEnd",1);
        if(params.get("orderBy")==null || params.get("orderBy")==""){
            params.put("orderBy","id");
        }
        PageUtils page = sucaiService.queryPage(params);

        //字典表数据转换
        List<SucaiView> list =(List<SucaiView>)page.getList();
        for(SucaiView c:list){
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(c, request);
        }
        return R.ok().put("data", page);
    }

    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("info方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        SucaiEntity sucai = sucaiService.selectById(id);
        if(sucai !=null){
            //entity转view
            SucaiView view = new SucaiView();
            BeanUtils.copyProperties( sucai , view );//把实体数据重构到view中

                //级联表
                YonghuEntity yonghu = yonghuService.selectById(sucai.getYonghuId());
                if(yonghu != null){
                    BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createTime", "insertTime", "updateTime"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setYonghuId(yonghu.getId());
                }
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody SucaiEntity sucai, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,sucai:{}",this.getClass().getName(),sucai.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");
        else if("用户".equals(role))
            sucai.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

        Wrapper<SucaiEntity> queryWrapper = new EntityWrapper<SucaiEntity>()
            .eq("yonghu_id", sucai.getYonghuId())
            .eq("sucai_uuid_number", sucai.getSucaiUuidNumber())
            .eq("sucai_name", sucai.getSucaiName())
            .eq("sucai_types", sucai.getSucaiTypes())
            .eq("sucai_erji_types", sucai.getSucaiErjiTypes())
            .eq("sucai_video", sucai.getSucaiVideo())
            .eq("sucai_music", sucai.getSucaiMusic())
            .eq("sucai_clicknum", sucai.getSucaiClicknum())
            .eq("shangxia_types", sucai.getShangxiaTypes())
            .eq("sucai_delete", sucai.getSucaiDelete())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        SucaiEntity sucaiEntity = sucaiService.selectOne(queryWrapper);
        if(sucaiEntity==null){
            sucai.setSucaiClicknum(1);
            sucai.setShangxiaTypes(1);
            sucai.setSucaiDelete(1);
            sucai.setCreateTime(new Date());
            sucaiService.insert(sucai);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody SucaiEntity sucai, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,sucai:{}",this.getClass().getName(),sucai.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
//        else if("用户".equals(role))
//            sucai.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        //根据字段查询是否有相同数据
        Wrapper<SucaiEntity> queryWrapper = new EntityWrapper<SucaiEntity>()
            .notIn("id",sucai.getId())
            .andNew()
            .eq("yonghu_id", sucai.getYonghuId())
            .eq("sucai_uuid_number", sucai.getSucaiUuidNumber())
            .eq("sucai_name", sucai.getSucaiName())
            .eq("sucai_types", sucai.getSucaiTypes())
            .eq("sucai_erji_types", sucai.getSucaiErjiTypes())
            .eq("sucai_video", sucai.getSucaiVideo())
            .eq("sucai_music", sucai.getSucaiMusic())
            .eq("sucai_clicknum", sucai.getSucaiClicknum())
            .eq("shangxia_types", sucai.getShangxiaTypes())
            .eq("sucai_delete", sucai.getSucaiDelete())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        SucaiEntity sucaiEntity = sucaiService.selectOne(queryWrapper);
        if("".equals(sucai.getSucaiPhoto()) || "null".equals(sucai.getSucaiPhoto())){
                sucai.setSucaiPhoto(null);
        }
        if("".equals(sucai.getSucaiZhanshiPhoto()) || "null".equals(sucai.getSucaiZhanshiPhoto())){
                sucai.setSucaiZhanshiPhoto(null);
        }
        if("".equals(sucai.getSucaiVideo()) || "null".equals(sucai.getSucaiVideo())){
                sucai.setSucaiVideo(null);
        }
        if("".equals(sucai.getSucaiFile()) || "null".equals(sucai.getSucaiFile())){
                sucai.setSucaiFile(null);
        }
        if(sucaiEntity==null){
            sucaiService.updateById(sucai);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        ArrayList<SucaiEntity> list = new ArrayList<>();
        for(Integer id:ids){
            SucaiEntity sucaiEntity = new SucaiEntity();
            sucaiEntity.setId(id);
            sucaiEntity.setSucaiDelete(2);
            list.add(sucaiEntity);
        }
        if(list != null && list.size() >0){
            sucaiService.updateBatchById(list);
        }
        return R.ok();
    }


    /**
     * 批量上传
     */
    @RequestMapping("/batchInsert")
    public R save( String fileName, HttpServletRequest request){
        logger.debug("batchInsert方法:,,Controller:{},,fileName:{}",this.getClass().getName(),fileName);
        Integer yonghuId = Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId")));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            List<SucaiEntity> sucaiList = new ArrayList<>();//上传的东西
            Map<String, List<String>> seachFields= new HashMap<>();//要查询的字段
            Date date = new Date();
            int lastIndexOf = fileName.lastIndexOf(".");
            if(lastIndexOf == -1){
                return R.error(511,"该文件没有后缀");
            }else{
                String suffix = fileName.substring(lastIndexOf);
                if(!".xls".equals(suffix)){
                    return R.error(511,"只支持后缀为xls的excel文件");
                }else{
                    URL resource = this.getClass().getClassLoader().getResource("static/upload/" + fileName);//获取文件路径
                    File file = new File(resource.getFile());
                    if(!file.exists()){
                        return R.error(511,"找不到上传文件，请联系管理员");
                    }else{
                        List<List<String>> dataList = PoiUtil.poiImport(file.getPath());//读取xls文件
                        dataList.remove(0);//删除第一行，因为第一行是提示
                        for(List<String> data:dataList){
                            //循环
                            SucaiEntity sucaiEntity = new SucaiEntity();
//                            sucaiEntity.setYonghuId(Integer.valueOf(data.get(0)));   //用户 要改的
//                            sucaiEntity.setSucaiUuidNumber(data.get(0));                    //素材编号 要改的
//                            sucaiEntity.setSucaiName(data.get(0));                    //素材名称 要改的
//                            sucaiEntity.setSucaiTypes(Integer.valueOf(data.get(0)));   //素材类型 要改的
//                            sucaiEntity.setSucaiErjiTypes(Integer.valueOf(data.get(0)));   //二级类型 要改的
//                            sucaiEntity.setSucaiPhoto("");//详情和图片
//                            sucaiEntity.setSucaiZhanshiPhoto("");//详情和图片
//                            sucaiEntity.setSucaiVideo(data.get(0));                    //素材展示视频 要改的
//                            sucaiEntity.setSucaiMusic(data.get(0));                    //素材展示音频 要改的
//                            sucaiEntity.setSucaiOldMoney(data.get(0));                    //素材原价 要改的
//                            sucaiEntity.setSucaiNewMoney(data.get(0));                    //现价 要改的
//                            sucaiEntity.setSucaiFile(data.get(0));                    //素材文件 要改的
//                            sucaiEntity.setSucaiClicknum(Integer.valueOf(data.get(0)));   //点击次数 要改的
//                            sucaiEntity.setSucaiContent("");//详情和图片
//                            sucaiEntity.setShangxiaTypes(Integer.valueOf(data.get(0)));   //是否上架 要改的
//                            sucaiEntity.setSucaiDelete(1);//逻辑删除字段
//                            sucaiEntity.setCreateTime(date);//时间
                            sucaiList.add(sucaiEntity);


                            //把要查询是否重复的字段放入map中
                                //素材编号
                                if(seachFields.containsKey("sucaiUuidNumber")){
                                    List<String> sucaiUuidNumber = seachFields.get("sucaiUuidNumber");
                                    sucaiUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> sucaiUuidNumber = new ArrayList<>();
                                    sucaiUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("sucaiUuidNumber",sucaiUuidNumber);
                                }
                        }

                        //查询是否重复
                         //素材编号
                        List<SucaiEntity> sucaiEntities_sucaiUuidNumber = sucaiService.selectList(new EntityWrapper<SucaiEntity>().in("sucai_uuid_number", seachFields.get("sucaiUuidNumber")).eq("sucai_delete", 1));
                        if(sucaiEntities_sucaiUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(SucaiEntity s:sucaiEntities_sucaiUuidNumber){
                                repeatFields.add(s.getSucaiUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [素材编号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        sucaiService.insertBatch(sucaiList);
                        return R.ok();
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            return R.error(511,"批量插入数据异常，请联系管理员");
        }
    }





    /**
    * 前端列表
    */
    @IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("list方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));

        // 没有指定排序字段就默认id倒序
        if(StringUtil.isEmpty(String.valueOf(params.get("orderBy")))){
            params.put("orderBy","id");
        }
        PageUtils page = sucaiService.queryPage(params);

        //字典表数据转换
        List<SucaiView> list =(List<SucaiView>)page.getList();
        for(SucaiView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段
        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        SucaiEntity sucai = sucaiService.selectById(id);
            if(sucai !=null){

                //点击数量加1
                sucai.setSucaiClicknum(sucai.getSucaiClicknum()+1);
                sucaiService.updateById(sucai);

                //entity转view
                SucaiView view = new SucaiView();
                BeanUtils.copyProperties( sucai , view );//把实体数据重构到view中

                //级联表
                    YonghuEntity yonghu = yonghuService.selectById(sucai.getYonghuId());
                if(yonghu != null){
                    BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setYonghuId(yonghu.getId());
                }
                //修改对应字典表字段
                dictionaryService.dictionaryConvert(view, request);
                return R.ok().put("data", view);
            }else {
                return R.error(511,"查不到数据");
            }
    }


    /**
    * 前端保存
    */
    @RequestMapping("/add")
    public R add(@RequestBody SucaiEntity sucai, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,sucai:{}",this.getClass().getName(),sucai.toString());
        Wrapper<SucaiEntity> queryWrapper = new EntityWrapper<SucaiEntity>()
            .eq("yonghu_id", sucai.getYonghuId())
            .eq("sucai_uuid_number", sucai.getSucaiUuidNumber())
            .eq("sucai_name", sucai.getSucaiName())
            .eq("sucai_types", sucai.getSucaiTypes())
            .eq("sucai_erji_types", sucai.getSucaiErjiTypes())
            .eq("sucai_video", sucai.getSucaiVideo())
            .eq("sucai_music", sucai.getSucaiMusic())
            .eq("sucai_clicknum", sucai.getSucaiClicknum())
            .eq("shangxia_types", sucai.getShangxiaTypes())
            .eq("sucai_delete", sucai.getSucaiDelete())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        SucaiEntity sucaiEntity = sucaiService.selectOne(queryWrapper);
        if(sucaiEntity==null){
            sucai.setSucaiDelete(1);
            sucai.setCreateTime(new Date());
        sucaiService.insert(sucai);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }


}
