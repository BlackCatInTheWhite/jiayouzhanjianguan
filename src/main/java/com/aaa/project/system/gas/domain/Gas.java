package com.aaa.project.system.gas.domain;

import com.aaa.framework.web.domain.BaseEntity;
import com.aaa.project.system.gasstatus.domain.Gasstatus;
import com.aaa.project.system.gastype.domain.Gastype;
import com.aaa.project.system.lpolice.domain.Lpolice;

import java.util.List;

/**
 * 加油站表 jyz_gas
 *
 * @author aaa
 * @date 2019-04-22
 */
public class Gas extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 加油站序号
     */
    private Integer gasId;
    /**
     * 加油站名称
     */
    private String gasName;
    /**
     * 详细地址
     */
    private String gasAddress;
    /**
     * 经度
     */
    private Float gasLongitude;
    /**
     * 纬度
     */
    private Float gasLatitude;
    /**
     * 派出所序号
     */
    private Integer lpoliceId;
    /**
     * 员工数量
     */
    private Integer staffNumber;
    /**
     * 加油机数量
     */
    private Integer machineNumber;
    /**
     * 性质
     */
    private Integer gasType;
    /**
     * 法人姓名
     */
    private String principalName;
    /**
     * 法人身份证号
     */
    private String principalCard;
    /**
     * 法人电话
     */
    private String principalPhone;
    /**
     * 登录账号
     */
    private String principalUsername;
    /**
     * 登录密码
     */
    private String principalPassword;
    /**
     * 状态序号
     */
    private Integer gasstatusId;
    /**
     * 所属派出所
     */
    private Lpolice lpoliceName;
    /**
     * 加油站性质
     */
    private Gastype gastypeName;
    /**
     * 加油站状态
     */
    private Gasstatus gasstatusName;
    /**加油站对应的任务*/
    private Integer missionId;
    /**
     * 加油站集合
     */
    private List<Integer> gasList;

    public List<Integer> getGasList() {
        return gasList;
    }

    public void setGasList(List<Integer> gasList) {
        this.gasList = gasList;
    }

    public Integer getMissionId() {
        return missionId;
    }

    public void setMissionId(Integer missionId) {
        this.missionId = missionId;
    }

    public Lpolice getLpoliceName() {
        return lpoliceName;
    }

    public void setLpoliceName(Lpolice lpoliceName) {
        this.lpoliceName = lpoliceName;
    }

    public Gastype getGastypeName() {
        return gastypeName;
    }

    public void setGastypeName(Gastype gastypeName) {
        this.gastypeName = gastypeName;
    }

    public Gasstatus getGasstatusName() {
        return gasstatusName;
    }

    public void setGasstatusName(Gasstatus gasstatusName) {
        this.gasstatusName = gasstatusName;
    }

    public void setGasId(Integer gasId) {
        this.gasId = gasId;
    }

    public Integer getGasId() {
        return gasId;
    }

    public void setGasName(String gasName) {
        this.gasName = gasName;
    }

    public String getGasName() {
        return gasName;
    }

    public void setGasAddress(String gasAddress) {
        this.gasAddress = gasAddress;
    }

    public String getGasAddress() {
        return gasAddress;
    }

    public void setGasLongitude(Float gasLongitude) {
        this.gasLongitude = gasLongitude;
    }

    public Float getGasLongitude() {
        return gasLongitude;
    }

    public void setGasLatitude(Float gasLatitude) {
        this.gasLatitude = gasLatitude;
    }

    public Float getGasLatitude() {
        return gasLatitude;
    }

    public void setLpoliceId(Integer lpoliceId) {
        this.lpoliceId = lpoliceId;
    }

    public Integer getLpoliceId() {
        return lpoliceId;
    }

    public void setStaffNumber(Integer staffNumber) {
        this.staffNumber = staffNumber;
    }

    public Integer getStaffNumber() {
        return staffNumber;
    }

    public void setMachineNumber(Integer machineNumber) {
        this.machineNumber = machineNumber;
    }

    public Integer getMachineNumber() {
        return machineNumber;
    }

    public void setGasType(Integer gasType) {
        this.gasType = gasType;
    }

    public Integer getGasType() {
        return gasType;
    }

    public void setPrincipalName(String principalName) {
        this.principalName = principalName;
    }

    public String getPrincipalName() {
        return principalName;
    }

    public void setPrincipalCard(String principalCard) {
        this.principalCard = principalCard;
    }

    public String getPrincipalCard() {
        return principalCard;
    }

    public void setPrincipalPhone(String principalPhone) {
        this.principalPhone = principalPhone;
    }

    public String getPrincipalPhone() {
        return principalPhone;
    }

    public void setPrincipalUsername(String principalUsername) {
        this.principalUsername = principalUsername;
    }

    public String getPrincipalUsername() {
        return principalUsername;
    }

    public void setPrincipalPassword(String principalPassword) {
        this.principalPassword = principalPassword;
    }

    public String getPrincipalPassword() {
        return principalPassword;
    }

    public void setGasstatusId(Integer gasstatusId) {
        this.gasstatusId = gasstatusId;
    }

    public Integer getGasstatusId() {
        return gasstatusId;
    }

    @Override
    public String toString() {
        return "Gas{" +
                "gasId=" + gasId +
                ", gasName='" + gasName + '\'' +
                ", gasAddress='" + gasAddress + '\'' +
                ", gasLongitude=" + gasLongitude +
                ", gasLatitude=" + gasLatitude +
                ", lpoliceId=" + lpoliceId +
                ", staffNumber=" + staffNumber +
                ", machineNumber=" + machineNumber +
                ", gasType=" + gasType +
                ", principalName='" + principalName + '\'' +
                ", principalCard='" + principalCard + '\'' +
                ", principalPhone='" + principalPhone + '\'' +
                ", principalUsername='" + principalUsername + '\'' +
                ", principalPassword='" + principalPassword + '\'' +
                ", gasstatusId=" + gasstatusId +
                ", lpoliceName=" + lpoliceName +
                ", gastypeName=" + gastypeName +
                ", gasstatusName=" + gasstatusName +
                ", missionId=" + missionId +
                ", gasList=" + gasList +
                '}';
    }
}
