package com.entity.view;

import com.entity.SucaiCommentbackEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;

/**
 * 素材评价
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("sucai_commentback")
public class SucaiCommentbackView extends SucaiCommentbackEntity implements Serializable {
    private static final long serialVersionUID = 1L;




		//级联表 sucai
			/**
			* 素材 的 用户
			*/
			private Integer sucaiYonghuId;
			/**
			* 素材编号
			*/
			private String sucaiUuidNumber;
			/**
			* 素材名称
			*/
			private String sucaiName;
			/**
			* 素材类型
			*/
			private Integer sucaiTypes;
				/**
				* 素材类型的值
				*/
				private String sucaiValue;
			/**
			* 二级类型
			*/
			private Integer sucaiErjiTypes;
				/**
				* 二级类型的值
				*/
				private String sucaiErjiValue;
			/**
			* 素材照片
			*/
			private String sucaiPhoto;
			/**
			* 素材展示照片
			*/
			private String sucaiZhanshiPhoto;
			/**
			* 素材展示视频
			*/
			private String sucaiVideo;
			/**
			* 素材展示音频
			*/
			private String sucaiMusic;
			/**
			* 素材原价
			*/
			private Double sucaiOldMoney;
			/**
			* 现价
			*/
			private Double sucaiNewMoney;
			/**
			* 素材文件
			*/
			private String sucaiFile;
			/**
			* 点击次数
			*/
			private Integer sucaiClicknum;
			/**
			* 素材详细介绍
			*/
			private String sucaiContent;
			/**
			* 是否上架
			*/
			private Integer shangxiaTypes;
				/**
				* 是否上架的值
				*/
				private String shangxiaValue;
			/**
			* 逻辑删除
			*/
			private Integer sucaiDelete;

		//级联表 yonghu
			/**
			* 用户姓名
			*/
			private String yonghuName;
			/**
			* 用户手机号
			*/
			private String yonghuPhone;
			/**
			* 用户身份证号
			*/
			private String yonghuIdNumber;
			/**
			* 用户头像
			*/
			private String yonghuPhoto;
			/**
			* 余额
			*/
			private Double newMoney;
			/**
			* 电子邮箱
			*/
			private String yonghuEmail;

	public SucaiCommentbackView() {

	}

	public SucaiCommentbackView(SucaiCommentbackEntity sucaiCommentbackEntity) {
		try {
			BeanUtils.copyProperties(this, sucaiCommentbackEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



















				//级联表的get和set sucai

					/**
					* 获取：素材 的 用户
					*/
					public Integer getSucaiYonghuId() {
						return sucaiYonghuId;
					}
					/**
					* 设置：素材 的 用户
					*/
					public void setSucaiYonghuId(Integer sucaiYonghuId) {
						this.sucaiYonghuId = sucaiYonghuId;
					}


					/**
					* 获取： 素材编号
					*/
					public String getSucaiUuidNumber() {
						return sucaiUuidNumber;
					}
					/**
					* 设置： 素材编号
					*/
					public void setSucaiUuidNumber(String sucaiUuidNumber) {
						this.sucaiUuidNumber = sucaiUuidNumber;
					}

					/**
					* 获取： 素材名称
					*/
					public String getSucaiName() {
						return sucaiName;
					}
					/**
					* 设置： 素材名称
					*/
					public void setSucaiName(String sucaiName) {
						this.sucaiName = sucaiName;
					}

					/**
					* 获取： 素材类型
					*/
					public Integer getSucaiTypes() {
						return sucaiTypes;
					}
					/**
					* 设置： 素材类型
					*/
					public void setSucaiTypes(Integer sucaiTypes) {
						this.sucaiTypes = sucaiTypes;
					}


						/**
						* 获取： 素材类型的值
						*/
						public String getSucaiValue() {
							return sucaiValue;
						}
						/**
						* 设置： 素材类型的值
						*/
						public void setSucaiValue(String sucaiValue) {
							this.sucaiValue = sucaiValue;
						}

					/**
					* 获取： 二级类型
					*/
					public Integer getSucaiErjiTypes() {
						return sucaiErjiTypes;
					}
					/**
					* 设置： 二级类型
					*/
					public void setSucaiErjiTypes(Integer sucaiErjiTypes) {
						this.sucaiErjiTypes = sucaiErjiTypes;
					}


						/**
						* 获取： 二级类型的值
						*/
						public String getSucaiErjiValue() {
							return sucaiErjiValue;
						}
						/**
						* 设置： 二级类型的值
						*/
						public void setSucaiErjiValue(String sucaiErjiValue) {
							this.sucaiErjiValue = sucaiErjiValue;
						}

					/**
					* 获取： 素材照片
					*/
					public String getSucaiPhoto() {
						return sucaiPhoto;
					}
					/**
					* 设置： 素材照片
					*/
					public void setSucaiPhoto(String sucaiPhoto) {
						this.sucaiPhoto = sucaiPhoto;
					}

					/**
					* 获取： 素材展示照片
					*/
					public String getSucaiZhanshiPhoto() {
						return sucaiZhanshiPhoto;
					}
					/**
					* 设置： 素材展示照片
					*/
					public void setSucaiZhanshiPhoto(String sucaiZhanshiPhoto) {
						this.sucaiZhanshiPhoto = sucaiZhanshiPhoto;
					}

					/**
					* 获取： 素材展示视频
					*/
					public String getSucaiVideo() {
						return sucaiVideo;
					}
					/**
					* 设置： 素材展示视频
					*/
					public void setSucaiVideo(String sucaiVideo) {
						this.sucaiVideo = sucaiVideo;
					}

					/**
					* 获取： 素材展示音频
					*/
					public String getSucaiMusic() {
						return sucaiMusic;
					}
					/**
					* 设置： 素材展示音频
					*/
					public void setSucaiMusic(String sucaiMusic) {
						this.sucaiMusic = sucaiMusic;
					}

					/**
					* 获取： 素材原价
					*/
					public Double getSucaiOldMoney() {
						return sucaiOldMoney;
					}
					/**
					* 设置： 素材原价
					*/
					public void setSucaiOldMoney(Double sucaiOldMoney) {
						this.sucaiOldMoney = sucaiOldMoney;
					}

					/**
					* 获取： 现价
					*/
					public Double getSucaiNewMoney() {
						return sucaiNewMoney;
					}
					/**
					* 设置： 现价
					*/
					public void setSucaiNewMoney(Double sucaiNewMoney) {
						this.sucaiNewMoney = sucaiNewMoney;
					}

					/**
					* 获取： 素材文件
					*/
					public String getSucaiFile() {
						return sucaiFile;
					}
					/**
					* 设置： 素材文件
					*/
					public void setSucaiFile(String sucaiFile) {
						this.sucaiFile = sucaiFile;
					}

					/**
					* 获取： 点击次数
					*/
					public Integer getSucaiClicknum() {
						return sucaiClicknum;
					}
					/**
					* 设置： 点击次数
					*/
					public void setSucaiClicknum(Integer sucaiClicknum) {
						this.sucaiClicknum = sucaiClicknum;
					}

					/**
					* 获取： 素材详细介绍
					*/
					public String getSucaiContent() {
						return sucaiContent;
					}
					/**
					* 设置： 素材详细介绍
					*/
					public void setSucaiContent(String sucaiContent) {
						this.sucaiContent = sucaiContent;
					}

					/**
					* 获取： 是否上架
					*/
					public Integer getShangxiaTypes() {
						return shangxiaTypes;
					}
					/**
					* 设置： 是否上架
					*/
					public void setShangxiaTypes(Integer shangxiaTypes) {
						this.shangxiaTypes = shangxiaTypes;
					}


						/**
						* 获取： 是否上架的值
						*/
						public String getShangxiaValue() {
							return shangxiaValue;
						}
						/**
						* 设置： 是否上架的值
						*/
						public void setShangxiaValue(String shangxiaValue) {
							this.shangxiaValue = shangxiaValue;
						}

					/**
					* 获取： 逻辑删除
					*/
					public Integer getSucaiDelete() {
						return sucaiDelete;
					}
					/**
					* 设置： 逻辑删除
					*/
					public void setSucaiDelete(Integer sucaiDelete) {
						this.sucaiDelete = sucaiDelete;
					}













				//级联表的get和set yonghu

					/**
					* 获取： 用户姓名
					*/
					public String getYonghuName() {
						return yonghuName;
					}
					/**
					* 设置： 用户姓名
					*/
					public void setYonghuName(String yonghuName) {
						this.yonghuName = yonghuName;
					}

					/**
					* 获取： 用户手机号
					*/
					public String getYonghuPhone() {
						return yonghuPhone;
					}
					/**
					* 设置： 用户手机号
					*/
					public void setYonghuPhone(String yonghuPhone) {
						this.yonghuPhone = yonghuPhone;
					}

					/**
					* 获取： 用户身份证号
					*/
					public String getYonghuIdNumber() {
						return yonghuIdNumber;
					}
					/**
					* 设置： 用户身份证号
					*/
					public void setYonghuIdNumber(String yonghuIdNumber) {
						this.yonghuIdNumber = yonghuIdNumber;
					}

					/**
					* 获取： 用户头像
					*/
					public String getYonghuPhoto() {
						return yonghuPhoto;
					}
					/**
					* 设置： 用户头像
					*/
					public void setYonghuPhoto(String yonghuPhoto) {
						this.yonghuPhoto = yonghuPhoto;
					}

					/**
					* 获取： 余额
					*/
					public Double getNewMoney() {
						return newMoney;
					}
					/**
					* 设置： 余额
					*/
					public void setNewMoney(Double newMoney) {
						this.newMoney = newMoney;
					}

					/**
					* 获取： 电子邮箱
					*/
					public String getYonghuEmail() {
						return yonghuEmail;
					}
					/**
					* 设置： 电子邮箱
					*/
					public void setYonghuEmail(String yonghuEmail) {
						this.yonghuEmail = yonghuEmail;
					}



}
