package com.entity.model;

import com.entity.SucaiOrderEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 素材订单
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class SucaiOrderModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 订单号
     */
    private String sucaiOrderUuidNumber;


    /**
     * 素材
     */
    private Integer sucaiId;


    /**
     * 用户
     */
    private Integer yonghuId;


    /**
     * 实付价格
     */
    private Double sucaiOrderTruePrice;


    /**
     * 订单类型
     */
    private Integer sucaiOrderTypes;


    /**
     * 支付类型
     */
    private Integer sucaiOrderPaymentTypes;


    /**
     * 订单创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 创建时间 show3
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date createTime;


    /**
	 * 获取：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 设置：主键
	 */
    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 获取：订单号
	 */
    public String getSucaiOrderUuidNumber() {
        return sucaiOrderUuidNumber;
    }


    /**
	 * 设置：订单号
	 */
    public void setSucaiOrderUuidNumber(String sucaiOrderUuidNumber) {
        this.sucaiOrderUuidNumber = sucaiOrderUuidNumber;
    }
    /**
	 * 获取：素材
	 */
    public Integer getSucaiId() {
        return sucaiId;
    }


    /**
	 * 设置：素材
	 */
    public void setSucaiId(Integer sucaiId) {
        this.sucaiId = sucaiId;
    }
    /**
	 * 获取：用户
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }


    /**
	 * 设置：用户
	 */
    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 获取：实付价格
	 */
    public Double getSucaiOrderTruePrice() {
        return sucaiOrderTruePrice;
    }


    /**
	 * 设置：实付价格
	 */
    public void setSucaiOrderTruePrice(Double sucaiOrderTruePrice) {
        this.sucaiOrderTruePrice = sucaiOrderTruePrice;
    }
    /**
	 * 获取：订单类型
	 */
    public Integer getSucaiOrderTypes() {
        return sucaiOrderTypes;
    }


    /**
	 * 设置：订单类型
	 */
    public void setSucaiOrderTypes(Integer sucaiOrderTypes) {
        this.sucaiOrderTypes = sucaiOrderTypes;
    }
    /**
	 * 获取：支付类型
	 */
    public Integer getSucaiOrderPaymentTypes() {
        return sucaiOrderPaymentTypes;
    }


    /**
	 * 设置：支付类型
	 */
    public void setSucaiOrderPaymentTypes(Integer sucaiOrderPaymentTypes) {
        this.sucaiOrderPaymentTypes = sucaiOrderPaymentTypes;
    }
    /**
	 * 获取：订单创建时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 设置：订单创建时间
	 */
    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：创建时间 show3
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间 show3
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
