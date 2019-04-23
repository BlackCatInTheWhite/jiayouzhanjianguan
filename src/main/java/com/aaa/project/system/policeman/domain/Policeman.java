package com.aaa.project.system.policeman.domain;

import com.aaa.framework.web.domain.BaseEntity;
import com.aaa.project.system.gas.domain.Gas;
import com.aaa.project.system.lpolice.domain.Lpolice;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.List;

/**
 * 派出所人员表 jyz_policeman
 *
 * @author aaa
 * @date 2019-04-22
 */

public class Policeman extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 派出人员序号
     */
    private Integer policemanId;
    /**
     * 派出所序号
     */
    private Integer lpoliceId;
    /**
     * 姓名
     */
    private String policemanName;
    /**
     * 年龄
     */
    private Integer policemanAge;
    /**
     * 职位
     */
    private String policemanPost;
    /**
     * 身份证号
     */
    private String policemanCard;
    /**
     * 手机号
     */
    private String policemanPhone;
    /**
     * 登录密码
     */
    private String policemanPassword;
    /**
     * 任务加油站信息
     */
    private List<Gas> gas;
    /** 所属派出所 */
    private Lpolice lpoliceName;

    public List<Gas> getGas() {
        return gas;
    }

    public void setGas(List<Gas> gas) {
        this.gas = gas;
    }

    public void setPolicemanId(Integer policemanId) {
        this.policemanId = policemanId;
    }

    public Integer getPolicemanId() {
        return policemanId;
    }

    public void setLpoliceId(Integer lpoliceId) {
        this.lpoliceId = lpoliceId;
    }

    public Integer getLpoliceId() {
        return lpoliceId;
    }

    public Lpolice getLpoliceName() {
        return lpoliceName;
    }

    public void setLpoliceName(Lpolice lpoliceName) {
        this.lpoliceName = lpoliceName;
    }

    public void setPolicemanName(String policemanName) {
        this.policemanName = policemanName;
    }

    public String getPolicemanName() {
        return policemanName;
    }

    public void setPolicemanAge(Integer policemanAge) {
        this.policemanAge = policemanAge;
    }

    public Integer getPolicemanAge() {
        return policemanAge;
    }

    public void setPolicemanPost(String policemanPost) {
        this.policemanPost = policemanPost;
    }

    public String getPolicemanPost() {
        return policemanPost;
    }

    public void setPolicemanCard(String policemanCard) {
        this.policemanCard = policemanCard;
    }

    public String getPolicemanCard() {
        return policemanCard;
    }

    public void setPolicemanPhone(String policemanPhone) {
        this.policemanPhone = policemanPhone;
    }

    public String getPolicemanPhone() {
        return policemanPhone;
    }

    public void setPolicemanPassword(String policemanPassword) {
        this.policemanPassword = policemanPassword;
    }

    public String getPolicemanPassword() {
        return policemanPassword;
    }

    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("policemanId", getPolicemanId())
                .append("lpoliceId", getLpoliceId())
                .append("policemanName", getPolicemanName())
                .append("policemanAge", getPolicemanAge())
                .append("policemanPost", getPolicemanPost())
                .append("policemanCard", getPolicemanCard())
                .append("policemanPhone", getPolicemanPhone())
                .append("policemanPassword", getPolicemanPassword())
                .toString();


}
}
