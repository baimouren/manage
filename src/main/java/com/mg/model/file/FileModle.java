package com.mg.model.file;

import java.util.Date;

import com.mg.util.DateUtil;

public class FileModle {
    private Integer id;

    // ����
    private String name;

    // �ļ�����
    private String fileType;

    // �����
    private Integer clicks;

    // ·��
    private String url;

    // ����
    private String author;

    // ��������
    private Date publicationDate;

    // ������
    private Date publication;

    // �۸�
    private Double price;

    // ͼƬ
    private String image;

    // ���
    private String remark;

    // ��ע
    private String notes;

    // ����ʱ��
    private Date createTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public Integer getClicks() {
        return clicks;
    }

    public void setClicks(Integer clicks) {
        this.clicks = clicks;
    }

    public String geturl() {
        return url;
    }

    public void seturl(String url) {
        this.url = url;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Date getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(Date publicationDate) {
        this.publicationDate = publicationDate;
    }

    public Date getPublication() {
        return publication;
    }

    public void setPublication(Date publication) {
        this.publication = publication;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
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
        return "FileModle [id=" + id + ", name=" + name + ", fileType=" + fileType + ", clicks=" + clicks + ", url=" + url + ", author=" + author
                + ", publicationDate=" + publicationDate + ", publication=" + publication + ", price=" + price + ", image=" + image + ", remark="
                + remark + ", notes=" + notes + ", createTime=" + createTime + "]";
    }

}
