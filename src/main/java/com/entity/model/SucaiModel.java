package com.entity.model;

import com.entity.SucaiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 素材
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class SucaiModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 用户
     */
    private Integer yonghuId;


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
     * 二级类型
     */
    private Integer sucaiErjiTypes;


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
     * 逻辑删除
     */
    private Integer sucaiDelete;


    /**
     * 创建时间  show1 show2 photoShow
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
	 * 获取：素材编号
	 */
    public String getSucaiUuidNumber() {
        return sucaiUuidNumber;
    }


    /**
	 * 设置：素材编号
	 */
    public void setSucaiUuidNumber(String sucaiUuidNumber) {
        this.sucaiUuidNumber = sucaiUuidNumber;
    }
    /**
	 * 获取：素材名称
	 */
    public String getSucaiName() {
        return sucaiName;
    }


    /**
	 * 设置：素材名称
	 */
    public void setSucaiName(String sucaiName) {
        this.sucaiName = sucaiName;
    }
    /**
	 * 获取：素材类型
	 */
    public Integer getSucaiTypes() {
        return sucaiTypes;
    }


    /**
	 * 设置：素材类型
	 */
    public void setSucaiTypes(Integer sucaiTypes) {
        this.sucaiTypes = sucaiTypes;
    }
    /**
	 * 获取：二级类型
	 */
    public Integer getSucaiErjiTypes() {
        return sucaiErjiTypes;
    }


    /**
	 * 设置：二级类型
	 */
    public void setSucaiErjiTypes(Integer sucaiErjiTypes) {
        this.sucaiErjiTypes = sucaiErjiTypes;
    }
    /**
	 * 获取：素材照片
	 */
    public String getSucaiPhoto() {
        return sucaiPhoto;
    }


    /**
	 * 设置：素材照片
	 */
    public void setSucaiPhoto(String sucaiPhoto) {
        this.sucaiPhoto = sucaiPhoto;
    }
    /**
	 * 获取：素材展示照片
	 */
    public String getSucaiZhanshiPhoto() {
        return sucaiZhanshiPhoto;
    }


    /**
	 * 设置：素材展示照片
	 */
    public void setSucaiZhanshiPhoto(String sucaiZhanshiPhoto) {
        this.sucaiZhanshiPhoto = sucaiZhanshiPhoto;
    }
    /**
	 * 获取：素材展示视频
	 */
    public String getSucaiVideo() {
        return sucaiVideo;
    }


    /**
	 * 设置：素材展示视频
	 */
    public void setSucaiVideo(String sucaiVideo) {
        this.sucaiVideo = sucaiVideo;
    }
    /**
	 * 获取：素材展示音频
	 */
    public String getSucaiMusic() {
        return sucaiMusic;
    }


    /**
	 * 设置：素材展示音频
	 */
    public void setSucaiMusic(String sucaiMusic) {
        this.sucaiMusic = sucaiMusic;
    }
    /**
	 * 获取：素材原价
	 */
    public Double getSucaiOldMoney() {
        return sucaiOldMoney;
    }


    /**
	 * 设置：素材原价
	 */
    public void setSucaiOldMoney(Double sucaiOldMoney) {
        this.sucaiOldMoney = sucaiOldMoney;
    }
    /**
	 * 获取：现价
	 */
    public Double getSucaiNewMoney() {
        return sucaiNewMoney;
    }


    /**
	 * 设置：现价
	 */
    public void setSucaiNewMoney(Double sucaiNewMoney) {
        this.sucaiNewMoney = sucaiNewMoney;
    }
    /**
	 * 获取：素材文件
	 */
    public String getSucaiFile() {
        return sucaiFile;
    }


    /**
	 * 设置：素材文件
	 */
    public void setSucaiFile(String sucaiFile) {
        this.sucaiFile = sucaiFile;
    }
    /**
	 * 获取：点击次数
	 */
    public Integer getSucaiClicknum() {
        return sucaiClicknum;
    }


    /**
	 * 设置：点击次数
	 */
    public void setSucaiClicknum(Integer sucaiClicknum) {
        this.sucaiClicknum = sucaiClicknum;
    }
    /**
	 * 获取：素材详细介绍
	 */
    public String getSucaiContent() {
        return sucaiContent;
    }


    /**
	 * 设置：素材详细介绍
	 */
    public void setSucaiContent(String sucaiContent) {
        this.sucaiContent = sucaiContent;
    }
    /**
	 * 获取：是否上架
	 */
    public Integer getShangxiaTypes() {
        return shangxiaTypes;
    }


    /**
	 * 设置：是否上架
	 */
    public void setShangxiaTypes(Integer shangxiaTypes) {
        this.shangxiaTypes = shangxiaTypes;
    }
    /**
	 * 获取：逻辑删除
	 */
    public Integer getSucaiDelete() {
        return sucaiDelete;
    }


    /**
	 * 设置：逻辑删除
	 */
    public void setSucaiDelete(Integer sucaiDelete) {
        this.sucaiDelete = sucaiDelete;
    }
    /**
	 * 获取：创建时间  show1 show2 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间  show1 show2 photoShow
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
