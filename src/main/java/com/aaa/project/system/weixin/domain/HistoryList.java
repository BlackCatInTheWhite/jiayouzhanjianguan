package com.aaa.project.system.weixin.domain;

import java.util.Date;

/**
 * @author 张益达
 * @create 2019-04-26 15:51
 * @desprint 这个代码好
 */
public class HistoryList {
    private Integer fmissionid;
    private String gasName;
    private String gasAddress;

    public String getGasAddress() {
        return gasAddress;
    }

    public void setGasAddress(String gasAddress) {
        this.gasAddress = gasAddress;
    }

    @Override
    public String toString() {
        return "HistoryList{" +
                "fmissionid=" + fmissionid +
                ", gasName='" + gasName + '\'' +
                ", commitTime=" + commitTime +
                ", point=" + point +
                ", gasAddress=" + gasAddress +
                '}';
    }

    public Integer getFmissionid() {
        return fmissionid;
    }

    public void setFmissionid(Integer fmissionid) {
        this.fmissionid = fmissionid;
    }

    public String getGasName() {
        return gasName;
    }

    public void setGasName(String gasName) {
        this.gasName = gasName;
    }

    public Date getCommitTime() {
        return commitTime;
    }

    public void setCommitTime(Date commitTime) {
        this.commitTime = commitTime;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    private Date commitTime;
    private int point;
}
