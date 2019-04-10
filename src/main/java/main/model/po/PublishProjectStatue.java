package main.model.po;

import java.util.Date;

public class PublishProjectStatue {
    
    private Long id;

    private Long pId;

    private Long captionId;

    private Long sId;

    private Integer statue;

    private Date requestTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getpId() {
        return pId;
    }

    public void setpId(Long pId) {
        this.pId = pId;
    }

    public Long getCaptionId() {
        return captionId;
    }

    public void setCaptionId(Long captionId) {
        this.captionId = captionId;
    }

    public Long getsId() {
        return sId;
    }

    public void setsId(Long sId) {
        this.sId = sId;
    }

    public Integer getStatue() {
        return statue;
    }

    public void setStatue(Integer statue) {
        this.statue = statue;
    }

    public Date getRequestTime() {
        return requestTime;
    }

    public void setRequestTime(Date requestTime) {
        this.requestTime = requestTime;
    }
}