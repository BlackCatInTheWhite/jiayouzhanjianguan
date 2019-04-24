package com.aaa.project.system.buyoilform.domain;

import com.aaa.framework.web.domain.BaseEntity;
import com.aaa.project.system.gas.domain.Gas;
import com.aaa.project.system.oilkind.domain.Oilkind;
import com.aaa.project.system.oiltype.domain.Oiltype;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * 散装油登记表 jyz_buyoilform
 *
 * @author aaa
 * @date 2019-04-23
 */
public class Buyoilform extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 散装油等级序号
     */
    private Integer id;
    /**
     * 购买人姓名
     */
    private String name;
    /**
     * 性别
     */
    private Integer sex;
    /**
     * 身份证
     */
    private String idcard;
    /**
     * 民族
     */
    private String nation;
    /**
     * 购买日期
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "GMT+8")
    private Date date;
    /**
     * 购买数量
     */
    private Integer num;
    /**
     * 油品类型序号
     */
    private Integer oilkindId;
    /**
     * 油瓶类型序号
     */
    private Integer oiltypeId;
    /**
     * 加油站序号
     */
    private Integer gasId;
    /**
     * 购买人住址
     */
    private String adress;
    /**
     * 购买用途
     */
    private String usefor;
    /**
     * 油品类型
     */
    private Oilkind oilkindName;
    /**
     * 油品类型
     */
    private Oiltype oiltypeName;
    /**
     * 所属加油站
     */
    private Gas gasName;
    /**
     * 性别名称
     */
    private String sexName="男";

    public String getSexName() {
        return sexName;
    }

    public void setSexName(String sexName) {
        this.sexName = sexName;
    }

    public Oilkind getOilkindName() {
        return oilkindName;
    }

    public void setOilkindName(Oilkind oilkindName) {
        this.oilkindName = oilkindName;
    }

    public Oiltype getOiltypeName() {
        return oiltypeName;
    }

    public void setOiltypeName(Oiltype oiltypeName) {
        this.oiltypeName = oiltypeName;
    }

    public Gas getGasName() {
        return gasName;
    }

    public void setGasName(Gas gasName) {
        this.gasName = gasName;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
        if (sex==0){
            this.sexName="女";
        }
    }

    public Integer getSex() {
        return sex;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard;
    }

    public String getIdcard() {
        return idcard;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public String getNation() {
        return nation;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getDate() {
        return date;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Integer getNum() {
        return num;
    }

    public void setOilkindId(Integer oilkindId) {
        this.oilkindId = oilkindId;
    }

    public Integer getOilkindId() {
        return oilkindId;
    }

    public void setOiltypeId(Integer oiltypeId) {
        this.oiltypeId = oiltypeId;
    }

    public Integer getOiltypeId() {
        return oiltypeId;
    }

    public void setGasId(Integer gasId) {
        this.gasId = gasId;
    }

    public Integer getGasId() {
        return gasId;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getAdress() {
        return adress;
    }

    public void setUsefor(String usefor) {
        this.usefor = usefor;
    }

    public String getUsefor() {
        return usefor;
    }

    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("name", getName())
                .append("sex", getSex())
                .append("idcard", getIdcard())
                .append("nation", getNation())
                .append("date", getDate())
                .append("num", getNum())
                .append("oilkindId", getOilkindId())
                .append("oiltypeId", getOiltypeId())
                .append("gasId", getGasId())
                .append("adress", getAdress())
                .append("usefor", getUsefor()).append("oilkindName", getOilkindName()).append("oiltypeName", getOiltypeName()).append("gasName", getGasName()).append("sexName", getSexName())
                .toString();
    }
}
