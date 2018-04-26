package com.mg.model.basicinfo;

import java.io.Serializable;
import java.util.Date;

import com.mg.util.DateUtil;

public class MenueModel implements Serializable {

    private static final long serialVersionUID = -8566139135922550210L;

    // id
    private Integer id;

    // 菜单名称
    private String menueName;

    // 菜单路径
    private String menueUrl;

    // 图片
    private String image;

    // 简介
    private String remark;

    // 备注
    private String notes;

    // 创建时间
    private Date createTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMenueName() {
        return menueName;
    }

    public void setMenueName(String menueName) {
        this.menueName = menueName;
    }

    public String getMenueUrl() {
        return menueUrl;
    }

    public void setMenueUrl(String menueUrl) {
        this.menueUrl = menueUrl;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getCreateTime() {
        return DateUtil.getDateTimeFormat(createTime);
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "MenueModel [id=" + id + ", menueName=" + menueName + ", menueUrl=" + menueUrl + ", image=" + image + ", remark=" + remark + ", notes="
                + notes + ", create_time=" + createTime + "]";
    }

}
