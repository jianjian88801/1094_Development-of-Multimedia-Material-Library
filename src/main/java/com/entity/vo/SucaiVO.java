package com.entity.vo;

import com.entity.SucaiEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 素材
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("sucai")
public class SucaiVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 用户
     */

    @TableField(value = "yonghu_id")
    private Integer yonghuId;


    /**
     * 素材编号
     */

    @TableField(value = "sucai_uuid_number")
    private String sucaiUuidNumber;


    /**
     * 素材名称
     */

    @TableField(value = "sucai_name")
    private String sucaiName;


    /**
     * 素材类型
     */

    @TableField(value = "sucai_types")
    private Integer sucaiTypes;


    /**
     * 二级类型
     */

    @TableField(value = "sucai_erji_types")
    private Integer sucaiErjiTypes;


    /**
     * 素材照片
     */

    @TableField(value = "sucai_photo")
    private String sucaiPhoto;


    /**
     * 素材展示照片
     */

    @TableField(value = "sucai_zhanshi_photo")
    private String sucaiZhanshiPhoto;


    /**
     * 素材展示视频
     */

    @TableField(value = "sucai_video")
    private String sucaiVideo;


    /**
     * 素材展示音频
     */

    @TableField(value = "sucai_music")
    private String sucaiMusic;


    /**
     * 素材原价
     */

    @TableField(value = "sucai_old_money")
    private Double sucaiOldMoney;


    /**
     * 现价
     */

    @TableField(value = "sucai_new_money")
    private Double sucaiNewMoney;


    /**
     * 素材文件
     */

    @TableField(value = "sucai_file")
    private String sucaiFile;


    /**
     * 点击次数
     */

    @TableField(value = "sucai_clicknum")
    private Integer sucaiClicknum;


    /**
     * 素材详细介绍
     */

    @TableField(value = "sucai_content")
    private String sucaiContent;


    /**
     * 是否上架
     */

    @TableField(value = "shangxia_types")
    private Integer shangxiaTypes;


    /**
     * 逻辑删除
     */

    @TableField(value = "sucai_delete")
    private Integer sucaiDelete;


    /**
     * 创建时间  show1 show2 photoShow
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
	 * 设置：素材编号
	 */
    public String getSucaiUuidNumber() {
        return sucaiUuidNumber;
    }


    /**
	 * 获取：素材编号
	 */

    public void setSucaiUuidNumber(String sucaiUuidNumber) {
        this.sucaiUuidNumber = sucaiUuidNumber;
    }
    /**
	 * 设置：素材名称
	 */
    public String getSucaiName() {
        return sucaiName;
    }


    /**
	 * 获取：素材名称
	 */

    public void setSucaiName(String sucaiName) {
        this.sucaiName = sucaiName;
    }
    /**
	 * 设置：素材类型
	 */
    public Integer getSucaiTypes() {
        return sucaiTypes;
    }


    /**
	 * 获取：素材类型
	 */

    public void setSucaiTypes(Integer sucaiTypes) {
        this.sucaiTypes = sucaiTypes;
    }
    /**
	 * 设置：二级类型
	 */
    public Integer getSucaiErjiTypes() {
        return sucaiErjiTypes;
    }


    /**
	 * 获取：二级类型
	 */

    public void setSucaiErjiTypes(Integer sucaiErjiTypes) {
        this.sucaiErjiTypes = sucaiErjiTypes;
    }
    /**
	 * 设置：素材照片
	 */
    public String getSucaiPhoto() {
        return sucaiPhoto;
    }


    /**
	 * 获取：素材照片
	 */

    public void setSucaiPhoto(String sucaiPhoto) {
        this.sucaiPhoto = sucaiPhoto;
    }
    /**
	 * 设置：素材展示照片
	 */
    public String getSucaiZhanshiPhoto() {
        return sucaiZhanshiPhoto;
    }


    /**
	 * 获取：素材展示照片
	 */

    public void setSucaiZhanshiPhoto(String sucaiZhanshiPhoto) {
        this.sucaiZhanshiPhoto = sucaiZhanshiPhoto;
    }
    /**
	 * 设置：素材展示视频
	 */
    public String getSucaiVideo() {
        return sucaiVideo;
    }


    /**
	 * 获取：素材展示视频
	 */

    public void setSucaiVideo(String sucaiVideo) {
        this.sucaiVideo = sucaiVideo;
    }
    /**
	 * 设置：素材展示音频
	 */
    public String getSucaiMusic() {
        return sucaiMusic;
    }


    /**
	 * 获取：素材展示音频
	 */

    public void setSucaiMusic(String sucaiMusic) {
        this.sucaiMusic = sucaiMusic;
    }
    /**
	 * 设置：素材原价
	 */
    public Double getSucaiOldMoney() {
        return sucaiOldMoney;
    }


    /**
	 * 获取：素材原价
	 */

    public void setSucaiOldMoney(Double sucaiOldMoney) {
        this.sucaiOldMoney = sucaiOldMoney;
    }
    /**
	 * 设置：现价
	 */
    public Double getSucaiNewMoney() {
        return sucaiNewMoney;
    }


    /**
	 * 获取：现价
	 */

    public void setSucaiNewMoney(Double sucaiNewMoney) {
        this.sucaiNewMoney = sucaiNewMoney;
    }
    /**
	 * 设置：素材文件
	 */
    public String getSucaiFile() {
        return sucaiFile;
    }


    /**
	 * 获取：素材文件
	 */

    public void setSucaiFile(String sucaiFile) {
        this.sucaiFile = sucaiFile;
    }
    /**
	 * 设置：点击次数
	 */
    public Integer getSucaiClicknum() {
        return sucaiClicknum;
    }


    /**
	 * 获取：点击次数
	 */

    public void setSucaiClicknum(Integer sucaiClicknum) {
        this.sucaiClicknum = sucaiClicknum;
    }
    /**
	 * 设置：素材详细介绍
	 */
    public String getSucaiContent() {
        return sucaiContent;
    }


    /**
	 * 获取：素材详细介绍
	 */

    public void setSucaiContent(String sucaiContent) {
        this.sucaiContent = sucaiContent;
    }
    /**
	 * 设置：是否上架
	 */
    public Integer getShangxiaTypes() {
        return shangxiaTypes;
    }


    /**
	 * 获取：是否上架
	 */

    public void setShangxiaTypes(Integer shangxiaTypes) {
        this.shangxiaTypes = shangxiaTypes;
    }
    /**
	 * 设置：逻辑删除
	 */
    public Integer getSucaiDelete() {
        return sucaiDelete;
    }


    /**
	 * 获取：逻辑删除
	 */

    public void setSucaiDelete(Integer sucaiDelete) {
        this.sucaiDelete = sucaiDelete;
    }
    /**
	 * 设置：创建时间  show1 show2 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间  show1 show2 photoShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
