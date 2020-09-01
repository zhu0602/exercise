package com.zantong.jdbc;

import java.sql.Date;

/**
 * @author ZhuGangGang
 * @Date 2020/3/17 19:29
 */
public class SysRole {
    private int id;
    private String roleName;
    private String enabled;
    private Date createTime;
    private int createBy;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getEnabled() {
        return enabled;
    }

    public void setEnabled(String enabled) {
        this.enabled = enabled;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public int getCreateBy() {
        return createBy;
    }

    public void setCreateBy(int createBy) {
        this.createBy = createBy;
    }

    @Override
    public String toString() {
        return "SysRole{" +
                "id=" + id +
                ", roleName='" + roleName + '\'' +
                ", enabled='" + enabled + '\'' +
                ", createTime=" + createTime +
                ", createBy=" + createBy +
                '}';
    }
}
