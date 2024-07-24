package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;

/**
 * 素材订单
 *
 * @author 
 * @email
 */
@TableName("sucai_order")
public class SucaiOrderEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public SucaiOrderEntity() {

	}

	public SucaiOrderEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
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
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "create_time",fill = FieldFill.INSERT)

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
	 * 设置：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }
    /**
	 * 获取：创建时间
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "SucaiOrder{" +
            "id=" + id +
            ", sucaiOrderUuidNumber=" + sucaiOrderUuidNumber +
            ", sucaiId=" + sucaiId +
            ", yonghuId=" + yonghuId +
            ", sucaiOrderTruePrice=" + sucaiOrderTruePrice +
            ", sucaiOrderTypes=" + sucaiOrderTypes +
            ", sucaiOrderPaymentTypes=" + sucaiOrderPaymentTypes +
            ", insertTime=" + insertTime +
            ", createTime=" + createTime +
        "}";
    }
}
