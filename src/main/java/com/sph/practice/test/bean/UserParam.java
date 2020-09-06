package com.sph.practice.test.bean;

/**
 * Created by Shen Peihong on 2020/8/27 16:45
 * Description:
 *
 * @since 1.0.0
 */
public class UserParam implements Cloneable {
    private String id;
    private String usernmae;
    private String password;
    private String sex;

    /**
     * 在本类中直接使用clone方法，是先用Object祖先类去调用方法，返回的实例再去向下强转
     * @return
     */
    public UserParam clone(){
        try {
            return (UserParam) super.clone();
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }

    public UserParam(){

    }

    public UserParam(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsernmae() {
        return usernmae;
    }

    public void setUsernmae(String usernmae) {
        this.usernmae = usernmae;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
