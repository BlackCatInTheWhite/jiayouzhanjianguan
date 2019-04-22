package com.aaa.project.system.fpolice.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.aaa.framework.web.domain.BaseEntity;

/**
 * 公安分局表 jyz_fpolice
 * 
 * @author aaa
 * @date 2019-04-22
 */
public class Fpolice extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 公安分局序号 */
	private Integer fpoliceId;
	/** 公安总局序号 */
	private Integer zpoliceId;
	/** 公安分局名称 */
	private String fpoliceName;

	public void setFpoliceId(Integer fpoliceId) 
	{
		this.fpoliceId = fpoliceId;
	}

	public Integer getFpoliceId() 
	{
		return fpoliceId;
	}
	public void setZpoliceId(Integer zpoliceId) 
	{
		this.zpoliceId = zpoliceId;
	}

	public Integer getZpoliceId() 
	{
		return zpoliceId;
	}
	public void setFpoliceName(String fpoliceName) 
	{
		this.fpoliceName = fpoliceName;
	}

	public String getFpoliceName() 
	{
		return fpoliceName;
	}

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("fpoliceId", getFpoliceId())
            .append("zpoliceId", getZpoliceId())
            .append("fpoliceName", getFpoliceName())
            .toString();
    }
}
