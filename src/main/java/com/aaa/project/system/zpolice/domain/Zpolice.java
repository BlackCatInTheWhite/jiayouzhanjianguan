package com.aaa.project.system.zpolice.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.aaa.framework.web.domain.BaseEntity;

/**
 * 公安总局表 jyz_zpolice
 * 
 * @author aaa
 * @date 2019-04-22
 */
public class Zpolice extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 公安总局序号 */
	private Integer zpoliceId;
	/** 地区序号 */
	private Integer areaId;
	/** 公安总局名称 */
	private String zpoliceName;

	public void setZpoliceId(Integer zpoliceId) 
	{
		this.zpoliceId = zpoliceId;
	}

	public Integer getZpoliceId() 
	{
		return zpoliceId;
	}
	public void setAreaId(Integer areaId) 
	{
		this.areaId = areaId;
	}

	public Integer getAreaId() 
	{
		return areaId;
	}
	public void setZpoliceName(String zpoliceName) 
	{
		this.zpoliceName = zpoliceName;
	}

	public String getZpoliceName() 
	{
		return zpoliceName;
	}

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("zpoliceId", getZpoliceId())
            .append("areaId", getAreaId())
            .append("zpoliceName", getZpoliceName())
            .toString();
    }
}
