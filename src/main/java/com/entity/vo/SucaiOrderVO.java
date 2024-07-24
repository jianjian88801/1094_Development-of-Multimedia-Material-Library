package com.entity.vo;

import com.entity.SucaiOrderEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 素材订单
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("sucai_order")
public class SucaiOrderVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 订单号
     */

    @TableField(value = "sucai_order_uuid_number")
    private String sucaiOrderUuidNumber;


    /**
     * 素材
     */

    @TableField(value = "sucai_id")
    private Integer sucaiId;


    /**
     * 用户
     */

    @TableField(value = "yonghu_id")
    private Integer yonghuId;


    /**
     * 实付价格
     */

    @TableField(value = "sucai_order_true_price")
    private Double sucaiOrderTruePrice;


    /**
     * 订单类型
     */

    @TableField(value = "sucai_order_types")
    private Integer sucaiOrderTypes;


    /**
     * 支付类型
     */

    @TableField(value = "sucai_order_payment_types")
    private Integer sucaiOrderPaymentTypes;


    /**
     * 订单创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 创建时间 show3
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "create_time")
    private Date createTime;


    /**
	 * 设置：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 获取：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 设置：订单号
	 */
    public String getSucaiOrderUuidNumber() {
        return sucaiOrderUuidNumber;
    }


    /**
	 * 获取：订单号
	 */

    public void setSucaiOrderUuidNumber(String sucaiOrderUuidNumber) {
        this.sucaiOrderUuidNumber = sucaiOrderUuidNumber;
    }
    /**
	 * 设置：素材
	 */
    public Integer getSucaiId() {
        return sucaiId;
    }


    /**
	 * 获取：素材
	 */

    public void setSucaiId(Integer sucaiId) {
        this.sucaiId = sucaiId;
    }
    /**
	 * 设置：用户
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }


    /**
	 * 获取：用户
	 */

    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 设置：实付价格
	 */
    public Double getSucaiOrderTruePrice() {
        return sucaiOrderTruePrice;
    }


    /**
	 * 获取：实付价格
	 */

    public void setSucaiOrderTruePrice(Double sucaiOrderTruePrice) {
        this.sucaiOrderTruePrice = sucaiOrderTruePrice;
    }
    /**
	 * 设置：订单类型
	 */
    public Integer getSucaiOrderTypes() {
        return sucaiOrderTypes;
    }


    /**
	 * 获取：订单类型
	 */

    public void setSucaiOrderTypes(Integer sucaiOrderTypes) {
        this.sucaiOrderTypes = sucaiOrderTypes;
    }
    /**
	 * 设置：支付类型
	 */
    public Integer getSucaiOrderPaymentTypes() {
        return sucaiOrderPaymentTypes;
    }


    /**
	 * 获取：支付类型
	 */

    public void setSucaiOrderPaymentTypes(Integer sucaiOrderPaymentTypes) {
        this.sucaiOrderPaymentTypes = sucaiOrderPaymentTypes;
    }
    /**
	 * 设置：订单创建时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：订单创建时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：创建时间 show3
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间 show3
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
