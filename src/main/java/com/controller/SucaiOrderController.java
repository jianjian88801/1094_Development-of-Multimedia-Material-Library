
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
 * 素材订单
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/sucaiOrder")
public class SucaiOrderController {
    private static final Logger logger = LoggerFactory.getLogger(SucaiOrderController.class);

    @Autowired
    private SucaiOrderService sucaiOrderService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;

    //级联表service
    @Autowired
    private SucaiService sucaiService;
    @Autowired
    private YonghuService yonghuService;
@Autowired
private SucaiCommentbackService sucaiCommentbackService;



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
        if(params.get("orderBy")==null || params.get("orderBy")==""){
            params.put("orderBy","id");
        }
        PageUtils page = sucaiOrderService.queryPage(params);

        //字典表数据转换
        List<SucaiOrderView> list =(List<SucaiOrderView>)page.getList();
        for(SucaiOrderView c:list){
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
        SucaiOrderEntity sucaiOrder = sucaiOrderService.selectById(id);
        if(sucaiOrder !=null){
            //entity转view
            SucaiOrderView view = new SucaiOrderView();
            BeanUtils.copyProperties( sucaiOrder , view );//把实体数据重构到view中

                //级联表
                SucaiEntity sucai = sucaiService.selectById(sucaiOrder.getSucaiId());
                if(sucai != null){
                    BeanUtils.copyProperties( sucai , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "yonghuId"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setSucaiId(sucai.getId());
                    view.setSucaiYonghuId(sucai.getYonghuId());
                }
                //级联表
                YonghuEntity yonghu = yonghuService.selectById(sucaiOrder.getYonghuId());
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
    public R save(@RequestBody SucaiOrderEntity sucaiOrder, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,sucaiOrder:{}",this.getClass().getName(),sucaiOrder.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");
        else if("用户".equals(role))
            sucaiOrder.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

        sucaiOrder.setInsertTime(new Date());
        sucaiOrder.setCreateTime(new Date());
        sucaiOrderService.insert(sucaiOrder);
        return R.ok();
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody SucaiOrderEntity sucaiOrder, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,sucaiOrder:{}",this.getClass().getName(),sucaiOrder.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
//        else if("用户".equals(role))
//            sucaiOrder.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        //根据字段查询是否有相同数据
        Wrapper<SucaiOrderEntity> queryWrapper = new EntityWrapper<SucaiOrderEntity>()
            .eq("id",0)
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        SucaiOrderEntity sucaiOrderEntity = sucaiOrderService.selectOne(queryWrapper);
        if(sucaiOrderEntity==null){
            sucaiOrderService.updateById(sucaiOrder);//根据id更新
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
        sucaiOrderService.deleteBatchIds(Arrays.asList(ids));
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
            List<SucaiOrderEntity> sucaiOrderList = new ArrayList<>();//上传的东西
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
                            SucaiOrderEntity sucaiOrderEntity = new SucaiOrderEntity();
//                            sucaiOrderEntity.setSucaiOrderUuidNumber(data.get(0));                    //订单号 要改的
//                            sucaiOrderEntity.setSucaiId(Integer.valueOf(data.get(0)));   //素材 要改的
//                            sucaiOrderEntity.setYonghuId(Integer.valueOf(data.get(0)));   //用户 要改的
//                            sucaiOrderEntity.setSucaiOrderTruePrice(data.get(0));                    //实付价格 要改的
//                            sucaiOrderEntity.setSucaiOrderTypes(Integer.valueOf(data.get(0)));   //订单类型 要改的
//                            sucaiOrderEntity.setSucaiOrderPaymentTypes(Integer.valueOf(data.get(0)));   //支付类型 要改的
//                            sucaiOrderEntity.setInsertTime(date);//时间
//                            sucaiOrderEntity.setCreateTime(date);//时间
                            sucaiOrderList.add(sucaiOrderEntity);


                            //把要查询是否重复的字段放入map中
                                //订单号
                                if(seachFields.containsKey("sucaiOrderUuidNumber")){
                                    List<String> sucaiOrderUuidNumber = seachFields.get("sucaiOrderUuidNumber");
                                    sucaiOrderUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> sucaiOrderUuidNumber = new ArrayList<>();
                                    sucaiOrderUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("sucaiOrderUuidNumber",sucaiOrderUuidNumber);
                                }
                        }

                        //查询是否重复
                         //订单号
                        List<SucaiOrderEntity> sucaiOrderEntities_sucaiOrderUuidNumber = sucaiOrderService.selectList(new EntityWrapper<SucaiOrderEntity>().in("sucai_order_uuid_number", seachFields.get("sucaiOrderUuidNumber")));
                        if(sucaiOrderEntities_sucaiOrderUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(SucaiOrderEntity s:sucaiOrderEntities_sucaiOrderUuidNumber){
                                repeatFields.add(s.getSucaiOrderUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [订单号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        sucaiOrderService.insertBatch(sucaiOrderList);
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
        PageUtils page = sucaiOrderService.queryPage(params);

        //字典表数据转换
        List<SucaiOrderView> list =(List<SucaiOrderView>)page.getList();
        for(SucaiOrderView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段
        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        SucaiOrderEntity sucaiOrder = sucaiOrderService.selectById(id);
            if(sucaiOrder !=null){


                //entity转view
                SucaiOrderView view = new SucaiOrderView();
                BeanUtils.copyProperties( sucaiOrder , view );//把实体数据重构到view中

                //级联表
                    SucaiEntity sucai = sucaiService.selectById(sucaiOrder.getSucaiId());
                if(sucai != null){
                    BeanUtils.copyProperties( sucai , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setSucaiId(sucai.getId());
                }
                //级联表
                    YonghuEntity yonghu = yonghuService.selectById(sucaiOrder.getYonghuId());
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
    public R add(@RequestBody SucaiOrderEntity sucaiOrder, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,sucaiOrder:{}",this.getClass().getName(),sucaiOrder.toString());
            SucaiEntity sucaiEntity = sucaiService.selectById(sucaiOrder.getSucaiId());
            if(sucaiEntity == null){
                return R.error(511,"查不到该素材");
            }
            // Double sucaiNewMoney = sucaiEntity.getSucaiNewMoney();

            if(false){
            }
            else if(sucaiEntity.getSucaiNewMoney() == null){
                return R.error(511,"素材价格不能为空");
            }


            if(sucaiOrder.getYonghuId() ==sucaiEntity.getYonghuId()){
                return R.error("您不能购买自己的素材,有需要请去后台下载自己的素材");
            }

        SucaiOrderEntity sucaiOrderEntity = sucaiOrderService.selectOne(new EntityWrapper<SucaiOrderEntity>().eq("yonghu_id", sucaiOrder.getYonghuId()).eq("sucai_id", sucaiOrder.getSucaiId()));
                if(sucaiOrderEntity != null){
                    return R.error(511,"该素材已经购买过了,请进素材订单中查看");

                }

        YonghuEntity yongyourenEntity = yonghuService.selectById(sucaiEntity.getYonghuId());


            Integer userId = (Integer) request.getSession().getAttribute("userId");
            YonghuEntity yonghuEntity = yonghuService.selectById(userId);
            if(yonghuEntity == null)
                return R.error(511,"用户不能为空");
            if(yonghuEntity.getNewMoney() == null)
                return R.error(511,"用户金额不能为空");


        yongyourenEntity.setNewMoney(yongyourenEntity.getNewMoney()+sucaiEntity.getSucaiNewMoney());
            double balance = yonghuEntity.getNewMoney() - sucaiEntity.getSucaiNewMoney();//余额
            if(balance<0)
                return R.error(511,"余额不够支付");
            sucaiOrder.setSucaiOrderTypes(1); //设置订单状态为已支付
            sucaiOrder.setSucaiOrderTruePrice(sucaiEntity.getSucaiNewMoney()); //设置实付价格
            sucaiOrder.setYonghuId(userId); //设置订单支付人id
            sucaiOrder.setSucaiOrderUuidNumber(String.valueOf(new Date().getTime()));
            sucaiOrder.setSucaiOrderPaymentTypes(1);
            sucaiOrder.setInsertTime(new Date());
            sucaiOrder.setCreateTime(new Date());
            sucaiOrderService.insert(sucaiOrder);//新增订单
            yonghuEntity.setNewMoney(balance);//设置金额
            yonghuService.updateById(yonghuEntity);
            yonghuService.updateById(yongyourenEntity);




            return R.ok();
    }



    /**
     * 发货
     */
    @RequestMapping("/deliver")
    public R deliver(Integer id ){
        logger.debug("refund:,,Controller:{},,ids:{}",this.getClass().getName(),id.toString());
        SucaiOrderEntity  sucaiOrderEntity = new  SucaiOrderEntity();;
        sucaiOrderEntity.setId(id);
        sucaiOrderEntity.setSucaiOrderTypes(3);
        boolean b =  sucaiOrderService.updateById( sucaiOrderEntity);
        if(!b){
            return R.error("发货出错");
        }
        return R.ok();
    }









    /**
     * 收货
     */
    @RequestMapping("/receiving")
    public R receiving(Integer id){
        logger.debug("refund:,,Controller:{},,ids:{}",this.getClass().getName(),id.toString());
        SucaiOrderEntity  sucaiOrderEntity = new  SucaiOrderEntity();
        sucaiOrderEntity.setId(id);
        sucaiOrderEntity.setSucaiOrderTypes(4);
        boolean b =  sucaiOrderService.updateById( sucaiOrderEntity);
        if(!b){
            return R.error("收货出错");
        }
        return R.ok();
    }



    /**
    * 评价
    */
    @RequestMapping("/commentback")
    public R commentback(Integer id, String commentbackText, Integer sucaiCommentbackPingfenNumber, HttpServletRequest request){
        logger.debug("commentback方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
            SucaiOrderEntity sucaiOrder = sucaiOrderService.selectById(id);
        if(sucaiOrder == null)
            return R.error(511,"查不到该订单");
        if(sucaiOrder.getSucaiOrderTypes() != 1)
            return R.error(511,"您不能评价");
        Integer sucaiId = sucaiOrder.getSucaiId();
        if(sucaiId == null)
            return R.error(511,"查不到该素材");

        SucaiCommentbackEntity sucaiCommentbackEntity = new SucaiCommentbackEntity();
            sucaiCommentbackEntity.setId(id);
            sucaiCommentbackEntity.setSucaiId(sucaiId);
            sucaiCommentbackEntity.setYonghuId((Integer) request.getSession().getAttribute("userId"));
            sucaiCommentbackEntity.setSucaiCommentbackText(commentbackText);
            sucaiCommentbackEntity.setInsertTime(new Date());
            sucaiCommentbackEntity.setReplyText(null);
            sucaiCommentbackEntity.setUpdateTime(null);
            sucaiCommentbackEntity.setCreateTime(new Date());
            sucaiCommentbackService.insert(sucaiCommentbackEntity);

            sucaiOrder.setSucaiOrderTypes(5);//设置订单状态为已评价
            sucaiOrderService.updateById(sucaiOrder);//根据id更新
            return R.ok();
    }












}
