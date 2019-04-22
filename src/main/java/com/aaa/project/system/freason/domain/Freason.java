package com.aaa.project.system.freason.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.aaa.framework.web.domain.BaseEntity;

/**
 * 观察原因表 jyz_freason
 * 
 * @author aaa
 * @date 2019-04-22
 */
public class Freason extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 观察原因序号 */
	private Integer freasonId;
	/** 观察原因 */
	private String freasonName;

	public void setFreasonId(Integer freasonId) 
	{
		this.freasonId = freasonId;
	}

	public Integer getFreasonId() 
	{
		return freasonId;
	}
	public void setFreasonName(String freasonName) 
	{
		this.freasonName = freasonName;
	}

	public String getFreasonName() 
	{
		return freasonName;
	}

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("freasonId", getFreasonId())
            .append("freasonName", getFreasonName())
            .toString();
    }
}
