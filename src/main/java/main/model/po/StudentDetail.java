package main.model.po;

public class StudentDetail {
    
    private Long id;

    private Long userId;

    private String academy;

    private String majorAndClass;

    private String tel;

    private String email;

    private String sex;

    private String interestDirection;

    private String imagePath;

    private String interestTag;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getAcademy() {
        return academy;
    }

    public void setAcademy(String academy) {
        this.academy = academy == null ? null : academy.trim();
    }

    public String getMajorAndClass() {
        return majorAndClass;
    }

    public void setMajorAndClass(String majorAndClass) {
        this.majorAndClass = majorAndClass == null ? null : majorAndClass.trim();
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel == null ? null : tel.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public String getInterestDirection() {
        return interestDirection;
    }

    public void setInterestDirection(String interestDirection) {
        this.interestDirection = interestDirection == null ? null : interestDirection.trim();
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath == null ? null : imagePath.trim();
    }

    public String getInterestTag() {
        return interestTag;
    }

    public void setInterestTag(String interestTag) {
        this.interestTag = interestTag == null ? null : interestTag.trim();
    }
}