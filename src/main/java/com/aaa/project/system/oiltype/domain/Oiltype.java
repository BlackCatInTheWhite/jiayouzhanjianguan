package com.aaa.project.system.oiltype.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.aaa.framework.web.domain.BaseEntity;

/**
 * 油品型号表 jyz_oiltype
 * 
 * @author aaa
 * @date 2019-04-23
 */
public class Oiltype extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 油品型号序号 */
	private Integer oilId;
	/** 油品型号名称 */
	private String oilName;
	/** 阈值 */
	private Integer oilThreshold;

	public void setOilId(Integer oilId) 
	{
		this.oilId = oilId;
	}

	public Integer getOilId() 
	{
		return oilId;
	}
	public void setOilName(String oilName) 
	{
		this.oilName = oilName;
	}

	public String getOilName() 
	{
		return oilName;
	}
	public void setOilThreshold(Integer oilThreshold) 
	{
		this.oilThreshold = oilThreshold;
	}

	public Integer getOilThreshold() 
	{
		return oilThreshold;
	}

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("oilId", getOilId())
            .append("oilName", getOilName())
            .append("oilThreshold", getOilThreshold())
            .toString();
    }
}
