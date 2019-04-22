package com.aaa.project.system.area.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.aaa.framework.web.domain.BaseEntity;

/**
 * 地区表 jyz_area
 * 
 * @author aaa
 * @date 2019-04-22
 */
public class Area extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 地区序号 */
	private Integer areaId;
	/** 地区名 */
	private String areaName;

	public void setAreaId(Integer areaId) 
	{
		this.areaId = areaId;
	}

	public Integer getAreaId() 
	{
		return areaId;
	}
	public void setAreaName(String areaName) 
	{
		this.areaName = areaName;
	}

	public String getAreaName() 
	{
		return areaName;
	}

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("areaId", getAreaId())
            .append("areaName", getAreaName())
            .toString();
    }
}
