package com.aaa.project.system.gastype.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.aaa.framework.web.domain.BaseEntity;

/**
 * 加油站性质表 jyz_gastype
 * 
 * @author aaa
 * @date 2019-04-22
 */
public class Gastype extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 加油站性质序号 */
	private Integer gastypeId;
	/** 加油站性质 */
	private String gastypeName;

	public void setGastypeId(Integer gastypeId) 
	{
		this.gastypeId = gastypeId;
	}

	public Integer getGastypeId() 
	{
		return gastypeId;
	}
	public void setGastypeName(String gastypeName) 
	{
		this.gastypeName = gastypeName;
	}

	public String getGastypeName() 
	{
		return gastypeName;
	}

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("gastypeId", getGastypeId())
            .append("gastypeName", getGastypeName())
            .toString();
    }
}
