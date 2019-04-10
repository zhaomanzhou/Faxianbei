package main.model.po;

import java.util.Date;

public class ProjectPublic {
    
    private Long id;

    private Long sId;

    private String logoPath;

    private Date publishDate;

    private String title;

    private String tinyDescription;

    private String catalog;

    private String academy;

    private String caption;

    private String direction;

    private String type;

    private Byte totalNum;

    private Byte curNum;

    private String technology;

    private Byte isShow;

    private Byte establish;

    private String detailDescription;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getsId() {
        return sId;
    }

    public void setsId(Long sId) {
        this.sId = sId;
    }

    public String getLogoPath() {
        return logoPath;
    }

    public void setLogoPath(String logoPath) {
        this.logoPath = logoPath == null ? null : logoPath.trim();
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getTinyDescription() {
        return tinyDescription;
    }

    public void setTinyDescription(String tinyDescription) {
        this.tinyDescription = tinyDescription == null ? null : tinyDescription.trim();
    }

    public String getCatalog() {
        return catalog;
    }

    public void setCatalog(String catalog) {
        this.catalog = catalog == null ? null : catalog.trim();
    }

    public String getAcademy() {
        return academy;
    }

    public void setAcademy(String academy) {
        this.academy = academy == null ? null : academy.trim();
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption == null ? null : caption.trim();
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction == null ? null : direction.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public Byte getTotalNum() {
        return totalNum;
    }

    public void setTotalNum(Byte totalNum) {
        this.totalNum = totalNum;
    }

    public Byte getCurNum() {
        return curNum;
    }

    public void setCurNum(Byte curNum) {
        this.curNum = curNum;
    }

    public String getTechnology() {
        return technology;
    }

    public void setTechnology(String technology) {
        this.technology = technology == null ? null : technology.trim();
    }

    public Byte getIsShow() {
        return isShow;
    }

    public void setIsShow(Byte isShow) {
        this.isShow = isShow;
    }

    public Byte getEstablish() {
        return establish;
    }

    public void setEstablish(Byte establish) {
        this.establish = establish;
    }

    public String getDetailDescription() {
        return detailDescription;
    }

    public void setDetailDescription(String detailDescription) {
        this.detailDescription = detailDescription == null ? null : detailDescription.trim();
    }
}